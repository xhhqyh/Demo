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
	
	/*����log()ͨ����̬������¼�������Ķ������*/
	void log(){
		count++;
		System.out.println("you are no "+ count + " user");
	}
	
	/*����spack()������������*/
	void speak(String words){
		TalkPlace.talkArea = TalkPlace.talkArea + username + "˵��" + words + "\n";
	}
	
	public static void main(String[] args) {
		Point x1 = new Point("����", 20);
		x1.log();
		x1.speak("hello");
		Point x2 = new Point("����", 15);
		x2.log();
		x2.speak("good morning");
		x1.speak("bye");
		System.out.println("---��������������");
		System.out.println(TalkPlace.talkArea);
	}

}








