package com.lec.ex02_protected.copy;
// SuperIJ: private i, j / public setI(), getI(), setJ(), getJ()    //100�ۼ�Ʈ ������ ��� ��ӹ��� ���� �װ� ���� ��.
public class Child extends SuperIJ{
	private int total;
	public Child() {
		super();
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j) { // ���� ���� ����
		super (i, j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ� - i, j �ʱ�ȭ"); // super �̿��Ͽ� �����غ���
//		this.i = i;	//super class�� private�� ���� access �Ұ�, protected��� ���� ��� ����
//		//setI(i); 
//		this.j = j;
//		//setJ(j); 
	}
	public void sum() {
		total = i + j;
		//total = getI() + getJ();	
		System.out.println("i = " + getI() + ", j=" + getJ() + ", total = " + total);
	}
}
