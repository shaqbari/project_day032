package com.ss.progressbar;

import javax.swing.JProgressBar;

public class ProgressThread extends Thread{
	JProgressBar bar;
	int interval, count;
	
	public ProgressThread(JProgressBar bar, int interval) {
		this.bar=bar;
		this.interval=interval;
	}	
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);			
		}
	}
}
