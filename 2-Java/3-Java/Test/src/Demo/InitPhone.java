package Demo;

public class InitPhone {
	public static void main(String[] args) {
		IPlayGame ip1 = new MePhone();
		ip1.playGame();
		IPlayGame ip2 = new Psp();
		ip2.playGame();
	}
}
