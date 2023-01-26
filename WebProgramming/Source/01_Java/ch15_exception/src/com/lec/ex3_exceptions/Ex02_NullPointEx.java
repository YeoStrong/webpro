package com.lec.ex3_exceptions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_NullPointEx {
	public static void main(String[] args) {
		Friend hong = new Friend("È«ÁØÇ¥", "010-8888-8888", new Date(new GregorianCalendar(1953, 10, 20).getTimeInMillis()));
		System.out.println(hong);
		Friend kim = new Friend("±è±æµ¿", "010-7777-7777");
		System.out.println(kim);
	}
}
