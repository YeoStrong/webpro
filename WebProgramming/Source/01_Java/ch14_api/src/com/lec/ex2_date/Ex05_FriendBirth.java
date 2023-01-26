package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// 오늘 생일인 친구들 출력
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("윤여송", "010-2306-5237", "12-14", "서울 마포"),
				new Friend("이종범", "010-2249-2759", "12-19", "경기 평택"),
				new Friend("신길동", "010-9999-7777", "12-13", "서울 용산"),
				new Friend("마길동", "010-6666-6666", "03-03", "인천 송도")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1; // 12
		int day = now.get(Calendar.DAY_OF_MONTH); // 14
//		String monthStr = month<10 ? "0"+month : ""+month; // "" + 12 => "12"
		String SmonthStr = month<10 ? "0"+month : String.valueOf(month); // "12"
		String SdayStr = day<10 ? "0"+day : String.valueOf(day);
		String today = SmonthStr + "-" + SdayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("오늘 생일인 친구 목록을 검색합니다.");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // 한명이상 출력 시 none은 false
			}//if
		}//for
		if(none) {
			System.out.println("오늘 생일인 친구가 없습니다.");
		}
	}//main
}//class
