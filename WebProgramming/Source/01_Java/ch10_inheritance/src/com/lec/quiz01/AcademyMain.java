package com.lec.quiz01;

public class AcademyMain {
	public static void main(String[] args) {
		Person st1 = new Student("A01","������","JAVA��");
		Person st2 = new Student("A02","ȫ�浿","C++��");
		Person sf1 = new Staff("S01","���浿","�������");
		Person sf2 = new Staff("S02","�̻��ؾ�","���������");
		Person ga1 = new Gangsa("G01","�̱浿","��ü����");
		Person[] p = {st1, st2, sf1, sf2, ga1};
		for(Person pp : p) {
			System.out.println(pp.infoString());
		}
	}
}
