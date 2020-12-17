package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sist.vo.ChefVO;
import com.sist.vo.ChefRecipeVO;
@Repository
public class ChefDAO {
   @Autowired
   private MongoTemplate mt;
   public List<ChefRecipeVO> recipeListData(int page){
      Query query=new Query();
      int rowSize=12;
      
      int skip=(page*rowSize)-rowSize;
      query.skip(skip).limit(rowSize);
      
      query.with(new Sort(Sort.Direction.ASC,"no"));
      return mt.find(query, ChefRecipeVO.class,"recipe");
   }
   
   public int recipeCount()
   {
	   Query query=new Query();
	   int count=(int)mt.count(query, "recipe");
	   return count;
   }
 
   
   public List<ChefVO> chefListData(int page)
   {
	      Query query=new Query(); //WHERE, SORT, SKIP, LIMIT
	      int rowSize=20;
	      int skip=(page*rowSize)-rowSize;
	      query.skip(skip).limit(rowSize);
	      
	      query.with(new Sort(Sort.Direction.ASC,"no"));
	      return mt.find(query, ChefVO.class,"chef");
	}
   
   public List<ChefRecipeVO> chefProductData(String chef,int page)
   {
	   List<ChefRecipeVO> list=new ArrayList<ChefRecipeVO>();
	   BasicQuery query=new BasicQuery("{chef:'"+chef+"'}"); //WHERE chef='aaa' 와 같은 역할
       int rowSize=20;
       int skip=(page*rowSize)-rowSize;
       query.skip(skip).limit(rowSize);
       list=mt.find(query, ChefRecipeVO.class,"recipe");
	   return list;
   }
   
   public List<ChefRecipeVO> chefProductFindData(String chef,String fd)
   {
	   List<ChefRecipeVO> list=new ArrayList<ChefRecipeVO>();
	   BasicQuery query=new BasicQuery("{$and:[{chef:'"+chef+"'},{title:{$regex:'.*"+fd+"'}}]}");
	   list=mt.find(query, ChefRecipeVO.class,"recipe");
	   return list;
   }
   
   public int chefTotalPage()
   {
	   BasicQuery query=new BasicQuery("{}");
	   List<ChefVO> list=mt.find(query,ChefVO.class,"chef");
	   int count=list.size();
	   int total=(int)(Math.ceil(count/20.0));
	   return total;
   }
}