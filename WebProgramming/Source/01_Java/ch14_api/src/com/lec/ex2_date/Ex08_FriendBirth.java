package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("������", "010-2306-5237", "12-14", "���� ����"),
				new Friend("������", "010-2249-2759", "12-19", "��� ����"),
				new Friend("�ű浿", "010-9999-7777", "12-13", "���� ���"),
				new Friend("���浿", "010-6666-6666", "03-03", "��õ �۵�")};
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(nowDate);
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�.");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}//Ȯ��for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false; // �Ѹ��̻� ��� �� none�� false
//			}//if
//		}//�Ϲ�for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�.");
		}
	}//main
}//class
