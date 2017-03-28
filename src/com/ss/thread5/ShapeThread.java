/*���̴� �簢���̴�, � ������ ǥ���� ��ü�̴� ��� �� Ŭ������ �ڽ����� ����
 * ��? ������ Ư¡�� �����Ƿ�.*/

package com.ss.thread5;

import java.awt.Graphics;

abstract public class ShapeThread extends Thread{
	Graphics g; //�߻��̴��� new�� �ȵ��� has a����� ����
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
	}
	
	abstract public void render(); //�߻����� ���ּܵ� �ڽĿ��� ������ ����
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			render(); //�Ұ��� run�� ������ �̹� �����ؾ� �ϱ� ������
		}
	}	
}