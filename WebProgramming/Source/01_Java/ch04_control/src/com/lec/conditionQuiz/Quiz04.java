package com.lec.conditionQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷�. ��, ����ڴ� ������ ������ �� ���� 0, ������ ������ �� ���� 1, ���� �����ϰ��� �� ���� 2�� �Է�
public class Quiz04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ������: ");
		int you = scan.nextInt();
		int computer = (int)(Math.random()*3);
		if(0>you || 2<you ) {
			System.out.println("��ȿ�� ���� �Է��ϼ���.");
		}else if((you+2)%3 == computer) {
			System.out.printf("����� %d, ��ǻ�ʹ� %d, ����� �̰���ϴ�.", you, computer);
		}else if((you+1)%3 == computer) {
			System.out.printf("����� %d, ��ǻ�ʹ� %d, ����� �����ϴ�.", you, computer);
		}else if((you)%3 == computer) {
			System.out.printf("����� %d, ��ǻ�ʹ� %d, �����ϴ�.", you, computer);
		}
//		if(you == 0) {
//			if(computer == 0) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, �����ϴ�.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", you, computer);
//			else 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�.", you, computer);
//		}else if(you == 1) {
//			if(computer == 0) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, �����ϴ�.", you, computer);
//			else 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", you, computer);
//		}else if(you == 2) {
//			if(computer == 0) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", you, computer);
//			else if(computer == 1) 
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�.", you, computer);
//			else if(computer == 2)
//				System.out.printf("����� %s, ��ǻ�ʹ� %s, �����ϴ�.", you, computer);
//		}else {
//			System.out.println("��ȿ���� ���� ���Դϴ�.");
//		} // if
		scan.close();
	} //main
} //class
