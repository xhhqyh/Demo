package Qiyanhui;

public class B extends classA{
	private int aa;
	private int bb;
	
	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

	public int getBb() {
		return bb;
	}

	public void setBb(int bb) {
		this.bb = bb;
	}

	void test(int x){
		System.out.println("in B.test(int):" + x);
	}
	
	void test(String x, int y){
		System.out.println("in B.test.(string.int):" + x + "," + y);
	}
	
	public static void main(String[] args) {
		B bb = new B();
		bb.test(3);
	}
}
