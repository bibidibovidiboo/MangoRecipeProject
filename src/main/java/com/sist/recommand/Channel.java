package com.sist.recommand;
import java.util.*;
/*
 	데이터 제공 시 XML 사용하는 이유
 	1. XML은 모든 운영체제에 호환성 있음
 	2. 파일 호환성
 	3. 정확한 데이터 전송
 	4. 모든 언어가 XML파싱 라이브러리를 가지고 있음
 */
public class Channel {
	private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}
