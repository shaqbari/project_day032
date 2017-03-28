/*Thread를 내부익명클래스 형태로 생성*/

package com.ss.thread2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; //내부익명스타일로 개발한다.
	
	
	public AniMain() {
		thread=new Thread(){
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					move();
				}
			}			
		};
		
		bt=new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		
		can=new Canvas(){
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50); //내부익명클래스에서 지역변수에는 final로 선언된거만 접근가능
				
			}			
		};
		can.setBackground(Color.YELLOW);
		add(can);		
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
				
			}
		});
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMain();
	}

}
