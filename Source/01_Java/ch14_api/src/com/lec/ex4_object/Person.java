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
		return "주민번호는 " + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// p1.equals(p2) : p1이 this, p2가 obj
		// this의 주민번호와 obj의 주민번호가 같은지 다른지 여부를 return
		if(obj!=null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}
