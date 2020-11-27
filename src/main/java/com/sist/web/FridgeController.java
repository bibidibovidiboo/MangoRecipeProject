package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FridgeDAO;
import com.sist.mapper.FridgeMapper;
import com.sist.vo.FridgeVO;

@Controller
@RequestMapping("fridge/")
public class FridgeController {
	@Autowired
	private FridgeDAO dao;
	@RequestMapping("fridge_main.do")
	public String fridge_main(String ingre_name,Model model)
	{
		List<FridgeVO> list = null;
		if(ingre_name!=null)
		{
			list= dao.fridge_ingre_search(ingre_name);
		}
		
		model.addAttribute("list",list);
		return "fridge/fridge_main";
	}
}
