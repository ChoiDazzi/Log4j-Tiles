package kr.letech.study.board.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.letech.study.board.mapper.BoardMapper;
import kr.letech.study.board.service.BoardService;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardVO> getNavItems() {
        return boardMapper.getNavItems();
    }
    
    @Override
    public PageInfo<PostVO> getAllPostByBoard(String boardId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostVO> posts = boardMapper.getAllPostByBoard(boardId);
        return new PageInfo<>(posts);
    }

	@Override
	public void modifyBoard(BoardVO boardVO, String userId) {
		boardVO.setUpdtId(userId);
		boardMapper.modifyBoard(boardVO);
	}

	@Override
	public void deleteBoard(String boardId, String userId) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);
		boardVO.setUpdtId(userId);
		boardMapper.deleteBoard(boardVO);
	}

	@Override
	public void insertBoard(String boardNm, String userId) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId("b" + boardMapper.getBoardSeq());
		boardVO.setBoardNm(boardNm);
		boardVO.setUpdtId(userId);
		boardMapper.insertBoard(boardVO);
	}
}
