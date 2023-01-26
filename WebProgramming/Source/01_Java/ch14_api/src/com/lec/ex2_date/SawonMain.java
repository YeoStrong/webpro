package com.lec.ex2_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("a01", "È«±æµ¿", Sawon.DESIGN),
						new Sawon("a02", "½Å±æµ¿", Sawon.COMPUTER, 2021, 12, 9),
						new Sawon("a03", "Â¯µ¹¼è", Sawon.PLANNING, 1872, 5, 15),
						new Sawon("a04", "º¯°­¼è", Sawon.HUMANRESOURCES, 1777, 7, 7)
						};
		for(Sawon s : sawons) {
			System.out.println(s);
		}
	}
}
