package com.ss.homework;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MovieCopy extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField path_ori, path_dest;
	
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;	
	int fileSize;
	
	public MovieCopy() {
		setLayout(new FlowLayout());
		
		bar=new JProgressBar();
		bt_open=new JButton("����");
		bt_save=new JButton("����");
		bt_copy=new JButton("����");
		path_ori=new JTextField(33);
		path_dest=new JTextField(33);		

		chooser=new JFileChooser("E:/git/java_workspace/project_day032/src/com/ss/res");
		
		bar.setPreferredSize(new Dimension(450, 30));
		
		add(bar);
		add(bt_open);
		add(path_ori);
		add(bt_save);
		add(path_dest);
		add(bt_copy);
		
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
	
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if (obj==bt_open) {
			open();
		}else if (obj==bt_save) {
			save();
		}else if (obj==bt_copy) {
			copy();
		}
	}
	
	public void open(){
		int state=chooser.showOpenDialog(this);//Ž����â �����ְ� �����ϸ� 0�̹�ȯ�ȴ�.
		if(state==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			fileSize=(int)file.length(); //���Ͽ뷮   x=100*��/��			
			System.out.println(fileSize);
			path_ori.setText(file.getPath());		
		}
	}
	
	public void save(){
		int state=chooser.showOpenDialog(this);
		if (state==JFileChooser.APPROVE_OPTION) {
			path_dest.setText(chooser.getSelectedFile().getPath());
		}	
	}
	
	//�����ư �������� ���Ͻ�Ʈ��ó����  �ٸ� ������ �ȿ� �־�� �Ѵ�.
	public void copy(){			
		try {
			fis=new FileInputStream(path_ori.getText());
			fos=new FileOutputStream(path_dest.getText());
			
			ProgressBarThread pbt=new ProgressBarThread(this);
			/*
			while (true) {
				int data = fis.read();
				if (data == -1) break;
				fos.write(data);
			}
			*/	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");
		}
		
	}
	
	public static void main(String[] args) {
		new MovieCopy();

	}


}
