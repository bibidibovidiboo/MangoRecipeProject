package com.sist.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.ChallDAO;
import com.sist.vo.ChReplyVO;
import com.sist.vo.ChallVO;

@Controller
@RequestMapping("chall/")
public class ChallController {
	@Autowired
	private ChallDAO dao;
	
	 @RequestMapping("list.do")
	   public String m_board_list(String page,Model model)
	   {
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   List<ChallVO> list=dao.m_boardListData(curpage);
		   int totalpage=dao.m_boardTotalpage();
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("list", list);
		   return "chall/list";
	   }
	   
	   @RequestMapping("insert.do")
	   public String m_board_insert()
	   {
		   return "chall/insert";
	   }
	   
	   @RequestMapping("insert_ok.do")
	   public String m_board_insert_ok(ChallVO vo)
	   {
		   dao.m_boardInsert(vo);
		   return "redirect:../chall/list.do";
	   }
	   
	   @RequestMapping("detail.do")
	   public String m_board_detailData(int no,String page,Model model)
	   {
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   ChallVO vo=dao.m_boardDetailData(no);
		   List<ChReplyVO> list=dao.m_replyListData(3, no, curpage);
		   model.addAttribute("vo", vo);
		   model.addAttribute("list", list);
		   return "chall/detail";
	   }
	   
	   @RequestMapping("update.do")
	   public String m_board_update(int no,Model model)
	   {
		   ChallVO vo=dao.m_boardUpdateData(no);
		   model.addAttribute("vo", vo);
		   return "chall/update";
	   }
	   @RequestMapping("update_ok.do")
	   public String m_board_update_ok(ChallVO vo,Model model)
	   {
		   boolean bCheck=dao.m_boardUpdate(vo);
		   model.addAttribute("bCheck", bCheck);
		   model.addAttribute("no", vo.getNo());
		   return "chall/update_ok";//ajax
	   }
	   
	   @RequestMapping("delete.do")
	   public String m_board_delete(int no,Model model)
	   {
		   model.addAttribute("no", no);
		   return "chall/delete";
	   }
	   
	   @RequestMapping("delete_ok.do")
	   public String m_board_delete_ok(int no,String pwd,Model model)
	   {
		   boolean bCheck=dao.m_boardDelete(no, pwd);
		   model.addAttribute("bCheck", bCheck);
		   return "chall/delete_ok";
	   }
	   
	   @RequestMapping("reply_insert.do")
	   public String m_replyInsert(ChReplyVO vo,HttpSession session)
	   {
		   
		   vo.setId((String)session.getAttribute("id"));
		   vo.setName((String)session.getAttribute("name"));
		   vo.setType(3);
		   dao.m_replyInsert(vo);
		   return "redirect:detail.do?no="+vo.getCno();
	   }
	   
	   @RequestMapping("reply_delete.do")
	   public String m_reply_delete(int no,int cno)
	   {
		   dao.m_replyDelete(no);
		   return "redirect:detail.do?no="+cno;
	   }
	   
	   @RequestMapping("reply_update.do")
	   public String m_reply_update(int no,int cno,String msg)
	   {
		   dao.m_replyUpdate(no, msg);
		   return "redirect:detail.do?no="+cno;
	   }
	
	
	
	
}
