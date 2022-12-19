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
		return grade + "�г� " + name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode(); // ���� grade�� ���� name�� ��� toString ����� ���Ƽ�, ���� hashCode�� ��ȯ
	}
	@Override
	public boolean equals(Object obj) { // s1.equals(s2) : s1�� this, s2�� obj
		// TODO Auto-generated method stub
		if(obj!=null & getClass()==obj.getClass()) {
			Student other = (Student)obj;
			return grade==other.grade && name.equals(other.name);
		}
		return false;
	}
}
