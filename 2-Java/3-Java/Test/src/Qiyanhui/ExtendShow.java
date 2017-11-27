package Qiyanhui;

public class ExtendShow extends Supershow{
	int y = 20;
	int z = 1;
	 void show(){
		System.out.println("ext.show,y=" + y);
	}
	public static void main(String[] ass) {
		ExtendShow b = new ExtendShow();
		Supershow a = b;
		System.out.println("ext.y=" + b.y);
		System.out.println("sup.y=" + a.y);
		b.show();
		a.show();
		System.out.println("z=" + b.z + ",m=" + b.m);
	}
}

