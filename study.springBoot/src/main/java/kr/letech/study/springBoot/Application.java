package kr.letech.study.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		System.setProperty("java.io.tmpdir", "d:/tmp");
		SpringApplication.run(Application.class, args);
	}

}
