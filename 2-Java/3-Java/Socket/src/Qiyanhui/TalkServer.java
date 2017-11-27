package Qiyanhui;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * @author Administrator
 * һ���򵥵Ķ��û��������
 */
public class TalkServer {
	public static ArrayList<Client> allclient = new ArrayList<Client>(); //�������ͨ���߳�
	public static int clientnum = 0;  //ͳ�ƿͻ����ӵļ�������
	
	public static void main(String args[]){
		try {
			ServerSocket s = new ServerSocket(5432);
			while(true){
				Socket s1 = s.accept();   //�ȴ��ͻ�����
				DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
				DataInputStream din = new DataInputStream(s1.getInputStream());
				Client x = new Client(clientnum, dos, din);  //������ͻ���Ӧ��ͨ���߳�
				allclient.add(x);
				x.start();
				clientnum++;
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

//ͨ���̴߳������Ӧ�ͻ���ͨ�ţ������Կͻ����ݷ��������ͻ�
class Client extends Thread {
	int id;     //�ͻ��ı�ʶ
	DataOutputStream dos;  //ȥ���ͻ��������
	DataInputStream din;    //���Կͻ���������
	
	public Client(int id, DataOutputStream dos, DataInputStream din){
		this.id = id;
		this.dos = dos;
		this.din = din;
	}
	
	public void run(){
		while(true){
			try {
				String message = "�ͻ�" + id + ":" + din.readUTF();   //���ͻ�����
				for(int i=0; i<TalkServer.clientnum; i++){
					TalkServer.allclient.get(i).dos.writeUTF(message); //����Ϣת���������û�
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}




















