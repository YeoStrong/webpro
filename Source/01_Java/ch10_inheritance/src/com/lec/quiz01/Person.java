package com.lec.quiz01;

public class Person {
	private String no;
	public static int count=0;
	private String id;
	private String name;
	public Person(String id, String name) {
		++count;
		no = "person" +count;
		this.id = id;
		this.name = name;
	}
	public String infoString() {
		return "(번호)" + no + "\t(ID)" + id +   "\t(이름)" + name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Person.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
