//원을 표현한 객체 및 그 움직임

package com.ss.thread5;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	//상속받으면 전역변수도 같이 상속받는다.
	public CircleThread(Graphics g, int x, int y, int width, int height, int interval) {
		super(g, x, y, width, height, interval);		
	}
	
	//오버라이드
	public void render(){
		System.out.println("g는"+g);
		//노란색 페인트로 윈도우에 적용하고
		g.setColor(Color.YELLOW);//붓으로 노란색을 찍는다.
		g.fillRect(0, 0, 700, 600); //JFrame크기만큼의 사각형생성해서 지운다.
			
		//그리자
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);		
	}
}
