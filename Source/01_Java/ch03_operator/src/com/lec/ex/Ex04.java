package com.lec.ex;
// �������� : &&(AND), ||(OR)
public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		System.out.println("&& : (i<j) && (++j>h) �� " + ((i<j) && (++j>h)) );
		System.out.println("j = " + j); // j = 11
		
		System.out.println("&& : (i>j) && (++j>h) �� " + ((i>j) && (++j>h)) );	// &&(AND)������ ��� ������ false�� ������ false�� ������ ������ �Ĵٵ� �� ��.
		System.out.println("j = " + j); // ���� ���⼭ j���� ���������ڰ� �۵����� ���� 11�� ��.
		
		System.out.println("|| : (i<j) || (++j>h) �� " + ((i<j) || (++j>h)) );	// ||(OR)������ ��� ������ true�� ������ true�� ������ ������ �Ĵٵ� �� ��.
		System.out.println("j = " + j); // ���� ���⼭ j���� ���������ڰ� �۵����� ���� 11�� ��.
		
		System.out.println("|| : (i>j) || (++j>h) �� " + ((i>j) || (++j>h)) );
		System.out.println("j = " + j); 
	}
}
