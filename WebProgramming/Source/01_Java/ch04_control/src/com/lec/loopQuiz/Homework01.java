package com.lec.loopQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 -1을 입력할때까지 무한반복하는 게임을 작성하시오.(단, 가위대신 0, 바위대신 1, 보대신 2, 종료를 원하면 -1을 입력합니다)
public class Homework01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you;
		int computer;
		while(true) {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나를 내세요.(-1을 내시면 게임을 종료합니다): ");
			you = scan.nextInt();
			computer = (int)(Math.random()*3);
			if(you == -1) {
				System.out.println("게임을 종료했습니다.");break;
			}
			String computerStr = (computer==0) ? "가위" : (computer==1)? "바위" : "보자기";
			String youStr = (you==0) ? "가위" : (you==1)? "바위" : "보자기";
			if(-1>you || 2<you ) {
				System.out.println("유효한 값을 입력하세요.");
			}else if((you+2)%3 == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신이 이겼습니다.", youStr, computerStr);
			}else if((you+1)%3 == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다.", youStr, computerStr);
			}else if((you)%3 == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s, 비겼습니다.", youStr, computerStr);
			}
		}scan.close();
	}
}
