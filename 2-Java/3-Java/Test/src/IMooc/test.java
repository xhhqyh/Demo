package IMooc;
import javax.swing.*;

public class test{
	public static void main(String args[]){
		int score=0;
		char c[] ={'+','-','*','/'};
		for(int i=0; i<2; i++){
			int a=10 + (int)(90*Math.random());
			int b=10 + (int)(90*Math.random());
			//随机产生一个运算符
			char n = c[(int)(Math.random()*4)];
			//这里输出运算符时，要在中间加上空格，不然不能输出
			String s=JOptionPane.showInputDialog(a+" "+ n +" "+b+"=?");
			int ans=Integer.parseInt(s);
			switch(n){
			case '+':
				if(a+b==ans)
					score = score +10;
				break;
			case '-':
				if(a-b==ans)
					score = score +10;
				break;
			case '*':
				if(a*b==ans)
					score = score +10;
				break;
			case '/':
				if(a/b==ans)
					score = score +10;
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Yuor score="+score);
	}
}