package com.lec.ch04.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	private int age;
	private double height;
	private double weight;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
