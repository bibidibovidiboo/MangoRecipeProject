package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FightController {
	@RequestMapping("fight/list.do")
	public String fight_list(){
		
		return "fight/list";
	}
}
