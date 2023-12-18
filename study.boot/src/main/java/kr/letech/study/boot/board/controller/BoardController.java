/**
 * 
 */
package kr.letech.study.boot.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import kr.letech.study.boot.board.service.BoardServiceImpl;
import kr.letech.study.boot.board.service.FileService;
import kr.letech.study.boot.board.service.PostServiceImpl;
import kr.letech.study.boot.board.vo.FileVO;
import kr.letech.study.boot.board.vo.PostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 
 * </pre>
 *  
 * << 개정이력 >>
 *   
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2023-12-18  CSY			최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardServiceImpl boardService;
	private final PostServiceImpl postService;
	private final FileService fileService; 
	
	/**
	 * 게시판에 따른 게시물 목록
	 * @param boardId	게시판 아이디
	 * @param pageNum	게시판 페이지 번호 
	 * @param pageSize	게시판 페이지 사이즈
	 * @param boardVO
	 * @param model
	 * @return			게시글 목록
	 */
	
	@GetMapping("/boards/{boardId}")
	public ResponseEntity<PageInfo<PostVO>> getBoard(@PathVariable String boardId,
						   @RequestParam(defaultValue = "1") int pageNum,
						   @RequestParam(defaultValue = "10") int pageSize) {
		PageInfo<PostVO> pageInfo = boardService.getAllPostByBoard(boardId, pageNum, pageSize);
		log.info("pageInfo", pageInfo);
		return ResponseEntity.ok(pageInfo);
	}
	
}
