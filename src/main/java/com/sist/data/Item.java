package com.sist.data;

public class Item {
	private String lastest_day;
	private String item_name; // 찹쌀/일반계
	private String unit; // 단위
	
	private int dpr1;	// 당일
	private int dpr2;	// 1일전
	private int dpr3; 	// 1개월 전
	private int dpr4; 	// 1년 전
	
	private int direction; // 등락여부( 0:가격하락 1:가격상승 2:등락없음 )

	public String getLastest_day() {
		return lastest_day;
	}

	public void setLastest_day(String lastest_day) {
		this.lastest_day = lastest_day;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getDpr1() {
		return dpr1;
	}

	public void setDpr1(int dpr1) {
		this.dpr1 = dpr1;
	}

	public int getDpr2() {
		return dpr2;
	}

	public void setDpr2(int dpr2) {
		this.dpr2 = dpr2;
	}

	public int getDpr3() {
		return dpr3;
	}

	public void setDpr3(int dpr3) {
		this.dpr3 = dpr3;
	}

	public int getDpr4() {
		return dpr4;
	}

	public void setDpr4(int dpr4) {
		this.dpr4 = dpr4;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
}
