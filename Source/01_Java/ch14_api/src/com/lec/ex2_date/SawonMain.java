package com.lec.ex2_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("a01", "ȫ�浿", Sawon.DESIGN),
						new Sawon("a02", "�ű浿", Sawon.COMPUTER, 2021, 12, 9),
						new Sawon("a03", "¯����", Sawon.PLANNING, 1872, 5, 15),
						new Sawon("a04", "������", Sawon.HUMANRESOURCES, 1777, 7, 7)
						};
		for(Sawon s : sawons) {
			System.out.println(s);
		}
	}
}
