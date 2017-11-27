package cjdx.com;

import java.util.Scanner;

/**
 * 作业六：
 * 	        某公司采用公用电话传递数据，数据是4位整数，在传递过程中是加密的，加密规则如下：
 * 		每位上的数字加上5，然后用和除以10的余数代替该数字，再将第一位和第四位交换，
 * 		第二位和第三位交换，编写一个程序，用于接受一个4位整数，并且打印输出加密后的数字
 * @author Administrator
 *
 */
public class Demo6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("请您输入一个数字：");
		
		int a = in.nextInt();
		String astr = Integer.toString(a); //把整型转换成字符串
		int number = astr.length();  //计算输入的数字的长度，用来定义数组的长度
		int[] arr = new int[number];
		
		int b = 0;  //用来存储求出的某一位的树值
		int c = 0; //用来记录循环的次数
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
		
		//输出分解好并存储好的数组值
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		//输出每位上的数字加上5，然后用和除以10的余数代替该数字后的数组
		for(int j=0; j<arr.length; j++){
			arr[j] = (arr[j]+5)%10;
			System.out.print(arr[j] + " ");
		}
		
		System.out.println();
		//把数组中的第一位和最后一位，第二位和倒数第二位...兑换
		for(int k=0; k<arr.length/2; k++){
			int num = arr[k];
			arr[k] = arr[arr.length-k-1];
			arr[arr.length-k-1] = num;
		}
		
		System.out.println();
		//输出最后的密码值
		for(int m=0; m<arr.length; m++){
			System.out.print(arr[m] + " ");
		}
		
	}
}

































