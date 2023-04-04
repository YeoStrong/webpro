package com.lec.ch03.method3;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Student;

@Configuration
public class Method3_ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("미끄럼틀"); hobbies.add("시소");
		Student student = new Student("성춘향", 22, hobbies);
		student.setHeight(158);
		student.setWeight(48);
		return student;
	}
}
