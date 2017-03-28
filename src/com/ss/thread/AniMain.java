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
		aniMain=this;//�����͸�Ŭ���������� �� AniMain�� ����Ű�� ����
		bt=new JButton("��ü�̵�");
		add(bt, BorderLayout.NORTH);
		
		
		can=new Canvas(){
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50); //�����͸�Ŭ�������� ������������ final�� ����ȰŸ� ���ٰ���
				
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
				moveThread=new MoveThread(AniMain.this);	//�̰͵� �ȴ�.
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
