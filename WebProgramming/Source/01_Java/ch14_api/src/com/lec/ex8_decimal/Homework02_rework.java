package com.lec.ex8_decimal;

import java.util.Random;
import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ ����� �� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.(��, ������� 0, ������� 1, ����� 2)
public class Homework02_rework {
	public static void main(String[] args) {
		int you;
		int computer;
		String computerStr;
		String youStr;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		do {
			System.out.print("����, ����, �� �� �ϳ��� ������.(���ø� ������ �����մϴ�): ");
			youStr = scan.next().trim(); // " ���� " �� �Է��ص� "����"��
			computer = random.nextInt(3);
			computerStr = (computer == 0) ? "����" : (computer == 1) ? "����" : "���ڱ�";
			you = (youStr=="����") ? (you = 0) : (youStr=="����") ? (you = 1) : (you = 2);
			if (0 > you || 2 < you) {
				System.out.println("��ȿ�� ���� �Է��ϼ���.");
			} else {
				if ((you + 2) % 3 == computer) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�. ������ �����մϴ�.", youStr, computerStr);
				} else if((you+1)%3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", youStr, computerStr);
				} else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", youStr, computerStr);					
				}
			}
		} while ((you + 2) % 3 != computer);
		scan.close();
	}
}