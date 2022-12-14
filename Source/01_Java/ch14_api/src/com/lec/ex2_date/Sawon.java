package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	private String id;
	private String name;
	private String part;
	private Date joinDate;
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";
	
	public Sawon(String id, String name, String part) {
		this.id = id;
		this.name = name;
		this.part = part;
		joinDate = new Date();
	}
	public Sawon(String id, String name, String part, int y, int m, int d) {
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
		if(part.length() >8)
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
	public String getPart() {
		return part;
	}
	public Date getJoinDate() {
		return joinDate;
	}
}
