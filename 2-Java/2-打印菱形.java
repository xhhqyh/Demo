package houpu2.com;

import java.util.Scanner;

/**
 * 打印菱形
 * @author Administrator
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		
		//算法一:
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要打印的菱形的上三角层数:");
		int num = in.nextInt();
		
		/*
		//打印上层三角
		for(int i=1; i<=num; i++){
			for(int j=1; j<=(2*i-1); j++){
				//输出每行前面的空格
				if(j==1){
					for(int m=1; m<=(num-i);m++){
						System.out.print(" ");
					}
				}
				//输出*
				System.out.print("*");
			}
			//换行
			System.out.println();
		}
		
		//打印下层三角
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
		
		
		//算法二:
		//打印行数
		for(int a=1;a<=num; a++){
			//打印空格
			for(int b=num-a; b>0; b--){
				System.out.print(" ");
			}
			//打印*
			for(int c=1; c<=2*a-1; c++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		//打印下三角
		for(int a=num-1;a>0; a--){
			//打印空格
			for(int b=0; b<num-a; b++){
				System.out.print(" ");
			}
			//打印*
			for(int c=2*a-1; c>0; c--){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}








































