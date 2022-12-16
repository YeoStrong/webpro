package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // 사용자에게 입력받을 수를 저장
		System.out.print("첫 번째 정수는?");
		do {
			try {
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.print("정수를 입력하세요.");
				scanner.nextLine(); // 버퍼 지우는 목적
			}
		}while(true);
		System.out.print("두 번째 정수는?");
		try {
			j = scanner.nextInt();	
			System.out.println("i / j = " + (i/j)); // 예외가 발생할 수도 있는 부분
		}catch(ArithmeticException e) { // 예외 발생 시 수행 부분
			 System.out.println(e.getMessage()); // 예외 메세지 출력
//			e.printStackTrace();
		}catch(InputMismatchException e) {
			System.out.println("예외 메세지: " + e.getMessage());
			System.out.println("J값을 잘못 입력하셔서 1로 처리합니다.");
		}
		System.out.println("i = " + i + ", j= " + j);
		System.out.println("i * j = " + (i*j));
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
