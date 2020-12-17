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
//@RequestMapping("shopping/")
public class ShoppoingController {
	@Autowired
	private ShoppingDAO dao;
	
	@Autowired
	private RecipeDAO rdao;
	
	@Autowired
	private ShoppingReplyDAO sdao;
	
	// 가격 리스트
	@RequestMapping("shopping/list.do")
	public String shopping_list(String page,String category2,Model model)
	{

		return "shopping/list";
	}
	//sublist (Ajax)	
	@RequestMapping("shopping/sublist.do")
	public String shopping_sublist(String page,String category2,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		System.out.println("page는?:"+page);
		
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
		
		List<ShoppingVO> list=dao.shoppingListData(map);
		
		model.addAttribute("model",model);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);
		return "sublist";
	}
	
	
	// 상세보기
	@RequestMapping("shopping/detail.do")
	public String shopping_detail(int no,String category3,Model model)
	{
		System.out.println("디테일 no값"+no);
		System.out.println("디테일 category3값"+category3);
		ShoppingVO vo=dao.shoppingDetailData(no);
		
		//상세보기 레시피데이터
		List<RecipeVO> rList=dao.shoppingRecipeData(vo.getCategory3());
		System.out.println("category3"+category3);

		
		// 그래프 출력
		System.out.println("no값은  :"+no);
		System.out.println("?");
		ShoppingReplyVO svo=dao.productGraphData(no);

		System.out.println("??");

		List<ShoppingReplyVO> sList= sdao.replyListData(no);
		System.out.println("sList사이즈는"+sList.size());
		
		model.addAttribute("rList",rList);
		model.addAttribute("sList",sList);
		model.addAttribute("vo",vo);
		model.addAttribute("svo",svo);	
		model.addAttribute("model",model);
		return "shopping/detail";
	}
	
	//상세보기페이지 레시피 상세보기 넘어가기
	@RequestMapping("recipe/detail2.do")
	public String recipe_detail(int rno,Model model)
	{
		RecipeVO vo=rdao.recipeDetailData(rno);
		System.out.println("rno값은??="+rno);
		model.addAttribute("vo",vo);
		return "redirect:../recipe/detail.do";
		
	}
	
	
	// 상세보기 내 댓글추가
	@RequestMapping("/shopping/shoppingReply_insert.do")
	public String ShoppingReply_insert(HttpSession session,String i,String j,String k,ShoppingReplyVO svo,ShoppingVO vo,RedirectAttributes as)
	{
		   String id=(String)session.getAttribute("id");
		   String name=(String)session.getAttribute("name");
		   svo.setId(id);
		   svo.setName(name);
		   System.out.println("category3:"+vo.getCategory3());
		   System.out.println("cno :"+svo.getCno());
		   
		   if(i!=null)
		   {
			   svo.setGood(1);
		   }
		   else if(j!=null)
		   {
			   svo.setSoso(1);
		   }
		   else if(k!=null)
		   {
			   svo.setBad(1);
		   }
		   
		   System.out.println("good???"+svo.getGood());
		   sdao.shoppingReply_insert(svo);
		   as.addAttribute("no",svo.getCno());
		   as.addAttribute("category3",vo.getCategory3());
		   return "redirect:../shopping/detail.do";
	}
	//댓글 삭제
	@RequestMapping("/shopping/shoppingReply_delete.do")
	public String shoppingReply_delete(RedirectAttributes attr,ShoppingReplyVO vo)
	{
		System.out.println("no는 뭐?"+vo.getNo());
		System.out.println("cno는 뭐??"+vo.getCno());
		sdao.shoppingReply_delete(vo);
//		as.addAttribute("no",svo.getCno());
//		as.addAttribute("category3",vo.getCategory3());
		attr.addAttribute("no",vo.getCno());
		return "redirect:../shopping/detail.do";
	}
	//댓글 수정
	@RequestMapping("/shopping/shoppingReply_update.do")
	public String shoppingReply_update(RedirectAttributes attr,ShoppingReplyVO vo,HttpSession session,String i,String j,String k)
	{
		 String id=(String)session.getAttribute("id");
		 String name=(String)session.getAttribute("name");
		 vo.setId(id);
		 vo.setName(name);
		 
		 if(i!=null)
		   {
			   vo.setGood(1);
		   }
		   else if(j!=null)
		   {
			   vo.setSoso(1);
		   }
		   else if(k!=null)
		   {
			   vo.setBad(1);
		   }
		System.out.println("cno값은??????????????"+vo.getCno()); 
		System.out.println("no값은??????????????"+vo.getNo()); 
		sdao.shoppingReply_update(vo);
//		as.addAttribute("no",svo.getCno());
//		as.addAttribute("category3",vo.getCategory3());
		attr.addAttribute("no", vo.getCno());
//		attr.addAttribute("no", vo.getNo());
		return "redirect:../shopping/detail.do";
	}
		
}
