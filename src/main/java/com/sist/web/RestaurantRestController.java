package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.RestaurantDAO;
import com.sist.vo.RestaurantVO;
@RestController
//코틀린에서 데이터 받아서 처리 
@RequestMapping("food/")
public class RestaurantRestController {
	   @Autowired
	   private RestaurantDAO dao;
	   
	   
	   @RequestMapping(value="kotlin_food.do",produces="text/plain;charset=UTF-8")
	   public String food_kotlin_food()
	   {
		   String result="";
			try{
			   List<RestaurantVO> list=dao.restaurantCateListData();
			   //list에 존재하는 데이터를 json으로 변경
			   JSONArray arr=new JSONArray();
			   for(RestaurantVO vo:list)
			   {
				   JSONObject obj=new JSONObject();
				   obj.put("no", vo.getNo());
				   obj.put("title", vo.getTitle());
				   obj.put("score", vo.getScore());
				   obj.put("poster", vo.getPoster());
				   obj.put("addr", vo.getAddr());
				   obj.put("tel", vo.getTel());
				   arr.add(obj);
			   }
			   result=arr.toJSONString();
		   }catch (Exception ex) {ex.printStackTrace();}
		   return result;
	   }
	   
	   @RequestMapping(value="kotlin_detail.do",produces="text/plain;charset=UTF-8")
	   public String food_kotlin_detail(int no)
	   {
		   String result="";
		   try{
			   RestaurantVO vo=dao.restaurantDetailData(no);
			   JSONObject obj=new JSONObject();
			   obj.put("cateno", vo.getCateno());
			   obj.put("title", vo.getTitle());
			   obj.put("score", vo.getScore());
			   obj.put("poster", vo.getPoster());
			   obj.put("addr", vo.getAddr());
			   obj.put("tel", vo.getTel());
			   obj.put("type", vo.getType());
			   obj.put("price", vo.getPrice());
			   obj.put("menu", vo.getMenu());
			   obj.put("good", vo.getGood());
			   obj.put("soso", vo.getSoso());
			   obj.put("bad", vo.getBad());
		   
			   result=obj.toJSONString();
		   }catch (Exception ex) {}
		   return result;
	   }
}
