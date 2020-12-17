package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import com.sist.dao.FridgeDAO;
import com.sist.dao.RecipeDAO;
import com.sist.mapper.FridgeMapper;
import com.sist.vo.*;

@Controller
@RequestMapping("fridge/")
public class FridgeController {
	@Autowired
	private FridgeDAO dao;

	@Autowired
	private RecipeDAO rdao;
	//===============================================================================================

	
	// 나의 관심 식재료
	@RequestMapping("my_favorite.do")
	public String my_favorite(HttpSession session,Model model) {
		
		
		// 등록한 관심 식재료 검색
		String id = (String) session.getAttribute("id");
		List<FavoriteIngreVO> list=null;
		if(id!=null)
		{
			list = dao.favorite_ingre(id);
			
		}
		model.addAttribute("list",list);
		
		return "fridge/my_favorite";
	}
	
	// 관심 식재료 최저가
	//favorite_buy
	@RequestMapping("buy_list.do")
	public String buy_list(String title,Model model) {
		
		title="%"+title+"%";
		
		//System.out.println(title);
		
		
		List<ShoppingVO> iList = dao.favorite_buy(title);
		for(ShoppingVO vo:iList)
		{
			String bTitle=vo.getTitle();
			//System.out.println(bTitle);
		}
		
		model.addAttribute("iList",iList);
		return "buy_list";
	}
	
	
	
	//===============================================================================================
	// 지역 특산물 페이지
	@RequestMapping("ingre_map.do")
	public String ingre_map(HttpSession session,Model model) {
		String id = (String) session.getAttribute("id");
		
		// 냉장고에 있는 식재료 목록
		if(id!=null)
		{
			List<MyFridgeListVO> list = dao.my_fridge_list(id);
			model.addAttribute("list",list);
		}
		
		// 냉장고에 있는 식재료 목록으로 맞춤 레시피 추천해주기(정확도 100%)
		/*
		 * String myRefList="%"; for(MyFridgeListVO vo:list) {
		 * //System.out.println(vo.getTitle()); String title=vo.getTitle()+"%";
		 * myRefList+=title; } List<RecipeVO> rList = dao.recomm100List(myRefList);
		 * List<RecipeVO> kList = null; for(RecipeVO vo:rList) { kList =
		 * rdao.recipeRefridgeListData(vo.getTitle());
		 * //System.out.println(vo.getTitle()); }
		 * 
		 * model.addAttribute("kList",kList);
		 */
		
		return "fridge/ingre_map";
	}

	// 지도 클릭 시 표 나타내기
	@RequestMapping("ingre_map_detail.do")
	public String ingre_map_detail(String region1, Model model) {
		//System.out.println(region1);
		List<IngreMapVO> list = dao.ingre_map(region1);
		model.addAttribute("list", list);
		return "ingre_map_detail";
	}
	//===============================================================================================
	
	
	@RequestMapping("fridge_search.do")
	public String fridge_search(String ingre_name, Model model) {

		List<FridgeIngreVO> list = null;
		if (ingre_name != null) {
			list = dao.fridge_ingre_search(ingre_name);
		}

		String arr = "[";
		for (int i = 0; i < list.size(); i++) {
			FridgeIngreVO vo = list.get(i);
			arr += "\"" + vo.getIngre_name() + "\",";
		}
		arr = arr.substring(0, arr.lastIndexOf(","));
		arr += "];";
		model.addAttribute("arr", arr);
		System.out.println("출력완료:" + arr);

		return "fridge/my-fridge-list";
	}
	
	//===============================================================================================
	@RequestMapping("ingre_cate.do")
	public String ingre_cate_list(String category2,Model model, HttpSession session) {
		
		// 분류별 재료 버튼 뿌리기
		if(category2==null)
			category2="과일/야채";
		//System.out.println(category2);
		List<FridgeIngreVO> iList = dao.fridgeCateAllData(category2);
		
		
		for(FridgeIngreVO vo:iList)
		{
			String ingre_name=vo.getIngre_name();
		}
		
		model.addAttribute("iList",iList);
		return "ingre_cate";
	}
	
	
	
	@RequestMapping("fridge_main.do")
	public String fridge_main(Model model, HttpSession session) {
		
		// 분류 버튼 보이기
		List<FridgeIngreVO> cateList = dao.fridgeIngreCate();
		model.addAttribute("cateList",cateList);
	
		return "fridge/fridge_main";
	}
	//===============================================================================================

	
	@GetMapping("ingre_out2.do")
	public String fridge_ingre_out2(String ingre_name, HttpSession session) {
		String id = (String) session.getAttribute("id");
		Map map = new HashMap();
		map.put("id", id);
		map.put("ingre_name", ingre_name);
		if (id != null)
			dao.my_fridge_delete(map);

		return "redirect:ingre_map.do";
	}
	
	
	
	/*
	 * @RequestMapping("fridge_recipe_recomm.do") public List<RecipeVO>
	 * fridge_recipe_recomm( )
	 */
	
	
	// 시세 그래프
	@RequestMapping("ingre_price.do")
	public String ingre_price() {
		return "fridge/ingre_price";
	}

}
