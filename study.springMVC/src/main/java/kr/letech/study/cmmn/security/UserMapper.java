package kr.letech.study.cmmn.security;

import kr.letech.study.cmmn.security.vo.RoleVO;
import kr.letech.study.cmmn.security.vo.UserAuthVO;
import kr.letech.study.cmmn.security.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserVO getUserInfo(String userId);
    List<String> getUserAuth(String userId);
    List<RoleVO> getAllAuth();
    void signInUser(UserVO userVO);
    void signInAuth(UserAuthVO userAuthVO);
}
