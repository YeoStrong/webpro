package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

public class Genesis extends Car {
	
	public Genesis() {
		// TODO Auto-generated constructor stub
		// engine, km, fuel setting
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("�����׽ý� ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�.");
	}

}
