//������ ������ ��� �� ������

package com.ss.thread4;

public class MoveThread extends Thread{
	AniMain aniMain;	
	//�����ڴ� ���� ������ �ڵ带 run�� �����Ѵ�.
	//jvm�� run�� �˾Ƽ� ȣ�����ش�.
	
	int id;
	int velX;	
	
	public MoveThread(AniMain aniMain, int id, int velX) {
		this.aniMain=aniMain;
		this.id=id;
		this.velX=velX;
	}
	
	public void run() {				
		while (true) {
			try {
				Thread.sleep(100);//�Ⱦ��� �ʹ� ������.
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			aniMain.move(id, velX); //�����ڿ��� ������ AniMain�� ���´�. getter/setter�� ������
		}
	}
}
