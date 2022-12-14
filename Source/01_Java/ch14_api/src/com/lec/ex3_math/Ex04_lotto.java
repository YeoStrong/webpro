package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1 : 실수
// 0 <= Math.random()*45 < 45 : 실수
//1 <= (int)(Math.random()*45 +1) < 46 : 1~45까지의 정수
public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do { // 발생된 난수가 중복되었는지 체크
				temp= random.nextInt(45)+1;
				for(j=0 ; j<i ; j++) { // i(뽑는 순서)가 0일때는 한번도 작동안함(중복 걱정할 필요가 없는 1번째 숫자)
					if(lotto[j] ==temp) {
						System.out.println("중복돼서 다시 함" + temp);
						break;
					} // if - temp랑 같은 번호가 있으면 for문을 빠져나감.
				}//for
			}while(i != j);
			lotto[i] = temp;
		}
		// 발생된 로또 번호 출력
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n정렬 후");
		// lotto배열 값을 sort
		for(i=0 ; i<lotto.length-1 ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp; //직접 넣으면 데이터가 덮어씌워지기 때문에 임시변수를 이용하여 3단 스왑
				}
			}
		}
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		
	}

}
