package com.sist.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FridgeDAO;

@RestController
@RequestMapping("fridge/")
public class FridgeRestController {
@Autowired
private FridgeDAO dao;
	@PostMapping("ingre_in.do")
	public String fridge_ingre_in(String ingre_name,HttpSession session)
	{
		String id = (String) session.getAttribute("id");
	
		// 재료 있는지 확인하기
		Map map = new HashMap();
		map.put("ingre_name", ingre_name);
		map.put("id", id);
		int count=dao.my_fridge_insert_check(map);
		
		String result="";
	
		// 재료가 등록되어 있지 않다면? count=0
		if(count==0)
		{
			
			dao.my_fridge_insert(map);
			System.out.println("데이터 들어감");
			
			result="<script>"
					 +"alert(\"등록되었습니다.\");"
					 +"location.reload();"
					 +"</script>";
	
		}
		// 재료가 등록되어 있다면? count!=0
		else
		{
			result="<script>"
					 +"alert(\"이미 등록된 재료입니다.\");"
					 +"history.back();"
					 +"location.reload();"
					 +"</script>";
		}
	
		return result;
	}
	
}
