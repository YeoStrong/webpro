package com.lec.quiz;
// �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�
public class Quiz01 {
	public static void main(String[] args) {
		int [] arr = {10, 20, 30, 40, 50};
		int totarr = 0;
		for (int idx=0 ; idx<arr.length ; idx++) {
			totarr += arr[idx];
		}
		System.out.println("�迭�� ������ " + totarr);
	}

}
