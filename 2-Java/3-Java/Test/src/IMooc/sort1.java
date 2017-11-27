package IMooc;

public class sort1 {
	public static void main(String args[]){
		int a[]={4, 6, 3, 8, 5, 3, 7, 1, 9, 2};
		int n=a.length;
		System.out.println("排序前...");
		for(int k=0; k<n; k++)
			System.out.print(" " + a[k]);
		System.out.println();
		//一下进行排序
		/*for(int i=0; i<n-1; i++)
			for(int j=i+1; j<n; j++)
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}*/
		//用系统函数进行排序
		java.util.Arrays.sort(a);
		
		System.out.println("排序后...");
		for(int k=0; k<n; k++){
			System.out.print(" " + a[k]);
		}
	}
}
