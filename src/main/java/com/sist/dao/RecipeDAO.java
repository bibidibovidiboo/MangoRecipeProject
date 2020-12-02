package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	
	
	
}