package com.sist.dao;
import java.util.*;

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

import com.sist.vo.RecipeCookVO;
import com.sist.vo.RecipeIngreVO;
import com.sist.vo.RecipeVO;
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
	
	@Select("SELECT img,title,chef,people FROM recipe_table WHERE title=#{title}")
	public List<RecipeVO> recipeRefridgeListData(String title);
	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe_table")
	public int recipeTotalPage();
	
	@Select("SELECT * FROM recipe_table "
			+ "WHERE rno=#{rno}")
	public RecipeVO recipeDetailData(int rno);
	
	@Select("SELECT * FROM cook_table WHERE title=#{title}")
	public List<RecipeCookVO> recipeCookData(String title);
	
	@Select("SELECT * FROM ingre_table WHERE title=#{title}")
	public List<RecipeIngreVO> recipeIngreData(String title);
	
	@Select("SELECT title FROM recipe_table WHERE rno=#{rno}")
	public String recipeTitle(int rno);
	
	
//	@Select("SELECT * FROM ingre_table "
//			+ "WHERE rno=#{rno}")
//	public RecipeIngreVO recipeIngreData(int rno);
	
}
	
