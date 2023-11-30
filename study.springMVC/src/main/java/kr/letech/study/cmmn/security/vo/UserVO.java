package kr.letech.study.cmmn.security.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
    private String userId;
    private String userPw;
    private String userNm;
}
