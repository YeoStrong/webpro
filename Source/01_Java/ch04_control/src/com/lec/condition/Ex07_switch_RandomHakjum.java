package com.lec.condition;
// ������ ������ ��ǻ�Ͱ� ���� ����(Random score)�� �߻��Ͽ� ���� ���
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
		// 0 <= Math.random() <1 : �Ǽ�
		// 0 <= Math.random()*101 <101 : �Ǽ�
		// 0 <= (int)(Math.random()*101) <101 : ����
		// 0 <= score <101 �� ���� ����
		// System.out.println((int)(Math.random()*101));
		int score = (int)(Math.random()*101);
		int temp = (score == 100) ? score-1 : score; //�̷��� 100���� 99������ ���
		switch(temp/10) {
		case 9:
			System.out.println(score + "��, A����");break;
		case 8:
			System.out.println(score + "��, B����");break;
		case 7:
			System.out.println(score + "��, C����");break;
		case 6:
			System.out.println(score + "��, D����");break;
		case 5:
			System.out.println(score + "��, F����");break;
		case 4:
			System.out.println(score + "��, F����");break;
		case 3:
			System.out.println(score + "��, F����");break;
		case 2:
			System.out.println(score + "��, F����");break;
		case 1:
			System.out.println(score + "��, F����");break;
		case 0:
			System.out.println(score + "��, F����");break;
		default:
			System.out.println("��ȿ���� ���� �����Դϴ�");
		}
	}
}
