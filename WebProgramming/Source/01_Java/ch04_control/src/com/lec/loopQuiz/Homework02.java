package com.lec.loopQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ ����� �� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.(��, ������� 0, ������� 1, ����� 2)
public class Homework02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you;
		int computer;
		String computerStr;
		String youStr;
		do {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ��� ������.(���ø� ������ �����մϴ�): ");
			you = scan.nextInt();
			computer = (int) (Math.random() * 3);
			computerStr = (computer == 0) ? "����" : (computer == 1) ? "����" : "���ڱ�";
			youStr = (you == 0) ? "����" : (you == 1) ? "����" : "���ڱ�";
			if (0 > you || 2 < you) {
				System.out.println("��ȿ�� ���� �Է��ϼ���.");
			} else {
				if ((you + 2) % 3 == computer) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�.", youStr, computerStr);
				} else if((you+1)%3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�. ������ �����մϴ�.", youStr, computerStr);
				} else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�. ������ �����մϴ�.", youStr, computerStr);					
				}
			}
		} while ((you + 1) % 3 != computer);
		scan.close();
	}
}