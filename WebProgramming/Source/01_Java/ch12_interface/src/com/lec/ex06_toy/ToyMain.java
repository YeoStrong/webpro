package com.lec.ex06_toy;

public class ToyMain {
	public static void main(String[] args) {
		PoohToy pooh = new PoohToy();
		MazingaToy mazinga = new MazingaToy();
		AirplaneToy airplane = new AirplaneToy();
		IToy[] toy = {pooh, mazinga, airplane};
		for(IToy t : toy) {
			// ��ü�� Ŭ���� �̸� ���
			System.out.println(t.getClass().getName());
		}
	}
}
