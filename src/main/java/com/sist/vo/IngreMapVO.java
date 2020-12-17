package com.sist.vo;

public class IngreMapVO {
/*
NO       NOT NULL NUMBER(38)     
TITLE    NOT NULL VARCHAR2(100)  
REGION1  NOT NULL VARCHAR2(100)  
REGION2  NOT NULL VARCHAR2(100)  
WHEN     NOT NULL VARCHAR2(100)  
CONTENT1          VARCHAR2(1000) 
CONTENT2          VARCHAR2(1000) 
CONTENT3          VARCHAR2(1000) 
CONTENT4          VARCHAR2(1000) 
 */
	
	private int no;
	private String title,region1,region2,when,content1,content2,content3,content4;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegion1() {
		return region1;
	}
	public void setRegion1(String region1) {
		this.region1 = region1;
	}
	public String getRegion2() {
		return region2;
	}
	public void setRegion2(String region2) {
		this.region2 = region2;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public String getContent4() {
		return content4;
	}
	public void setContent4(String content4) {
		this.content4 = content4;
	}
	
}
