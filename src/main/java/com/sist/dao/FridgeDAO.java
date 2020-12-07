package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FridgeMapper;
import com.sist.vo.*;

@Repository
public class FridgeDAO {
	@Autowired
	private FridgeMapper mapper;
	public List<FridgeIngreVO> fridge_ingre_search(String ingre_name){
		
		return mapper.fridge_ingre_search(ingre_name);
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
	  public List<MyFridgeListVO> fridge_ingre_list(String id){
		  return mapper.fridge_ingre_list(id);
	  }
	  
	  // 등록한 재료 리스트에서 삭제
	  public void my_fridge_delete(Map map) {
		  mapper.my_fridge_delete(map);
	  }

}
