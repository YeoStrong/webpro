package com.lec.quiz01;

public class Gangsa extends Person {
	private String subject;
	private static int cntGangsa = 0;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++cntGangsa;
		setNo("gangsa" + cntGangsa);
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t(°ú¸ñ)" + getSubject();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
