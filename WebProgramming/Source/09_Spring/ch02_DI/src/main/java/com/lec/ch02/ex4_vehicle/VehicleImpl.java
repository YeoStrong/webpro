package com.lec.ch02.ex4_vehicle;

import lombok.Data;

@Data
public class VehicleImpl implements Vehicle {
	private String vehicle;
	private int speed;
	public void ride(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + "은 " + vehicle + "로 " + speed + "km/h 속도로 간다");
	}

}
