package com.sist.web;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.*;
import com.sist.vo.RecipeCookVO;
import com.sist.vo.RecipeIngreVO;
import com.sist.vo.RecipeVO;

@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	/*
	
	@RequestMapping("recipe/detail.do")
	public String recipe_detial(int rno,Model model){
		RecipeVO vo=dao.recipeDetailData(rno);
		model.addAttribute("vo",vo);
		return "recipe/detail";
	}*/
	
	
	@RequestMapping("recipe/list.do")
	
	public String recipe_list(String page, Model model,HttpServletRequest request)
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
		List<RecipeVO> list=dao.recipeListData(map);
		
		int totalpage=dao.recipeTotalPage();
		
		List<RecipeVO> cList=new ArrayList<RecipeVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(int i=cookies.length-1;i>=0;i--){
				if(cookies[i].getName().startsWith("m")){
					RecipeVO vo=dao.recipeDetailData(Integer.parseInt(cookies[i].getValue()));
					cList.add(vo);
				}
			}
		}
		
		model.addAttribute("cList",cList);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);
		return "recipe/list";
	}
	
	
	@RequestMapping("recipe/detail_before.do")
	public String recipe_detail_before(int rno,RedirectAttributes ra, HttpServletResponse response)
	{
		Cookie cookie=new Cookie("m"+rno, String.valueOf(rno));
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		return "redirect:detail.do?rno="+rno;
	}
	
	@RequestMapping("recipe/detail.do")
	public String recipe_detial(int rno,Model model){
		// 레시피 개요 검색
		RecipeVO vo=dao.recipeDetailData(rno);
		model.addAttribute("vo",vo);
		//System.out.println(rno);
		String title= dao.recipeTitle(rno);
		
		//System.out.println(title);
		List<RecipeCookVO> cList= dao.recipeCookData(title);
		for(RecipeCookVO vo2:cList)
		{
			
			//System.out.println(vo2.getCook());
		}
		
		
		model.addAttribute("cList",cList);
		
		List<RecipeIngreVO> iList= dao.recipeIngreData(title);
		model.addAttribute("iList",iList);
		
		return "recipe/detail";
	}
	
	
	
}
