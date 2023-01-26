package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_jumin {
	public static void main(String[] args) {
		System.out.println("주민등록번호를 입력하세요(******-*******): ");
		Scanner scan = new Scanner(System.in);
		String jumin = scan.next();
		char gender = jumin.charAt(7);
		if(gender=='1' || gender=='3') {
			System.out.println("남성이시군요.");
		}else if(gender=='2' || gender=='4') {
			System.out.println("여성이시군요.");
		}else {
			System.out.println("유효하지 않은 주민번호 입니다.");
		}
		// 방법2 String으로 추출
		String genderStr = jumin.substring(7,8); // "2"
		if(genderStr.equals("1") || genderStr.equals("3")) {
			System.out.println("남성이시군요.");
		}
		// 방법3 genderStr을 정수로 전환
		int genderInt = Integer.parseInt(genderStr); //2
		if(genderInt==1 || genderInt==3) {
			System.out.println("남성이시군요.");
		}else if(genderInt==2 || genderInt==4) {
			System.out.println("여성이시군요.");
		}else {
			System.out.println("유효하지 않은 주민등록번호입니다.");
		}
	}
}
