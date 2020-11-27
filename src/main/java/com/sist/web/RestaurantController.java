package com.sist.web;
import java.util.*;

import com.sist.dao.*;
import com.sist.vo.RestaurantVO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantDAO dao;
	
	@RequestMapping("restaurant/resList.do")
	public String restaurant_list(Model model,HttpServletRequest request)
	{
		List<RestaurantVO> list=dao.restaurantListData();
		model.addAttribute("list",list);
		List<RestaurantVO> cList=new ArrayList<RestaurantVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("m"))
				{
					RestaurantVO vo=dao.restaurantDetailData(Integer.parseInt(cookies[i].getValue()));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList",cList);
		return "restaurant/resList";
	}
	
	   @RequestMapping("restaurant/resDetail_before.do")
	   public String resDetail_before(int no,RedirectAttributes ra,HttpServletResponse response)
	   {
	       Cookie cookie=new Cookie("m"+no, String.valueOf(no));
	       cookie.setMaxAge(60*60*24);
	       response.addCookie(cookie);
	       return "redirect:resDetail.do?no="+no;
	   }
	
	@RequestMapping("restaurant/resDetail.do")
	public String restaurant_detail(int no,Model model)
	{
		RestaurantVO vo=dao.restaurantDetailData(no);
		model.addAttribute("vo",vo);
		return "restaurant/resDetail";
	}

}
