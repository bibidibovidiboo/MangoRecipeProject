package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FridgeMapper;
import com.sist.vo.FridgeVO;

@Repository
public class FridgeDAO {
	@Autowired
	private FridgeMapper mapper;
	public List<FridgeVO> fridge_ingre_search(String ingre_name){
		
		return mapper.fridge_ingre_search(ingre_name);
	}

}
