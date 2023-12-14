/**
 * 
 */
package kr.letech.study.springBoot.user.entity;

import javax.persistence.*;

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

@Entity
@Getter
@Setter
@ToString
@Table(name = "TB_USERS")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String userId; // 사용자 아이디
	private String userNm; // 사용자 이름
	private String userPw; // 사용자 비밀번호
	private String role;	// 사용자 권한
}
