package com.lec.ex11_store;
// 대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
		super(storeName);
		// TODO Auto-generated constructor stub
	}
	@Override //안 써도 기능은 하지만 꼭 쓰기
	public void bude() {
		System.out.println("부대찌개: 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥: 5,000원");
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥: 무료");
	}
}
