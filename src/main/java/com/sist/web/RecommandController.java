package com.sist.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
      else if(wd.equals("비"))
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
      
      model.addAttribute("list", list);
      model.addAttribute("wd", wd);
      return "recommand/weather_list";
   }
}