package com.lec.ex4_object;

public class Person {
	private long juminNo; //9312301205839

	public Person() {}
	
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�ֹι�ȣ�� " + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// this�� �ֹι�ȣ�� obj�� �ֹι�ȣ�� ������ �ٸ��� ���θ� return
		return (this == obj); // p1.equals(p2) : p1�� this, p2�� obj
	}
}
