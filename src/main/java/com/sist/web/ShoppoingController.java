package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("shopping/")
public class ShoppoingController {
	@Autowired
	private ShoppingDAO dao;
	
	@Autowired
	private ShoppingReplyDAO sdao;
	
	// 가격 리스트
	@RequestMapping("list.do")
	public String shopping_list(Model model)
	{
		/*if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<ShoppingVO> list=dao.shoppingListData(map);
		
		int totalpage=dao.shoppingTotalPage();
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);*/
		
		return "shopping/list";
	}
	//sublist (Ajax)	
	@RequestMapping("sublist.do")
	public String shopping_sublist(String page,String category2,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		int totalpage=dao.shoppingTotalPage(category2);
		
		System.out.println("category2 값:"+category2);
		if(category2==null || category2.equals(""))
			category2="축산";
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("category2",category2);
		//안치훈
//		List<ShoppingVO> svo=dao.shoppingCateData(category2);
		
		
		List<ShoppingVO> list=dao.shoppingListData(map);
//		List<ShoppingVO> list=dao.shoppingCateData(category2);
		
		
		model.addAttribute("model",model);
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);
		return "sublist";
	}
	
	
	// 상세보기
	@RequestMapping("detail.do")
	public String shopping_detail(int no,String page,String category3,String title,Model model)
	{
		System.out.println("category3"+category3);
		ShoppingVO vo=dao.shoppingDetailData(no);
		//상세보기 레시피데이터
		List<RecipeVO> rList=dao.shoppingRecipeData(category3);
		
		//상세보기 댓글추가
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<ShoppingReplyVO> sList= sdao.ShoppingReplyListData(no, curpage);
		System.out.println("sList사이즈는"+sList.size());
		model.addAttribute("rList",rList);
		model.addAttribute("sList",sList);
		model.addAttribute("vo",vo);
		return "shopping/detail";
	}
	
	
	//카테고리 분류
	/*@RequestMapping("cate.do")
	public String shopping_cate(String category2,Model model)
	{
		List<ShoppingVO> list = dao.shoppingCateDate(category2);
		model.addAttribute("list",list);
		return "shopping/sublist";	
	}*/
	
	// 상세보기 내 댓글추가
	@RequestMapping("ShoppingReply_insert.do")
	public String ShoppingReply_insert(RedirectAttributes attr,int cno,int good,int soso,int bad,String msg,HttpSession session)
	{
		String id=(String)session.getAttribute("id");
		   String name=(String)session.getAttribute("name");
		   ShoppingReplyVO vo=new ShoppingReplyVO();
		   vo.setCno(cno);
		   vo.setMsg(msg);
		   vo.setId(id);
		   vo.setName(name);
		   vo.setGood(good);
		   vo.setSoso(soso);
		   vo.setBad(bad);
		   sdao.replyInsert(vo);
		   attr.addAttribute("no", cno);
		   //attr.addFlashAttribute(arg0) : Object(VO,List)
		   return "redirect:../shopping/detail.do";
	}
	//댓글 삭제
	@RequestMapping("ShoppingReply_delete.do")
	public String ShoppingReply_delete(RedirectAttributes attr,int no,int cno)
	{
		sdao.ShoppingReplyDelete(no);
		attr.addAttribute("no", no);//GET 
		return "redirect:../shopping/detail.do";
	}
	//댓글 수정
	@RequestMapping("ShoppingReply_update.do")
	public String ShoppingReply_update(RedirectAttributes attr,int no,int cno,String msg)
	{
		sdao.ShoppingReplyUpdate(no, msg);
		attr.addAttribute("no", no);
		return "redirect:../shopping/detail.do";
	}
	
	
	
	
	
}
