package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.annotation.Resource;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
@CrossOrigin("http://localhost:3000")
// 코틀린에서 데이터 받아서 처리 
@RequestMapping("food/")
public class KotlinRecipeRestController {
   
   @Autowired
   private KotlinRecipeDAO rDao;
  
   
   // Redux
   @RequestMapping(value="kotlin_recipe.do",produces="text/plain;charset=UTF-8")
   public String food_kotlin_recipe(int page)
   {
	   String result="";
	   try
	   {
		   // 10 => {},{},{} ==> []
		   JSONArray arr=new JSONArray();
		   // 몽고디비로부터 데이터 받기 
		   List<KotlinRecipeVO> list=rDao.recipeListData(page);
		   for(KotlinRecipeVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("no", vo.getNo());
			   obj.put("title", vo.getTitle());
			   obj.put("poster", vo.getPoster());
			   obj.put("chef", vo.getChef());
			   obj.put("hit", vo.getHit());
			   
			   arr.add(obj);
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
   @RequestMapping(value="kotlin_recipe_detail.do",produces="text/plain;charset=UTF-8")
   public String recipe_kotlin_recipe_detail(int no)
   {
	   String result="";
	   try
	   {
		   KotlinRecipeDetailVO vo=rDao.recipeDetailData(no);
		   JSONObject obj=new JSONObject();
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   obj.put("content", vo.getContent());
		   obj.put("foodmake", vo.getFoodmake());
		   obj.put("info1", vo.getInfo1());
		   obj.put("info2", vo.getInfo2());
		   obj.put("info3", vo.getInfo3());
		   
		   result=obj.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
   @RequestMapping(value="kotlin_chef_detail.do",produces="text/plain;charset=UTF-8")
   public String recipe_kotlin_chef_detail(String chef)
   {
	   String result="";
	   try
	   {
		   List<KotlinRecipeVO> list=rDao.chefDetailData(chef);
		   // JSON변환 []
		   JSONArray arr=new JSONArray();
		   for(KotlinRecipeVO vo:list)
		   {
			   //{}   
			   JSONObject obj=new JSONObject();
			   obj.put("chef", vo.getChef());
			   obj.put("title", vo.getTitle());
			   obj.put("poster", vo.getPoster());
			   arr.add(obj);
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
   
}












