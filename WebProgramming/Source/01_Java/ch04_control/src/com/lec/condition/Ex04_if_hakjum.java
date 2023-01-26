package com.lec.condition;
import java.util.Scanner;
// 정수를 입력받아 학점 출력(if문)
public class Ex04_if_hakjum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수는? : ");
		int score = sc.nextInt();
		// 90<=score<100 if문에 python은 가능하지만 java는  불가
		if(90<=score && score<=100) {
			System.out.println("A학점");
		}else if(80<=score && score<=90) {
			System.out.println("B학점");
		}else if(70<=score && score<=80) {
			System.out.println("C학점");
		}else if(60<=score && score<=70) {
			System.out.println("D학점");
		}else if(0<=score && score<=60) {
			System.out.println("F학점");
		}else {
			System.out.println("올바른 점수를 입력해 주세요.");
		}
		sc.close();
	}
}
