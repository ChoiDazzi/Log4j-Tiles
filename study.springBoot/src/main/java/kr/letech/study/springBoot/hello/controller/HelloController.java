package kr.letech.study.springBoot.hello.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 *
 * << 개정이력 >>
 *
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2023-12-12  YSH			최초 생성
 */
@RestController
public class HelloController {

	@GetMapping("/api/v1/hello")
	public ResponseEntity<String> hello(String name) {
		String resultNm = null;
		if (StringUtils.isAllBlank(name)) {
			resultNm = "익명";
		} else {
			resultNm = name;
		}
		return ResponseEntity.ok(resultNm + "님 안녕하세요!!!!");
	}
}
