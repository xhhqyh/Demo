package IMooc;
import java.util.Scanner;
/*
 * 功能：实现接收三个班级的各四名学员的成绩信息，然后计算每个班级学员的平均分
 * 知识点：二重循环、外层循环控制班级的数量、内层循环控制每个班级的学员数量
 * */
public class ceshi {
	public static void main(String[] args) {
		int sum=0; //成绩总和
		double avg=0; //成绩平均分
		int classnum=3; //班级数量
		int stunum=4; //学生数量
		//创建Scanner对象
		Scanner input=new Scanner(System.in);
		try{
			for(int i=0; i<classnum; i++){
				sum=0;
				System.out.println("***请输入"+ (i+1) +"班级的学生成绩***");
				for(int j=0; j<stunum; j++){
					System.out.print("请输入第"+ (j+1) +"个学生的成绩:");
					int score=input.nextInt();
					sum=sum+score;
				}
				avg=sum/classnum;
				System.out.println("第"+ (i+1) +"个班级的学生平均分为："+avg);
			}
		}finally{
			input.close();
		}
	}
}
