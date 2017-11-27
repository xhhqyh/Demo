package Index;

/*用递归方式求阶乘*/
public class digui {
	//定义递归函数
	private static long Digui(int n){
		if(n == 1){
			return 1;
		}else{
			return n*Digui(n-1);
		}
	}
	public static void main(String[] args) {
		int n=5;
		long sum = Digui(n);
		System.out.println(sum);
	}
}
