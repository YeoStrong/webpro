package com.lec.ex02_store;
// ���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ��ū���뱹-6,000  �����-1,000��
public class Store3 implements HeadQuarterStore {

	private String storeName;
	public Store3(String storeName) {
		this.storeName = storeName;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�: 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ��: 7,000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����: 7,000��");
	}
	@Override
	public void sunde() {
		System.out.println("��ū���뱹: 6,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("�����: 1,000��");
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
