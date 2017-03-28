package com.ss.homework2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{
	JProgressBar[] bar=new JProgressBar[3];
	MyBar[] mb =new MyBar[3];
	int[] interval={100, 200, 300};
	
	JButton bt;
	int count;
	
	public ProgressBar() {
		setLayout(new FlowLayout());		
		
		for(int i=0; i<interval.length; i++){
			bar[i] = new JProgressBar();
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
			mb[i]=new MyBar(bar[i], interval[i]);			
		}		
		
		setSize(500, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ProgressBar();
	}

}
