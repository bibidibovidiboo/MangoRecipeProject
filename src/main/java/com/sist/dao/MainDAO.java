package com.sist.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.RecipeVO;
import com.sist.vo.RestaurantVO;



@Repository
public class MainDAO {
	@Autowired
	private MainMapper mapper;

	//
	public List<RestaurantVO> mainGetRestaurantListData()
	{
		return mapper.mainGetRestaurantListData();
	}
	
	//
	public List<RecipeVO> mainRecipeData()
	{
		return mapper.mainRecipeData();
	}
	
	
	//
	public List<RecipeVO> mainweatherDetailData()
	{
		return mapper.mainweatherDetailData();
	}
}
