package com.lec.ex6_member;

public class MemberMain {
	public static void main(String[] args) {
		Member m1 = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", 'm');
		System.out.println(m1.infoString());
		Member[] member = new Member[2];
		member[0] = m1;
		member[1] = new Member("aaa", "yyy", "ȫ���", "soon@company.com", "���� ���ı�", "2004-01-01", 'f');
		for(Member m : member) {
			System.out.println(m.infoString());
		}
	}
}
