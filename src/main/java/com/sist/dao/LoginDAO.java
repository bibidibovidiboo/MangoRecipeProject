package com.sist.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	private Connection conn;
	  private CallableStatement cs;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@211.238.142.186:1521:XE";
	  public LoginDAO()
	  {
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
}