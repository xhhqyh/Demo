package IMooc;

//��10��ѧ����ƽ���ɼ�
public class Ave {
	public static void main(String args[]){
		int score[]=new int[10];
		for(int k=0; k<score.length; k++){
			score[k]=(int)(Math.random()*101);
			System.out.print(score[k]+"\t");
		}
		System.out.println();
		//����ƽ���ɼ�
		double sum=0;
		//for(int k=0;k<score.length; k++)
		//	sum+=score[k];
		//��һ��������Ԫ��֮�͵ķ���
		for(int x:score) sum+=x;
		System.out.println("ƽ���ɼ�:" + sum/score.length);
	}
	
}
