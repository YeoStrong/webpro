package com.lec.ex4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		while (true) {
			Scanner scname = new Scanner(System.in);
			System.out.println("회원가입을 원하면 성명을 입력해주세요(회원가입 거부=n키 입력): ");
			String name = scname.next();
			if (!name.equalsIgnoreCase("n")) {
				Scanner sctel = new Scanner(System.in);
				System.out.println("전화번호를 입력해주세요: ");
				String tel = sctel.next();
				//기존에 가입한 전화번호인지 확인하는 방법
				if (customers.get(tel)!=null) {
					System.out.println("이미 가입된 전화번호입니다. 전화번호는 중복하여 가입할 수 없습니다.");
				}
				Scanner scaddress = new Scanner(System.in);
				System.out.println("주소를 입력해주세요: ");
				String address = scaddress.next();
				customers.put(tel, new Customer(name, tel, address));
			} else {
				if (!customers.isEmpty()) {
					Iterator<String> iterator = customers.keySet().iterator();
					while (iterator.hasNext()) {
						String key = iterator.next();
						System.out.println(customers.get(key));
					}
				}else {
					System.out.println("가입한 회원 목록이 없습니다.");
					break;
				}
			}
		}
	}
}
