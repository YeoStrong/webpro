package com.lec.ex3_target1ThreadN;

public class TargetEx implements Runnable {
	private int num = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<10 ; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("~ ~ ~ A 쓰레드 수행중 num 증가 ~ ~ ~");
				num ++;
			}
			System.out.println(Thread.currentThread().getName() + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
