package IMooc;

/*
 * test1():�׳����ȴ��ˡ��쳣
 * test2():����test1()�����񡰺ȴ��ˡ��쳣�����Ұ�װ������ʱ���쳣�������׳�main�����У�
 * ����test2(),����test2()�����Բ���test2()�����׳����쳣
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
		throw new ThinkException("������Ⱦ�");
	}

	public void test2(){
		try{
			test1();
		}catch(ThinkException e){
			RuntimeException newExc = new RuntimeException("˾��һ�ξƣ�����������");
			newExc.initCause(e);
			throw newExc;
		}
	}
}
