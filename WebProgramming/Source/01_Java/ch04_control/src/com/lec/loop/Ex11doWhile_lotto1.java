package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζ� ������ ���߱�
public class Ex11doWhile_lotto1 {
	public static void main(String[] args) {
		int lotto, su;
		Scanner scan = new Scanner(System.in);
		// 0 <= Math.random() < 1 : �Ǽ�
		// 1 <= Math.random() * 45 +1 < 46 : �Ǽ� 
		// 1 <= (int) (Math.random() * 45 +1) < 46 : 46 �̸��� �ڿ���
		lotto = (int) ((Math.random()*45) +1); //�ζ� ��ȣ
		do {
			System.out.print("�ζ� ��ȣ �� ���� ���� ������(1~45): ");
			su = scan.nextInt();
			if(su>lotto) {
				System.out.println(su + "���� ���� ���� �����ϼ���: ");
			}else if(su<lotto) {
				System.out.println(su + "���� ū ���� �����ϼ���: ");
			}
		}while(su!=lotto);
		System.out.println("���ϵ帳�ϴ� ���߼̽��ϴ�!!!");
		scan.close();
	}

}
