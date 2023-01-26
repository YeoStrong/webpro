package com.lec.quiz;
// 배열에 담긴 값을 더하는 프로그램을 작성
public class Quiz01 {
	public static void main(String[] args) {
		int [] arr = {10, 20, 30, 40, 50};
		int totarr = 0;
		for (int idx=0 ; idx<arr.length ; idx++) {
			totarr += arr[idx];
		}
		System.out.println("배열의 총합은 " + totarr);
	}

}
