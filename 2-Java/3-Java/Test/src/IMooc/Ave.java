package IMooc;

//求10个学生的平均成绩
public class Ave {
	public static void main(String args[]){
		int score[]=new int[10];
		for(int k=0; k<score.length; k++){
			score[k]=(int)(Math.random()*101);
			System.out.print(score[k]+"\t");
		}
		System.out.println();
		//计算平均成绩
		double sum=0;
		//for(int k=0;k<score.length; k++)
		//	sum+=score[k];
		//另一种求数组元素之和的方法
		for(int x:score) sum+=x;
		System.out.println("平均成绩:" + sum/score.length);
	}
	
}
