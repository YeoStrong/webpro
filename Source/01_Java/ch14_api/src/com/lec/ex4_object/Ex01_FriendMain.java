package com.lec.ex4_object;

public class Ex01_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("윤여송", "010-2306-5237", "12-14", "서울 마포"),
				new Friend("김길동", "010-8888-9999", "12-19", "수원 영통"),
				new Friend("신길동", "010-9999-7777", "02-10", "서울 용산"),
				new Friend("마길동", "010-6666-6666", "03-03", "인천 송도")};
		for(Friend friend : friends) {
			// 이름: 홍길동 전화:010-9999-9999 생일: 12-14 주소: 서울 서대문
//			System.out.printf("[이름]%s\t[전화]%s\t[생일]%s\t[주소]%s\n",
//					friend.getName(), friend.getTel(), friend.getBirth(), friend.getAddress());
			System.out.println(friend); //println 자체가 toString을 강제로 호출
		}
	}
}
