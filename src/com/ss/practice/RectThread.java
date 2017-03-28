package com.ss.practice;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{
	
	//��ӹ����� ��������� �ڵ���ӹ����� �����ڴ� ��ӹ��� ���Ѵ�.
	public RectThread(Graphics g, int x, int y, int width, int height, int interval) {
		//superŬ������ �������� ���ڰ� ������ ���� ����� �Ѵ�.
		super(g, x, y, width, height, interval);
	}
	
	
	public void render() {
		//ȭ�� �����
		g.setColor(Color.YELLOW);//�׻��� ����
		g.fillRect(0, 0, 700, 800);
		
		//���ϴ� ���� �׸���
		x+=2;
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
	}
}
