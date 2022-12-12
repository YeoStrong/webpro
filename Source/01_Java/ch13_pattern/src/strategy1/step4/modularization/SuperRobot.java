package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {
	private FlyImpl     fly;
	private MissileImpl missile;
	private KnifeImpl   knife;
	public SuperRobot() {
		setFly(new FlyYes()); // fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}

	@Override
	public void actionFly() {
		// TODO Auto-generated method stub
		fly.fly();
	}

	@Override
	public void actionMissile() {
		// TODO Auto-generated method stub
		missile.missile();
	}

	@Override
	public void actionKnife() {
		// TODO Auto-generated method stub
		knife.knife();
	}
	//setters
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
}
