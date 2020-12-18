package com.sist.vo;

public class RecipeCookVO {
//	CNO            NUMBER        
//	TITLE NOT NULL VARCHAR2(500) 
//	CHEF  NOT NULL VARCHAR2(500) 
//	ORD            NUMBER        
//	COOK           VARCHAR2(500) 
	private String title,chef,cook;
	private int ord;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getCook() {
		return cook;
	}
	public void setCook(String cook) {
		this.cook = cook;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
}
