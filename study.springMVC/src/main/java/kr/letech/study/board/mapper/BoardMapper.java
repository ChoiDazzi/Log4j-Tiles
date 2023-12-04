package kr.letech.study.board.mapper;

import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    /* select */
    List<BoardVO> getNavItems();
    List<PostVO> getAllPostByBoard(String boardId);
    
    /* update */
    void modifyBoard(BoardVO boardVO);
    void deleteBoard(BoardVO boardVO);
    
    /* insert */
    void insertBoard(BoardVO boardVO);
}
