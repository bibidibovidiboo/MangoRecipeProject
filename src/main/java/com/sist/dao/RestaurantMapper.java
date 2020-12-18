package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RestaurantVO;

public interface RestaurantMapper {
	 @Select("SELECT no,cateno,poster,poster2,poster3,poster4,poster5,title,score,addr,tel,type,price,menu,good,soso,bad,rownum "
	          +"FROM restaurant_data "
	          +"WHERE rownum<=20")
	   public List<RestaurantVO> restaurantListData();
	   
	   @Select("SELECT * FROM restaurant_data "
	          +"WHERE no=#{no}")
	   public RestaurantVO restaurantDetailData(int no);
	   
	   
	   //kotlin 맛집리스트
	   /*@Select("SELECT poster,title,no,score,addr,tel FROM restaurant_data WHERE rownum<=20")
	   public List<RestaurantVO> foodCateListData();*/
	   @Select("SELECT poster,title,no,score,addr,tel,num "
	   		+ "FROM (SELECT poster,title,no,score,addr,tel,rownum as num "
	   		+ "FROM (SELECT poster,title,no,score,addr,tel "
	   		+ "FROM restaurant_data)) WHERE num BETWEEN #{start} AND #{end}")
	   public List<RestaurantVO> foodCateListData(Map map);
	   
	   // 3. 맛집 상세보기 
	   @Select("SELECT no,cateno,good,soso,bad,poster,title,score,addr,tel,type,price,menu FROM restaurant_data WHERE no=#{no}")
	   public RestaurantVO foodDetailData(int no);
	   
	   //4. 추천
	   @Select("SELECT no,title,poster FROM restaurant_data ORDER BY no ASC")
	   public List<RestaurantVO> foodHouseListData();
}
