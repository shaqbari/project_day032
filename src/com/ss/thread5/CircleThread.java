//���� ǥ���� ��ü �� �� ������

package com.ss.thread5;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	//��ӹ����� ���������� ���� ��ӹ޴´�.
	public CircleThread(Graphics g, int x, int y, int width, int height, int interval) {
		super(g, x, y, width, height, interval);		
	}
	
	//�������̵�
	public void render(){
		System.out.println("g��"+g);
		//����� ����Ʈ�� �����쿡 �����ϰ�
		g.setColor(Color.YELLOW);//������ ������� ��´�.
		g.fillRect(0, 0, 700, 600); //JFrameũ�⸸ŭ�� �簢�������ؼ� �����.
			
		//�׸���
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);		
	}
}
