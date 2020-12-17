package com.sist.web;

<<<<<<< Updated upstream
import java.util.*;

import com.sist.dao.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.List;

import javax.servlet.http.HttpSession;
>>>>>>> Stashed changes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MainDAO;
<<<<<<< Updated upstream
import com.sist.dao.RestaurantVO;
import com.sist.dao.RecipeVO;
=======
import com.sist.dao.RecommandData;
import com.sist.vo.*;
>>>>>>> Stashed changes

@Controller
public class MainController {
	@Autowired
	private MainDAO mdao;
	
<<<<<<< Updated upstream
	
	@RequestMapping("main/main.do")
	public String main_main(Model model) {
=======
	@RequestMapping("main/main.do")
	public String main_main(Model model)
	{
>>>>>>> Stashed changes
		mainRestaurant(model);
		mainRecipe(model);
		mainfind_recipe(model);
		mainweatherDetailData(model);
		return "main";
	}
<<<<<<< Updated upstream

	
	//레스토랑
	public void mainRestaurant(Model model) {
		List<com.sist.dao.RestaurantVO> rList = mdao.mainGetRestaurantListData();
=======
	@RequestMapping("main/logout.do")
	 public String main_logout(HttpSession session)
	 {
		 session.invalidate();
		 return "redirect:main.do";
	 }
	
	//레스토랑
	public void mainRestaurant(Model model) {
		List<RestaurantVO> rList = mdao.mainGetRestaurantListData();
>>>>>>> Stashed changes
		model.addAttribute("rList", rList);
	}
	
	//레시피
	public void mainRecipe(Model model) {
<<<<<<< Updated upstream
		List<com.sist.dao.RecipeVO> rdList = mdao.mainRecipeData();
=======
		List<RecipeVO> rdList = mdao.mainRecipeData();
>>>>>>> Stashed changes
		model.addAttribute("rdList", rdList);
	}

	// 날씨1
	public void mainfind_recipe(Model model) {
		// 레시피 검색
		RecommandData RecommandData = new RecommandData();
		String wd = RecommandData.weather();
		String food = "";
		if (wd.equals("흐림") || wd.equals("구름많음")) {
			food = "찌개";
		} else if (wd.equals("비") || wd.equals("눈비")) {
			food = "전";
		} else if (wd.equals("눈")) {
			food = "눈오는";
		} else // 맑은날씨
		{
			food = " ";
		}
		model.addAttribute("wd", wd);
	}

	// 날씨2
	public void mainweatherDetailData(Model model) {
<<<<<<< Updated upstream
		List<com.sist.dao.RecipeVO> wddList = mdao.mainweatherDetailData();
=======
		List<RecipeVO> wddList = mdao.mainweatherDetailData();
>>>>>>> Stashed changes
		model.addAttribute("wddList", wddList);
	}

}
