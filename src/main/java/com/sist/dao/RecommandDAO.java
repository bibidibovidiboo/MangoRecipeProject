package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RecommandDAO {
	  @Autowired
	  private RecommandMapper mapper;
	  public List<RecipeVO> foodLikeRecipeData(String finddata)
	  {
		  return mapper.foodLikeRecipeData(finddata);
	  }
	  
	}