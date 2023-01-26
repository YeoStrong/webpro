package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_StringTokenArray {
	public static void main(String[] args) {
		String str = "�̼� ����� ������ ��ȿ�� ����";
		StringTokenizer tokenizer = new StringTokenizer(str);
		String[] arr = new String[tokenizer.countTokens()];
		int idx = 0;
		while(tokenizer.hasMoreTokens()) {
			arr[idx++] = tokenizer.nextToken();
			//idx++;
		}
		System.out.println("�迭�� ����� ������ ");
		for(String a: arr) {
			System.out.println(a);
		}
	}
}
