package com.lec.ex3_math;
// Math.ceil(�ø� �� �Ǽ�) => double�� return ex:Math.ceil(9.1)=>10.0
// Math.round(�ݿø��� �Ǽ�) => long�� return ex:Math.round(9.1)=>9
//Math.round(���� �� �Ǽ�) => double�� return ex:Math.floor(9.9)=>9.0
public class Ex02_Round {
	public static void main(String[] args) {
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�, �ø�, ����"); // Math���� ����
		System.out.println("9.15�� �ø�: " + (int)Math.ceil(9.15));
		System.out.println("9.15�� �ݿø�: " + Math.round(9.15));
		System.out.println("9.15�� ����: " + (int)Math.floor(9.15));
		
		System.out.println("�Ҽ��� ���ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �ø�: " + Math.ceil(9.15 * 10)/10);
		System.out.println("9.15�� �ݿø�: " +Math.round(9.15 * 10)/10.0);
		System.out.println("9.15�� ����: " + Math.floor(9.15 * 10)/10);
		
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85�� �ø�: " + (int)Math.ceil(85 / 10.0)*10);
		System.out.println("85�� �ݿø�: " +Math.round(85 / 10.0)*10);
		System.out.println("85�� ����: " + (int)Math.floor(85 / 10.0)*10);

	}
}