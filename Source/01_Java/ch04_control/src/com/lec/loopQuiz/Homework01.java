package com.lec.loopQuiz;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.(��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�)
public class Homework01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int you;
		int computer;
		while(true) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ��� ������.(-1�� ���ø� ������ �����մϴ�): ");
			you = scan.nextInt();
			computer = (int)(Math.random()*3);
			if(you == -1) {
				System.out.println("������ �����߽��ϴ�.");break;
			}
			String computerStr = (computer==0) ? "����" : (computer==1)? "����" : "���ڱ�";
			String youStr = (you==0) ? "����" : (you==1)? "����" : "���ڱ�";
			if(-1>you || 2<you ) {
				System.out.println("��ȿ�� ���� �Է��ϼ���.");
			}else if((you+2)%3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �̰���ϴ�.", youStr, computerStr);
			}else if((you+1)%3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s, ����� �����ϴ�.", youStr, computerStr);
			}else if((you)%3 == computer) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s, �����ϴ�.", youStr, computerStr);
			}
		}scan.close();
	}
}
