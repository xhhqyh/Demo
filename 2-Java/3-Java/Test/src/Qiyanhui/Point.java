package Qiyanhui;
/*
 * equals��==������
 * ���������û��toString�������򷵻�x=Qiyanhui.Point@15db9742
 * */
public class Point {
	private int x, y;
	 //�вι��췽��
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p){
		return (x == p.x && y == p.y);
	}
	
	public String toString(){
		return "�㣺" + x + "," + y;
	}
	public static void main(String[] args) {
		Point x = new Point(4, 3);
		System.out.println("x=" + x);
		System.out.println(x.equals(new Point(4, 3)));
	}
}


























