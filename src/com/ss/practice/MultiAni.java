package com.ss.practice;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;	 
		
	public MultiAni() {		
		bt=new JButton("움직이기");
		can=new Canvas(){
			public void paint(Graphics g) {
			}
		};
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//캔버스가 쓰레드 생성보다 늦게 그려지면 g를 넘길 수 없다.//버튼을 눌렀을때 생성하자
				Graphics g=can.getGraphics();
				RectThread rt=new RectThread(g, 0, 0, 50, 50, 100);	
				OvalThread ot=new OvalThread(g, 0, 60, 50, 50, 50);
			}
		});
		
		setSize(700, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MultiAni();
	}
}
