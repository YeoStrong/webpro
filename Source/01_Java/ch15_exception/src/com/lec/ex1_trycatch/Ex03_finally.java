package com.lec.ex1_trycatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[]arr = {0,1,2};
		for(int i=0 ; i<=arr.length ; i++) {
			try {				
				System.out.println("arr[" + i + "] = " + arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}finally {
				System.out.println("finally절: try절 실행 후에도, catch절 실행 후에도 실행되는 절");
			}
		}
	}
}
