package com.sist.dao;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.common.DBConnection;
import com.sist.vo.*;
/* m_board;
 * NO      NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(34)   
	SUBJECT NOT NULL VARCHAR2(1000) 
	CONTENT NOT NULL CLOB           
	PWD     NOT NULL VARCHAR2(10)   
	POSTER           VARCHAR2(2000) 
	REGDATE          DATE           
	HIT              NUMBER 
 */
import oracle.jdbc.OracleTypes;

@Repository
public class ChallDAO {
	/*@Autowired
	private DBConnection dbConn;
	private CallableStatement cs;
	private PreparedStatement ps;
	
	public List<ChallVO> m_boardListData(int page)
	{
		List<ChallVO> list=new ArrayList<ChallVO>();
		
		try{
			String sql="{CALL m_boardListData(?,?,?)}";
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
				ChallVO vo=new ChallVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setRegdate(rs.getDate(5));
				vo.setPoster(rs.getString(6));
				list.add(vo);
				}
			rs.close();
		
		}catch(Exception ex){}
		return list;
	}
	
	
	public void m_boardInsert(ChallVO vo)
	{
		try{
			vo.setPoster("없음");
			String sql="{CALL m_boardInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setString(1, vo.getName());
			cs.setString(2, vo.getSubject());
			cs.setString(3, vo.getContent());
			cs.setString(4, vo.getPwd());
			cs.setString(5, vo.getPoster());
			cs.executeQuery();
		}catch(Exception ex){
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getMessage());
		}
	}
	
	public ChallVO m_boardDetailData(int no)
	{
		ChallVO vo=new ChallVO();
		try{
			String sql="{CALL m_boardDetailData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setSubject(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setHit(rs.getInt(4));
			vo.setRegdate(rs.getDate(5));
			vo.setPoster(rs.getString(6));
			rs.close();
		}catch(Exception ex){}
		return vo;
	}
	
	public ChallVO m_boardUpdateData(int no)
	{
		ChallVO vo=new ChallVO();
		try{
			String sql="{CALL m_boardUpdateData(?,?)}";
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
			vo.setPoster(rs.getString(5));
			rs.close();
		}catch(Exception ex){}
		return vo;
	}
	
	public boolean m_boardUpdate(ChallVO vo)
	{
		boolean bCheck=false;
		try{
			String sql="{CALL m_boardUpdate(?,?,?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.setString(7, vo.getPoster());
			cs.executeQuery();
			String result=cs.getString(6);
			bCheck=Boolean.parseBoolean(result);
		}catch(Exception ex){}
		return bCheck;
	}
	
	public boolean m_boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try{
			String sql="{CALL m_boardDelete(?,?,?)}";
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
	
	public int m_boardTotalPage(){
		int total=0;
		try{
			String sql="SELECT m_boardTotalPage() FROM m_board";
			ps=dbConn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			ps.close();
		}catch(Exception ex){}
		return total;
	}
	
	public List<ChReplyVO> m_replyListData(int type,int cno,int page){
		List<ChReplyVO> list= new ArrayList<ChReplyVO>();
		try{
			String sql="{CALL m_replyListData(?,?,?,?,?)}";
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
				ChReplyVO vo=new ChReplyVO();
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
	
	public void m_replyInsert(ChReplyVO vo){
		try
		{
			String sql="{CALL m_replyInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	
	public void m_replyUpdate(int no,String msg)
	{
		try
		{
			String sql="{CALL m_replyUpdate(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public void m_replyDelete(int no)
	{
		try
		{
			String sql="{CALL m_ReplyDelete(?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
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
	}*/
	
	@Autowired
	private DBConnection dbConn;
	private CallableStatement cs;
	private PreparedStatement ps;
	
	public List<ChallVO> m_boardListData(int page){
		List<ChallVO> list=new ArrayList<ChallVO>();
		try{
			String sql="{CALL m_boardListData(?,?,?)}";
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
				ChallVO vo=new ChallVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				vo.setPoster(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){}
		return list;
	}
	
	public void m_boardInsert(ChallVO vo){
		try{
			String sql="{CALL m_boardInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setString(1, vo.getName());
			cs.setString(2, vo.getSubject());
			cs.setString(3, vo.getContent());
			cs.setString(4, vo.getPwd());
			cs.setString(5, vo.getPoster());
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public ChallVO m_boardDetailData(int no)
	{
		ChallVO vo=new ChallVO();
		try{
			String sql="{CALL m_boardDetailData(?,?)}";
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
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			vo.setPoster(rs.getString(7));
			rs.close();
		}catch(Exception ex){}
		return vo;
	}
	
	public ChallVO m_boardUpdateData(int no)
	{
		ChallVO vo=new ChallVO();
		try{
			String sql="{CALL m_boardUpdateData(?,?)";
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
			vo.setPoster(rs.getString(5));
			rs.close();
		}catch(Exception ex){}
		return vo;
	}
	
	public boolean m_boardUpdate(ChallVO vo)
	{
		boolean bCheck=false;
		try{
			String sql="{CALL m_boardUpdate(?,?,?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.setString(6, vo.getPoster());
			cs.registerOutParameter(7, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(7);
			bCheck=Boolean.parseBoolean(result);
		}catch(Exception ex){}
		return bCheck;
	}
	
	public boolean m_boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try{
			String sql="{CALL m_boardDelete(?,?,?)}";
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
	
	public int m_boardTotalpage()
	{
		int total=0;
		try{
			String sql="SELECT m_boardTotalPage() FROM m_board";
			ps=dbConn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			ps.close();
		}catch(Exception ex){}
		return total;
	}
	
	public List<ChReplyVO> m_replyListData(int type,int cno,int page)
	{
		List<ChReplyVO> list=new ArrayList<ChReplyVO>();
		try{
			String sql="{CALL m_replyListData(?,?,?,?,?)}";
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
				ChReplyVO vo=new ChReplyVO();
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
	
	public void m_replyInsert(ChReplyVO vo){
		try{
			String sql="{CALL m_replyInser(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public void m_replyUpdate(int no,String msg)
	{
		try{
			String sql="{CALL m_replyUpdate(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	public void m_replyDelete(int no)
	{
		try{
			String sql="{CALL m_replyDelete(?)}";
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
