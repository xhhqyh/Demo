package Qiyanhui;

public class HelloWorld {
	int num1;
	int num2;
	static int num3;
	public HelloWorld(){
		num1 = 91;
		System.out.println("ͨ�����췽��Ϊ����num1��ֵ");
	}
	
	{
		num2 = 74;
		System.out.println("ͨ����ʼ����Ϊ����num2��ֵ");
	}
	
	static{
		num3 = 83;
		System.out.println("ͨ����ʼ����Ϊ����num3��ֵ");
	}
	
	public static void main(String[] args){
		HelloWorld hello = new HelloWorld();
		System.out.println("num1:" + hello.num1);
		System.out.println("num2:" + hello.num2);
		System.out.println("num3:" + num3);
		HelloWorld hello2 = new HelloWorld();
	}
	
}

















