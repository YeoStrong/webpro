package com.lec.conditionQuiz;
// 수를 입력 받아 절대값을 출력
import java.util.Scanner;
public class Quiz01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("수를 입력하세요: ");
		int num = scan.nextInt();
		if(num>0) {
			System.out.println("절대값은 " + num + "입니다.");
		}else if(num==0) {
			System.out.println(num + "입니다.");
		}else {
			System.out.println("절대값은 " + (-num) + "입니다.");
		} //if
		scan.close();
	} //main
} //class