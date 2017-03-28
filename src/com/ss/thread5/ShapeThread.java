/*원이던 사각형이던, 어떤 도형을 표현한 객체이던 모두 이 클래스의 자식으로 두자
 * 왜? 공통적 특징이 있으므로.*/

package com.ss.thread5;

import java.awt.Graphics;

abstract public class ShapeThread extends Thread{
	Graphics g; //추상이더라도 new만 안되지 has a관계는 가능
	int x;
	int y;
	int width;
	int height;
	int interval;
	
	public ShapeThread(Graphics g, int x, int y, int width, int height, int interval) {
		this.g=g;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		
		start();
	}
	
	abstract public void render(); //추상으로 남겨둬서 자식에서 구현을 강제
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			render(); //불가능 run이 돌때는 이미 존재해야 하기 때문에
		}
	}	
}
