/**
 * 
 */
package kr.letech.study.springBoot.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <pre>
 * 
 * </pre>
 *  
 * << 개정이력 >>
 *   
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2023-12-14  CSY			최초 생성
 */

@Getter
@Setter
@ToString
public class UsersDTO {
	private String userId; 	// 사용자 아이디
	private String userNm; 	// 사용자 이름
	private String userPw; 	// 사용자 비밀번호
	private String role;	// 사용자 권한
}
