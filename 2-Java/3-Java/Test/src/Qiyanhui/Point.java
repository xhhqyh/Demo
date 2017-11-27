package Qiyanhui;
/*
 * equals与==的区别
 * 本例中如果没有toString函数，则返回x=Qiyanhui.Point@15db9742
 * */
public class Point {
	private int x, y;
	 //有参构造方法
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p){
		return (x == p.x && y == p.y);
	}
	
	public String toString(){
		return "点：" + x + "," + y;
	}
	public static void main(String[] args) {
		Point x = new Point(4, 3);
		System.out.println("x=" + x);
		System.out.println(x.equals(new Point(4, 3)));
	}
}


























