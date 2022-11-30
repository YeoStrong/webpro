package com.lec.conditionQuiz;
// 현재 몇 월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램
import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("현재 몇 월 입니까?: ");
		int month = scan.nextInt(); // 1 ~ 12
		switch(month) {
		case 1: case 2: case 11: case 12:
			System.out.println(month + "월은 겨울입니다.");break;
		case 3: case 4: case 5:
			System.out.println(month + "월은 봄입니다.");break;
		case 6: case 7: case 8:
			System.out.println(month + "월은 여름입니다.");break;
		case 9: case 10:
			System.out.println(month + "월은 가을입니다.");break;
		default:
			System.out.println("유효한 월을 입력해주세요(1~12).");
		} //switch
		scan.close();
	} //main

} //class
