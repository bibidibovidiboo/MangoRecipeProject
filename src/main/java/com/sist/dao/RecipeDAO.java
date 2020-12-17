package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	public List<RecipeVO> recipeListData(Map map){
		
		return mapper.recipeListData(map);
	}
	
	public RecipeVO recipeDetailData(int rno){
		
		return mapper.recipeDetailData(rno);
	}
	
	public int recipeTotalPage(){
		return mapper.recipeTotalPage();
	}
	/*
	 * public RecipeIngreVO recipeIngreData(int rno){
	 * 
	 * return mapper.recipeIngreData(rno); }
	 */
	
	
	public List<RecipeVO> recipeRefridgeListData(String title){
		return mapper.recipeRefridgeListData(title);
	}
	
	
}
