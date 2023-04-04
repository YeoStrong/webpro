package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamImpl2 implements Exam {
	private String name;
	private int kor;
	private int eng;
	private int math;
	public int getTotal() {
		// TODO Auto-generated method stub
		return kor + eng + math;
	}

	public double getAvg() {
		// TODO Auto-generated method stub
		return getTotal() / 3.0;
	}

}
