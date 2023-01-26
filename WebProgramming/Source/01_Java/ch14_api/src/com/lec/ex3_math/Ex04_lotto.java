package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1 : �Ǽ�
// 0 <= Math.random()*45 < 45 : �Ǽ�
//1 <= (int)(Math.random()*45 +1) < 46 : 1~45������ ����
public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do { // �߻��� ������ �ߺ��Ǿ����� üũ
				temp= random.nextInt(45)+1;
				for(j=0 ; j<i ; j++) { // i(�̴� ����)�� 0�϶��� �ѹ��� �۵�����(�ߺ� ������ �ʿ䰡 ���� 1��° ����)
					if(lotto[j] ==temp) {
						System.out.println("�ߺ��ż� �ٽ� ��" + temp);
						break;
					} // if - temp�� ���� ��ȣ�� ������ for���� ��������.
				}//for
			}while(i != j);
			lotto[i] = temp;
		}
		// �߻��� �ζ� ��ȣ ���
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n���� ��");
		// lotto�迭 ���� sort
		for(i=0 ; i<lotto.length-1 ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp; //���� ������ �����Ͱ� ��������� ������ �ӽú����� �̿��Ͽ� 3�� ����
				}
			}
		}
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		
	}

}
