package Qiyanhui;

import java.awt.Color;

public class Pixel extends Point{
	Color c;
	
	public Pixel(int x, int y, Color c){
		super(x, y);
		this.c = c;
	}
	
	public String toString(){
		return super.toString() + "ÑÕÉ«£º" + c;
	}
	
	public static void main(String a[]){
		Pixel x = new Pixel(3, 24, Color.blue);
		System.out.println(x);
	}
}
