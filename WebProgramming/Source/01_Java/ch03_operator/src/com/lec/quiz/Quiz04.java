package com.lec.quiz;

import java.util.Scanner;

// 나이를 입력 받아 입력 받은 나이가 65세 이상일 때, "경로우대" 출력, 아니면 "일반" 출력
public class Quiz04 {
	public static void main(String[] args) {
		System.out.print("나이를 입력해주세요: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		String result = (age >= 65) ? "경로우대" : "일반";
		System.out.println(result);
		sc.close();
	}

}
