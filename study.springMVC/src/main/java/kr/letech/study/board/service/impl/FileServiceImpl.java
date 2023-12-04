package kr.letech.study.board.service.impl;

import kr.letech.study.board.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl {
    @Value("${file.directory}")
    private String uploadFolder;

    public List<FileVO> uploadFile(ArrayList<MultipartFile> files) {
        List<FileVO> fileList = new ArrayList<>();
        File uploadPath = new File(uploadFolder, getFolder());

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

}
