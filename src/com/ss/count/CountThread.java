package com.ss.count;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int count, interval;
	
	public CountThread(JLabel la, int interval) {
		this.la=la;
		this.interval=interval;
		
		this.start();
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			la.setText(Integer.toString(count));
		}
	}
}
