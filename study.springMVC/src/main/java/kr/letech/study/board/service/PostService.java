package kr.letech.study.board.service;

import kr.letech.study.board.vo.PostVO;

public interface PostService {
	/* select */
	String getNavNm(String boardId);
	PostVO getPost(String postId);
	
	 /* insert */
    void insertPost(PostVO postVO, String userId);

    /* update */
    void modifyPost(PostVO postVO, String userId);
    void deletePost(String postId);
}
