package com.ss.thread;

public class MyThread extends Thread{
	/*
	 * �����ڴ� ���������� �����ϰ� ���� �ڵ带 �������� run�޼ҵ� �ȿ� �ۼ��ϸ� �ȴ�.
	 * �ΰ��� thread�� while���� �־ jvm�� ���� �ǵ�� �ش�.
	 * */
	
	public void run() {
		
		while(true){
			try {
				Thread.sleep(1000); //1�� ���ٿ�! sleep�� static�޼ҵ�� �ٷ� ȣ�Ⱑ��
				//runnable���� 1/1000�� ������ nonrunable ������ ������.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			System.out.println("��");
		}
	}
}
