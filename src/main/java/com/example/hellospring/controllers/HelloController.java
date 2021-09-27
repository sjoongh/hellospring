package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		mav.addObject("message",	// 키
				"Hello, " + name);	// 값
		// 뷰파일을 연결: 서블릿에서 RequestDispatcher로 포워드한 것과 비슷
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
}
