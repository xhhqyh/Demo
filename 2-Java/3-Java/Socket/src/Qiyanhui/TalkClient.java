package Qiyanhui;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class TalkClient {
	public static void main(String args[]) throws IOException {
		Socket s1 = new Socket("localhost",5432);   //���ӷ�����
		DataInputStream dis = new DataInputStream(s1.getInputStream());
		final DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
		Frame myframe = new Frame("����������");
		Panel panelx = new Panel();
		final TextField input = new TextField(30);
		TextArea display = new TextArea(12,30);
		panelx.add(display);
		panelx.add(input);
		myframe.add(panelx);
		new receiveThread(dis, display);  //��������������Ϣ�߳�
		input.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					dos.writeUTF(input.getText());   //������Ϣ
					input.setText("");  //������Ϣ����������
				} catch (IOException z) {}
			}
		});
		
		myframe.setSize(300, 300);
		myframe.setVisible(true);
//		s1.close();
	}

}

//������Ϣ�߳�ѭ����ȡ������Ϣ����ʾ���ı���
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
				String str = dis.readUTF();  //�����Է���������Ϣ
				displayarea.append(str + "\n"); //����Ϣ��ӵ��ı�����ʾ
			} catch (IOException e) {}
		}
	}
}
















