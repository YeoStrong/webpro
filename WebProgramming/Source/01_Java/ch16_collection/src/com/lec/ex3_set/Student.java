package com.lec.ex3_set;

public class Student {
	private int grade;
	private String name;
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	@Override
	public String toString() {
		return grade + "학년 " + name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode(); // 같은 grade와 같은 name일 경우 toString 결과가 같아서, 같은 hashCode가 반환
	}
	@Override
	public boolean equals(Object obj) { // s1.equals(s2) : s1은 this, s2는 obj
		// TODO Auto-generated method stub
		if(obj!=null & getClass()==obj.getClass()) {
			Student other = (Student)obj;
			return grade==other.grade && name.equals(other.name);
		}
		return false;
	}
}
