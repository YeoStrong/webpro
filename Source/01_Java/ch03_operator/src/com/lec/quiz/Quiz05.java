package com.lec.quiz;

import java.util.Scanner;

// 국어, 영어, 수학 점수를 사용자에게 입력 받아, 각 점수를 출력하고 총점, 평균(소수점 2자리까지) 출력하는 프로그램을 구현하시오.
public class Quiz05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요: ");
		int kr = sc.nextInt();
		System.out.print("영어 점수를 입력하세요: ");
		int en = sc.nextInt();
		System.out.print("수학 점수를 입력하세요: ");
		int math = sc.nextInt();
		System.out.printf("국어: %d \n영어: %d \n수학: %d\n\n", kr, en, math);
		int sum = kr + en + math;
		System.out.printf("총점: %d\n", sum);
		double average = sum / 3.0;
		System.out.printf("평균: %.2f\n", average);
		sc.close();
	}
}
