package kr.letech.study.board.dao;

import kr.letech.study.board.vo.FileVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.study.board.vo.PostVO;

@Mapper
public interface PostDAO {
	/* select */
	String getNavNm(String boardId);
    String getPostSeq();
    PostVO getPost(String postId);
    
    /* insert */
    void insertPost(PostVO postVO);

    /* update */
    void modifyPost(PostVO postVO);
    void deletePost(String postId);

    /* file */
    void insertFile(FileVO fileVO);
    List<FileVO> getFileByPost(String postId);
    FileVO getFileById(String fileId);
}
