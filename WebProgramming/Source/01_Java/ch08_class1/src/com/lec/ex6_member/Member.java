package com.lec.ex6_member;

public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	public Member() {}
	public Member(String id, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public Member(String id, String password, String name, String email, String address, String birth, char gender) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public  String infoString() {
		String result = "���̵�: " + id;
		result += "\n�̸�: " + name;
		result += "\n�̸���: " + email;
		result += "\n�ּ�: " + address;
		result += "\n����: " + birth;
		result += "\n����: " + (gender=='m'? "����":(gender=='f'? "����":"undefined"));
		return result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
