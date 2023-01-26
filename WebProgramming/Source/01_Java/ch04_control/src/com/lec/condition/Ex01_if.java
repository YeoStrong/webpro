package com.lec.condition;
//if
public class Ex01_if {
	public static void main(String[] args) {
		int score = 55;
		if(score>=90) {
			System.out.println("Âü ÀßÇß½À´Ï´Ù.");
		}else if(score>=70) {
			System.out.println("±¦Âú½À´Ï´Ù.");
		}else if(score>=60) {
			System.out.println("¾îÀÌÄí.");
		}else {
			System.out.println("±¦Âú¾Æ ´Ù½Ã ÇÏ¸é µÅ.");
		}
		System.out.println("DONE");
	}

}
