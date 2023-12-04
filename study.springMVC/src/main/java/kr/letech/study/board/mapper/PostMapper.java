package kr.letech.study.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.study.board.vo.PostVO;

@Mapper
public interface PostMapper {
	/* select */
	String getNavNm(String boardId);
    String getPostSeq();
    PostVO getPost(String postId);
    
    /* insert */
    void insertPost(PostVO postVO);

    /* update */
    void modifyPost(PostVO postVO);
    void deletePost(String postId);
}
