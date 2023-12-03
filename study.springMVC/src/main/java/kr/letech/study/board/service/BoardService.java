package kr.letech.study.board.service;

import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;

import java.util.List;

public interface BoardService {
    List<BoardVO> getNavItems();

    String getNavNm(String boardId);

    void insertPost(PostVO postVO, String userId);
}
