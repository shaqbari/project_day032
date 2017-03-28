package com.ss.practice;

import java.awt.Graphics;

abstract public class ShapeThread extends Thread{
	Graphics g;
	int x, y, width, height, interval;
	
	public ShapeThread(Graphics g, int x, int y, int width, int height, int interval) {
		this.g=g;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		
		start();
	}
	
	abstract public void render();
	
	public void run() {			
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}		
	};
}
