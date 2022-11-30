package com.lec.condition;

import java.util.Scanner;

// 두 수를 입력받아 어떤 수가 얼마나 더 큰지 출력하시오.
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 수는? : ");
		int num1 = scanner.nextInt();
		System.out.print("두 번째 수는? : ");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.printf("첫 번째 수 (%d)가 (%d)만큼 더 큽니다.", num1, (num1-num2));
		}else if(num1<num2) {
			System.out.printf("두 번째 수 (%d)가 (%d)만큼 더 큽니다.", num2, (num2-num1));
		}else {
			System.out.printf("같은 수를 입력하셨습니다.");
		} // if
		scanner.close();
	} // main
} // class
