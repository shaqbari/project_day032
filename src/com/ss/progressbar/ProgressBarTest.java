package com.ss.progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar bar;
	JButton bt;
	int count;
	
	public ProgressBarTest() {
		setLayout(new FlowLayout());
		bar = new JProgressBar();
		bt=new JButton("¿€µø");
		
		bar.setPreferredSize(new Dimension(450, 40));
		
		add(bar);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				bar.setValue(count);
			}
		});
		
		setSize(500, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();
	}

}
