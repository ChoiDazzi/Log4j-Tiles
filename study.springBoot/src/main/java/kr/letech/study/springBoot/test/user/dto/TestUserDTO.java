package kr.letech.study.springBoot.test.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestUserDTO { //Data Transfer Object: 데이터를 전송해주는 객체 
	private String userNm;
}
