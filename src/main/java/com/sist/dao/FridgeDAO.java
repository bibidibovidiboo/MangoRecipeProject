package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FridgeMapper;
import com.sist.vo.*;

@Repository
public class FridgeDAO {
	@Autowired
	private FridgeMapper mapper;
	// 특산물 지도
	public List<IngreMapVO> ingre_map(String region1){
		return mapper.ingre_map(region1);
	}
	
	
	// 재료검색 : 결과를 arraylist로 받기
	public List<FridgeIngreVO> fridge_ingre_search(String ingre_name){
		
		return mapper.fridge_ingre_search(ingre_name);
	}
	
	// 분류 버튼 뿌리기
	public List<FridgeIngreVO> fridgeIngreCate(){
		return mapper.fridgeIngreCate();
	}
	
	// 분류별 재료명 뿌리기
	public List<FridgeIngreVO> fridgeCateAllData(String category2){
		return mapper.fridgeCateAllData(category2);
	}
	
	
	 // 재료 넣었는지 확인하기
	  public int my_fridge_insert_check(Map map)
	  {
		  return mapper.my_fridge_insert_check(map);
	  }
	  
	  // 재료 담기
	  public void my_fridge_insert(Map map) {
		  mapper.my_fridge_insert(map);
	  }
	  
	  // 등록한 재료 리스트 출력하기
	  public List<MyFridgeListVO> my_fridge_list(String id){
		  return mapper.my_fridge_list(id);
	  }
	  
	  // 등록한 재료 리스트에서 삭제
	  public void my_fridge_delete(Map map) {
		  mapper.my_fridge_delete(map);
	  }
	  
	  // 정확도 100% 추천받기
	  public List<RecipeVO> recomm100List(String myRefList) {
		  return mapper.recomm100List(myRefList);
	  }
	  
	  
	  
	// 주의 사항 : 만약 이미 들어있는 제품이라면 insert에서 제외시켜야 함
		// 관심에 재료 넣었는지 확인하기
		
		public int fav_ingre_insert_check(Map map)
		{
			return mapper.fav_ingre_insert_check(map);
		}

		// 관심에 재료 담기
		// ==============================================================================================
		public void fav_ingre_insert(Map map)
		{
			mapper.fav_ingre_insert(map);
		}

		// 관심에 재료 빼기
		// ==============================================================================================
		public void fav_ingre_delete(Map map)
		{
			mapper.fav_ingre_delete(map);
		}

		// 관심에 내가 담은 재료 리스트
		// ==============================================================================================
		public List<FavoriteIngreVO> favorite_ingre(String id)
		{
			return mapper.favorite_ingre(id);
		}

	  
		// 관심 상품 최저가 상품 
		public List<ShoppingVO> favorite_buy(String title)
		{
			return mapper.favorite_buy(title);
		}
	  
	  
	 

}
