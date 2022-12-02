package com.lec.loopQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 당신이 질 때까지 무한반복하는 게임을 작성하시오.(단, 가위대신 0, 바위대신 1, 보대신 2)
public class Homework02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you;
		int computer;
		String computerStr;
		String youStr;
		do {
			System.out.println("가위(0), 바위(1), 보(2) 중 하나를 내세요.(지시면 게임을 종료합니다): ");
			you = scan.nextInt();
			computer = (int) (Math.random() * 3);
			computerStr = (computer == 0) ? "가위" : (computer == 1) ? "바위" : "보자기";
			youStr = (you == 0) ? "가위" : (you == 1) ? "바위" : "보자기";
			if (0 > you || 2 < you) {
				System.out.println("유효한 값을 입력하세요.");
			} else {
				if ((you + 2) % 3 == computer) {
					System.out.printf("당신은 %s, 컴퓨터는 %s, 당신이 이겼습니다.", youStr, computerStr);
				} else if((you+1)%3 == computer) {
				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다. 게임을 종료합니다.", youStr, computerStr);
				} else {
					System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다. 게임을 종료합니다.", youStr, computerStr);					
				}
			}
		} while ((you + 1) % 3 != computer);
		scan.close();
	}
}