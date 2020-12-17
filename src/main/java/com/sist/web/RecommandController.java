package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.recommand.NaverBlogFind;
import com.sist.recommand.RecommandManager;
import com.sist.recommand.RecommandVO;
import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;
import com.sist.vo.ChefRecipeVO;

@Controller
@RequestMapping("recommand/")
public class RecommandController {
   @Autowired
   private RecommandDAO wdao;
   @Autowired
   private ChefDAO cdao;
   @Autowired
   private RecommandManager mgr;
   @Autowired
   private NaverBlogFind  nb;
   
   
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
         food="비";
      }
      else if(wd.equals("눈"))
      {
         food="눈 오는";
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
		   String s1="봄,여름,가을,겨울,맑은,추운,흐린,비오는,더운,안개,눈 오는";
		   String s2="아침,오후,저녁,밤,행복,사랑,기쁨,슬픔,지침,짜증,분노,그리움,추억,우울";
		   String s3="밝은,신나는,따뜻,편안,부드러운,로맨틱,영화,잔잔,달콤,시원,어두운";
		   String s4="친구,여행,데이트,휴식,산책,출근,퇴근,야근,휴가,운동,고백";
		   String data="";
		   int index=0;
		   if(no==1){
			   data=s1;
			   index=11;
		   }
		   else if(no==2){
			   data=s2;
			   index=14;
		   }
		   else if(no==3){
			   data=s3;
			   index=11;
		   }
		   else if(no==4){
			   data=s4;
			   index=11;
		   }
		   
		   String[] ss=new String[index];
		   StringTokenizer st=new StringTokenizer(data,",");
		   int i=0;
		   while(st.hasMoreTokens())
		   {
			   ss[i]=st.nextToken();
			   i++;
		   }
		   model.addAttribute("ss", ss);
		   return "tag_sublist";
	   }
	   @RequestMapping("find.do")
	   public String recommand_find(String fd,Model model)
	   {
		   nb.naverFindData(fd);// XML 제작
		   List<RecommandVO> list=mgr.recommandData();
		   List<RestaurantVO> fList=new ArrayList<RestaurantVO>();
		   for(RecommandVO vo:list)
		   {
			   List<RestaurantVO> dList=wdao.recommandFindData(vo.getTitle());
			   fList.add(dList.get(0));
		   }
		   model.addAttribute("fList", fList);
		   return "find";
	   }

	   @RequestMapping("chef_list.do")
		public String chef_list(String page,Model model)
		{
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			List<ChefVO> list=cdao.chefListData(curpage);
			model.addAttribute("list", list);
			return "recommand/chef_list";
		}
		
		@RequestMapping("chef_product.do")
		public String chef_product(String chef,String page,String fd,Model model)
		{
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			List<ChefRecipeVO> list=new ArrayList<ChefRecipeVO>();
			if(fd==null)
			{
				list=cdao.chefProductData(chef, curpage);
			}
			else
			{
				list=cdao.chefProductFindData(chef, fd);
			}
			
			model.addAttribute("list", list);
			model.addAttribute("chef", chef);
			return "recommand/chef_product";
		}
	   
	   
   
}