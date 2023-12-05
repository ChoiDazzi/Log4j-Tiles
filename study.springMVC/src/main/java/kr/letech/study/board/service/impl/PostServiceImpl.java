package kr.letech.study.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.letech.study.board.vo.FileVO;
import org.springframework.stereotype.Service;

import kr.letech.study.board.mapper.BoardMapper;
import kr.letech.study.board.mapper.PostMapper;
import kr.letech.study.board.service.PostService;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	private final PostMapper postMapper;

	@Override
	public String getNavNm(String boardId) {
		return postMapper.getNavNm(boardId);
	}

	@Override
	public PostVO getPost(String postId) {
		 return postMapper.getPost(postId);
	}

	@Override
	public void insertPost(PostVO postVO, String userId, List<FileVO> fileVOList) {
		postVO.setUserId(userId);
        postVO.setRgstId(userId);
        postVO.setPostId(generatePostId(userId));
		postMapper.insertPost(postVO);
		for (FileVO fileVO : fileVOList) {
			fileVO.setRgstId(userId);
			fileVO.setPostId(postVO.getPostId());
			postMapper.insertFile(fileVO);
		}
	}

	@Override
	public void modifyPost(PostVO postVO, String userId) {
		postVO.setUpdtId(userId);
		postMapper.modifyPost(postVO);
		
	}

	@Override
	public void deletePost(String postId) {
		postMapper.deletePost(postId);
	}
	
	@Override
	public List<FileVO> getFileByPost(String postId) {
		return postMapper.getFileByPost(postId);
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
        String postId = formatter.format(date) + "-" + postMapper.getPostSeq() + "-" +userId;
        System.out.println("postId = " + postId);
        return postId;
    }

}
