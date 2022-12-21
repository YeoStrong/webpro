package com.lec.ex2_thread;

public class TargetEx02 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<20 ; i++) {
			System.out.println(Thread.currentThread().getName() + " ¹Ý°©½À´Ï´Ù. " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
