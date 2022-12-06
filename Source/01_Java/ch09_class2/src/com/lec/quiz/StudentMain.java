package com.lec.quiz;

import com.lec.ex1_student.Student;

public class StudentMain {
	public static void main(String[] args) {
			Student s1 = new Student("정우성", 90, 80, 95);
			Student s2 = new Student("김하늘", 100, 80, 95);
			Student s3 = new Student("황정민", 95, 80, 90);
			Student s4 = new Student("강동원", 95, 90, 99);
			Student s5 = new Student("유아인", 90, 90, 90);
			Student[] students = {s1,s2,s3,s4,s5};
			String[] title = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};
			int[] total = new int[students.length];
			int[] avg = new int[students.length];// 0번 idx: 국어누적, 1번 idx: 영어 누적... 4번 idx: 평균 누적
			line();
			System.out.println("\t\t\t       성적표");
			line('-');
			for(String t : title) {
				System.out.print("\t" + t);
			}
			System.out.println(); //개행
			line('-');
			for (Student student : students) {
				System.out.print(student.infoString());
				//student.infoPrint();
				// 총점변수(국,영,수,총,평) 누적
				total[0] += student.getKor();
				total[1] += student.getEng();
				total[2] += student.getMath();
				total[3] += student.getTot();
				total[4] += student.getAvg(); // 평균 누적
			}
			line('-');
			System.out.print("\t\t총점");
			for(int t : total) {
				System.out.print("\t"+t);
			}
			System.out.print("\n\t\t평균");
			for(int t : total) {
//				System.out.print("\t"+t/(double)students.length);
				System.out.printf("\t%d", t / students.length);
			}
			System.out.println();
			line();
		}

		private static void line(char c) {
			System.out.print("\t");
			for(int i=0 ; i<=50 ; i++) {
				System.out.print("-");
			}
			System.out.println();
		}

		private static void line() {
			for(int i=0 ; i<65 ; i++) {
				System.out.printf("■");
			}
			System.out.println();
	}
}
