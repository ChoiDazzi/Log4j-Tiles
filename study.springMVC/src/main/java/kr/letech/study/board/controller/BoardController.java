package kr.letech.study.board.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import kr.letech.study.board.service.impl.BoardServiceImpl;
import kr.letech.study.board.service.impl.PostServiceImpl;
import kr.letech.study.board.vo.BoardVO;
import kr.letech.study.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardServiceImpl boardService;
	private final PostServiceImpl postService;

	@ModelAttribute("navItems")
	public List<BoardVO> getNavItems() {
		return boardService.getNavItems();
	}

	@GetMapping("/board/board")
	public String getMain() {
		return "board/boardMain.main";
	}

	@GetMapping("/board/board/{boardId}")
	public String getBoard(@PathVariable String boardId,
						   @RequestParam(defaultValue = "1") int pageNum,
						   @RequestParam(defaultValue = "10") int pageSize,
						   BoardVO boardVO,
						   Model model) {
		PageInfo<PostVO> pageInfo = boardService.getAllPostByBoard(boardVO, pageNum, pageSize);
		model.addAttribute("boardNm", postService.getNavNm(boardId));
		model.addAttribute("posts", pageInfo.getList());
		model.addAttribute("pageInfo", pageInfo);
		return "board/board.main";
	}

	@GetMapping("/board/manageBoard")
	public String getManageBoard() {
		return "board/manageBoard.main";
	}
	
	@PostMapping("/board/insertBoard")
	public String insertBoard(String boardNm, Principal principal) {
		boardService.insertBoard(boardNm, principal.getName());
		return "redirect:/board/manageBoard";
	}
	
	@PostMapping("/board/modifyBoard")
	@ResponseBody
	public void modifyBoard(BoardVO boardVO, Principal principal) {
		boardService.modifyBoard(boardVO, principal.getName());
	}

	@PostMapping("/board/deleteBoard")
	@ResponseBody
	public void modifyBoard(String id, Principal principal) {
		boardService.deleteBoard(id, principal.getName());
	}
}
