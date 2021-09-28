package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// RequestMapping (Type + Method)
@RequestMapping("/user")
@Controller
public class UserController {
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinform() {
		return "/WEB-INF/views/joinform.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@RequestParam String name,
						@RequestParam String email,
						@RequestParam String password) {
		System.out.println("name" + name);
		System.out.println("email" + email);
		System.out.println("password" + password);
		
		// 리다이렉트
		return "redirect:/user/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/joinsuccess")
	public String joinsucess() {
		return "<h1>JOIN SUCCESS</h1>";
	}
}
