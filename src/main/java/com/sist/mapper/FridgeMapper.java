package com.sist.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;
import com.sist.dao.*;

public interface FridgeMapper {

	// 특산물 지도
	// ==============================================================================================
	@Select("SELECT * FROM ingre_map " 
			+ "WHERE region1=#{region1}")
	public List<IngreMapVO> ingre_map(String region1);
	
	// 분류 버튼 뿌리기
	// ==============================================================================================
	@Select("SELECT DISTINCT category2 FROM fridge_ingredient")
	public List<FridgeIngreVO> fridgeIngreCate();
	
	// 분류별 재료명 뿌리기
	// ==============================================================================================
	@Select("SELECT ingre_name FROM fridge_ingredient WHERE category2=#{category2}")
	public List<FridgeIngreVO> fridgeCateAllData(String category2);


	
	
	// 재료 찾기
	// ==============================================================================================
	// 결과 list로 받기
	@Select("SELECT no,ingre_name,category2 " 
			+ "FROM fridge_ingredient "
			+ "WHERE ingre_name LIKE '%'||#{ingre_name}||'%'")
	public List<FridgeIngreVO> fridge_ingre_search(String ingre_name);


	// 주의 사항 : 만약 이미 들어있는 제품이라면 insert에서 제외시켜야 함
	// 냉장고에 재료 넣었는지 확인하기
	// ==============================================================================================
	@Select("SELECT COUNT(*) FROM my_fridge_list " 
			+ "WHERE title=#{ingre_name} AND id=#{id}")
	public int my_fridge_insert_check(Map map);

	// 냉장고에 재료 담기
	// ==============================================================================================
	@Insert("INSERT INTO my_fridge_list(no,title,regdate,id) "
			+ "VALUES((SELECT NVL(MAX(no),0)+1 FROM my_fridge_list) ,#{ingre_name},sysdate,#{id})")
	public void my_fridge_insert(Map map);

	// 냉장고에서 재료 빼기
	// ==============================================================================================
	@Delete("DELETE FROM my_fridge_list " 
			+ "WHERE id=#{id} " 
			+ "AND title=#{ingre_name}")
	public void my_fridge_delete(Map map);

	// 냉장고에 내가 담은 재료 리스트
	// ==============================================================================================
	@Select("SELECT * " 
			+ "FROM my_fridge_list " 
			+ "WHERE id=#{id} ORDER BY regdate")
	public List<MyFridgeListVO> my_fridge_list(String id);

	
	
	// 주의 사항 : 만약 이미 들어있는 제품이라면 insert에서 제외시켜야 함
	// 관심에 재료 넣었는지 확인하기
	// ==============================================================================================
	@Select("SELECT COUNT(*) FROM favorite_ingre " 
			+ "WHERE title=#{ingre_name} AND id=#{id}")
	public int fav_ingre_insert_check(Map map);

	// 관심에 재료 담기
	// ==============================================================================================
	@Insert("INSERT INTO favorite_ingre(no,title,regdate,id) "
			+ "VALUES((SELECT NVL(MAX(no),0)+1 FROM favorite_ingre) ,#{ingre_name},sysdate,#{id})")
	public void fav_ingre_insert(Map map);

	// 관심에 재료 빼기
	// ==============================================================================================
	@Delete("DELETE FROM favorite_ingre " 
			+ "WHERE id=#{id} " 
			+ "AND title=#{ingre_name}")
	public void fav_ingre_delete(Map map);

	// 관심에 내가 담은 재료 리스트
	// ==============================================================================================
	@Select("SELECT * " 
			+ "FROM favorite_ingre " 
			+ "WHERE id=#{id} ORDER BY regdate")
	public List<FavoriteIngreVO> favorite_ingre(String id);

	
	// 관심에 내가 담은 재료 구매하기
	// ==============================================================================================
	@Select("SELECT no,title,image,lprice FROM "
			+ "(SELECT no,title,image,lprice,rownum as num FROM "
			+ "(SELECT no,title,image,lprice FROM naver_shopping "
			+ "WHERE title LIKE #{title} ORDER BY lprice)) "
			+ "WHERE num BETWEEN 1 AND 10" + 
			"")
	public List<ShoppingVO> favorite_buy(String title);

	
	
	
	// 관심 재료 가격 검색
	
	
	// 레시피추천하기(정확도 100%)==============================================================================================
	@Select("SELECT title FROM ingres_table WHERE ingres LIKE #{myRefList}")
	public List<RecipeVO> recomm100List(String myRefList);
	

	// ==============================================================================================
	// ==============================================================================================
	// ==============================================================================================
	// ==============================================================================================

}
