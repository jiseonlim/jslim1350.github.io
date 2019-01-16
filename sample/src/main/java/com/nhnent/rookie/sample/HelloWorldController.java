package com.nhnent.rookie.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

@Controller
public class HelloWorldController {		// Controller
	@GetMapping("/helloworld")
	@ResponseBody
	public String helloWorld() {
		return "Hello World!";
	}
	
	// application.properties에 있는 application.message 값이 우선순위가 가장 높음
	// 없으면 @Value값!
	@Value("${application.message:Hello Default}")	// message의 default값을 설정. 값이 없으면 에러가 남
	private String message;			// @가 있으면 여기에 있는 값은 의미가 없음(무시됨)
	
	@GetMapping("/")
	public String welcome(Model model) {		// Model
		model.addAttribute("time", new Date());
		model.addAttribute("message", this.message);
		return "welcome";		// View 반환
	}
}
