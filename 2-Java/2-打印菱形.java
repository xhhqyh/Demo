package houpu2.com;

import java.util.Scanner;

/**
 * ��ӡ����
 * @author Administrator
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		
		//�㷨һ:
		
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ��ӡ�����ε������ǲ���:");
		int num = in.nextInt();
		
		/*
		//��ӡ�ϲ�����
		for(int i=1; i<=num; i++){
			for(int j=1; j<=(2*i-1); j++){
				//���ÿ��ǰ��Ŀո�
				if(j==1){
					for(int m=1; m<=(num-i);m++){
						System.out.print(" ");
					}
				}
				//���*
				System.out.print("*");
			}
			//����
			System.out.println();
		}
		
		//��ӡ�²�����
		for(int f=num-1; f>0; f--){
			for(int n=2*f-1;n>0; n--){
				if(n==2*f-1){
					for(int m=num-f;m>0; m--){
						System.out.print(" ");
					}
				}
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		
		//�㷨��:
		//��ӡ����
		for(int a=1;a<=num; a++){
			//��ӡ�ո�
			for(int b=num-a; b>0; b--){
				System.out.print(" ");
			}
			//��ӡ*
			for(int c=1; c<=2*a-1; c++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		//��ӡ������
		for(int a=num-1;a>0; a--){
			//��ӡ�ո�
			for(int b=0; b<num-a; b++){
				System.out.print(" ");
			}
			//��ӡ*
			for(int c=2*a-1; c>0; c--){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}








































