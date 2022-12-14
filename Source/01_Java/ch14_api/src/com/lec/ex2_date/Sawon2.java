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
		// 특정한 날짜를 y년 m월 d일로 초기화
		// joinDate = new Date(y-1900, m-1, d);
		joinDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일(E)");
		if((part+"").length() >8)
			return "[사번]" + id + "\t[이름]" + name + "\t[부서]" + part +  "\t[입사일]" + sdf.format(joinDate);
		else
			return "[사번]" + id + "\t[이름]" + name + "\t[부서]" + part +  "\t\t[입사일]" + sdf.format(joinDate);
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
