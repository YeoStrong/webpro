package com.lec.loopQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ����, -1�Է��ϸ� ����, ������������ ���� 0, 1, 2
public class Homework01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you, computer;
		do {			
			System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ������. ���Ḧ ���Ͻø� -1�� ������: ");
			you = scan.nextInt();
			computer = (int)(Math.random()*3);
			if (2>you || -1>you) {
				System.out.println("��ȿ�� ���� �Է��ϼ���.");
			}else if((you+2)%3 == computer) {
				System.out.printf("����� %d, ��ǻ�ʹ� %d, ����� �̰���ϴ�.", you, computer);
			 else if((you+1)%3 == computer) {
				System.out.printf("����� %d, ��ǻ�ʹ� %d, ����� �����ϴ�.", you, computer);
			
			}
		}while(computer != -1);
		System.out.println("������ ����Ǿ����ϴ�.");
	}

}
