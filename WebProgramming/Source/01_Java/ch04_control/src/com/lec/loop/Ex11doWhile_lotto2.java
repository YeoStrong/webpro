package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζ� ������ ���߱�
public class Ex11doWhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su;
		Scanner scan = new Scanner(System.in);
		lotto = (int) ((Math.random()*45) +1); //�ζ� ��ȣ
		int min=1, max=45;
		do {
			System.out.printf("�ζ� ��ȣ �� ���� ���� ������(%d~%d): ", min, max);
			su = scan.nextInt();
			if(su<min || su>max) {
				System.out.println("�־��� ������ Ȯ�����ּ���.");
			}else if(su>lotto) {
				max = su-1;
//				System.out.println(su + "���� ���� ���� �����ϼ���: ");
			}else if(su<lotto) {
				min = su+1;
//				System.out.println(su + "���� ū ���� �����ϼ���: ");
			}
		}while(su!=lotto);
		System.out.println("���ϵ帳�ϴ� ���߼̽��ϴ�!!!");
		scan.close();
	}

}
