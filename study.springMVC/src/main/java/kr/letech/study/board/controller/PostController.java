package kr.letech.study.board.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.letech.study.board.service.BoardService;
import kr.letech.study.board.service.FileService;
import kr.letech.study.board.service.PostService;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.FileVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
	private final FileService fileService; 
	private final BoardService boardService;
	
	@ModelAttribute("navItems")
	public List<BoardVO> getNavItems() {
		return boardService.getNavItems();
	}
	
	@GetMapping("/post/registerPost/{boardId}")
	public String registerPost(@PathVariable String boardId, Model model) {
		String navNm = postService.getNavNm(boardId);
		String currentTime = postService.getCurrentTime();
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNm", navNm); 
		model.addAttribute("currentTime", currentTime);
		return "board/registerPost.main";
	}

	@PostMapping("/post/registerPost")
	public String registerPost(@ModelAttribute PostVO postVO,
							   @RequestParam("multiUpload") List<MultipartFile> files, 
							   Principal principal) {
		System.out.println("postVO = " + postVO);
		String userId = principal.getName();
		postService.insertPost(postVO, userId, files);
		return "redirect:/board/board/" + postVO.getBoardId();
	}

	@GetMapping("/post/detailPost/{boardId}/{postId}")
	public String detailPost(@PathVariable String boardId, 
							 @PathVariable String postId, 
							 Model model) {
		List<FileVO> files = fileService.getFileByPost(postId);
		String boardNm = postService.getNavNm(boardId);
		PostVO postInfo = postService.getPost(postId);
		model.addAttribute("files", files);
		model.addAttribute("boardNm", boardNm);
		model.addAttribute("postInfo", postInfo);
		return "board/detailPost.main";
	}

	@ResponseBody
	@PostMapping("/post/modifyPost")
	public void modifyPost(@ModelAttribute PostVO postVO, 
						   @RequestParam String deleteFileIdList,
						   @RequestParam("multiUpload") List<MultipartFile> files,
						   Principal principal) {
		String updtId = principal.getName();
		postService.modifyPost(postVO, deleteFileIdList, files, updtId);
	}

	@ResponseBody
	@PostMapping("/post/deletePost")
	public void deletePost(String postId) {
		postService.deletePost(postId);
	}
	
	@GetMapping("/post/fileDownload/{fileId}")
	public void fileDownload(@PathVariable String fileId, HttpServletResponse response){
		fileService.fileDownload(fileId, response);
	}

	@ResponseBody
	@GetMapping("/post/preview")
	public void preview(String fileId, HttpServletResponse response) {
		FileVO fileVO = fileService.getFileById(fileId);
		fileService.preview(fileVO, response);
	}
}
