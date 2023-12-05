package kr.letech.study.board.service.impl;

import kr.letech.study.board.mapper.PostMapper;
import kr.letech.study.board.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileUploadUtils {
    @Value("${file.directory}")
    private String uploadFolder;
    
    private final PostMapper postMapper;

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
            uploadFileName = uuid + "_" + uploadFileName;
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            fileVO.setFileId(uuid);
            fileVO.setFileOrgNm(file.getOriginalFilename());
            fileVO.setFileSaveNm(uploadFileName);
            fileVO.setFileSize(file.getSize());
            fileVO.setFilePath(uploadFolder + "/" + getFolder());
            fileList.add(fileVO);
        }

        return fileList;
    }

    public String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String str = sdf.format(date);

        return str.replace("-", File.separator);
    }
    
    public void fileDownload(String fileId, HttpServletResponse response){
    	FileVO fileVO = postMapper.getFileById(fileId);
    	String filename = fileVO.getFileOrgNm();
    	File file = new File(fileVO.getFilePath(), fileVO.getFileSaveNm());
    	String encodedFileName;
		try {
			encodedFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
			response.setContentType("application/download");
	    	response.setContentLength((int) file.length());
	    	response.setHeader("Content-Disposition", "attatchment;filename=\"" + encodedFileName + "\"");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try (OutputStream out = response.getOutputStream();
			FileInputStream fis = new FileInputStream(file);) {
			FileCopyUtils.copy(fis, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
