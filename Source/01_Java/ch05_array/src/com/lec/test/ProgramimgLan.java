package com.lec.test;
//{76,45,34,89,100,50,90,93}  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷�
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,93};
		int totarr = 0;
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
		}
		for (i=0 ; i<arr.length ; i++) {
			totarr += arr[i];
		}
		System.out.print("�� ��: " + totarr + "\t");
		System.out.printf("�� ��: %.2f\n", totarr/(double)(arr.length));
		System.out.println("�ִ밪: " + arr[arr.length-1] + "\t�ּҰ�: " + arr[0]);
	}

}
