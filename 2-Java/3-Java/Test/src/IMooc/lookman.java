package IMooc;
/*
 * 4位同学中一位做了好事，班主任问这4位是谁做的好事。A说“不是我”，B说是“C”，C说是“D”，D说“C胡说”。
 * 已知4人中3个人说的是真话，一个人说的是假话。根据这些信息，找出做了好事的人？
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
