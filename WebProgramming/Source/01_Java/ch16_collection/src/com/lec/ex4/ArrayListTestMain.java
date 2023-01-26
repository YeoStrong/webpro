package com.lec.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("회원가입을 원하면 성명을 입력해주세요(회원가입 거부=n키 입력): ");
			String name = scanner.next();
			if (!name.equalsIgnoreCase("n")) {
				System.out.println("전화번호를 입력해주세요: ");
				String tel = scanner.next();
				System.out.println("주소를 입력해주세요: ");
				String address = scanner.next();
				customers.add(new Customer(name, tel, address));
			} else {
				if (customers.size() == 0) {
					System.out.println("가입한 회원 목록이 없습니다.");
					
				} else {
					for (int i = 0; i < customers.size(); i++) {
						System.out.println(customers.get(i));
					}
				}
				break;
			}
		}
	}
}
