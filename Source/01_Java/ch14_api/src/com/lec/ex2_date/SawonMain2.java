package com.lec.ex2_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("a01", "ȫ�浿", Part.DESIGN),
						new Sawon2("a02", "�ű浿", Part.COMPUTER, 2021, 11, 9),
						new Sawon2("a03", "¯����", Part.PLANNING, 1872, 5, 15),
						new Sawon2("a04", "������", Part.HUMANRESOURCES, 1777, 7, 7)
						};
		for(Sawon2 s : sawons) {
			System.out.println(s);
		}
	}
}
