package IMooc;
import java.util.Arrays;

//ʵ��������Գɼ���ǰ����
public class HelloWorld {
  //��� main ����
  public static void main(String[] args) {
      int[] scores={89, -23, 64, 91, 119, 52, 73};
      HelloWorld hello=new HelloWorld();
      //���÷���
      hello.index(scores);        
  }
  
  //���巽����ɳɼ��������ǰ�����Ĺ���
  public void index(int[] score){
      int sum=0;  //��Ч�ɼ��ĸ���
      Arrays.sort(score);
      for(int i=score.length-1; i>=0; i--){
          //�ж�ֵ�Ƿ�ϸ񣬲��ϸ����continue����
          if(score[i]<0 || score[i]>100)
              continue;
          sum += 1;
          System.out.println(score[i]);
          if(sum == 3)
              break;
      }
  }
}