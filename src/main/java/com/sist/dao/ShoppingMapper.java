package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ShoppingVO;

public interface ShoppingMapper {
	//리스트
	@Select("SELECT no,title,image,lprice,category2,num "
			+"FROM (SELECT no,title,image,lprice,category2,rownum as num "
			+"FROM (SELECT no,title,image,lprice,category2 "
			+"FROM naver_shopping))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<ShoppingVO> shoppingListData(Map map);
	
	//총페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM naver_shopping")
	public int shoppingTotalPage();
	
	// 상세
	@Select("SELECT * FROM naver_shopping WHERE no=#{no}")
	public ShoppingVO shoppingDetailData(int no);
}
