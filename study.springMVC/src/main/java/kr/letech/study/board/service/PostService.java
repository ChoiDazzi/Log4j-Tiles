package kr.letech.study.board.service;

import kr.letech.study.board.vo.FileVO;
import kr.letech.study.board.vo.PostVO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PostService {
	/* select */
	String getNavNm(String boardId);
	PostVO getPost(String postId);
	String getCurrentTime();
	
	 /* insert */
	 void insertPost(PostVO postVO, String userId, List<MultipartFile> files);
	
    /* update */
    void modifyPost(PostVO postVO, String userId);
    void deletePost(String postId);
    
    /* file */
    List<FileVO> getFileByPost(String postId);
    FileVO getFileById(String fileId);
	
}

