package com.lec.conditionQuiz;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 하는 프로그램. 단, 사용자는 가위를 내고자 할 때는 0, 바위를 내고자 할 때는 1, 보를 선택하고자 할 때는 2를 입력
public class Quiz04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내세요: ");
		int you = scan.nextInt();
		int computer = (int)(Math.random()*3);
		if(0>you || 2<you ) {
			System.out.println("유효한 값을 입력하세요.");
		}else if((you+2)%3 == computer) {
			System.out.printf("당신은 %d, 컴퓨터는 %d, 당신이 이겼습니다.", you, computer);
		}else if((you+1)%3 == computer) {
			System.out.printf("당신은 %d, 컴퓨터는 %d, 당신은 졌습니다.", you, computer);
		}else if((you)%3 == computer) {
			System.out.printf("당신은 %d, 컴퓨터는 %d, 비겼습니다.", you, computer);
		}
//		if(you == 0) {
//			if(computer == 0) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 비겼습니다.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다.", you, computer);
//			else 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 이겼습니다.", you, computer);
//		}else if(you == 1) {
//			if(computer == 0) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 이겼습니다.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 비겼습니다.", you, computer);
//			else 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다.", you, computer);
//		}else if(you == 2) {
//			if(computer == 0) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 졌습니다.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 당신은 이겼습니다.", you, computer);
//			else if(computer == 2)
//				System.out.printf("당신은 %s, 컴퓨터는 %s, 비겼습니다.", you, computer);
//		}else {
//			System.out.println("유효하지 않은 값입니다.");
//		} // if
		scan.close();
	} //main
} //class
