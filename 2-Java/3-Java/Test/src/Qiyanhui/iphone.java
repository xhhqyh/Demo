package Qiyanhui;
import Qiyanhui.iphone;
public class iphone {
	private float screen;
	private float cup;
	private float mem;
	
	public void setScreen(float newScreen){
		screen = newScreen;
	}
	
	public float getScreen(){
		return screen;
	}
	//无参构造方法
	public iphone(){
		System.out.println("我是无参构造方法");
	}
	
	//有参构造方法
	public iphone(float NewScreen, float newCup, float newMem){
		if(NewScreen < 3.5f){
			System.out.println("您输入的数据有误，自动赋值3.5");
			screen = 3.5f;
		}else{
			screen = NewScreen;
		}
		cup = newCup;
		mem = newMem;
	}
}
