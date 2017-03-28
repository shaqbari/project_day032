package com.ss.thread;

public class MyThread extends Thread{
	/*
	 * 개발자는 독립적으로 수행하고 싶은 코드를 스레드의 run메소드 안에 작성하면 된다.
	 * 두개의 thread에 while문이 있어도 jvm은 골고루 건드려 준다.
	 * */
	
	public void run() {
		
		while(true){
			try {
				Thread.sleep(1000); //1초 쉬다와! sleep은 static메소드라 바로 호출가능
				//runnable에서 1/1000초 단위로 nonrunable 영역에 보낸다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			System.out.println("★");
		}
	}
}
