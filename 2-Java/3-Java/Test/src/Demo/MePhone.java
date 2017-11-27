package Demo;

public class MePhone extends Telphone implements IPlayGame{

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("用语音打电话");
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println("用语音发短信");
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("本智能手机具有玩游戏的功能");
	}

}
