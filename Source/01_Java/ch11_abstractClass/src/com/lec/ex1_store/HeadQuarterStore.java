package com.lec.ex1_store;
// �߻�class: �ϳ� �̻��� �߻�method�� ������ ������ �߻�class��� �θ���.
public abstract class HeadQuarterStore {
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	//�߻�޼ҵ� : ���� ����� class����  �ݵ�� override�ض�.
	//		  	�޼ҵ��� ���� ���� ��, ������ ����.
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongibab();
	public String getStoreName() {
		return storeName;
	}
}
