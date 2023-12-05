package kr.letech.study.board.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.letech.study.board.service.impl.FileUploadUtils;
import kr.letech.study.board.vo.FileVO;
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
	private final FileUploadUtils fileUploadUtils;

	@GetMapping("/post/registerPost/{boardId}")
	public String registerPost(@PathVariable String boardId, Model model) {
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNm", postService.getNavNm(boardId));
		model.addAttribute("currentTime", postService.getCurrentTime());
		return "board/registerPost.main";
	}

	@PostMapping("/post/registerPost")
	public String registerPost(@ModelAttribute PostVO postVO,
							   @RequestParam("multiUpload") ArrayList<MultipartFile> files,
							   Principal principal) {
		List<FileVO> fileVOList = fileUploadUtils.uploadFile(files);
		postService.insertPost(postVO, principal.getName(), fileVOList);
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
}
