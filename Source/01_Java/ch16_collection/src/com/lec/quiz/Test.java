package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "����� ��걸", "010-9999-1234",1990,5,22));
		friends.add(new Friend("�ű浿", "����� ������", "010-9999-9999", 1990,4,5));
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ�(��,���Ḧ ���Ͻø� x�� �Է��Ͻÿ�): ");
			String searchAddress = sc.next(); // 8888
			if(searchAddress.equalsIgnoreCase("x"))
				break;
			for(Friend friend : friends) {
				String address = friend.getAddress();
				String frontAddress = address.substring(0,2);
				if(searchAddress.equals(frontAddress)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(! searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�");
			}
		}
	}
}
