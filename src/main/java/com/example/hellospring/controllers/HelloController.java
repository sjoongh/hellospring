package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// 메서드 단독 매핑
//@Controller("myController") 이름을 명시하지 않아도됨
@Controller
public class HelloController {
	// 메서드가 /hello URL 요청에 반응하도록 한다
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam String name) {
		// 서블릿에서 getParameter로 해준 것을
		// RequestParam이 대신 해준 것
		ModelAndView mav = new ModelAndView();
		
		// 객체 추가: 서블릿에서 addAttribute의 역할
		// key=message가 value=Hello World를 저장
		// name은 url을 통해 값을 입력해줌
		// name의 값이 null일 경우 spring에서 감지해 오류 발생		
		mav.addObject("message",	// 키
				"Hello, " + name);	// 값
		// 뷰파일을 연결: 서블릿에서 RequestDispatcher로 포워드한 것과 비슷
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	// /hello2라는 url요청에 반응
	@RequestMapping("/hello2")
	// 문자열을 반환하면 해당 뷰로의 포워딩을 의미
	public String hello2() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	// 문자열을 반환할 때 직접 응답으로 전송하고 싶을 때
	// ResponseBody -> MessageConverter를 실행하는 어노테이션
	@ResponseBody
	@RequestMapping("/hello3")
	public String hello3() {
		return "<h1>문자열 직접 전송</h1>";
	}
}
