package com.ss.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class ProgressBarThread extends Thread{
	MovieCopy movieCopy;
	JProgressBar bar;	
	FileInputStream fis;
	FileOutputStream fos;
	int count;
	
	public ProgressBarThread(MovieCopy movieCopy) {
		this.movieCopy=movieCopy;
		bar=movieCopy.bar;
		fis=movieCopy.fis;
		fos=movieCopy.fos;
		
		start();
	}
	
	public void run() {					
		try {
			while (true) {
				int data = fis.read();
				if (data == -1) break;
				fos.write(data);
				count++;
				int percent=100*count/movieCopy.fileSize;
				movieCopy.bar.setValue(percent);
			}				
		} catch (IOException e) {				
			e.printStackTrace();
			JOptionPane.showMessageDialog(movieCopy, "파일을 찾을 수 없습니다.");
		} finally {
			try {
				//fos가 있을때만 닫는다. 업그레이드 빨때 있으면 먼저 닫아야 해
				if(fos!=null){				
					fos.close();
				}
				//bar도 초기화할수 있으면 좋겠다
				bar.setValue(0);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(movieCopy, "IO중에러가 발생했습니다.");
			}
		}		
	}
}
