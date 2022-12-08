package com.lec.quiz01;

public class Staff extends Person {
	private String department;
	private static int cntStaff = 0;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++cntStaff;
		setNo("staff" + cntStaff);
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(ºÎ¼­)" + getDepartment();
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
