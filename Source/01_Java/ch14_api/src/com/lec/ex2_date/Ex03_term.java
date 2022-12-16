package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

// 두 시점 계산
public class Ex03_term {
	public static void main(String[] args) {
		Date now = new Date(); // 지금
		Date checkOut = new Date(new GregorianCalendar(2022, 10, 28).getTimeInMillis());
		long nowMillis = now.getTime(); // 1970.1.1 ~ now까지의 밀리세컨
		long checkMillis = checkOut.getTime();
//		GregorianCalendar now = new GregorianCalendar(); // 지금
//		long nowMillis = now.getTimeInMillis(); // 1970.1.1 ~ now의 밀리세컨
//		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28, 9, 30); // 대출 시점
//		long checkMillis = checkOut.getTimeInMillis();
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));
		System.out.println("몇일 지났나: " + day);
	}
}
