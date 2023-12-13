package kr.letech.study.springBoot.test.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TB_TEST_USER")
public class TestUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 id 생성
	private long ID;
	
	private String username;
	
	
}
