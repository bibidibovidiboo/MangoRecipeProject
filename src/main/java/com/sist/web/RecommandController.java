package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;

@Controller
@RequestMapping("recommand/")
public class RecommandController {
   @Autowired
   private RecommandDAO wdao;
   
   @RequestMapping("weather_list.do")
   public String find_recipe(Model model)
   {
      //레시피 검색
      RecommandData RecommandData=new RecommandData();
      String wd=RecommandData.weather();
      String food="";
      if(wd.equals("흐림") || wd.equals("구름많음"))
      {
    	  food="찌개"; 
      }
      else if(wd.equals("비") || wd.equals("눈비"))
      {
         food="전";
      }
      else if(wd.equals("눈"))
      {
         food="눈오는";
      }
      else // 맑은날씨
      {
    	  food=" ";
      }
      
      List<RecipeVO> list=wdao.foodLikeRecipeData(food);
      for(RecipeVO vo:list)
	   {
    	  	String str=vo.getTitle();
	  		if(str.length()>20)
	  		{
	  		    str=str.substring(0,20);
	  		    str+="...";
	  		}
	  		vo.setTitle(str);
	   }
      
      model.addAttribute("list", list);
      model.addAttribute("wd", wd);
      return "recommand/weather_list";
   }
   
   @RequestMapping("weather_detail.do")
   public String recipe_detial(int rno,Model model){
	   RecipeVO vo=wdao.weatherDetailData(rno);
	   model.addAttribute("vo",vo);
	   return "recommand/weather_detail";
   }
   
   @RequestMapping("tag_list.do")
	public String recommand_list()
	{
		return "recommand/tag_list";
	}
	@RequestMapping("tag_sublist.do")
	public String recommand_tag_sublist(int no,Model model)
	{
		String s1="봄,여름,가을,겨울,맑은날,추운날,흐린날,비오는날,더운날,눈오는날";
		String s2="외로움,슬픔,이별,설렘,밤,새벽,아침,사랑,짜증,그리움,추억,우울,행복,분노,기쁨,축하";
		String s3="밝은,신나는,따뜻한,편안한,그루브한,부드러운,로맨틱한,잔잔한,몽환적인,시원한,애절한,어두운";
		String s4="운동,드라이브,산책,퇴근길,휴가,거리,고백,해변";
		
		String data="";
		int index=0;
		if(no==1) {
			data=s1;
			index=10;
		}
		else if(no==2) {
			data=s2;
			index=16;
		}
		else if(no==3) {
			data=s3;
			index=12;
		}
		else if(no==4) {
			data=s4;
			index=9;
		}
		
		String[] ss=new String[index];
		StringTokenizer st=new StringTokenizer(data,",");
		int i=0;
		while(st.hasMoreTokens())
		{
			ss[i]=st.nextToken();
			i++;
		}
		
		
		/*List<RecipeVO> list=wdao.foodLikeRecipeData(ss[i]);
	      for(RecipeVO vo:list)
		   {
	    	  	String str=vo.getTitle();
		  		if(str.length()>20)
		  		{
		  		    str=str.substring(0,20);
		  		    str+="...";
		  		}
		  		vo.setTitle(str);
		   }
	      
	    model.addAttribute("list", list);*/
		
		model.addAttribute("ss",ss);
		return "tag_sublist";
	}
   
}