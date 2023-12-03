package kr.letech.study.board;

import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    /* select */
    List<BoardVO> getNavItems();
    String getNavNm(String boardId);
    String getPostSeq();
    List<PostVO> getAllPostByBoard(String boardId);
    PostVO getPost(String postId);

    /* insert */
    void insertPost(PostVO postVO);

    /* update */
    void modifyPost(PostVO postVO);

}
