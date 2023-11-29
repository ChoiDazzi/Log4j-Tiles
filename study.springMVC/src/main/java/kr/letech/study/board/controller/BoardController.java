package kr.letech.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@GetMapping("/board/board.do")
	public String getBoard() {
		return "board/board.main";
	}
	
	@GetMapping("/board2.do")
	public String getBoard2() {
		return "board2.main";
	}
	
	@GetMapping("/board/popup.do")
	public String getPopup() {
		return "board/popup.popup";
	}
}
