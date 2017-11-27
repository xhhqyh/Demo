package Exception;
import java.util.*;

/*
 * 模拟借书系统
 * 		1)定义字符串数组保存图书信息
 * 		2)提示用户输入，分别按“书名” 和 “图书序号”查找图书
 * 		3)根据输入信息进行适当的异常处理
 * 			a.如果输入类型错误，抛出“错误命令异常”，并提示重新输入
 * 			b.如果书名不存在，抛出“图书不存在异常”,并提示重新输入
 * 			c.如果图书序号超过字符串数组范围，抛出"图书不存在异常",并提示输入
 * */
public class Book {
	private String[] books = new String[4]; //定义存储书的数组
	private String road;  //存储用户输入的数据
	
	public static void main(String[] args) {
		Book book = new Book();
		book.initbook();
		book.Findbook();
		
	}
	//初始化书信息
	void initbook(){
		books[0] = "计算机网络";
		books[1] = "数据结构";
		books[2] = "设计模式";
		books[3] = "操作系统";
	}
			
	//查找书籍
	void Findbook(){
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("请输入要查询的书名或者书号:");
			road = in.next();
			if(Checkroad())
				CheckNum();
			else
				CheckName();
			System.out.println("是否继续查阅图书？是(1):否(0)");
			int in2 = in.nextInt();
			if(in2 == 1)
				Findbook();
			else
				System.out.println("您已退出图书系统,欢迎下次光临");
		}catch(BookException e){
			System.out.println("图书不存在");
			Findbook();
		}finally{
			in.close();
		}
	}
	
	//判断输入的值是不是数字
	boolean Checkroad(){
		try{
		    Integer.parseInt(road);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//按数字查找
	void CheckNum() throws BookException{
		//road是字符串，要转成int型
		int num = Integer.parseInt(road);
		if(num>0 && num<5)
			System.out.println("书名是：" + books[num-1]);
		else
			throw new BookException();
	}
	
	//按名字查找
	void CheckName() throws BookException{
		String name = road;
		for(String book:books){
			if(book.equals(name)){
				System.out.println("您要查找的书在馆,书名为:" + name);
				return;
			}
			throw new BookException();
		}
	}
}


















