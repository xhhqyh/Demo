package HouPu;

import java.util.Scanner;

/**
 * 交换数组元素:
 * 		.定义一个方法，实现数组元素交换的功能，具体要求如下：在主函数中接收10个数存入数组，在自定义函数中，
    	将该数组中的最大值与第一个元素交换，最小值与最后一个元素交换，然后在主函数中输出交换后的数组(注意：默认数组中的10个数是不重复的)
 * @author Administrator
 *
 */
public class demo5 {
	
	public static void change(int a[]){
		int max = a[0];
		int maxi = 0;  //记录最大的i值 
		int min = a[0];
		int mini = 0;  //记录最小的i值
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
		
		//如果maxi=9 mini=1
		if(maxi == 9 && mini == 0){
			int temp = a[0];
			a[0] = a[9];
			a[9] = temp;
			return;
		}
		
		//最大值与a[0]交换
		a[maxi] = a[0];
		a[0] = max;
		
		//最小值与a[0]交换
		a[mini] = a[9];
		a[9] = min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//定义一个数组
		int[] arr = new int[10];
		
		System.out.println("请您依次输入十个元素的值:");
		int i=0;
		while(true){
			int num = in.nextInt();
			arr[i] = num;
			i++;
			
			if(i==10){
				break;
			}
		}
		
		//变换前输出数组元素
		System.out.println("交换前为：");
		for(int j=0; j<arr.length; j++){
			
			System.out.print(arr[j] + " ");
		}
		System.out.println();
		
		System.out.println("交换后:");
		change(arr);
		
		for(int m=0; m<arr.length; m++){
			System.out.print(arr[m] + " ");
		}
	}
}







































