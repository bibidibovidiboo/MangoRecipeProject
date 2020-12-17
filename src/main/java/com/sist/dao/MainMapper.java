package com.sist.dao;

<<<<<<< Updated upstream
import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;
import com.sist.dao.RestaurantVO;

public interface MainMapper {
		// 메인페이지(식당)
		@Select("SELECT * FROM restaurant_data WHERE no <= 8")
		public List<RestaurantVO> mainGetRestaurantListData();
		
		// 메인페이지(레시피)
		@Select("SELECT * FROM recipe_table WHERE rno <= 8")
		public List<RecipeVO> mainRecipeData();
		
		//메인페이지(날씨레시피)
		@Select("SELECT * FROM recipe_table WHERE rno <= 4")
		public List<RecipeVO> mainweatherDetailData();
		  
}		

=======
import java.util.*;


import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import com.sist.vo.RestaurantVO;

public interface MainMapper {
	// 메인페이지(식당)
	@Select("SELECT * FROM restaurant_data WHERE no <= 8")
	public List<RestaurantVO> mainGetRestaurantListData();
	
	// 메인페이지(레시피)
	@Select("SELECT * FROM recipe_table WHERE rno <= 8")
	public List<RecipeVO> mainRecipeData();
	
	//메인페이지(날씨레시피)
	@Select("SELECT * FROM recipe_table WHERE rno <= 4")
	public List<RecipeVO> mainweatherDetailData();
}
>>>>>>> Stashed changes
