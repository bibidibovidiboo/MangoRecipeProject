package com.sist.data;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class IngreManager {
	public List<Item> ingrePriceData()
	{
		List<Item> list = new ArrayList<Item>();
		try {
			
			String strUrl="http://www.kamis.or.kr/service/price/xml.do?action=dailyPriceByCategoryList" + 
					"&p_product_cls_code=02" + 
					"&p_convert_kg_yn=N" + 
					"&p_item_category_code=100" + 
					"&p_cert_key=f7a3417b-50d2-4e52-ab73-317b95c53fe6" + 
					"&p_cert_id=1329" + 
					"&p_returntype=xml";
			URL url=new URL(strUrl);
			// 파싱
			   JAXBContext jb=JAXBContext.newInstance(Document.class);
			   //                                  받을 클래스명(@XMLRootElement)
			   
			   Unmarshaller un=jb.createUnmarshaller();
			   /*
			    *   Unmarshaller : XML=>자바클래스로 변환
			    *   Marshaller : 자바클래스 => XML로 변환 
			    *   
			    */
			   Document document=(Document)un.unmarshal(url);
			   list = document.getData().getItem();
			   
			   for(Item i: list)
			   {
				   System.out.println(i.getItem_name());
				   
				/*
				 * String temp = i.getItem_name();
				 * 
				 * int idx = temp.indexOf("/"); String item_name = temp.substring(0,idx);
				 * System.out.println(item_name);
				  
				  */
				  System.out.println(i.getDpr3());
				 
				   
				   
				/*
				 * Item item = new Item(); item.setItem_name(item_name);
				 * item.setLastest_day(i.getLastest_day()); item.setUnit(i.getUnit());
				 * item.setDpr1(i.getDpr1()); item.setDpr2(i.getDpr2());
				 * item.setDpr3(i.getDpr3()); item.setDpr4(i.getDpr4());
				 * item.setDirection(i.getDirection());
				 */
				   
			   }
			   
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public static void main(String[] args) {
		IngreManager im = new IngreManager();
		im.ingrePriceData();
	}
}
