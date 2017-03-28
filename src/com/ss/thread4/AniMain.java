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
		aniMain=this;//�����͸�Ŭ���������� �� AniMain�� ����Ű�� ����
		bt=new JButton("��ü�̵�");
		add(bt, BorderLayout.NORTH);
				
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x1, 100, 50, 50); //�����͸�Ŭ�������� ������������ final�� ����ȰŸ� ���ٰ���
				g.drawRect(x2, 200, 50, 50);
				g.drawRoundRect(x3, 300, 50, 50, 30, 30);				
			}			
		};
		can.setBackground(Color.YELLOW);
		add(can);		
		
		//��ư�� ������ ����
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������� �̵� �޼ҵ� ȣ��
				//move();
				
				//���� �����带 ����� �� ��Ű��
				//moveThread=new MoveThread(this);���⼭ this�� �����͸�Ŭ������ ���Ѵ�.
				//moveThread=new MoveThread(aniMain);//���� AniMain ���۷���
				mt1=new MoveThread(AniMain.this, 1, 5);	//�̰͵� �ȴ�.
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
