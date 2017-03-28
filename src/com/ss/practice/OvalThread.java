package com.ss.practice;

import java.awt.Color;
import java.awt.Graphics;

public class OvalThread extends ShapeThread{
	
	public OvalThread(Graphics g, int x, int y, int width, int height, int interval) {
		super(g, x, y, width, height, interval);
	}
	
	public void render() {
		//�����
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 800);
		
		//�׸���
		x+=3;
		g.setColor(Color.GREEN);
		g.drawOval(x, y, width, height);
	}
}
