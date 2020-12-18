package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.sist.vo.KotlinRecipeDetailVO;
import com.sist.vo.KotlinRecipeVO;
@Repository
public class KotlinRecipeDAO {
   private MongoClient mc;
   private DB db;
   private DBCollection dbc;
   public KotlinRecipeDAO()
   {
	   try
	   {
		   mc=new MongoClient("localhost",27017);
		   db=mc.getDB("myMongo");
		   dbc=db.getCollection("recipe");
	   }catch(Exception ex){}
   }
   public void recipeInsert(KotlinRecipeVO vo)
   {
	   try
	   {
		   BasicDBObject obj=new BasicDBObject();
		   obj.put("no", vo.getNo());
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   obj.put("chef", vo.getChef());
		   obj.put("link", vo.getLink());
		   obj.put("hit", vo.getHit());
		   
		   dbc.insert(obj);
	   }catch(Exception ex){}
   }
   
   public void recipeDetailData(KotlinRecipeDetailVO vo)
   {
   	try
   	{
   		
   		BasicDBObject obj=new BasicDBObject();
   		obj.put("no", vo.getNo());
   		obj.put("poster", vo.getPoster());
   		obj.put("title", vo.getTitle());
   		obj.put("chef", vo.getChef());
   		obj.put("chef_poster", vo.getChef_poster());
   		obj.put("chef_profile", vo.getChef_profile());
   		obj.put("info1", vo.getInfo1());
   		obj.put("info2", vo.getInfo2());
   		obj.put("info3", vo.getInfo3());
   		obj.put("content", vo.getContent());
   		obj.put("foodmake", vo.getFoodmake());
   		
   		dbc.insert(obj);
   	}catch(Exception ex){}
   }
   // 레시피 데이터 읽기
   public List<KotlinRecipeVO> recipeListData(int page)
   {
	   dbc=db.getCollection("recipe");
	   List<KotlinRecipeVO> list=new ArrayList<KotlinRecipeVO>();
	   try
	   {
		   int rowSize=10;
		   int skip=(page*rowSize)-rowSize;
		   // new BasicDBObject("no",1):ASC , new BasicDBObject("no",-1):DESC
		   DBCursor cursor=dbc.find().skip(skip).limit(rowSize).sort(new BasicDBObject("no",1));
		   // find() => SELECT * FROM recipe
		   while(cursor.hasNext())// 데이터 읽은 갯수 만큼 ==> JSON => {} => BasicDBObject
		   {
			   // DBCursor == ResultSet
			   BasicDBObject obj=(BasicDBObject)cursor.next();
			   KotlinRecipeVO vo=new KotlinRecipeVO();
			   vo.setNo(obj.getInt("no"));
			   vo.setTitle(obj.getString("title"));
			   vo.setPoster(obj.getString("poster"));
			   vo.setChef(obj.getString("chef"));
			   vo.setHit(obj.getString("hit"));
			   list.add(vo);
		   }
		   cursor.close();
	   }catch(Exception ex){}
	   return list;
   }
   
   
   public List<KotlinRecipeVO> chefDetailData(String chef)
   {
	   dbc=db.getCollection("recipe");
	   List<KotlinRecipeVO> list=new ArrayList<KotlinRecipeVO>();
	   try
	   {
		   BasicDBObject where=new BasicDBObject("chef",chef);
		   // WHERE chef='chef명'
		   DBCursor cursor=dbc.find(where).limit(20);
		   // limit=>가지고 오는 갯수 
		   while(cursor.hasNext())
		   {
			   BasicDBObject obj=(BasicDBObject)cursor.next();
			   KotlinRecipeVO vo=new KotlinRecipeVO();
			   vo.setChef(obj.getString("chef"));
			   vo.setTitle(obj.getString("title"));
			   vo.setPoster(obj.getString("poster"));
			   list.add(vo);
		   }
		   cursor.close();
	   }catch(Exception ex){}
	   return list;
   }
   /*
    *   private int no;
	   private String poster;
	   private String title;
	   private String chef;
	   private String chef_poster;
	   private String chef_profile;
	   private String info1,info2,info3;
	   private String content;
	   private String foodmake;
    */
   public KotlinRecipeDetailVO recipeDetailData(int no)
   {
	   KotlinRecipeDetailVO vo=new KotlinRecipeDetailVO();
	   try
	   {
		   BasicDBObject where=new BasicDBObject("no",no);
		   // WHERE no=1
		   BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
		   // find(): 데이터 여러개 일때 , findOne() : 데이터 한개 정보
		   vo.setTitle(obj.getString("title"));
		   vo.setContent(obj.getString("content"));
		   vo.setPoster(obj.getString("poster"));
		   vo.setChef(obj.getString("chef"));
		   vo.setFoodmake(obj.getString("foodmake"));
		   vo.setInfo1(obj.getString("info1"));
		   vo.setInfo2(obj.getString("info2"));
		   vo.setInfo3(obj.getString("info3"));
	   }catch(Exception ex){}
	   return vo;
   }
   
}














