package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호를 입력받아 이것 저것 다 출력.
public class Ex06_telPrint {
	public static void main(String[] args) {
		String tel;
		while (true) {
			System.out.println("전화번호를 입력하세요: ");
			Scanner scan = new Scanner(System.in);
			tel = scan.next();
			if (tel.equalsIgnoreCase("x")) {
				System.out.println("종료되었습니다.");
				break;
			}
			System.out.println("입력하신 전화번호: " + tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i) + " ");
				}
			} // for1
			System.out.println();
			System.out.print("문자를 거꾸로: ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			} // for2
			System.out.println();
			System.out.print("전화번호 앞자리: ");
			for (int i = 0; i < tel.indexOf('-'); i++) {
				System.out.print(tel.charAt(i));
			} // for3
			System.out.println();
			System.out.print("전화번호 뒷자리: ");
			for (int i = tel.lastIndexOf('-')+1 ; i < tel.length() ; i++) {
				System.out.print(tel.charAt(i));
			} // for4
			System.out.println();
		}
	}
}
