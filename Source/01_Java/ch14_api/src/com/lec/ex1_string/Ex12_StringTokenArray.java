package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_StringTokenArray {
	public static void main(String[] args) {
		String str = "이수 김범수 하현우 박효신 나얼";
		StringTokenizer tokenizer = new StringTokenizer(str);
		String[] arr = new String[tokenizer.countTokens()];
		int idx = 0;
		while(tokenizer.hasMoreTokens()) {
			arr[idx++] = tokenizer.nextToken();
			//idx++;
		}
		System.out.println("배열에 제대로 들어갔는지 ");
		for(String a: arr) {
			System.out.println(a);
		}
	}
}
