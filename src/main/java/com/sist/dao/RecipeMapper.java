package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
/*
 * private int rno;

	private int cno;
	private String title;
	private String chef;
	private String img;
	private String summ;
	private String people;
	private String cooktime;
	private String lvl;
 */

import org.apache.ibatis.annotations.Select;
public interface RecipeMapper {
	/*@Select("SELECT * "
			+ "FROM recipe_table "
			+ "WHERE rownum<=20")
	public List<RecipeVO> recipeListData();
	
	@Select("SELECT * FROM recipe_table "
			+ "WHERE rno=#{rno}")
	public RecipeVO recipeDetailData(int rno);*/
	
	@Select("SELECT rno,cno,title,chef,img,summ,people,cooktime,lvl,num "
			+ "FROM (SELECT rno,cno,title,chef,img,summ,people,cooktime,lvl,rownum as num "
			+ "FROM (SELECT rno,cno,title,chef,img,summ,people,cooktime,lvl "
			+ "FROM recipe_table))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe_table")
	public int recipeTotalPage();
	
	@Select("SELECT * FROM recipe_table "
			+ "WHERE rno=#{rno}")
	public RecipeVO recipeDetailData(int rno);
	
	@Select("SELECT no,cateno,title,poster,price,rownum "
			+ "FROM restaurant_data "
			+ "WHERE rownum<=5")
			// SELECT distinct r.no,r.title,r.cateno,r.poster FROM restaurant_data r,recipe_table p WHERE r.cateno=p.cno;
	public RestaurantVO LikeRecipeData(int cateno);
	
	
}