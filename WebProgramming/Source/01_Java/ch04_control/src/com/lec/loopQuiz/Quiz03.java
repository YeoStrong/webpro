package com.lec.loopQuiz;
import java.util.Scanner;
//사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력해보자.
public class Quiz03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 구구단수를 입력하세요: ");
		int gugu = scan.nextInt();
		if(gugu<=0) {
			System.out.println("양의 정수를 입력하세요.");
		}else {
			for(int i=1 ; i<=9 ; i++) {
				System.out.println(gugu + "*" + i + "=" + (gugu*i));
			}
		}scan.close(); //if
	} //main
} //class