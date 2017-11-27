package Exception;
import java.util.*;

/*
 * ģ�����ϵͳ
 * 		1)�����ַ������鱣��ͼ����Ϣ
 * 		2)��ʾ�û����룬�ֱ𰴡������� �� ��ͼ����š�����ͼ��
 * 		3)����������Ϣ�����ʵ����쳣����
 * 			a.����������ʹ����׳������������쳣��������ʾ��������
 * 			b.������������ڣ��׳���ͼ�鲻�����쳣��,����ʾ��������
 * 			c.���ͼ����ų����ַ������鷶Χ���׳�"ͼ�鲻�����쳣",����ʾ����
 * */
public class Book {
	private String[] books = new String[4]; //����洢�������
	private String road;  //�洢�û����������
	
	public static void main(String[] args) {
		Book book = new Book();
		book.initbook();
		book.Findbook();
		
	}
	//��ʼ������Ϣ
	void initbook(){
		books[0] = "���������";
		books[1] = "���ݽṹ";
		books[2] = "���ģʽ";
		books[3] = "����ϵͳ";
	}
			
	//�����鼮
	void Findbook(){
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("������Ҫ��ѯ�������������:");
			road = in.next();
			if(Checkroad())
				CheckNum();
			else
				CheckName();
			System.out.println("�Ƿ��������ͼ�飿��(1):��(0)");
			int in2 = in.nextInt();
			if(in2 == 1)
				Findbook();
			else
				System.out.println("�����˳�ͼ��ϵͳ,��ӭ�´ι���");
		}catch(BookException e){
			System.out.println("ͼ�鲻����");
			Findbook();
		}finally{
			in.close();
		}
	}
	
	//�ж������ֵ�ǲ�������
	boolean Checkroad(){
		try{
		    Integer.parseInt(road);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//�����ֲ���
	void CheckNum() throws BookException{
		//road���ַ�����Ҫת��int��
		int num = Integer.parseInt(road);
		if(num>0 && num<5)
			System.out.println("�����ǣ�" + books[num-1]);
		else
			throw new BookException();
	}
	
	//�����ֲ���
	void CheckName() throws BookException{
		String name = road;
		for(String book:books){
			if(book.equals(name)){
				System.out.println("��Ҫ���ҵ����ڹ�,����Ϊ:" + name);
				return;
			}
			throw new BookException();
		}
	}
}


















