package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller

@RequestMapping("community/")
public class CBoardController {
   @Autowired
   private CBoardDAO dao;
   
   @RequestMapping("list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<CBoardVO> list=dao.boardListData(curpage);
	   int totalpage=dao.boardTotalPage();
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   return "community/list";
   }
   
   @RequestMapping("insert.do")
   public String board_insert()
   {
	   return "community/insert";
   }
   
   @RequestMapping("insert_ok.do")
   public String board_insert_ok(CBoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:../community/list.do";
   }
   
   @RequestMapping("detail.do")
   public String board_detailData(int no,String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   CBoardVO vo=dao.boardDetailData(no);
	   List<CReplyVO> list=dao.replyListData(3, no, curpage);
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   return "community/detail";
   }
   
   @RequestMapping("update.do")
   public String board_update(int no,Model model)
   {
	   CBoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "community/update";
   }
   @RequestMapping("update_ok.do")
   public String board_update_ok(CBoardVO vo,Model model)
   {
	   boolean bCheck=dao.boardUpdate(vo);
	   model.addAttribute("bCheck", bCheck);
	   model.addAttribute("no", vo.getNo());
	   return "community/update_ok";//ajax
   }
   
   @RequestMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "community/delete";
   }
   
   @RequestMapping("delete_ok.do")
   public String board_delete_ok(int no,String pwd,Model model)
   {
	   boolean bCheck=dao.boardDelete(no, pwd);
	   model.addAttribute("bCheck", bCheck);
	   return "community/delete_ok";
   }
   
   @RequestMapping("reply_insert.do")
   public String replyInsert(CReplyVO vo,HttpSession session)
   {
	   
	   vo.setId((String)session.getAttribute("id"));
	   vo.setName((String)session.getAttribute("name"));
	   vo.setType(3);
	   dao.replyInsert(vo);
	   return "redirect:detail.do?no="+vo.getCno();
   }
   
   @RequestMapping("reply_delete.do")
   public String reply_delete(int no,int cno)
   {
	   dao.replyDelete(no);
	   return "redirect:detail.do?no="+cno;
   }
   
   @RequestMapping("reply_update.do")
   public String reply_update(int no,int cno,String msg)
   {
	   dao.replyUpdate(no, msg);
	   return "redirect:detail.do?no="+cno;
   }
   
   // 로그인 
   @RequestMapping("login.do")
   public String board_login()
   {
	   return "community/login";
   }
   
   @RequestMapping("login_ok.do")
   public String board_login_ok(String id,String pwd,Model model,HttpSession session)
   {
	  MemberVO vo=dao.memberLogin(id, pwd);
	   if(vo.getMessage().equals("OK"))
	   {
		   session.setAttribute("id", id);
		   session.setAttribute("name", vo.getName());
	   }
	   model.addAttribute("msg", vo.getMessage());
	   return "community/login_ok";
   }
   
}
