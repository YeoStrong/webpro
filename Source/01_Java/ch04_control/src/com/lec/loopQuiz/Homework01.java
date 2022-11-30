package com.lec.loopQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임, -1입력하면 종료, 가위바위보는 각각 0, 1, 2
public class Homework01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you, computer;
		do {			
			System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내세요. 종료를 원하시면 -1을 내세요: ");
			you = scan.nextInt();
			computer = (int)(Math.random()*3);
			if (2>you || -1>you) {
				System.out.println("유효한 값을 입력하세요.");
			}else if((you+2)%3 == computer) {
				System.out.printf("당신은 %d, 컴퓨터는 %d, 당신이 이겼습니다.", you, computer);
			 else if((you+1)%3 == computer) {
				System.out.printf("당신은 %d, 컴퓨터는 %d, 당신은 졌습니다.", you, computer);
			
			}
		}while(computer != -1);
		System.out.println("게임이 종료되었습니다.");
	}

}
