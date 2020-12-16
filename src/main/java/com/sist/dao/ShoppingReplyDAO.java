package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.ShoppingReplyVO;

import java.util.*;
@Repository
public class ShoppingReplyDAO {
   @Autowired
   private ShoppingMapper mapper;
   
   // 댓글 리스트
   public List<ShoppingReplyVO> replyListData(int no)
   {
	   return mapper.shoppingReplyListData(no);
   }
   
   //댓글 추가
   public void shoppingReply_insert(ShoppingReplyVO vo)
   {
	  mapper.shoppingReplyInsertData(vo);
   }
   
   //댓글 삭제
   public void shoppingReply_delete(int no)
   {
	   mapper.shoppingReplyDeletData(no);
   }
   
   //댓글 수정
   public void shoppingReply_update(int no)
   {
	   mapper.shoppingReplyDeletData(no);
   }
   
   
}