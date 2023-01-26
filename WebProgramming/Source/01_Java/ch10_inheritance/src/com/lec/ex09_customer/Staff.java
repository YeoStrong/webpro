package com.lec.ex09_customer;
// name, tel, infoString
public class Staff extends Person {
	private String hiredate; //입사일("2000-12-12") 다음주부터 Date형 사용할 예정
	private String department; // 부서
	// Staff s = new Staff("박사원", "010-8888-8888", "2022-12-01", "전산실")
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "   [입사일]" + hiredate + "   [부서]" +  department;
	}

}
