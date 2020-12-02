package com.sist.dao;
/*no NUMBER, 
res_cno NUMBER, 
res_title VARCHAR2(100),
res_score VARCHAR2(50),
res_menu VARCHAR2(500),
res_add VARCHAR2(500),  
res_tel VARCHAR2(50),  
res_price VARCHAR2(100),  
res_username VARCHAR2(50),
res_review CLOB,
res_reviedate VARCHAR2(50),
res_poster1 VARCHAR2(1000),  
res_poster2 VARCHAR2(1000),  
res_poster3 VARCHAR2(1000),
res_poster4 VARCHAR2(1000),
res_poster5 VARCHAR2(1000), */
public class RestaurantVO {
	private int no;
	private int cno;
	private String res_title;
	private String res_score;
	private String res_menu;
	private String res_add;
	private String res_tel;
	private String res_price;
	private String res_username;
	private String res_review;
	private String res_riviewdate;
	private String res_poster1;
	private String res_poster2;
	private String res_poster3;
	private String res_poster4;
	private String res_poster5;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getRes_title() {
		return res_title;
	}
	public void setRes_title(String res_title) {
		this.res_title = res_title;
	}
	public String getRes_score() {
		return res_score;
	}
	public void setRes_score(String res_score) {
		this.res_score = res_score;
	}
	public String getRes_menu() {
		return res_menu;
	}
	public void setRes_menu(String res_menu) {
		this.res_menu = res_menu;
	}
	public String getRes_add() {
		return res_add;
	}
	public void setRes_add(String res_add) {
		this.res_add = res_add;
	}
	public String getRes_tel() {
		return res_tel;
	}
	public void setRes_tel(String res_tel) {
		this.res_tel = res_tel;
	}
	public String getRes_price() {
		return res_price;
	}
	public void setRes_price(String res_price) {
		this.res_price = res_price;
	}
	public String getRes_username() {
		return res_username;
	}
	public void setRes_username(String res_username) {
		this.res_username = res_username;
	}
	public String getRes_review() {
		return res_review;
	}
	public void setRes_review(String res_review) {
		this.res_review = res_review;
	}
	public String getRes_riviewdate() {
		return res_riviewdate;
	}
	public void setRes_riviewdate(String res_riviewdate) {
		this.res_riviewdate = res_riviewdate;
	}
	public String getRes_poster1() {
		return res_poster1;
	}
	public void setRes_poster1(String res_poster1) {
		this.res_poster1 = res_poster1;
	}
	public String getRes_poster2() {
		return res_poster2;
	}
	public void setRes_poster2(String res_poster2) {
		this.res_poster2 = res_poster2;
	}
	public String getRes_poster3() {
		return res_poster3;
	}
	public void setRes_poster3(String res_poster3) {
		this.res_poster3 = res_poster3;
	}
	public String getRes_poster4() {
		return res_poster4;
	}
	public void setRes_poster4(String res_poster4) {
		this.res_poster4 = res_poster4;
	}
	public String getRes_poster5() {
		return res_poster5;
	}
	public void setRes_poster5(String res_poster5) {
		this.res_poster5 = res_poster5;
	}
	
	
}
