package houpu.com;

/**
 * ��ҵ�ģ���1998~2020��֮�������������
 * 		 �������������(����һ����������):
 * 			1)�ܱ�4���������ܱ�100����
 *          2)�ܱ�400����
 * @author Administrator
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		for(int i=1998; i<=2020; i++){
			int a=i%4;
			int b=i%100;
			int c=i%400;
			
			if(c == 0 || (a == 0 && b != 0)){
				System.out.println(i + "������");
			}
		}
	}
}
