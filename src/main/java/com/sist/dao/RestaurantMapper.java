package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RestaurantVO;

public interface RestaurantMapper {
	 @Select("SELECT no,res_cno,res_title,res_score,res_menu,res_add,res_tel,res_price,res_poster1,res_poster2,res_poster3,res_poster4,res_poster5,rownum "
	          +"FROM restaurant_data "
	          +"WHERE rownum<=20")
	   public List<RestaurantVO> restaurantListData();
	   
	   @Select("SELECT * FROM restaurant_data "
	          +"WHERE no=#{no}")
	   public RestaurantVO restaurantDetailData(int no);
}
