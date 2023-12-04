package kr.letech.study.board.service;

import com.github.pagehelper.PageInfo;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;

import java.util.List;

public interface BoardService {
    /* select */
    List<BoardVO> getNavItems();
    PageInfo<PostVO> getAllPostByBoard(String boardId, int pageNum, int pageSize);
    
    /* update */
    void modifyBoard(BoardVO boardVO, String userId);
    void deleteBoard(String boardId, String userId);
    
    /* insert */
    void insertBoard(String boardNm, String userId);
}
