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
	//�޲ι��췽��
	public iphone(){
		System.out.println("�����޲ι��췽��");
	}
	
	//�вι��췽��
	public iphone(float NewScreen, float newCup, float newMem){
		if(NewScreen < 3.5f){
			System.out.println("����������������Զ���ֵ3.5");
			screen = 3.5f;
		}else{
			screen = NewScreen;
		}
		cup = newCup;
		mem = newMem;
	}
}
