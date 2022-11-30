package com.lec.condition;
//if
public class Ex01_if {
	public static void main(String[] args) {
		int score = 55;
		if(score>=90) {
			System.out.println("참 잘했습니다.");
		}else if(score>=70) {
			System.out.println("괜찮습니다.");
		}else if(score>=60) {
			System.out.println("좀 못하시네요.");
		}else {
			System.out.println("미쳤습니까 휴먼.");
		}
		System.out.println("DONE");
	}

}
