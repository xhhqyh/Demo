package com.houpu;

import java.util.Scanner;


/**
 * ��ҵ12����һ���û������һ����λ���ֽ��ǧλ����λ��ʮλ����λ
 * @author Administrator
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("������һ����λ����");
		int num = in.nextInt();
		
		//����һ:
		if(999 < num && num < 10000 ){
			//ǧλ
			int a = num / 1000;
			//��λ
			int b = (num-a*1000)/100;
			//ʮλ
			int c = (num-a*1000-b*100)/10;
			//��λ
			int d = (num-a*1000-b*100-c*10);
			//��
			int sum = a+b+c+d;
			System.out.println("���������Ϊ��" + num + "��ǧλΪ��" + a + ",��λΪ��" + b + ",ʮλΪ:" + c + ",��λΪ��" + d + "���ǵĺ�Ϊ:" + sum);
		}else {
			System.out.println("�����ֵ���Ϸ�");
		}
		
		//������
		int a = num;
		int b = 0;
		int c = 0; //������¼ѭ���Ĵ���
		while(true){
			if(a < 10){
				b = a;
				c++;
				System.out.println("��ĩβ����" + c + "λ��ֵ�ǣ�" + b);
				break;
			}
			
			b = a%10;
			c++;
			a = (a-b)/10;
			System.out.println("��ĩβ����" + c + "λ��ֵ�ǣ�" + b);
		}
	}
}


































