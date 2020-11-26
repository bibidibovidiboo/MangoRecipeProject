package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface RestaurantMapper {
	 @Select("SELECT no,cateno,poster,poster2,poster3,poster4,poster5,title,score,addr,tel,type,price,menu,good,soso,bad,rownum "
	          +"FROM restaurant_data "
	          +"WHERE rownum<=20")
	   public List<RestaurantVO> restaurantListData();
	   
	   @Select("SELECT * FROM restaurant_data "
	          +"WHERE no=#{no}")
	   public RestaurantVO restaurantDetailData(int no);
}
