package com.lec.ex;
// Quiz : 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오. 
// (단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9사이의 수를 입력할 때까지 계속 입력 받는다.)
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int gugu;
		do {
			System.out.print("구구단 몇 단을 불러올까요?: ");
			gugu = scan.nextInt();
		}while(gugu<=1 || gugu>9);
		System.out.println(gugu + "단\n");
		multiTable(gugu);
		scan.close();
	}

	private static void multiTable(int gugu) {
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(gugu + "*" + i + "=" + (gugu*i));
		}
	}
}
