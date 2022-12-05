package com.lec.ex1_student;
// 单捞磐: name(string), kor(int), eng(int), math(int), tot(int), avg(double)
// 皋家靛: infoString()
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	public Student() {}
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor + eng + math;
		avg = tot / 3.0;
	}
	// Student s = new Student("沥快己", 100, 100, 100);
	// sysout(s.infoString()) => \t沥快己\t100\t100\t100\t300\t100.00
	public String infoString() {
//		return "\t" + name + "\t" +kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg;
		return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, math, tot, avg);
	}
	//s,infoPrint();
	public void infoPrint() {
		System.out.printf("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, math, tot, avg);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	//getters
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
}
