package com.ss.count;

public class CountThread2 extends Thread{
	int x, interval;
	
	public CountThread2(int x, int interval) {
		this.x=x;
		this.interval=interval;
	}
	
	public void run() {
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		x++;
	}
}
