package Qiyanhui;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * @author Administrator
 * 一个简单的多用户聊天程序
 */
public class TalkServer {
	public static ArrayList<Client> allclient = new ArrayList<Client>(); //存放所有通信线程
	public static int clientnum = 0;  //统计客户连接的计数变量
	
	public static void main(String args[]){
		try {
			ServerSocket s = new ServerSocket(5432);
			while(true){
				Socket s1 = s.accept();   //等待客户连接
				DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
				DataInputStream din = new DataInputStream(s1.getInputStream());
				Client x = new Client(clientnum, dos, din);  //创建与客户对应的通信线程
				allclient.add(x);
				x.start();
				clientnum++;
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

//通信线程处理与对应客户的通信，将来自客户数据发往其他客户
class Client extends Thread {
	int id;     //客户的标识
	DataOutputStream dos;  //去往客户的输出流
	DataInputStream din;    //来自客户的输入流
	
	public Client(int id, DataOutputStream dos, DataInputStream din){
		this.id = id;
		this.dos = dos;
		this.din = din;
	}
	
	public void run(){
		while(true){
			try {
				String message = "客户" + id + ":" + din.readUTF();   //读客户数据
				for(int i=0; i<TalkServer.clientnum; i++){
					TalkServer.allclient.get(i).dos.writeUTF(message); //将消息转发给所有用户
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}




















