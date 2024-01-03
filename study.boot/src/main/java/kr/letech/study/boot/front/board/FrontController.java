/**
 * 
 */
package kr.letech.study.boot.front.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <pre>
 * 
 * </pre>
 *  
 * << 개정이력 >>
 *   
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2024-01-03  CSY			최초 생성
 */

@Controller
public class FrontController {
	
	@GetMapping("/front/boards")
	public String list() {
		return "/board/list";
	}
}
