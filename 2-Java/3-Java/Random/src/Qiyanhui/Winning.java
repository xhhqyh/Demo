package Qiyanhui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Winning extends Frame implements Runnable {
	//��������һ�����
	String phoneNumber[] = {"18163132202", "123456798955", "14584524585", "12542589645", "15632548965", "12345688888"};
	//������ʾ��������
	TextArea disp = new TextArea(100, 100);
	//��¼������������λ��
	int pos = 0;
	//�����߳�ֹͣ�ı�Ǳ���
	boolean flag;
	//������ֹͣ��ť
	Button onoff;
	
	public static void main(String[] args){
		new Winning();
	}
	
	public Winning(){
		add("Center", disp);
		onoff = new Button("begin");
		add("South", onoff);
		onoff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("begin")){
					flag = true;
					//���İ�ť��ǩ
					onoff.setLabel("end");
					//�����߳�
					(new Thread(Winning.this)).start();
				} else {
					//�����߳�ֹͣ���
					flag = false;
					onoff.setLabel("begin");
				}
			}
			
		});
		
		setSize(200, 100);
		setVisible(true);
	}
	
	public void run(){
		while(flag){
			int n=phoneNumber.length;
			//�����ѡλ��
			pos = (int)(Math.random() * n);
			String message = phoneNumber[pos] + "\n" + phoneNumber[(pos + 1) % n];
			//��ʾλ����������������
			disp.setText(message);
		}
	}
}

















