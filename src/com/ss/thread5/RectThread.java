package com.ss.thread5;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{
	public RectThread(Graphics g, int x, int y, int width, int height, int interval) {
		super(g, x, y, width, height, interval);		
	}
	
	public void render(){
		//화면 지우기
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		//원하는 도형 그리기
		x+=2;
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);		
	}
}
