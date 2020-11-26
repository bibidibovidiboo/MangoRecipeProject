package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface RecommandMapper {

//@Select("SELECT title,img,chef,rownum FROM recipe_table WHERE rownum<=10 AND REGEXP_LIKE(title,#{finddata}) ORDER BY dbms_random.random")	
  @Select("SELECT * FROM (SELECT * FROM recipe_table ORDER BY DBMS_RANDOM.RANDOM) WHERE rownum<=10 AND REGEXP_LIKE(title,#{finddata})")
  public List<RecipeVO> foodLikeRecipeData(String finddata);
  
  @Select("SELECT * FROM recipe_table WHERE rno=#{rno}")
	public RecipeVO weatherDetailData(int rno);
	
}