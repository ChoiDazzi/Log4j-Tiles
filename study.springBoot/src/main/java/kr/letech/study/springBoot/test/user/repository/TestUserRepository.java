package kr.letech.study.springBoot.test.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.test.user.entity.TestUser;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {

}
