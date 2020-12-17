package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(Model model)
	{
		String kakaoUrl = KakaoLoginController.getAuthorizationUrl();
		model.addAttribute("kakaoUrl",kakaoUrl);
		
		return "main";
	}
	@RequestMapping("main/logout.do")
	 public String main_logout(HttpSession session)
	 {
		 session.invalidate();
		 return "redirect:main.do";
	 }
}