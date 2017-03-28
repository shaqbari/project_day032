package com.ss.thread;

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
	MoveThread moveThread;
	AniMain aniMain;
	
	public AniMain() {
		aniMain=this;//내부익명클래스내에서 이 AniMain을 가리키게 위해
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
				//수동으로 이동 메소드 호출
				//move();
				
				//동생 쓰레드를 만들어 일 시키자
				//moveThread=new MoveThread(this);여기서 this는 내부익명클래스를 말한다.
				//moveThread=new MoveThread(aniMain);//기존 AniMain 레퍼런스
				moveThread=new MoveThread(AniMain.this);	//이것도 된다.
				moveThread.start();
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
