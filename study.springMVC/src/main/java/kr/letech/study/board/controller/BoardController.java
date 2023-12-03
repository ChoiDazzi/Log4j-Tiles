package kr.letech.study.board.controller;

import com.github.pagehelper.PageInfo;
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
	public String getBoard(@PathVariable String boardId,
						   @RequestParam(defaultValue = "1") int pageNum,
						   @RequestParam(defaultValue = "10") int pageSize,
						   Model model) {
		PageInfo<PostVO> pageInfo = boardService.getAllPostByBoard(boardId, pageNum, pageSize);
		model.addAttribute("boardNm", boardService.getNavNm(boardId));
		model.addAttribute("posts", pageInfo.getList());
		model.addAttribute("pageInfo", pageInfo);

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
		boardService.insertPost(postVO, principal.getName());
		return "redirect:/board/board/b001";
	}

	@GetMapping("/board/detailPost/{boardId}/{postId}")
	public String detailPost(@PathVariable String boardId,
                             @PathVariable String postId,
                             Model model) {
		model.addAttribute("boardNm", boardService.getNavNm(boardId));
		model.addAttribute("postInfo", boardService.getPost(postId));
		return "board/detailPost.main";
	}

	@ResponseBody
	@PostMapping("/board/modifyPost")
	public void modifyPost(PostVO postVO, Principal principal) {
		System.out.println("postVO = " + postVO);
		boardService.modifyPost(postVO, principal.getName());
	}

	@PostMapping("/board/deletePost")
	public String deletePost() {
		return null;
	}
}
