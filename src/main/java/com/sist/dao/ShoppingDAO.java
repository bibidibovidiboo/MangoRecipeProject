package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;

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
	public int shoppingTotalPage(String category2)
	{
		return mapper.shoppingTotalPage(category2);
	}
	
	//카테고리별 데이터
	public List<ShoppingVO> shoppingCateData(String category2)
	{
		return mapper.shoppingCateData(category2);
	}

	//상세보기 레시피 5개 출력
	public List<RecipeVO> shoppingRecipeData(String category3)
	{
		return mapper.shoppingRecipeData(category3);
	}
	
	//상세보기 레시피 디테일데이터
	public RecipeVO recipeDetailData(int rno)
	{
		return mapper.recipeDetailData(rno);
	}
	
	
	//상품 평가 데이터
	public ShoppingReplyVO productGraphData(int no)
	{
		return mapper.productGraphData(no);
	}
	
	
}
