package strategy2.modularization;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km20;

public class Accent extends Car {
	
	public Accent() {
		// TODO Auto-generated constructor stub
		// engine, km, fuel setting
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("�ڿ���Ʈ ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�.");
	}

}
