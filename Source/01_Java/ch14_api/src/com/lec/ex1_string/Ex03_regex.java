package com.lec.ex1_string;

public class Ex03_regex {
	public static void main(String[] args) {
		/* ����ǥ����(regex)
		  1. ���� (http://goo.gl/HLntbd)
		  2. ��������
		  	\d	(���ڿ� ��ġ, [0-9]�� ����)
		  	\D	(���ڰ� �ƴ� ��)
		  	\w	(�����ڳ� ����, [a-zA-z0-9]�� ����)
		  	\W	(�����ڳ� ���ڰ� �ƴ� ��)
		  	. 	(����)
		  	\something (something)
		  	{2,} 	(2�� �̻� �ݺ�)
		  	{2,4}	(2~4ȸ �ݺ�)
		  	+		(1�� �̻� �ݺ�)
		  	*		(0�� �̻� �ݺ�)
		  	?		(0���̳� 1�� �ǹ�)
		  3. ����ǥ���� ������ : https://regexr.com/ https://regexpal.com/
		  		ex1. IP �ּ�: 198.168.2.125    0.0.0.0 = 
		  		ex2. ��ȭ��ȣ : 02 712 6100 / 010 9999 9999 / 010-9999-9999 / 010.9999.9999 / 02)717.6541 = \d{2,3}.?\d{3,4}.?\d{4}
		  		ex3. �ֹε�Ϲ�ȣ : 981212-2052121 / 9812122052121 = \d{2}[0-1]\d[0-3]\d-?[1-4]\d{6}
		  		ex4. �̸��� : yi09@naver.com / yi@sec.co.kr = \w+@\w+(\.\w+){1,2}         // \w{2,}@\w{3,}.?\w{2,3}.?\w{2,3}
		  
		  4. �ҽ� ����
		 */
		String juminNo = "981212-2054545";
		System.out.println("�ֹι�ȣ: " + juminNo.replaceAll("[1-4][0-9]{6}", "*******"));
		String str = "010-9999-9999 yisy0703@naver.com �ݰ����ϴ�. 981212-2054545 ���� ����";
		System.out.println("�̸����� ���� str : " + str.replaceAll("\\w+@\\w+(\\.\\w+){1,2}", ""));
		System.out.println("��ȭ��ȣ�� ������ str : " + str.replaceAll("\\d{2,3}-\\d{3,4}-\\d{4}", ""));
		System.out.println("������ ���ŵ� str : " + str.replaceAll("[��-��]", ""));
	}
}
