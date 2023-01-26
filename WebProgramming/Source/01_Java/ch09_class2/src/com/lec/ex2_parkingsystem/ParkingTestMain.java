package com.lec.ex2_parkingsystem;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111·ç1111", 6);
		System.out.println(car1.in());
		Parking car2 = new Parking("222·ç2222", 8);
		System.out.println(car2.in());
		car1.out(8);
		car2.out(9);
		Parking car3 = new Parking("333·ç3333", 9);
		car3.out(19);
		System.out.println(car3.in());
//		Parking[] cars = {car1, car2, car3};
//		for (Parking car : cars) {
//			System.out.println(car.in());
//		}
	}
}