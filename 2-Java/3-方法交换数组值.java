package HouPu;

import java.util.Scanner;

/**
 * ��������Ԫ��:
 * 		.����һ��������ʵ������Ԫ�ؽ����Ĺ��ܣ�����Ҫ�����£����������н���10�����������飬���Զ��庯���У�
    	���������е����ֵ���һ��Ԫ�ؽ�������Сֵ�����һ��Ԫ�ؽ�����Ȼ��������������������������(ע�⣺Ĭ�������е�10�����ǲ��ظ���)
 * @author Administrator
 *
 */
public class demo5 {
	
	public static void change(int a[]){
		int max = a[0];
		int maxi = 0;  //��¼����iֵ 
		int min = a[0];
		int mini = 0;  //��¼��С��iֵ
		for(int i=0; i<a.length; i++){
			
			if(a[i] > max){
				max = a[i];
				maxi = i;
			}
			
			if(a[i] < min){
				min = a[i];
				mini = i;
			}
		}
		
		//���maxi=9 mini=1
		if(maxi == 9 && mini == 0){
			int temp = a[0];
			a[0] = a[9];
			a[9] = temp;
			return;
		}
		
		//���ֵ��a[0]����
		a[maxi] = a[0];
		a[0] = max;
		
		//��Сֵ��a[0]����
		a[mini] = a[9];
		a[9] = min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//����һ������
		int[] arr = new int[10];
		
		System.out.println("������������ʮ��Ԫ�ص�ֵ:");
		int i=0;
		while(true){
			int num = in.nextInt();
			arr[i] = num;
			i++;
			
			if(i==10){
				break;
			}
		}
		
		//�任ǰ�������Ԫ��
		System.out.println("����ǰΪ��");
		for(int j=0; j<arr.length; j++){
			
			System.out.print(arr[j] + " ");
		}
		System.out.println();
		
		System.out.println("������:");
		change(arr);
		
		for(int m=0; m<arr.length; m++){
			System.out.print(arr[m] + " ");
		}
	}
}







































