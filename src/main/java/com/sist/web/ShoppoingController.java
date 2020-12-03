package com.sist.web;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("shopping/")
public class ShoppoingController {
	@Autowired
	private ShoppingDAO dao;
	
	//@Autowired
	//private RecipeDAO rdao;
	
	// 가격 리스트
	@RequestMapping("list.do")
	public String shopping_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<ShoppingVO> list=dao.shoppingListData(map);
		
		int totalpage=dao.shoppingTotalPage();
		
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);
		return "shopping/list";
	}
	
	// 상세보기
	@RequestMapping("detail.do")
	public String shopping_detail(int no,String category3,String title,Model model)
	{
		System.out.println("category3"+category3);
		ShoppingVO vo=dao.shoppingDetailData(no);
		//상세보기 레시피데이터
		List<RecipeVO> rList=dao.shoppingRecipeData(category3);
		model.addAttribute("rList",rList);
		model.addAttribute("vo",vo);
		return "shopping/detail";
	}
	
	
	//카테고리 분류
	@RequestMapping("cate.do")
	public List<ShoppingVO> shopping_cate(String name)
	{
		List<ShoppingVO> list = dao.shoppingCateDate(name);
		
		return list;	
	}
	

	
	
	
	
	
}
