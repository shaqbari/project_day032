/*재사용성 있으면 .java로 빼라
 * 내부익명으로 thread를 생성하면 멤버변수를 내것처럼 편하게 쓸수 있다. but 1회성
 * Runnable을 implements, 내부익명 클래스로 선언한것과 비슷*/

package com.ss.thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*개발자가 쓰레드를 상속하여 개발할 수 있으나 이미 다른클래스의 자식일 경우, 
 * 상속은 불가하다. 이럴때 사용할 수 있는 객체가 바로 Runnable 인터페이스이다.
 * */
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; //내부익명스타일로 개발한다.
	
	
	public AniMain() {
		thread=new Thread(this);			
		//Runable인 객체를 인수로 넘긴다
		//그러면, run 메소드의 호출은 Runnable을 재정의한 객체의 run을 호출한다.
		//여기서는 자기자신이(this) Runnable이다.
		
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
