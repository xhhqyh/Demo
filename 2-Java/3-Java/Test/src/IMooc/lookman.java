package IMooc;
/*
 * 4λͬѧ��һλ���˺��£�����������4λ��˭���ĺ��¡�A˵�������ҡ���B˵�ǡ�C����C˵�ǡ�D����D˵��C��˵����
 * ��֪4����3����˵�����滰��һ����˵���Ǽٻ���������Щ��Ϣ���ҳ����˺��µ��ˣ�
 * */
public class lookman {
	public static void main(String args[]){
		int man; //1--A, 2--B, 3--C, 4--D
		for(man=1; man<=4; man++){
			int a=(man != 1)?1:0;
			int b=(man == 3)?1:0;
			int c=(man == 4)?1:0;
			int d=(man != 4)?1:0;
			if(a+b+c+d==3)
				break;
		}
		switch(man){
		case 1:
			System.out.println("the man is A");
			break;
		case 2:
			System.out.println("the man is B");
			break;
		case 3:
			System.out.println("the man is C");
			break;
		case 4:
			System.out.println("the man is D");
		}
	}
}
