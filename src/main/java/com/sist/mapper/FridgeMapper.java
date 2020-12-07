package com.sist.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface FridgeMapper {

	  // 재료 찾기 ==============================================================================================
	  @Select("SELECT no,ingre_name,category2 "
			 +"FROM fridge_ingredient "
			 +"WHERE ingre_name LIKE '%'||#{ingre_name}||'%'")
	  public List<FridgeIngreVO> fridge_ingre_search(String ingre_name);
	  
	  // 재료 담기==============================================================================================
	  // 주의 사항 : 만약 이미 들어있는 제품이라면 insert에서 제외시켜야 함
	  
	  /*
	  <my_fridge_list>
	  NO
	  TITLE
	  REGDATE
	  DELDATE
	  ID
	  */
	  
	  // 재료 넣었는지 확인하기
	  @Select("SELECT COUNT(*) FROM my_fridge_list "
	  		+ "WHERE title=#{ingre_name} AND id=#{id}")
	  public int my_fridge_insert_check(Map map);
	  
	  // 재료 담기
	  @Insert("INSERT INTO my_fridge_list(no,title,regdate,id) "
	  		+ "VALUES((SELECT NVL(MAX(no),0)+1 FROM my_fridge_list) ,#{ingre_name},sysdate,#{id})")
	  public void my_fridge_insert(Map map);
	  
	  // 재료 리스트 출력하기
	  @Select("SELECT * "
				 +"FROM my_fridge_list "
				 +"WHERE id=#{id}")
		  public List<MyFridgeListVO> fridge_ingre_list(String id);
	  // 재료 빼기 ==============================================================================================
	  @Delete("DELETE FROM my_fridge_list "
	  		+ "WHERE id=#{id} "
	  		+ "AND title=#{ingre_name}")
	  public void my_fridge_delete(Map map);
	  
	  
	  
	  // 레시피 추천하기==============================================================================================
	  
	  
	  
	  
	  // ==============================================================================================
	  // ==============================================================================================
	  // ==============================================================================================
	  // ==============================================================================================
	  
}
