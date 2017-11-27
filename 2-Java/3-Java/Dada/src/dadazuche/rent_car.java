package dadazuche;
import java.util.Scanner;

public class rent_car {
	public static void main(String[] args) {
		//定义数组存储车型
		Car car[] = new Car[]{
				new Coach("玛莎拉蒂", 2, 1000),
				new Coach("布加迪", 2, 2000),
				new Coach("宝马4系", 4, 500),
				new Truck("五菱之光", 10, 200),
				new Truck("依维柯", 20, 1000),
				new pika("皮卡", 4,2 ,600)
		};
		
		System.out.println("***欢迎来到嗒嗒租车系统***");
		System.out.println("您要选取租车服务吗?是(1) 否(0)");
		Scanner in1 = new Scanner(System.in);
		
		//通过输入值判断是否进入租车系统
		if(in1.nextInt()== 1){
			System.out.println("车型及项目表如下：");
			System.out.println("序号\t车型\t容量\t\t\t价格(RBM/天)");
			for(int i=0; i<car.length; i++){
				System.out.println((i+1) + "\t" + car[i]);
			}
			
			System.out.println("****请输入您要租用几辆车？****");
			float num_price = 0; //总价格
			int num_people = 0; //总人数
			float num_load =0; //总载货量
			String laren = "";
			String lahuo = "";
			
			int in2 = in1.nextInt();
			for(int j=0; j<in2; j++){
				System.out.println("**请选择第"+ (j+1) +"辆车**");
				int in3 = in1.nextInt();
				System.out.println("您选择的是：" + car[in3-1].car_name);
				System.out.println("*请问要租用此车几天?*");
				int in4 = in1.nextInt();
				//计算人数、载货、价格
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
			
			System.out.println("*********您的账单如下**********");
			System.out.println("**载人的车：**");
			System.out.println(laren + "\t总载人数:" + num_people);
			System.out.println("**载物的车：**");
			System.out.println(lahuo + "\t总载货数：" + num_load);
			System.out.println("总账单为：" + num_price);
		}else {
			System.out.println("嗒嗒租车系统已退出，欢迎您的下次光临!!!");
		}
	}
}
