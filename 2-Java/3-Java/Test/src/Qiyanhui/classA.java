package Qiyanhui;

public class classA {
	void test(int x) {
		System.out.println("test(int):" + x);
	}
	
	void test(long x) {
		System.out.println("test(long):" + x);
	}
	
	void test(double x) {
		System.out.println("test(double):" + x);
	}
	
	public static void main(String[] args) {
		classA a1 = new classA();
		a1.test(5.0);
		a1.test(5);
	}
}















