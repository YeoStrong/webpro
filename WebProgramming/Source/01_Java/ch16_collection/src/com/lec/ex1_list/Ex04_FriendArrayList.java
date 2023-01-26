package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999"));
		friends.add(new Friend("신길동", "010-8888-8888", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("김길동", "02-7777-7777"));
		for(int i=0 ; i<friends.size(); i++) {
			System.out.println(friends.get(i));
		}
		System.out.println("전화번호만 출력");
		for(Friend temp : friends) {
			System.out.println(temp.getTel());
		}
	}
}
