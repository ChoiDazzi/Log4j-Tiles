package kr.letech.study.springBoot.test.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.test.user.dto.TestUserDTO;
import kr.letech.study.springBoot.test.user.entity.TestUser;
import kr.letech.study.springBoot.test.user.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestUserServiceImpl implements TestUserService{
	private final TestUserRepository userRepository;
	
	@Override
	public List<TestUser> selectUserList() {
		return userRepository.findAll();
	}

	@Override
	public TestUser selectUser(Long ID) {
		Optional<TestUser> result = this.userRepository.findById(ID);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get();
		}
		
	}

	@Override
	public TestUser insertUser(TestUserDTO testUserDTO) {
		TestUser user = new TestUser();
		user.setUsername(testUserDTO.getUserNm());
		return userRepository.save(user);
	}

}
