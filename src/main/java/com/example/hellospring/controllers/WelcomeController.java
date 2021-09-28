package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hellospring.vo.RequestVo;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	//	파라미터 받아오기
	@RequestMapping("/")
//	public ModelAndView home(@RequestParam("name") String name) {
	public ModelAndView home(
			@RequestParam(value="name", 
				required=false, 
				defaultValue="Anonymous") String name) {
		//	파라미터의 필수 여부와 기본값을 지정할 수 있다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello, " + name);
		mav.setViewName("/WEB-INF/views/welcome.jsp");
		return mav;
	}
	
	// 파라미터를 쿼리 스트링이 아니라 URL Path로 전달
	@RequestMapping("/pathparams/{name}/{no}")
	public ModelAndView pathParams(@PathVariable("name") String name,
			@PathVariable("no") Long no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name: " + name + " No: " + no);
		mav.setViewName("/WEB-INF/views/welcome.jsp");
		
		return mav;
	}
	
	// /using-vo?name=hong&no=2021
	// 요청 파라미터를 DTO 객체에 담아서 전달 @ModelAttribute
	@RequestMapping("/using-vo")
	public ModelAndView usingVo(@ModelAttribute RequestVo reqVo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name: "+reqVo.getName()+", No: "
				+reqVo.getNo());
		mav.setViewName("/WEB-INF/views/welcome.jsp");
		
		return mav;
	}
	
	// Return Type이 String이면 ViewName을 의미
	@RequestMapping("/rstr")
	public String returnString() {
		return "/WEB-INF/views/welcome.jsp";
	}
	
	// 메서드 인자 값으로 Model or ModelMap을 함께 주면
	// View에 객체를 전달할 수 있다.
	@RequestMapping("/rstr2")
	public String returnString2(ModelMap map) {
		map.addAttribute("message", "ModelMap 사용");
		return "/WEB-INF/views/welcome.jsp";
	}
}