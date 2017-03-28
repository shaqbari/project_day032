package com.ss.progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{
	JProgressBar bar1, bar2, bar3;
	JButton bt;
	ProgressThread pt1, pt2, pt3;
	int count;
	
	public ProgressBar() {
		setLayout(new FlowLayout());
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bt=new JButton("¿€µø");
		
		bar1.setPreferredSize(new Dimension(450, 50));
		bar2.setPreferredSize(new Dimension(450, 50));
		bar3.setPreferredSize(new Dimension(450, 50));
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pt1.start();
				pt2.start();
				pt3.start();
			}
		});
		
		setSize(500, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 pt1=new ProgressThread(bar1, 10);
		 pt2=new ProgressThread(bar2, 20);
		 pt3=new ProgressThread(bar3, 30);
	}
	
	public static void main(String[] args) {
		new ProgressBar();
	}
}
