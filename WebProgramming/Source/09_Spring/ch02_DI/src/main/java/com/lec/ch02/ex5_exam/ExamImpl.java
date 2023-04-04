package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamImpl implements Exam {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int com;
	public int getTotal() {
		// TODO Auto-generated method stub
		return kor + eng + math + com;
	}

	public double getAvg() {
		// TODO Auto-generated method stub
		return getTotal() / 4.0;
	}

}
