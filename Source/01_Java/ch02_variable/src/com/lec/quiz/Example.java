package com.lec.quiz;
//����, ����, ���� ���� �Ҵ� �� ���, ����, ��� ���
public class Example {
	public static void main(String[] args) {
		int korean = 90, english = 80, math = 63; 
		int sum = korean + english + math;
		double average = sum / 3.0;
		System.out.println("���� =" + korean + "\t���� =" + english + "\t����= " + math + "\n����= " + sum + "\n���= " + average);
//		System.out.printf("���� : %d\n��� : %.2f\n", sum, average); //�Ҽ��� ��°���� �ݿø� �ϰ���� ��� printf�� ����ؾ� �Ѵ�.
	}
}
