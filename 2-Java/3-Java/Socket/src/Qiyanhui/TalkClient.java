package Qiyanhui;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class TalkClient {
	public static void main(String args[]) throws IOException {
		Socket s1 = new Socket("localhost",5432);   //连接服务器
		DataInputStream dis = new DataInputStream(s1.getInputStream());
		final DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
		Frame myframe = new Frame("简易聊天室");
		Panel panelx = new Panel();
		final TextField input = new TextField(30);
		TextArea display = new TextArea(12,30);
		panelx.add(display);
		panelx.add(input);
		myframe.add(panelx);
		new receiveThread(dis, display);  //创建启动接收消息线程
		input.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					dos.writeUTF(input.getText());   //发送消息
					input.setText("");  //发送消息后清空输入框
				} catch (IOException z) {}
			}
		});
		
		myframe.setSize(300, 300);
		myframe.setVisible(true);
//		s1.close();
	}

}

//接收消息线程循环读取网络消息，显示在文本域
class receiveThread extends Thread{
	DataInputStream dis;
	TextArea displayarea;
	
	public receiveThread(DataInputStream dis, TextArea m){
		this.dis = dis;
		displayarea = m;
		this.start();
	}
	
	public void run(){
		for(;;){
			try {
				String str = dis.readUTF();  //读来自服务器的消息
				displayarea.append(str + "\n"); //将消息添加到文本域显示
			} catch (IOException e) {}
		}
	}
}
















