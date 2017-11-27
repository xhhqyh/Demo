package Qiyanhui;
/*
 *从复数方法理解多态性 
 * */
public class Complex {
	private double x, y;
	
	public Complex(double real, double imaginary){
		x = real;
		y = imaginary;
	}
	
	public String toString(){
		return "(" + x +", " + y + "i" + ")";
	}
	
	//方法一：将复数与另一复数a相加
	public Complex add(Complex a){
		return new Complex(x + a.x, y + a.y);	
	}
	
	//方法二：将复数与另一个由两实数a、b构成的复数相加
	public Complex add(double a, double b){
		return new Complex(x+a, y+b);
	}
	
	//方法三：将两复数a和b相加
	public static Complex add(Complex a, Complex b){
		return new Complex(a.x + b.x, a.y + b.y);
	}
	
	public static void main(String[] args) {
		Complex x, y, z;
		x = new Complex(4, 5);
		y = new Complex(3.4, 2.8);
		z = add(x, y);
		System.out.println("result1=" + z);
		z=x.add(y);
		System.out.println("result2=" + z);
		z=x.add(6,8);
		System.out.println("result3=" + z);
	}
}

























