package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	private String id;
	private String name;
	private Part part;
	private Date joinDate;
	
	public Sawon2(String id, String name, Part part) {
		this.id = id;
		this.name = name;
		this.part = part;
		joinDate = new Date();
	}
	public Sawon2(String id, String name, Part part, int y, int m, int d) {
		this.id = id;
		this.name = name;
		this.part = part;
		// Ư���� ��¥�� y�� m�� d�Ϸ� �ʱ�ȭ
		// joinDate = new Date(y-1900, m-1, d);
		joinDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d��(E)");
		if((part+"").length() >8)
			return "[���]" + id + "\t[�̸�]" + name + "\t[�μ�]" + part +  "\t[�Ի���]" + sdf.format(joinDate);
		else
			return "[���]" + id + "\t[�̸�]" + name + "\t[�μ�]" + part +  "\t\t[�Ի���]" + sdf.format(joinDate);
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Part getPart() {
		return part;
	}
	public Date getJoinDate() {
		return joinDate;
	}
}
