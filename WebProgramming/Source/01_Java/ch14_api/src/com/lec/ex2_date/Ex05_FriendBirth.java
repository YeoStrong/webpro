package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("������", "010-2306-5237", "12-14", "���� ����"),
				new Friend("������", "010-2249-2759", "12-19", "��� ����"),
				new Friend("�ű浿", "010-9999-7777", "12-13", "���� ���"),
				new Friend("���浿", "010-6666-6666", "03-03", "��õ �۵�")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1; // 12
		int day = now.get(Calendar.DAY_OF_MONTH); // 14
//		String monthStr = month<10 ? "0"+month : ""+month; // "" + 12 => "12"
		String SmonthStr = month<10 ? "0"+month : String.valueOf(month); // "12"
		String SdayStr = day<10 ? "0"+day : String.valueOf(day);
		String today = SmonthStr + "-" + SdayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�.");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // �Ѹ��̻� ��� �� none�� false
			}//if
		}//for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�.");
		}
	}//main
}//class
