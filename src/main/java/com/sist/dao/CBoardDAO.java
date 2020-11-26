package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.sist.vo.*;

@Repository
public class CBoardDAO {
	@Autowired
    private DBConnection dbConn;
	private CallableStatement cs;//Procedure
	private PreparedStatement ps;//SQL
	
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
			// 실행
			cs.executeQuery();
			// 데이터 받기
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
		// dbConn.disConnection
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
		// getConnection() => @Before
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
		// disConnection() => @After
		return vo;
	}
	
	public CBoardVO boardUpdateData(int no)
	{
		CBoardVO vo=new CBoardVO();
		// getConnection() => Before
		try
		{
			String sql="{CALL communityBoardUpdateData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			// 실행 요청 ?에 값을 채운다 
			cs.setInt(1, no);
			// OUT => 저장 공간을 만들어 준다 
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			// 저장공간에서 값을 가지고 온다 
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
			
		}catch(Exception ex){/*AfterThrowing*/} // AOP에서 처리 
		// disConnection() => After
		return vo; // AfterReturning
	}
	
	public boolean boardUpdate(CBoardVO vo)
	{
		boolean bCheck=false;
		// dbConn.getConnection()
		try
		{
			String sql="{CALL communityBoardUpdate(?,?,?,?,?,?)}";
			// 전송 => 오라클 
			
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(6);
			// Cursor => 자바(X) => ResultSet
			bCheck=Boolean.parseBoolean(result);
			// "10"
		}catch(Exception ex){/*ex.printStackTrace();*/}
		// dbConn.disConnection()
		// System.out.println("obj="+obj);
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
		// dbConn.getConnection()
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
			//no,type,cno,id,name,msg,TO_CHAR(regdate
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
		// dbConn.disConnection()
		return list;
	}
	
	public void replyInsert(CReplyVO vo)
	{
		// dbConn.getConnection()
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
		//dbConn.disConnection()
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
	
	// 로그인 부분
	public MemberVO memberLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		try
		{
			dbConn.getConnection();
			String sql="SELECT COUNT(*) FROM member "
					  +"WHERE id=?";
			ps=dbConn.getConn().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0)//ID가 없는 상태
			{
				vo.setMessage("NOID");
			}
			else // ID가 존재하는 상태 
			{
				sql="SELECT pwd,name FROM member "
				   +"WHERE id=?";
				ps=dbConn.getConn().prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				
				if(db_pwd.equals(pwd))//로그인
				{
					vo.setId(id);
					vo.setName(name);
					vo.setMessage("OK");
				}
				else//비밀번호가 틀린 경우
				{
					vo.setMessage("NOPWD");
				}
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			dbConn.disConnection();
		}
		return vo;
	}
    
}