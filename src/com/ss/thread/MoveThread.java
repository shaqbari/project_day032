//움직임 로직을 담게 될 쓰레드

package com.ss.thread;

public class MoveThread extends Thread{
	AniMain aniMain;	
	//개발자는 독립 실행할 코드를 run에 기재한다.
	//jvm이 run을 알아서 호출해준다.
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain;
	}
	
	public void run() {
				
		while (true) {
			try {
				Thread.sleep(100);//안쓰면 너무 빠르다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			aniMain.move(); //생성자에서 기존의 AniMain을 얻어온다. getter/setter도 괜찮음
		}
	}
}
