package com.lec.test;
//{76,45,34,89,100,50,90,93}  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램
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
		System.out.print("합 계: " + totarr + "\t");
		System.out.printf("평 균: %.2f\n", totarr/(double)(arr.length));
		System.out.println("최대값: " + arr[arr.length-1] + "\t최소값: " + arr[0]);
	}

}
