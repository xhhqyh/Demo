package IMooc;
//编写求阶乘的方法，并利用求阶乘的方法实现一个求组合的方法
//n个元素中取m个组合计算公式为:c(n,m)=n!/((n-m)!*m!),并利用求组合的方法输出如下杨辉三角形
public class jiecheng {
	//求n!的方法
	public static long fac(int n){
		long res=1;
		for(int k=2; k<=n; k++)
			res=res*k;
		return res;
	}
	
	//求n个中取m个组合的方法
	public static long com(int n, int m){
		return fac(n)/(fac(n-m)*fac(m));
	}
	
	public static void main(String args[]){
		for(int n=0; n<=3; n++){
			for(int m=0; m<=n; m++)
				System.out.print(com(n,m)+" ");
			System.out.println();
		}
	}

}
