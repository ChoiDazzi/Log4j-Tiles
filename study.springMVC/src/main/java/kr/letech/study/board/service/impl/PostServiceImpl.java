package kr.letech.study.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.letech.study.board.dao.FileDAO;
import kr.letech.study.board.dao.PostDAO;
import kr.letech.study.board.service.FileService;
import kr.letech.study.board.service.PostService;
import kr.letech.study.board.vo.FileVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	private final PostDAO postDao; 
	private final FileDAO fileDao;
	private final FileService fileService;

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
			List<FileVO> fileVOList = fileService.uploadFile(files);
			for (FileVO fileVO : fileVOList) {
				fileVO.setRgstId(userId);
				fileVO.setPostId(postId);
				fileDao.insertFile(fileVO);
			}
		}
	}

	@Override
	public void modifyPost(PostVO postVO, List<MultipartFile> files, String updtId) {
		postVO.setUpdtId(updtId);
		// 게시글 수정 
		postDao.modifyPost(postVO);
		// 파일 수정 - 파일 삭제 
		List<String> deleteFileIdList = postVO.getDeleteFileIdList();
		FileVO deleteFileVO = new FileVO();
		deleteFileVO.setUpdtId(updtId);
		for (String fileId : deleteFileIdList) {
			deleteFileVO.setFileId(fileId);
			fileService.deleteFIle(deleteFileVO);
		}
		if (files.get(0).getSize() != 0) {
			// 파일 수정 - 파일 등록
			List<FileVO> fileList = fileService.uploadFile(files);
			for (FileVO fileVO : fileList) {
				fileVO.setUpdtId(updtId);
				fileVO.setPostId(postVO.getPostId());
				fileService.insertFile(fileVO);
			}	
		}
	}

	@Override
	public void deletePost(String postId) {
		postDao.deletePost(postId);
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
