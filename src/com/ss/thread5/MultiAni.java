/*서로 다른 그래픽, 속도, 기타 값을 갖는
 * 물체를 움직이게 하자.*/

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
		bt=new JButton("각자 움직이기");
		can=new Canvas(){
			public void paint(Graphics g) {
				//ct=new CircleThread(g, 0, 0, 50, 50); 여기서 만들면 paint()메소드 때문데 프레임 움직일때마다 생성됨
				//gp=g; //변수명 다르게 하면 g를 얻을 수 있다. //캔버스가 쓰레드 생성보다 늦게 그려지면 gp에 g를 넘길 수 없다.//버튼을 눌렀을때 생성하자.
				//위의 방법으로는 잘 안되니 아래에서 getGraphics()메소드를 이용하자
			}			
		};		
		
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics(); //캔버스가 보유하고 있는 그래픽을 넘긴다.
				//ct=new CircleThread(gp, 0, 0, 50, 50); //쓰레드 생성을 버튼누른뒤에 해야 캔버스보다 늦게 생성되어g를 넘길 수 있따. 
				//ct.start();
				
				//for(int i=0; i<5; i++){
					CircleThread ct=new CircleThread(g, 0, 60, 50, 50, 100);
					RectThread rt=new RectThread(g, 0, 120, 50, 50, 100);
					//}
				//ShapeThread st=ct;//이런식으로도 가능				
				//ct.start(); //Thread를 상속받는 ShapeThread의 start()를 호출
				//st.start(); 태어난 녀석 스스로 움직이게 ShapeThread의 생성자에서 호출
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
