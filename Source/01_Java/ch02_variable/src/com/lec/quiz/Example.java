package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		int korean = 90, english = 80, math = 63; // 국어, 영어, 수학 점수 할당, 출력
		System.out.println("국어 =" + korean + "\t영어 =" + english + "\t수학= " + math);
		int sum;
		sum = (korean + english + math);
		System.out.println("총합= " + sum);
		double average;
		average = (korean + english + math) / 3.0;
		System.out.println("평균= " + average);
		// 총점, 평균
		// 점수들 출력
	}
}
