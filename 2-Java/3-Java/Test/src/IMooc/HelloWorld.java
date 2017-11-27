package IMooc;
import java.util.Arrays;

//实现输出考试成绩的前三名
public class HelloWorld {
  //完成 main 方法
  public static void main(String[] args) {
      int[] scores={89, -23, 64, 91, 119, 52, 73};
      HelloWorld hello=new HelloWorld();
      //调用方法
      hello.index(scores);        
  }
  
  //定义方法完成成绩排序并输出前三名的功能
  public void index(int[] score){
      int sum=0;  //有效成绩的个数
      Arrays.sort(score);
      for(int i=score.length-1; i>=0; i--){
          //判断值是否合格，不合格的用continue忽略
          if(score[i]<0 || score[i]>100)
              continue;
          sum += 1;
          System.out.println(score[i]);
          if(sum == 3)
              break;
      }
  }
}