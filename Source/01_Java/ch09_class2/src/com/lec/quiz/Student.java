package com.lec.quiz;
// 객체 생성: new Student("정우성", 90, 80, 100); -> 번호, 총점, 평균도 같이 초기화
// 데이터: 번호, 이름, 국, 영, 수, 총, 평
public class Student {
	private int num;
	public static int count;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;
	public Student() {}
	public Student(String name, int kor, int eng, int math) {
		num = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor + eng + math;
		avg = (int)(tot/3.0 + 0.5);
	}
//	public Student(int num, String name, int kor, int eng, int math, int tot, int avg) {
//		this.num = num;
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//		this.tot = tot;
//		this.avg = avg;
//	}
	public String infoString() {
		return String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", num, name, kor, eng, math, tot, avg);
	}
	public int getNum() {
		return num;
	}
	public static int getCount() {
		return count;
	}
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
	public int getTot() {
		return tot;
	}
	public int getAvg() {
		return avg;
	}
}