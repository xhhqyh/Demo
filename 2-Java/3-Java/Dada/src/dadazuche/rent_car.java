package dadazuche;
import java.util.Scanner;

public class rent_car {
	public static void main(String[] args) {
		//��������洢����
		Car car[] = new Car[]{
				new Coach("��ɯ����", 2, 1000),
				new Coach("���ӵ�", 2, 2000),
				new Coach("����4ϵ", 4, 500),
				new Truck("����֮��", 10, 200),
				new Truck("��ά��", 20, 1000),
				new pika("Ƥ��", 4,2 ,600)
		};
		
		System.out.println("***��ӭ�������⳵ϵͳ***");
		System.out.println("��Ҫѡȡ�⳵������?��(1) ��(0)");
		Scanner in1 = new Scanner(System.in);
		
		//ͨ������ֵ�ж��Ƿ�����⳵ϵͳ
		if(in1.nextInt()== 1){
			System.out.println("���ͼ���Ŀ�����£�");
			System.out.println("���\t����\t����\t\t\t�۸�(RBM/��)");
			for(int i=0; i<car.length; i++){
				System.out.println((i+1) + "\t" + car[i]);
			}
			
			System.out.println("****��������Ҫ���ü�������****");
			float num_price = 0; //�ܼ۸�
			int num_people = 0; //������
			float num_load =0; //���ػ���
			String laren = "";
			String lahuo = "";
			
			int in2 = in1.nextInt();
			for(int j=0; j<in2; j++){
				System.out.println("**��ѡ���"+ (j+1) +"����**");
				int in3 = in1.nextInt();
				System.out.println("��ѡ����ǣ�" + car[in3-1].car_name);
				System.out.println("*����Ҫ���ô˳�����?*");
				int in4 = in1.nextInt();
				//�����������ػ����۸�
				num_price = car[in3-1].price*in4 + num_price;
				num_people = car[in3-1].num_people + num_people;
				num_load = car[in3-1].load + num_load;			
				if(car[in3-1].num_people != 0){
					laren = car[in3-1].car_name + " " + laren;
				}
				if(car[in3-1].load != 0){
					lahuo = car[in3-1].car_name + " " + lahuo;
				}
			}
			
			System.out.println("*********�����˵�����**********");
			System.out.println("**���˵ĳ���**");
			System.out.println(laren + "\t��������:" + num_people);
			System.out.println("**����ĳ���**");
			System.out.println(lahuo + "\t���ػ�����" + num_load);
			System.out.println("���˵�Ϊ��" + num_price);
		}else {
			System.out.println("���⳵ϵͳ���˳�����ӭ�����´ι���!!!");
		}
	}
}
