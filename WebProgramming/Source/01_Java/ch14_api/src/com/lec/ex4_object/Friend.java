package com.lec.ex4_object;

public class Friend {
	private String name;
	private String tel;
	private String birth; // "12-12"
	private String address;
	public Friend() {}
	public Friend(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
//	public String infoString() {
//		return "[捞抚]" +name+ "\t[傈拳]" + tel + "\t[积老]" + birth + "\t[林家]" + address;
//	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[捞抚]" +name+ "\t[傈拳]" + tel + "\t[积老]" + birth + "\t[林家]" + address;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	public String getAddress() {
		return address;
	}
}
