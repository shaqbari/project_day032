/*���� �ٸ� �׷���, �ӵ�, ��Ÿ ���� ����
 * ��ü�� �����̰� ����.*/

package com.ss.thread5;

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
	//Graphics gp;
	
	//CircleThread ct;
	
	public MultiAni() {
		bt=new JButton("���� �����̱�");
		can=new Canvas(){
			public void paint(Graphics g) {
				//ct=new CircleThread(g, 0, 0, 50, 50); ���⼭ ����� paint()�޼ҵ� ������ ������ �����϶����� ������
				//gp=g; //������ �ٸ��� �ϸ� g�� ���� �� �ִ�. //ĵ������ ������ �������� �ʰ� �׷����� gp�� g�� �ѱ� �� ����.//��ư�� �������� ��������.
				//���� ������δ� �� �ȵǴ� �Ʒ����� getGraphics()�޼ҵ带 �̿�����
			}			
		};		
		
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics(); //ĵ������ �����ϰ� �ִ� �׷����� �ѱ��.
				//ct=new CircleThread(gp, 0, 0, 50, 50); //������ ������ ��ư�����ڿ� �ؾ� ĵ�������� �ʰ� �����Ǿ�g�� �ѱ� �� �ֵ�. 
				//ct.start();
				
				//for(int i=0; i<5; i++){
					CircleThread ct=new CircleThread(g, 0, 60, 50, 50, 100);
					RectThread rt=new RectThread(g, 0, 120, 50, 50, 100);
					//}
				//ShapeThread st=ct;//�̷������ε� ����				
				//ct.start(); //Thread�� ��ӹ޴� ShapeThread�� start()�� ȣ��
				//st.start(); �¾ �༮ ������ �����̰� ShapeThread�� �����ڿ��� ȣ��
			}
		});
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MultiAni();
	}

}
