package com.lec.ex2_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("a01", "È«±æµ¿", Part.DESIGN),
						new Sawon2("a02", "½Å±æµ¿", Part.COMPUTER, 2021, 11, 9),
						new Sawon2("a03", "Â¯µ¹¼è", Part.PLANNING, 1872, 5, 15),
						new Sawon2("a04", "º¯°­¼è", Part.HUMANRESOURCES, 1777, 7, 7)
						};
		for(Sawon2 s : sawons) {
			System.out.println(s);
		}
	}
}
