package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.ShoppingVO;

@Repository
public class ShoppingDAO {
	@Autowired
	private ShoppingMapper mapper;
	
	// 가격 리스트
	public List<ShoppingVO> shoppingListData(Map map)
	{
		return mapper.shoppingListData(map);
	}
	
	//물품 상세보기
	public ShoppingVO shoppingDetailData(int no)
	{
		return mapper.shoppingDetailData(no);
	}
	
	
	// 가격 총페이지
	public int shoppingTotalPage()
	{
		return mapper.shoppingTotalPage();
	}
}
