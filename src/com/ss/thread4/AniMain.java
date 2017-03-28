package com.ss.thread4;

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
	int x1, x2, x3;
	MoveThread mt1, mt2, mt3;
	AniMain aniMain;
	
	public AniMain() {
		aniMain=this;//내부익명클래스내에서 이 AniMain을 가리키게 위해
		bt=new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
				
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x1, 100, 50, 50); //내부익명클래스에서 지역변수에는 final로 선언된거만 접근가능
				g.drawRect(x2, 200, 50, 50);
				g.drawRoundRect(x3, 300, 50, 50, 30, 30);				
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
				mt1=new MoveThread(AniMain.this, 1, 5);	//이것도 된다.
				mt2=new MoveThread(aniMain, 2, 10);
				mt3=new MoveThread(AniMain.this, 3, 15);
				
				mt1.start();
				mt2.start();
				mt3.start();
			}
		});
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(int id, int velX){
		if(id==1){
			x1+=velX;			
		}else if(id==2){
			x2+=velX;
		}else if(id==3){
			x3+=velX;			
		}
		
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMain();
	}

}
