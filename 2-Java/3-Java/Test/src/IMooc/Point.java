package IMooc;

class TalkPlace{
	static String talkArea="";
}
public class Point {
	static int count=0;
	String username;
	int age;
	
	public Point(String name, int yourage){
		username = name;
		age = yourage;
	}
	
	/*方法log()通过静态变量记录调用它的对象次数*/
	void log(){
		count++;
		System.out.println("you are no "+ count + " user");
	}
	
	/*方法spack()向讨论区发言*/
	void speak(String words){
		TalkPlace.talkArea = TalkPlace.talkArea + username + "说：" + words + "\n";
	}
	
	public static void main(String[] args) {
		Point x1 = new Point("张三", 20);
		x1.log();
		x1.speak("hello");
		Point x2 = new Point("李四", 15);
		x2.log();
		x2.speak("good morning");
		x1.speak("bye");
		System.out.println("---讨论区内容如下");
		System.out.println(TalkPlace.talkArea);
	}

}








