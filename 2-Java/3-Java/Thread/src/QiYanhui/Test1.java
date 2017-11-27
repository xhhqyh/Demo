package QiYanhui;

class Test extends Thread{
	private Bridge bridge;
	String id;
	
	public Test(String id, Bridge b) {
		bridge = b;
		this.id = id;
	}
	
	public void run() {
		bridge.getBridge();
		System.out.println(id + "正过桥...");
		try {
			Thread.sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		bridge.goDownBridge();
	}
}

class Bridge{
	private boolean engaged = false;
	
	public synchronized void getBridge(){
		while(engaged){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		engaged =true;
	}
	
	public synchronized void goDownBridge(){
		engaged = false;
		notifyAll();
	}
}

public class Test1 {
	public static void main(String args[]){
		Bridge b = new Bridge();
		Test x;
		for(int k=1; k<=4; k++){
			x = new Test("南边，第" + k + "人", b);
			x.start();
		}
		
		for(int k=1; k<=3; k++){
			x = new Test("北边，第" + k + "人", b);
			x.start();
		}
	}
}









