package cjdx.com;

import java.util.Scanner;

/**
 * ��ҵ����
 * 	        ĳ��˾���ù��õ绰�������ݣ�������4λ�������ڴ��ݹ������Ǽ��ܵģ����ܹ������£�
 * 		ÿλ�ϵ����ּ���5��Ȼ���úͳ���10��������������֣��ٽ���һλ�͵���λ������
 * 		�ڶ�λ�͵���λ��������дһ���������ڽ���һ��4λ���������Ҵ�ӡ������ܺ������
 * @author Administrator
 *
 */
public class Demo6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("��������һ�����֣�");
		
		int a = in.nextInt();
		String astr = Integer.toString(a); //������ת�����ַ���
		int number = astr.length();  //������������ֵĳ��ȣ�������������ĳ���
		int[] arr = new int[number];
		
		int b = 0;  //�����洢�����ĳһλ����ֵ
		int c = 0; //������¼ѭ���Ĵ���
		while(true){
			if(a < 10){
				b = a;
				arr[number-c-1] = b;
				c++;
				break;
			}
			
			b = a%10;
			a = (a-b)/10;
			arr[number-c-1] = b;
			c++;
		}
		
		//����ֽ�ò��洢�õ�����ֵ
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		//���ÿλ�ϵ����ּ���5��Ȼ���úͳ���10��������������ֺ������
		for(int j=0; j<arr.length; j++){
			arr[j] = (arr[j]+5)%10;
			System.out.print(arr[j] + " ");
		}
		
		System.out.println();
		//�������еĵ�һλ�����һλ���ڶ�λ�͵����ڶ�λ...�һ�
		for(int k=0; k<arr.length/2; k++){
			int num = arr[k];
			arr[k] = arr[arr.length-k-1];
			arr[arr.length-k-1] = num;
		}
		
		System.out.println();
		//�����������ֵ
		for(int m=0; m<arr.length; m++){
			System.out.print(arr[m] + " ");
		}
		
	}
}

































