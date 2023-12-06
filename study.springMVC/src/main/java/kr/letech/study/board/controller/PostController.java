package kr.letech.study.board.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.letech.study.board.service.impl.BoardServiceImpl;
import kr.letech.study.board.service.impl.FileUploadServiceImpl;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.FileVO;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.letech.study.board.service.impl.PostServiceImpl;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostServiceImpl postService;
	private final FileUploadServiceImpl fileUploadUtils; //service
	private final BoardServiceImpl boardService;
	
	@ModelAttribute("navItems")
	public List<BoardVO> getNavItems() {
		return boardService.getNavItems();
	}
	
	@GetMapping("/post/registerPost/{boardId}")
	public String registerPost(@PathVariable String boardId, Model model) {
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNm", postService.getNavNm(boardId)); //변수로 따로 빼서 담기 
		model.addAttribute("currentTime", postService.getCurrentTime());
		return "board/registerPost.main";
	}

	@PostMapping("/post/registerPost")
	public String registerPost(@ModelAttribute PostVO postVO,
							   @RequestParam("multiUpload") ArrayList<MultipartFile> files, //vo, List 수정 
							   Principal principal) {
		String userId = principal.getName();
		postService.insertPost(postVO, userId);
		if (files.get(0).getSize() != 0) { //서비스 단으로 넘기기 -> TRANSACTION
			List<FileVO> fileVOList = fileUploadUtils.uploadFile(files);
			postService.insertFile(fileVOList, userId, postVO.getPostId());
		}
		return "redirect:/board/board/" + postVO.getBoardId();
	}

	@GetMapping("/post/detailPost/{boardId}/{postId}")
	public String detailPost(@PathVariable String boardId, 
							 @PathVariable String postId, 
							 Model model) {
		model.addAttribute("files", postService.getFileByPost(postId));
		model.addAttribute("boardNm", postService.getNavNm(boardId));
		model.addAttribute("postInfo", postService.getPost(postId));
		return "board/detailPost.main";
	}

	@ResponseBody
	@PostMapping("/post/modifyPost")
	public void modifyPost(PostVO postVO, Principal principal) {
		postService.modifyPost(postVO, principal.getName());
	}

	@ResponseBody
	@PostMapping("/post/deletePost")
	public void deletePost(String postId) {
		postService.deletePost(postId);
	}
	
	@GetMapping("/post/fileDownload/{fileId}")
	public void fileDownload(@PathVariable String fileId, HttpServletResponse response){
		fileUploadUtils.fileDownload(fileId, response);
	}

	@ResponseBody
	@GetMapping("/post/preview")
	public ResponseEntity<byte[]> preview(String fileId) {
		FileVO fileVO = postService.getFileById(fileId);
		ResponseEntity<byte[]> bytefileEntity = fileUploadUtils.preview(fileVO);
		return bytefileEntity;
	}
}
