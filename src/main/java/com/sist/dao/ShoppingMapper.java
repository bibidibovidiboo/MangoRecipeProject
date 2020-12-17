package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface ShoppingMapper {
	//리스트
	@Select("SELECT no,title,image,lprice,category2,category3,num "
			+"FROM (SELECT no,title,image,lprice,category2,category3,rownum as num "
			+"FROM (SELECT no,title,image,lprice,category2,category3 "
			+"FROM naver_shopping WHERE category2=#{category2} ORDER BY no ASC))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<ShoppingVO> shoppingListData(Map map);
	
	//총페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM naver_shopping WHERE category2=#{category2}")
	public int shoppingTotalPage(String category2);
	
	// 상세
	@Select("SELECT * FROM naver_shopping WHERE no=#{no}")
	public ShoppingVO shoppingDetailData(int no);
	
	
	// 카테고리 분류
	@Select("SELECT * FROM naver_shopping WHERE category2=#{category2}")
	public List<ShoppingVO> shoppingCateData(String category2);
	
	
	// 상세보기 레시피 리스트 출력
	@Select("SELECT rno,title,img,rownum FROM recipe_table "
			+ "WHERE rownum<=7 AND "
			+ "REGEXP_LIKE(title,#{category3})")
	public List<RecipeVO> shoppingRecipeData(String category3);

	// 상세보기 레시피 디테일
	@Select("SELECT * FROM recipe_table "
			+ "WHERE rno=#{rno}")
	public RecipeVO recipeDetailData(int rno);

	
	 // 댓글 파트
	 // 댓글 목록 읽기
	 @Select("SELECT no,cno,id,name,msg,good,soso,bad,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			 +"FROM shopping_reply "
			 +"WHERE cno=#{no} "
			 +"ORDER BY no DESC")
	 public List<ShoppingReplyVO> shoppingReplyListData(int no);
	 
	 //댓글 추가
	 @Insert("INSERT INTO shopping_reply(no,cno,id,name,msg,good,soso,bad) values(shopping_reply_seq.NEXTVAL,#{cno},#{id},#{name},#{msg},#{good},#{soso},#{bad})")
	 public void shoppingReplyInsertData(ShoppingReplyVO vo);
	
	 //댓글 삭제
	 @Delete("DELETE FROM shopping_reply where no=#{no} AND cno=#{cno}")
	 public void shoppingReplyDeleteData(ShoppingReplyVO vo);
	 
	 //댓글 수정
	 @Update("UPDATE shopping_reply SET no=#{no},cno=#{cno},id=#{id},name=#{name},msg=#{msg},good=#{good},soso=#{soso},bad=#{bad} where cno=#{cno} AND no=#{no}")
	 public void shoppingReplyUpdateData(ShoppingReplyVO vo);
	
	 
	// 파이그래프
	@Select("SELECT SUM(good) as good,"
			+ "SUM(soso) as soso,"
			+ "SUM(bad) as bad "
			+ "FROM shopping_reply WHERE cno=#{no}")
	public ShoppingReplyVO productGraphData(int no);
	
}
