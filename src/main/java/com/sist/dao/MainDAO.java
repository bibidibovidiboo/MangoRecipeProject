package com.sist.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.RecipeVO;
import com.sist.vo.RestaurantVO;

<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
@Repository
public class MainDAO {
	@Autowired
	private MainMapper mapper;

<<<<<<< Updated upstream
	//
=======
	//메인(레스토랑)
>>>>>>> Stashed changes
	public List<RestaurantVO> mainGetRestaurantListData()
	{
		return mapper.mainGetRestaurantListData();
	}
	
<<<<<<< Updated upstream
	//
=======
	//메인(레시피)
>>>>>>> Stashed changes
	public List<RecipeVO> mainRecipeData()
	{
		return mapper.mainRecipeData();
	}
	
	
<<<<<<< Updated upstream
	//
=======
	//메인(날씨)
>>>>>>> Stashed changes
	public List<RecipeVO> mainweatherDetailData()
	{
		return mapper.mainweatherDetailData();
	}
}
