package com.lec.quiz01;

public class Student extends Person {
	private String ban;
	private static int cntStudent=0;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		//no = "student" + (++cntStudent);
		++cntStudent;
		setNo("student" + cntStudent);
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(¹Ý)" + getBan();
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
}
