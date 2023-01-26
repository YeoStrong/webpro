package com.lec.loop;

import java.util.Scanner;

// 짝수를 입력받아 출력, 짝수를 입력할때까지 물어봄
public class Ex10doWhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		do {
			System.out.print("짝수를 입력하세요: ");
			num = scan.nextInt();
		}while((num%2) != 0);
		System.out.println("입력한 짝수는" + num);
		scan.close();
	}

}
