package kr.letech.study.board.service;

import com.github.pagehelper.PageInfo;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;

import java.util.List;

public interface BoardService {
    /* select */
    List<BoardVO> getNavItems();
    String getNavNm(String boardId);
    PageInfo<PostVO> getAllPostByBoard(String boardId, int pageNum, int pageSize);
    PostVO getPost(String postId);

    /* insert */
    void insertPost(PostVO postVO, String userId);

    /* update */
    void modifyPost(PostVO postVO, String userId);
}
