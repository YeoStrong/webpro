package com.lec.loop;

import java.util.Scanner;

// 컴퓨터가 발생한 로또 난수를 맞추기
public class Ex11doWhile_lotto1 {
	public static void main(String[] args) {
		int lotto, su;
		Scanner scan = new Scanner(System.in);
		// 0 <= Math.random() < 1 : 실수
		// 1 <= Math.random() * 45 +1 < 46 : 실수 
		// 1 <= (int) (Math.random() * 45 +1) < 46 : 46 미만의 자연수
		lotto = (int) ((Math.random()*45) +1); //로또 번호
		do {
			System.out.print("로또 번호 한 개를 맞춰 보세요(1~45): ");
			su = scan.nextInt();
			if(su>lotto) {
				System.out.println(su + "보다 작은 수로 도전하세요: ");
			}else if(su<lotto) {
				System.out.println(su + "보다 큰 수로 도전하세요: ");
			}
		}while(su!=lotto);
		System.out.println("축하드립니다 맞추셨습니다!!!");
		scan.close();
	}

}
