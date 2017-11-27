package IMooc;
/*
 * 参数传递演示：
 * 		1）对于基本数据类型的参数，其对应的内存单元存放的是变量的值，因此，它是将实参的值传递给形参单元。
 * 		      这种情形下，对形参和实参的访问操纵的是不同的内存单元，因此在方法内对形参数据的任何修改不会影响实参。
 * 		2）对于引用类型（如对象、数组等）的参数变量，实参和形参单元中存放的是引用地址，参数传递是将实参存放的引用地址给形参。
 * 		  这样，实参和形参引用的是同一对象或同一数组。因此，对形参所引用对象成员或数组元素的更改将直接影响实参对象或数组。
 * */
public class canshu {
	static void paraPass(int x, int y[]){
		x=x+1;
		y[1]=y[1]+1;
		System.out.println("x=" + x);
	}
	
	public static void main(String args[]){
		int m=5;
		int a[]={1, 4, 6, 3};
		paraPass(m, a);
		System.out.println("m=" + m);
		for(int k=0; k<a.length; k++)
			System.out.print(a[k] + "\t");
	}
}
