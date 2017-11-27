package IMooc;

public class sushu {
	public static void main(String args[]){
		int m=0;
		for(int n=3; n<=50; n++){
			boolean f=true;
			int k=2;
			while(f&&k<=(n-1)){
				if(n%k==0)
					f=false;
				k++;
			}
			if(f){
				System.out.print("\t"+n);
				m++;
				if(m%5==0)
					System.out.println();
			}
		}
	}
}
