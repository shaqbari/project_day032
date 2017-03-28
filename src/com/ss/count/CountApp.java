package com.ss.count;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountApp extends JFrame{
	JPanel p_left, p_right;
	JLabel label_left, label_right;
	CountThread ct_left, ct_right;
	int x=1, y=1;
	
	public CountApp() {
		p_left=new JPanel();
		p_right=new JPanel();
		label_left=new JLabel(Integer.toString(x));
		label_right=new JLabel(Integer.toString(y));
		
		setLayout(new FlowLayout());
		
		label_left.setPreferredSize(new Dimension(200, 200));
		label_right.setPreferredSize(new Dimension(200, 200));
		
		label_left.setFont(new Font("Verdana", Font.BOLD, 80));
		label_right.setFont(new Font("Verdana", Font.BOLD, 80));
		
		p_left.setBackground(Color.YELLOW);
		p_left.setPreferredSize(new Dimension(200, 200));
		p_left.add(label_left);
		
		p_right.setBackground(Color.RED);
		p_right.setPreferredSize(new Dimension(200, 200));
		p_right.add(label_right);
		
		add(p_left);
		add(p_right);
		
		setSize(500, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ct_left=new CountThread(label_left, 100);
		ct_right=new CountThread(label_right, 200);
	}
	
	public static void main(String[] args) {
		new CountApp();
	}

}
