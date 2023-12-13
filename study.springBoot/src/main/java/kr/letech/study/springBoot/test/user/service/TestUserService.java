package kr.letech.study.springBoot.test.user.service;

import java.util.List;

import kr.letech.study.springBoot.test.user.dto.TestUserDTO;
import kr.letech.study.springBoot.test.user.entity.TestUser;

public interface TestUserService {
	List<TestUser> selectUserList();
	TestUser selectUser(Long ID);
	TestUser insertUser(TestUserDTO testUserDTO);
}
