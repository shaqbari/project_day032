package com.ss.practice;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{
	
	//상속받으면 멤버변수는 자동상속받지만 생성자는 상속받지 못한다.
	public RectThread(Graphics g, int x, int y, int width, int height, int interval) {
		//super클래스의 생성자의 인자가 있으면 따로 써줘야 한다.
		super(g, x, y, width, height, interval);
	}
	
	
	public void render() {
		//화면 지우기
		g.setColor(Color.YELLOW);//붓색깔 선택
		g.fillRect(0, 0, 700, 800);
		
		//원하는 도형 그리기
		x+=2;
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
	}
}
