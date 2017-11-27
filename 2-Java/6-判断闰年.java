package houpu.com;

/**
 * 作业四：将1998~2020年之间的闰年年份输出
 * 		 闰年满足的条件(满足一个条件即可):
 * 			1)能被4整除，不能被100整除
 *          2)能被400整除
 * @author Administrator
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		for(int i=1998; i<=2020; i++){
			int a=i%4;
			int b=i%100;
			int c=i%400;
			
			if(c == 0 || (a == 0 && b != 0)){
				System.out.println(i + "是闰年");
			}
		}
	}
}
