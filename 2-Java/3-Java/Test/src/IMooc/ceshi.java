package IMooc;
import java.util.Scanner;
/*
 * ���ܣ�ʵ�ֽ��������༶�ĸ�����ѧԱ�ĳɼ���Ϣ��Ȼ�����ÿ���༶ѧԱ��ƽ����
 * ֪ʶ�㣺����ѭ�������ѭ�����ư༶���������ڲ�ѭ������ÿ���༶��ѧԱ����
 * */
public class ceshi {
	public static void main(String[] args) {
		int sum=0; //�ɼ��ܺ�
		double avg=0; //�ɼ�ƽ����
		int classnum=3; //�༶����
		int stunum=4; //ѧ������
		//����Scanner����
		Scanner input=new Scanner(System.in);
		try{
			for(int i=0; i<classnum; i++){
				sum=0;
				System.out.println("***������"+ (i+1) +"�༶��ѧ���ɼ�***");
				for(int j=0; j<stunum; j++){
					System.out.print("�������"+ (j+1) +"��ѧ���ĳɼ�:");
					int score=input.nextInt();
					sum=sum+score;
				}
				avg=sum/classnum;
				System.out.println("��"+ (i+1) +"���༶��ѧ��ƽ����Ϊ��"+avg);
			}
		}finally{
			input.close();
		}
	}
}
