/**
 * 
 */
package kr.letech.study.boot.board.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.letech.study.boot.board.service.FileService;
import kr.letech.study.boot.board.service.PostService;
import kr.letech.study.boot.board.vo.PostVO;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * 
 * </pre>
 *  
 * << 개정이력 >>
 *   
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2023-12-19  CSY			최초 생성
 */

@RestController
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	private final FileService fileService;
	
	/**
	 * 게시글 등록
	 * @param postVO	등록할 게시물 정보
	 * @param files		등록할 파일 정보
	 * @param principal
	 */
	@PostMapping(value = "/api/v1/posts", 
				 consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registerPost(@ModelAttribute PostVO postVO,
										     @RequestPart("multiUpload") List<MultipartFile> files, 
										     Principal principal) {
		String userId = principal.getName();
		postService.insertPost(postVO, userId, files);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * 게시글 상세 정보
	 * @param boardId	게시글이 속해있는 게시판 아이디
	 * @param postId	조회하려는 게시글 아이디
	 * @return 게시물 상세 정보
	 */
	@GetMapping("/api/v1/posts/{postId}")
	public ResponseEntity<PostVO> detailPost(@PathVariable String postId) {
//		List<FileVO> files = fileService.getFileByPost(postId);
//		String boardNm = postService.getNavNm(boardId);
		PostVO postInfo = postService.getPost(postId);
		return ResponseEntity.ok(postInfo);
	}
	
	/**
	 * 게시글 수정
	 * @param postVO	수정할 게시글 내용
	 * @param files		추가 업로드 파일
	 */
	@PutMapping(value = "/api/v1/posts", 
				consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> modifyPost(@ModelAttribute PostVO postVO, 
						   @RequestPart("multiUpload") List<MultipartFile> files,
						   Principal principal) {
		String updtId = principal.getName();
		postService.modifyPost(postVO, files, updtId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * 게시글 삭제
	 * @param postId	삭제할 게시글 아이디
	 */
	@DeleteMapping("/api/v1/posts")
	public ResponseEntity<Void> deletePost(String postId) {
		postService.deletePost(postId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
