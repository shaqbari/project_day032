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
			JOptionPane.showMessageDialog(movieCopy, "������ ã�� �� �����ϴ�.");
		} finally {
			try {
				//fos�� �������� �ݴ´�. ���׷��̵� ���� ������ ���� �ݾƾ� ��
				if(fos!=null){				
					fos.close();
				}
				//bar�� �ʱ�ȭ�Ҽ� ������ ���ڴ�
				bar.setValue(0);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(movieCopy, "IO�߿����� �߻��߽��ϴ�.");
			}
		}		
	}
}
