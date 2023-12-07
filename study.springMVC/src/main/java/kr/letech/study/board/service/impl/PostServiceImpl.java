package kr.letech.study.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.letech.study.board.vo.FileVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.letech.study.board.dao.PostDAO;
import kr.letech.study.board.service.PostService;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	private final PostDAO postDao; 
	private final FileUploadServiceImpl fileUploadService;

	@Override
	public String getNavNm(String boardId) {
		return postDao.getNavNm(boardId);
	}

	@Override
	public PostVO getPost(String postId) {
		 return postDao.getPost(postId);
	}

	@Override
//	@Transactional
	public void insertPost(PostVO postVO, String userId, List<MultipartFile> files) {
		postVO.setUserId(userId);
        postVO.setRgstId(userId);
        postVO.setPostId(generatePostId(userId));
		postDao.insertPost(postVO);
		String postId = postVO.getPostId();
		if (files.get(0).getSize() != 0) {
			List<FileVO> fileVOList = fileUploadService.uploadFile(files);
			for (FileVO fileVO : fileVOList) {
				fileVO.setRgstId(userId);
				fileVO.setPostId(postId);
				postDao.insertFile(fileVO);
			}
		}
	}

	@Override
	public void modifyPost(PostVO postVO, String userId) {
		postVO.setUpdtId(userId);
		postDao.modifyPost(postVO);
		
	}

	@Override
	public void deletePost(String postId) {
		postDao.deletePost(postId);
	}
	
	@Override
	public List<FileVO> getFileByPost(String postId) {
		return postDao.getFileByPost(postId);
	}
	

	@Override
	public FileVO getFileById(String fileId) {
		return postDao.getFileById(fileId);
	}
	
	@Override
    public String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(); 
        return formatter.format(date);
    }

    public String generatePostId(String userId) {
        //등록날짜-seq(000001)-등록자id
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String postId = formatter.format(date) + "-" + postDao.getPostSeq() + "-" +userId;
        return postId;
    }
}
