package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main()
	{
		return "main";
	}
	@RequestMapping("main/logout.do")
	 public String main_logout(HttpSession session)
	 {
		 session.invalidate();
		 return "redirect:main.do";
	 }
}
