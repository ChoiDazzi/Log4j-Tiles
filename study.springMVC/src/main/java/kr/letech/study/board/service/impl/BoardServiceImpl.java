package kr.letech.study.board.service.impl;

import kr.letech.study.board.BoardMapper;
import kr.letech.study.board.service.BoardService;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardVO> getNavItems() {
        return boardMapper.getNavItems();
    }

    @Override
    public String getNavNm(String boardId) {
        return boardMapper.getNavNm(boardId);
    }

    @Override
    public void insertPost(PostVO postVO, String userId) {
        postVO.setUserId(userId);
        postVO.setRgstId(userId);
        postVO.setPostId(generatePostId(userId));
        boardMapper.insertPost(postVO);
    }

    public String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public String generatePostId(String userId) {
        //등록날짜-seq(000001)-등록자id
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String postId = formatter.format(date) + "-" + boardMapper.getPostSeq() + "-" +userId;
        System.out.println("postId = " + postId);
        return postId;
    }

}
