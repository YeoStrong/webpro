package com.lec.ex;

public class Student {
	private String sNo;
	private String name;
	private int grade;
	private char sClass;
	private int score;
	public Student() {}
	public Student(String sNo, String name, int grade, char sClass, int score) {
		this.sNo = sNo;
		this.name = name;
		this.grade = grade;
		this.sClass = sClass;
		this.score = score;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getsClass() {
		return sClass;
	}
	public void setsClass(char sClass) {
		this.sClass = sClass;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
