package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.sist.common.DBConnection;
import com.sist.vo.*;

@Repository
public class CBoardDAO {
	@Autowired
    private DBConnection dbConn;
	private CallableStatement cs; // Procedure
	private PreparedStatement ps; // SQL
	
	// 커뮤니티 게시판
	public List<CBoardVO> boardListData(int page)
	{
		System.out.println("BoardDAO:"+dbConn);
		List<CBoardVO> list=new ArrayList<CBoardVO>();
		
		try
		{
			String sql="{CALL communityBoardListData(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(1, start);
			cs.setInt(2, end);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();

			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				CBoardVO vo=new CBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setRegdate(rs.getDate(4));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){}
		return list;
	}
	
	public void boardInsert(CBoardVO vo)
	{
		try
		{
			String sql="{CALL communityBoardInsert(?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setString(1, vo.getName());
			cs.setString(2, vo.getSubject());
			cs.setString(3, vo.getContent());
			cs.setString(4, vo.getPwd());
			
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public CBoardVO boardDetailData(int no)
	{
		CBoardVO vo=new CBoardVO();
		try
		{
			String sql="{CALL communityBoardDetailData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			// 데이터 받기
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex){}
		return vo;
	}
	
	public CBoardVO boardUpdateData(int no)
	{
		CBoardVO vo=new CBoardVO();
		try
		{
			String sql="{CALL communityBoardUpdateData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
			
		}catch(Exception ex){ } // AOP에서 처리 
		return vo; // AfterReturning
	}
	
	public boolean boardUpdate(CBoardVO vo)
	{
		boolean bCheck=false;
		try
		{
			String sql="{CALL communityBoardUpdate(?,?,?,?,?,?)}";
			
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(6);
			bCheck=Boolean.parseBoolean(result);
		}catch(Exception ex){/*ex.printStackTrace();*/}
		return bCheck;
	}
	
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try
		{
			String sql="{CALL communityBoardDelete(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(3);
			bCheck=Boolean.parseBoolean(result);
		}catch(Exception ex){}
		return bCheck;
	}
	
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			String sql="SELECT communityBoardTotalPage() FROM community_board";
			ps=dbConn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			ps.close();
			
		}catch(Exception ex){}
		return total;
	}
	
	// 게시판 댓글 
	public List<CReplyVO> replyListData(int type,int cno,int page)
	{
		List<CReplyVO> list=
				new ArrayList<CReplyVO>();
		try
		{
			String sql="{CALL communityReplyListData(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, type);
			cs.setInt(2, cno);
			int rowSize=5;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(3, start);
			cs.setInt(4, end);
			cs.registerOutParameter(5, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(5);
			while(rs.next())
			{
				CReplyVO vo=new CReplyVO();
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
		}catch(Exception ex){}
		return list;
	}
	
	public void replyInsert(CReplyVO vo)
	{
		try
		{
			String sql="{CALL communityReplyInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public void replyUpdate(int no,String msg)
	{
		try
		{
			String sql="{CALL communityReplyUpdate(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public void replyDelete(int no)
	{
		try
		{
			String sql="{CALL communityReplyDelete(?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	

    
}