package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.RestaurantDAO;
import com.sist.recommand.*;
import com.sist.vo.RestaurantVO;


@RestController
//코틀린에서 데이터 받아서 처리 
@RequestMapping("food/")
public class RestaurantRestController {
	   @Autowired
	   private RestaurantDAO dao;
	   
	   @Autowired
	   private NaverBlogManager nbm;
	   
	   @Autowired
	   private RecomKotlinManager rkm;
	   
	   
	   //코틀린 식당
	   @RequestMapping(value="kotlin_res.do",produces="text/plain;charset=UTF-8")
	   public String kotlin_res(String page)
	   {
		   String result="";
		   if(page==null) // 첫화면 => default 
			   page="1";
		   int curpage=Integer.parseInt(page);
			int rowSize=12;
			int start=(rowSize*curpage)-(rowSize-1);
			int end=rowSize*curpage;
			Map map=new HashMap();
			map.put("start", start);
			map.put("end", end);
			try{
			   List<RestaurantVO> list=dao.foodCateListData(map);
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
		   }catch (Exception ex) {}
		   return result;
	   }
	   
	 //코틀린 식당 상세정보
	   @RequestMapping(value="kotlin_resdetail.do",produces="text/plain;charset=UTF-8")
	   public String food_kotlin_detail(int no)
	   {
		   String result="";
		   try{
			   RestaurantVO vo=dao.foodDetailData(no);
			   JSONObject obj=new JSONObject();
		//	   obj.put("cateno", vo.getCateno());
			   obj.put("no", vo.getNo());
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
	   
	 //코틀린  추천
	   @RequestMapping(value="kotlin_resrecommand.do",produces="text/plain;charset=UTF-8")
	   public String kotlin_recommand(String fd)
	   {
		   String result="";
		   nbm.naverFindData(fd);
		   List<RestaurantVO> list=rkm.foodRecommandData();
		   try{
			   JSONArray arr=new JSONArray();
			   for(RestaurantVO vo:list)
			   {
				   JSONObject obj=new JSONObject();
				   obj.put("no", vo.getNo());
				   obj.put("title", vo.getTitle());
				   obj.put("poster", vo.getPoster());
				   arr.add(obj);
			   }
			   result=arr.toJSONString();
		   }catch (Exception ex) {}
		   return result;
	   }
	/*   
	 //코틀린 레시피
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
	   
	 //코틀린 레시피 상세
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
	   }*/
}
