package com.lec.ex11_store;
// ���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
public class Store1 extends HeadQuarterStore {

	public Store1(String storeName) {
		super(storeName);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void bude() {
		System.out.println("�δ��: 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹�� ���� �غ����Դϴ�.");
	}
}
