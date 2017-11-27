package HouPu;

/**
 * 挑选水仙花数
 * @author Administrator
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		/*for(int i=100; i< 1000; i++){
			//百位
			int a = i/100;
			int b = (i-a*100)/10;
			int c = i-a*100-b*10;
			
			int water = a*a*a + b*b*b + c*c*c;
			if(water == i){
				System.out.print(i + " ");
			}
		}*/
		
		/*for(int i=1; i<10; i++){
			for(int j=0; j<10; j++){
				for(int k=0; k<10; k++){
					if((i*100 + j*10 + k) == (i*i*i + j*j*j + k*k*k)){
						System.out.println(i*100 + j*10 + k);
					}
				}
			}
		}*/
		
		//冒泡排序
		int [] aa = {2, 44, 22, 54,1,8};
		System.out.println(aa.length);
		for(int i=0; i<aa.length; i++){
			for(int j=i; j<aa.length; j++){
				if(aa[i] > aa[j]){
					int max = aa[i];
					aa[i] = aa[j];
					aa[j] = max;
				}
			}
		}
		
		for(int k=0; k<aa.length; k++){
			System.out.println(aa[k]);
		}
		
	}
}













