package IMooc;
//打印二维数组的下三角行列式
public class two_shuzu {
	public static void main(String[] args){
		int[][] m=new int[4][];
		for(int i=0; i<m.length; i++){
			m[i]=new int[i+1];  //对每行创建子数组
			for(int j=0; j<m[i].length; j++){
				m[i][j] = i+j;
			}
		}
		//输出
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
}
