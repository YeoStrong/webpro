package com.lec.quiz;
//�Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?
public class Quiz03 {
	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		int i;
		int money = 2680;
		System.out.println(money + "���� ");
		for(i=0 ; i<coinUnit.length ; i++) {
			System.out.print(coinUnit[i] + "��¥�� ���� " + money/coinUnit[i] + "��\t");
			money = money%coinUnit[i];
		}
	}
}
