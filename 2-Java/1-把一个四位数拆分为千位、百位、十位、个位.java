package com.houpu;

import java.util.Scanner;


/**
 * 作业12：把一个用户输入的一个四位数分解出千位、百位、十位、个位
 * @author Administrator
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入一个四位数：");
		int num = in.nextInt();
		
		//方法一:
		if(999 < num && num < 10000 ){
			//千位
			int a = num / 1000;
			//百位
			int b = (num-a*1000)/100;
			//十位
			int c = (num-a*1000-b*100)/10;
			//个位
			int d = (num-a*1000-b*100-c*10);
			//和
			int sum = a+b+c+d;
			System.out.println("您输入的数为：" + num + "，千位为：" + a + ",百位为：" + b + ",十位为:" + c + ",个位为：" + d + "它们的和为:" + sum);
		}else {
			System.out.println("输入的值不合法");
		}
		
		//方法二
		int a = num;
		int b = 0;
		int c = 0; //用来记录循环的次数
		while(true){
			if(a < 10){
				b = a;
				c++;
				System.out.println("从末尾数第" + c + "位的值是：" + b);
				break;
			}
			
			b = a%10;
			c++;
			a = (a-b)/10;
			System.out.println("从末尾数第" + c + "位的值是：" + b);
		}
	}
}


































