package com.lec.ex2_thread;

public class TargetEx01 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName() +"¾È³çÇÏ¼¼¿ä - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
