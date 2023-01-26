package com.lec.quiz;

import java.util.Scanner;

//두 수를 입력받아
//두 수가 같은지 결과를 o나 x로 출력.
//첫번째 수가 더 큰지 결과를 o나 x로 출력.
public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요: ");
		int su1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요: ");
		int su2 = sc.nextInt();
		String result1 = (su1 == su2) ? "O입니다." : "X입니다.";
		String result2 = (su1 > su2) ? "O입니다." : "X입니다.";
		System.out.printf("\n" + result1 + "\n" + result2);
		sc.close();
	}

}
