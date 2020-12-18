package com.sist.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.RestaurantVO;

@Repository
public class RestaurantDAO {
	@Autowired
	private RestaurantMapper mapper;
	public List<RestaurantVO> restaurantListData()
	{
		return mapper.restaurantListData();
	}
   
	public RestaurantVO restaurantDetailData(int no)
	{
		return mapper.restaurantDetailData(no);
	}
	
	
	// kotlin
	
	/*public List<RestaurantVO> foodCateListData()
	{
		return mapper.foodCateListData();
	}*/

	public List<RestaurantVO> foodCateListData(Map map)
	{
		return mapper.foodCateListData(map);
	}
	
	 public RestaurantVO foodDetailData(int no)
	   {
		   return mapper.foodDetailData(no);
	   }
	   
	   //추천
	   public List<RestaurantVO> foodHouseListData()
	   {
		   return mapper.foodHouseListData();
	   }

}
