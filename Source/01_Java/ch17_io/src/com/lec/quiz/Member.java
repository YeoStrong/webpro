package com.lec.quiz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Member {
	private String name;
	private String address;
	private String phone;
	private Date birthday;
	public Member() {}
	public Member(String name, String address, String phone, Date birthday) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd»ý");
		return name + "\t" + phone + "\t" + sdf.format(birthday) + "\t" + address + "\n";
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
