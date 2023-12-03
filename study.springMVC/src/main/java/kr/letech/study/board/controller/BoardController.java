package kr.letech.study.board.controller;

import kr.letech.study.board.service.impl.BoardServiceImpl;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardServiceImpl boardService;

	@ModelAttribute("navItems")
	public List<BoardVO> getNavItems() {
		return boardService.getNavItems();
	}

	@GetMapping("/board/board/{boardId}")
	public String getBoard(@PathVariable String boardId, Model model) {
		model.addAttribute("boardNm", boardService.getNavNm(boardId));
		return "board/board.main";
	}

	@GetMapping("/board/registerPost/{boardId}")
	public String registerPost(@PathVariable String boardId, Model model) {
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNm", boardService.getNavNm(boardId));
		model.addAttribute("currentTime", boardService.getCurrentTime());
		return "board/registerPost.main";
	}

	@PostMapping("/board/registerPost")
	public String registerPost(@ModelAttribute PostVO postVO, Principal principal) {
		System.out.println("postVO = " + postVO);
		boardService.insertPost(postVO, principal.getName());
		return "redirect:/board/board/b001";
	}
}
