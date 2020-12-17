package com.sist.web;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FridgeDAO;
import com.sist.vo.*;

@RestController
@RequestMapping("fridge/")
public class FridgeRestController {
@Autowired
private FridgeDAO dao;

	/*
	 * @PostMapping("ingre_map_detail.do") public List<IngreMapVO>
	 * ingre_map_detail(String region1) { List<IngreMapVO> list =
	 * dao.ingre_map(region1); return list;
	 * 
	 * }
	 */

	// 냉장고에 넣기
	//==================================================================================================
	@GetMapping("ingre_in.do")
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
			
			result="<script charset=\"utf-8\">"
					 +"alert(\"등록되었습니다.\");"
					 +"location.reload();"
					 +"</script>";
	
		}
		// 재료가 등록되어 있다면? count!=0
		else
		{
			result="<script charset=\"utf-8\">"
					 +"alert(\"이미 등록된 재료입니다.\");"
					 +"history.back();"
					 +"location.reload();"
					 +"</script>";
		}
	
		return result;
	}
	
	
	
	// 관심상품에 넣기
		//==================================================================================================
	//ingre_heart.do?ingre_name
		@GetMapping("ingre_heart.do")
		public String favorite_ingre_in(String ingre_name,HttpSession session)
		{
			String id = (String) session.getAttribute("id");
		
			// 재료 있는지 확인하기
			Map map = new HashMap();
			map.put("ingre_name", ingre_name);
			map.put("id", id);
			int count=dao.fav_ingre_insert_check(map);
			
			String result="";
		
			// 재료가 등록되어 있지 않다면? count=0
			if(count==0)
			{
				
				dao.fav_ingre_insert(map);
				System.out.println("데이터 들어감");
				
				result="<script charset=\"utf-8\">"
						 +"alert(\"등록되었습니다.\");"
						 +"location.reload();"
						 +"</script>";
		
			}
			// 재료가 등록되어 있다면? count!=0
			else
			{
				result="<script charset=\"utf-8\">"
						 +"alert(\"이미 등록된 재료입니다.\");"
						 +"history.back();"
						 +"location.reload();"
						 +"</script>";
			}
		
			return result;
		}
	
	
	// 냉장고에서 빼기
	//==================================================================================================	
	@GetMapping("ingre_out.do")
	public String fridge_ingre_out(String ingre_name,HttpSession session)
	{
		String id = (String) session.getAttribute("id");
	
		// 재료 있는지 확인하기
		Map map = new HashMap();
		map.put("ingre_name", ingre_name);
		map.put("id", id);
		int count=dao.my_fridge_insert_check(map);
		
		String result="";
	
		// 재료가 등록되어 있다면 삭제
		if(count!=0)
		{
			
			dao.my_fridge_delete(map);
			System.out.println("데이터 삭제됨");
			
			result="<script>"
					 +"alert(\"삭제되었습니다.\");"
					 +"location.reload();"
					 +"</script>";
	
		}
		// 재료가 등록되어 있지 않다면 빼는 거 불가
		else
		{
			result="<script>"
					 +"alert(\"등록되어 있지 않은 재료입니다.\");"
					 +"history.back();"
					 +"location.reload();"
					 +"</script>";
		}
	
		return result;
	}
	
	
	// 냉장고에서 빼기
		//==================================================================================================	
		@GetMapping("heard_out.do")
		public String favorite_ingre_out(String ingre_name,HttpSession session)
		{
			String id = (String) session.getAttribute("id");
		
			// 재료 있는지 확인하기
			Map map = new HashMap();
			map.put("ingre_name", ingre_name);
			map.put("id", id);
			int count=dao.fav_ingre_insert_check(map);
			
			String result="";
		
			// 재료가 등록되어 있다면 삭제
			if(count!=0)
			{
				
				dao.fav_ingre_delete(map);
				System.out.println("데이터 삭제됨");
				
				result="<script>"
						 +"alert(\"삭제되었습니다.\");"
						 +"location.reload();"
						 +"</script>";
		
			}
			// 재료가 등록되어 있지 않다면 빼는 거 불가
			else
			{
				result="<script>"
						 +"alert(\"등록되어 있지 않은 재료입니다.\");"
						 +"history.back();"
						 +"location.reload();"
						 +"</script>";
			}
			return result;
		}
	
	
}
