package IMooc;

/*
 * test1():抛出“喝大了”异常
 * test2():调用test1()，捕获“喝大了”异常，并且包装成运行时的异常，继续抛出main方法中，
 * 调用test2(),尝试test2()，尝试捕获test2()方法抛出的异常
 * 
 * 
 * */
public class ChainThrow {

	public static void main(String[] args) {
		ChainThrow ct = new ChainThrow();
		try{
			ct.test2();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void test1() throws ThinkException{
		throw new ThinkException("开车别喝酒");
	}

	public void test2(){
		try{
			test1();
		}catch(ThinkException e){
			RuntimeException newExc = new RuntimeException("司机一滴酒，亲人两行泪");
			newExc.initCause(e);
			throw newExc;
		}
	}
}
