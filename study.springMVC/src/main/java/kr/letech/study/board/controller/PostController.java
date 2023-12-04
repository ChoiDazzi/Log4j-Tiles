package kr.letech.study.board.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.letech.study.board.service.impl.PostServiceImpl;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostServiceImpl postService;
	@GetMapping("/post/registerPost/{boardId}")
	public String registerPost(@PathVariable String boardId, Model model) {
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNm", postService.getNavNm(boardId));
		model.addAttribute("currentTime", postService.getCurrentTime());
		return "board/registerPost.main";
	}

	@PostMapping("/post/registerPost")
	public String registerPost(@ModelAttribute PostVO postVO, Principal principal) {
		postService.insertPost(postVO, principal.getName());
		return "redirect:/board/board/b001";
	}

	@GetMapping("/post/detailPost/{boardId}/{postId}")
	public String detailPost(@PathVariable String boardId, @PathVariable String postId, Model model) {
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
}
