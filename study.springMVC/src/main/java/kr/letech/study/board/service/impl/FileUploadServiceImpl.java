package kr.letech.study.board.service.impl;

import kr.letech.study.board.dao.PostDAO;
import kr.letech.study.board.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl {
    @Value("${file.directory}")
    private String uploadFolder;
    
    private final PostDAO postDao;

    public List<FileVO> uploadFile(ArrayList<MultipartFile> files) {
        List<FileVO> fileList = new ArrayList<>();
        File uploadPath = new File(uploadFolder, getFolder());
        log.info(uploadFolder.toString());
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        for (MultipartFile file : files) {
            FileVO fileVO = new FileVO();
            String uploadFileName = file.getOriginalFilename(); 
            String uuid = UUID.randomUUID().toString();
            uploadFileName = uuid + "_" + uploadFileName; // -> uuid 
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            fileVO.setFileId(uuid);
            fileVO.setFileOrgNm(file.getOriginalFilename()); //문자 확장자 붙이면 ...  
            fileVO.setFileSaveNm(uploadFileName); //local - uuid
            fileVO.setFileSize(file.getSize());
            fileVO.setFilePath(uploadFolder + "/" + getFolder());
            fileList.add(fileVO);
        }

        return fileList;
    }

    public String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Date date = new Date();
        String str = sdf.format(date);

        return str;
    }
    
    public void fileDownload(String fileId, HttpServletResponse response){
    	FileVO fileVO = postDao.getFileById(fileId);
    	String filename = fileVO.getFileOrgNm();
    	File file = new File(fileVO.getFilePath(), fileVO.getFileSaveNm());
    	String encodedFileName;
		try {
			encodedFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
			response.setContentType("application/download");
	    	response.setContentLength((int) file.length());
	    	response.setHeader("Content-Disposition", "attatchment;filename=\"" + encodedFileName + "\"");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
    	try (OutputStream out = response.getOutputStream();
			FileInputStream fis = new FileInputStream(file);) {
			FileCopyUtils.copy(fis, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public ResponseEntity<byte[]> preview(FileVO fileVO) { //이미지 리사이징...(라이브러리)
    	File file = new File(fileVO.getFilePath() + "\\" + fileVO.getFileSaveNm());
    	ResponseEntity<byte[]> fileBytEntity = null;
    	try {
    		HttpHeaders headers = new HttpHeaders();
    		headers.add("Content-Type", Files.probeContentType(file.toPath()));
    		fileBytEntity = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return fileBytEntity;
	}
}
