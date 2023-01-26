package com.lec.ex11_store;
// ※본사의 메뉴 가격을 기본적으로 따르되, 지역 특색에 맞춰 가격을 변경함.
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
// HeadQuarterStore head = new HeadQuarterStore("= = 본사 = =");
public class HeadQuarterStore {
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("김치찌개: 5,000원");
	}
	public void bude() {
		System.out.println("부대찌개: 6,000원");
	}
	public void bibim() {
		System.out.println("비빔밥: 6,000원");
	}
	public void sunde() {
		System.out.println("순대국: 5,000원");
	}
	public void gongibab() {
		System.out.println("공기밥: 1,000원");
	}
	public String getStoreName() {
		return storeName;
	}
}
