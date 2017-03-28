/*���뼺 ������ .java�� ����
 * �����͸����� thread�� �����ϸ� ��������� ����ó�� ���ϰ� ���� �ִ�. but 1ȸ��
 * Runnable�� implements, �����͸� Ŭ������ �����ѰͰ� ���*/

package com.ss.thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*�����ڰ� �����带 ����Ͽ� ������ �� ������ �̹� �ٸ�Ŭ������ �ڽ��� ���, 
 * ����� �Ұ��ϴ�. �̷��� ����� �� �ִ� ��ü�� �ٷ� Runnable �������̽��̴�.
 * */
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; //�����͸�Ÿ�Ϸ� �����Ѵ�.
	
	
	public AniMain() {
		thread=new Thread(this);			
		//Runable�� ��ü�� �μ��� �ѱ��
		//�׷���, run �޼ҵ��� ȣ���� Runnable�� �������� ��ü�� run�� ȣ���Ѵ�.
		//���⼭�� �ڱ��ڽ���(this) Runnable�̴�.
		
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

	public static void main(String[] args) {
		new AniMain();
	}
}
