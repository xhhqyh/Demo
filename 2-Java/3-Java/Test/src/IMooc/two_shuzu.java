package IMooc;
//��ӡ��ά���������������ʽ
public class two_shuzu {
	public static void main(String[] args){
		int[][] m=new int[4][];
		for(int i=0; i<m.length; i++){
			m[i]=new int[i+1];  //��ÿ�д���������
			for(int j=0; j<m[i].length; j++){
				m[i][j] = i+j;
			}
		}
		//���
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
}
