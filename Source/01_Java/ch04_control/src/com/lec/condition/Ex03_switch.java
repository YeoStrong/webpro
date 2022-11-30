package com.lec.condition;

public class Ex03_switch { //스위치 내부에는 정수형, 문자형, 문자열만 가능
	public static void main(String[] args) {
		int num=3;
		switch(num) {
		case 1:
			System.out.println("주사위 1");break;
		case 2:
			System.out.println("주사위 2");break;
		case 3:
			System.out.println("주사위 3");break;
		case 4:
			System.out.println("주사위 4");break;
		case 5:
			System.out.println("주사위 5");break;
		case 6:
			System.out.println("주사위 6");break;
		default:
			System.out.println("주사위 숫자가 아닙니다.");
		}
//		if(num == 1) {
//			System.out.println("주사위 1");
//		}else if(num == 2) {
//			System.out.println("주사위 2");
//		}else if(num == 3) {
//			System.out.println("주사위 3");
//		}else if(num == 4) {
//			System.out.println("주사위 4");
//		}else if(num == 5) {
//			System.out.println("주사위 5");
//		}else if(num == 6) {
//			System.out.println("주사위 6");
//		}else {
//			System.out.println("주사위 숫자가 아닙니다.");
//		}
	}
}
