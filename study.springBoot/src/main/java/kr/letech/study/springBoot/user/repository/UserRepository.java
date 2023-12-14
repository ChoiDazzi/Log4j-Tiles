/**
 * 
 */
package kr.letech.study.springBoot.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.user.entity.Users;

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

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    /**
     * 사용자 아이디로 사용자 정보
     * @param userId
     * @return
     */
    Users findByUserId(String userId);
}
