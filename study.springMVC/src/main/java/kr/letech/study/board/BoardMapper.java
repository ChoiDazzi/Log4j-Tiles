package kr.letech.study.board;

import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVO> getNavItems();

    String getNavNm(String boardId);

    void insertPost(PostVO postVO);

    String getPostSeq();
}
