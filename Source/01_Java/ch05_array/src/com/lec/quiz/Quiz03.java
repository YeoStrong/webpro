package com.lec.quiz;
//거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?
public class Quiz03 {
	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		int i;
		int money = 2680;
		System.out.println(money + "원은 ");
		for(i=0 ; i<coinUnit.length ; i++) {
			System.out.print(coinUnit[i] + "원짜리 동전 " + money/coinUnit[i] + "개\t");
			money = money%coinUnit[i];
		}
	}
}
