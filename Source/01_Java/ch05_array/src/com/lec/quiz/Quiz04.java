package com.lec.quiz;
// 76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷��� �ۼ� �Ͻÿ�
public class Quiz04 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int i, j;
		int temp;
		for(i=0 ; i<arr.length-1 ; i++) {
			for(j=i+1 ; j<arr.length ; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for j
		}//for i
		for(int a : arr) {
			System.out.print(a + "\t");
		}//for a
	}//main
}//class
