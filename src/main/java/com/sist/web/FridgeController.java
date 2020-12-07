package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FridgeDAO;
import com.sist.mapper.FridgeMapper;
import com.sist.vo.*;

@Controller
@RequestMapping("fridge/")
public class FridgeController {
	@Autowired
	private FridgeDAO dao;
	/*
	 * // 식재료 검색---------------------------------------------------------------------------
	 * 
	 * @RequestMapping("ingre_search.do") public String ingre_search(String
	 * ingre_name,Model model) {
	 * 
	 * 
	 * List<FridgeIngreVO> list = null; if(ingre_name!=null) { list=
	 * dao.fridge_ingre_search(ingre_name); } model.addAttribute("list",list);
	 * return "fridge/fridge_main"; }
	 */
	
	
	@RequestMapping("fridge_main.do")
	public String fridge_main(String ingre_name,Model model,HttpSession session)
	{
		
		// 식재료 검색------------------------------------------------------------------------
		List<FridgeIngreVO> list = null;
		if(ingre_name!=null)
		{
			list= dao.fridge_ingre_search(ingre_name);
		}
		model.addAttribute("list",list);
		
		// 등록한 리스트 출력하기------------------------------------------------------------------------
		
		  String id = (String) session.getAttribute("id"); 
		  
		  if(id!=null)
		  {
			  List<MyFridgeListVO> rList =
			  dao.fridge_ingre_list(id); model.addAttribute("rList",rList);
		  }
		 
		return "fridge/fridge_main";
	}
	@PostMapping("ingre_out.do")
	public String fridge_ingre_out(String ingre_name,HttpSession session)
	{
		String id = (String) session.getAttribute("id");
		Map map = new HashMap();
		map.put("id",id);
		map.put("ingre_name", ingre_name);
		if(id!=null)
			dao.my_fridge_delete(map);
		
		return "redirect:fridge_main";
	}
	
}
