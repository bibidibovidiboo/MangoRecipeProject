package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface ShoppingMapper {
	//리스트
	@Select("SELECT no,title,image,lprice,category2,category3,num "
			+"FROM (SELECT no,title,image,lprice,category2,category3,rownum as num "
			+"FROM (SELECT no,title,image,lprice,category2,category3 "
			+"FROM naver_shopping ORDER BY no ASC))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<ShoppingVO> shoppingListData(Map map);
	
	//총페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM naver_shopping")
	public int shoppingTotalPage();
	
	// 상세
	@Select("SELECT * FROM naver_shopping WHERE no=#{no}")
	public ShoppingVO shoppingDetailData(int no);
	
	
	// 카테고리 분류
	@Select("SELECT * FROM naver_shopping WHERE category2=#{name}")
	public List<ShoppingVO> shoppingCateDate(String name);
	
	
	// 상세보기 레시피 리스트 출력
	@Select("SELECT title,img,rownum FROM recipe_table "
			+ "WHERE rownum<=5 AND "
			+ "REGEXP_LIKE(title,#{category3})")
	public List<RecipeVO> shoppingRecipeData(String category3);
	
}
