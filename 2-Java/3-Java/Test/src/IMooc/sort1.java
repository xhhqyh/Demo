package IMooc;

public class sort1 {
	public static void main(String args[]){
		int a[]={4, 6, 3, 8, 5, 3, 7, 1, 9, 2};
		int n=a.length;
		System.out.println("����ǰ...");
		for(int k=0; k<n; k++)
			System.out.print(" " + a[k]);
		System.out.println();
		//һ�½�������
		/*for(int i=0; i<n-1; i++)
			for(int j=i+1; j<n; j++)
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}*/
		//��ϵͳ������������
		java.util.Arrays.sort(a);
		
		System.out.println("�����...");
		for(int k=0; k<n; k++){
			System.out.print(" " + a[k]);
		}
	}
}
