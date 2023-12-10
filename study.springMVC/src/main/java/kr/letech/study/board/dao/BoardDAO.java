package kr.letech.study.board.dao;

import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {
    /* select */
    List<BoardVO> getNavItems();
    List<PostVO> getAllPostByBoard(BoardVO boardVO);
    String getBoardSeq();
    
    /* update */
    void modifyBoard(BoardVO boardVO);
    void deleteBoard(BoardVO boardVO);
    
    /* insert */
    void insertBoard(BoardVO boardVO);
}
