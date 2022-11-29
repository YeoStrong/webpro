package com.lec.quiz;
//국어, 영어, 수학 점수 할당 및 출력, 총점, 평균 출력
public class Example {
	public static void main(String[] args) {
		int korean = 90, english = 80, math = 63; 
		int sum = korean + english + math;
		double average = sum / 3.0;
		System.out.println("국어 =" + korean + "\t영어 =" + english + "\t수학= " + math + "\n총합= " + sum + "\n평균= " + average);
//		System.out.printf("총점 : %d\n평균 : %.2f\n", sum, average); //소수점 둘째까지 반올림 하고싶을 경우 printf를 사용해야 한다.
	}
}
