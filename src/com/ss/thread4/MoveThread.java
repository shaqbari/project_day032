//움직임 로직을 담게 될 쓰레드

package com.ss.thread4;

public class MoveThread extends Thread{
	AniMain aniMain;	
	//개발자는 독립 실행할 코드를 run에 기재한다.
	//jvm이 run을 알아서 호출해준다.
	
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
				Thread.sleep(100);//안쓰면 너무 빠르다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			aniMain.move(id, velX); //생성자에서 기존의 AniMain을 얻어온다. getter/setter도 괜찮음
		}
	}
}
