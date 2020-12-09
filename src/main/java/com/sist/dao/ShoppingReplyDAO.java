package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.sist.vo.ShoppingReplyVO;

import oracle.jdbc.OracleTypes;

import java.sql.*;
@Repository
public class ShoppingReplyDAO {
  private Connection conn;
  private CallableStatement cs;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@211.238.142.186:1521:XE";
  public ShoppingReplyDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex){}
  }
  public void getConnection()
  {
	  try
	  {
		  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex){}
  }
  public void disConnection()
  {
	  try
	  {
		  if(cs!=null) cs.close();// procedure 
		  if(ps!=null) ps.close();// 일반 sql
		  if(conn!=null) conn.close();
	  }catch(Exception ex){}
  }
  // LOGIN => 일반 SQL 
  public String isLogin(String id,String pwd)
  {
	  String result="";
	  try
	  {
		  getConnection();
		  String sql="SELECT COUNT(*) FROM member "
				    +"WHERE id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  ResultSet rs=ps.executeQuery();
		  rs.next();
		  int count=rs.getInt(1);
		  rs.close();
		  if(count==0)
		  {
			  result="NOID";
		  }
		  else
		  {
			  sql="SELECT pwd,name FROM member "
			     +"WHERE id=?";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, id);
			  rs=ps.executeQuery();
			  rs.next();
			  String db_pwd=rs.getString(1);
			  String name=rs.getString(2);
			  rs.close();
			  if(db_pwd.equals(pwd))
			  {
				  result=id+"|"+name;
			  }
			  else
			  {
				  result="NOPWD";
			  }
		  }
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
	  return result;
  }
  
/// 댓글  
  /*
   *    
   *    CREATE TABLE shopping_reply(
		    no NUMBER,
		    type NUMBER,
		    cno NUMBER,
		    id VARCHAR2(20) CONSTRAINT pr99_id_nn NOT NULL,
		    name VARCHAR2(34) CONSTRAINT pr99_name_nn NOT NULL,
		    msg CLOB CONSTRAINT pr_msg_nn NOT NULL,
		    good NUMBER,
		    soso NUMBER,
		    bad NUMBER,
		    regdate DATE DEFAULT SYSDATE
		 );
   *    
   *    
   *    
   *     create or replace PROCEDURE ShoppingReplyInsert(
		   pType shopping_reply.type%TYPE,
		   pCno shopping_reply.cno%TYPE,
		   pId shopping_reply.id%TYPE,
		   pName shopping_reply.name%TYPE,
		   pMsg shopping_reply.msg%TYPE,
           pgood shopping_reply.good%TYPE,
           psoso shopping_reply.soso%TYPE,
           pbad shopping_reply.bad%TYPE
		)
		IS
		  vNo shopping_reply.no%TYPE;
		BEGIN
		  SELECT NVL(MAX(no)+1,1) INTO vNo
		  FROM shopping_reply;
		
		  INSERT INTO shopping_reply(no,type,cno,id,name,msg,good,soso,bad)
		  VALUES(vNo,pType,pCno,pId,pName,pMsg,pGood,pSoso,pBad);
		  COMMIT;
		END;
   */
  public void replyInsert(ShoppingReplyVO vo)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL ShoppingReplyInsert(?,?,?,?,?,?,?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, 1);
		  cs.setInt(2, vo.getCno());
		  cs.setString(3, vo.getId());
		  cs.setString(4, vo.getName());
		  cs.setString(5, vo.getMsg());
		  cs.setInt(6, vo.getGood());
		  cs.setInt(7, vo.getSoso());
		  cs.setInt(8, vo.getBad());
		  
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
  /*
   *   CREATE OR REPLACE PROCEDURE ShoppingReplyListData(
    		pType shopping_reply.type%TYPE,
		    pCno shopping_reply.cno%TYPE,
		    pStart NUMBER,
		    pEnd NUMBER,
		    pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		    OPEN pResult FOR
		    SELECT no,type,cno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),num
		    FROM (SELECT no,type,cno,id,name,msg,regdate,rownum as num
		    FROM (SELECT no,type,cno,id,name,msg,regdate
		    FROM shopping_reply WHERE type=pType AND cno=pCno ORDER BY no DESC))
		    WHERE num BETWEEN pStart AND pEnd;
		END;
   */
  public List<ShoppingReplyVO> ShoppingReplyListData(int cno,int page)
  {
	  List<ShoppingReplyVO> list=new ArrayList<ShoppingReplyVO>();
	  try
	  {
		  getConnection();
		  String sql="{CALL ShoppingReplyListData(?,?,?,?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, 1);
		  cs.setInt(2, cno);
		  int rowSize=10;
		  int start=(rowSize*page)-(rowSize-1);
		  int end=rowSize*page;
		  cs.setInt(3, start);
		  cs.setInt(4, end);
		  cs.registerOutParameter(5, OracleTypes.CURSOR);
		  cs.executeQuery();
		  // 결과값 받기 
		  ResultSet rs=(ResultSet)cs.getObject(5);
		  // no,type,cno,id,name,msg,dbday
		  while(rs.next())
		  {
			  ShoppingReplyVO vo=new ShoppingReplyVO();
			  vo.setNo(rs.getInt(1));
			  vo.setType(rs.getInt(2));
			  vo.setCno(rs.getInt(3));
			  vo.setId(rs.getString(4));
			  vo.setName(rs.getString(5));
			  vo.setMsg(rs.getString(6));
			  vo.setDbday(rs.getString(7));
			  list.add(vo);
		  }
		  rs.close();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
	  return list;
  }
  /*
	   * create or replace PROCEDURE ShoppingReplyDelete(
			   pNo shopping_reply.no%TYPE
			)
			IS
			BEGIN
			  DELETE FROM shopping_reply
			  WHERE no=pNo;
			  COMMIT;
			END; 
   */
  public void ShoppingReplyDelete(int no)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL ShoppingReplyDelete(?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, no);
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
  /*
   *create or replace PROCEDURE ShoppingReplyUpdate(
	   pNo shopping_reply.no%TYPE,
	   pMsg shopping_reply.msg%TYPE
	)
	IS
	BEGIN
	  UPDATE shopping_reply SET
	  msg=pMsg
	  WHERE no=pNo;
	  COMMIT;
	END;
    /
   */
  public void ShoppingReplyUpdate(int no,String msg)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL ShoppingReplyUpdate(?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, no);
		  cs.setString(2, msg);
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
}

  