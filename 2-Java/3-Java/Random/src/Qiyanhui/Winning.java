package Qiyanhui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Winning extends Frame implements Runnable {
	//用数组存放一组号码
	String phoneNumber[] = {"18163132202", "123456798955", "14584524585", "12542589645", "15632548965", "12345688888"};
	//用来显示滚动号码
	TextArea disp = new TextArea(100, 100);
	//记录滚动到的索引位置
	int pos = 0;
	//控制线程停止的标记变量
	boolean flag;
	//启动、停止按钮
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
					//更改按钮标签
					onoff.setLabel("end");
					//启动线程
					(new Thread(Winning.this)).start();
				} else {
					//设置线程停止标记
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
			//随机挑选位置
			pos = (int)(Math.random() * n);
			String message = phoneNumber[pos] + "\n" + phoneNumber[(pos + 1) % n];
			//显示位置连续的两个号码
			disp.setText(message);
		}
	}
}

















