package com.lec.ex5_booklib;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		Book book = new Book("890��-01", "java", "ȫ�浿");
		Book book1 = new Book("890��-02", "hadoop", "ȫ�ϵ�");
		try {
			book.checkOut("kim");
			book1.checkOut("lee");
			book.setCheckOutDate(new Date(new GregorianCalendar(2022, 10, 30).getTimeInMillis())); // ������ ����
			book.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try
		System.out.println(book);
		System.out.println(book1);
	}// main
}