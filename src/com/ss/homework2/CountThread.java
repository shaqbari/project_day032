package com.ss.homework2;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int interval;
	int count;
	
	public CountThread(JLabel la, int interval) {
		this.la=la;
		this.interval=interval;
		
		this.start();
	}
	
	public void run() {
		while(count<=100){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Ư�� ���� ���� 1�� ������Ű��, ������ �ӵ����
		count++;
		la.setText(Integer.toString(count));
		}
		
	}
	
}
