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
}
