package com.ss.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class ProgressBarThread extends Thread{
	MovieCopy movieCopy;
	JProgressBar bar;
	int count, interval;
	FileInputStream fis;
	FileOutputStream fos;
	
	
	public ProgressBarThread(MovieCopy movieCopy, JProgressBar bar, int interval, FileInputStream fis, FileOutputStream fos) {
		this.movieCopy=movieCopy;
		this.bar=bar;
		this.interval=interval;
		this.fis=fis;
		this.fos=fos;
		
		start();
	}
	
	public void run() {
		while (true) {			
			try {
				int data = fis.read();
				if (data == -1) break;
				fos.write(data);
				count++;
				int percent=100*count/movieCopy.fileSize;
				movieCopy.bar.setValue(percent);
				
			} catch (IOException e) {				
				e.printStackTrace();
				JOptionPane.showMessageDialog(movieCopy, "파일을 찾을 수 없습니다.");
			}
		}
	}
}
