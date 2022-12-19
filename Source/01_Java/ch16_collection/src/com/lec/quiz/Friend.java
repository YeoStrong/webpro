package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	public Friend() {}
	public Friend(String name, String phone, String address, int y, int m, int d) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		birthday = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "�̸�: " + name + "\n�ּ�: " + address + "\n�ڵ���: " + phone + "\n����: " + sdf.format(birthday) + "\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
