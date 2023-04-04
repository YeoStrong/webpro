package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MycalTestMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx
			= new GenericXmlApplicationContext(resourceLocation);
//		MyCalculator myCal = (MyCalculator) ctx.getBean("myCal");
		MyCalculator myCal = ctx.getBean("myCal", MyCalculator.class);
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		ctx.close();
	}
}
