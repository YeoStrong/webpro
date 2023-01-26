package com.lec.loop;
//*
//**
//*** 
//**** 
//***** 이렇게 출력되도록 for문으로 구현
public class Ex03for_star {
	public static void main(String[] args) {
		for(int i=1 ; i<6 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				System.out.print('*');
			} //for - j
			System.out.println(); //개행만
		} //for - i	
	} //main
} //class