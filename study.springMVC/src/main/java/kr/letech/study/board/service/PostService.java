package kr.letech.study.board.service;

import kr.letech.study.board.vo.FileVO;
import kr.letech.study.board.vo.PostVO;

import java.util.List;

public interface PostService {
	/* select */
	String getNavNm(String boardId);
	PostVO getPost(String postId);
	
	 /* insert */
    void insertPost(PostVO postVO, String userId, List<FileVO> fileVOList);

    /* update */
    void modifyPost(PostVO postVO, String userId);
    void deletePost(String postId);
    
    /* file */
    List<FileVO> getFileByPost(String postId);
}
