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


   //메인(레스토랑)

   public List<RestaurantVO> mainGetRestaurantListData()
   {
      return mapper.mainGetRestaurantListData();
   }
   

   //메인(레시피)

   public List<RecipeVO> mainRecipeData()
   {
      return mapper.mainRecipeData();
   }


   //메인(날씨)

   public List<RecipeVO> mainweatherDetailData()
   {
      return mapper.mainweatherDetailData();
   }
}