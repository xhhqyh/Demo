package dadazuche;

//皮卡--既载人又载货
public class pika extends Car{
	//构造方法，给变量赋值
	public pika(String name, int car_people, float load, float price){
		this.car_name = name;
		this.num_people = car_people;
		this.load = load;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + num_people + "人" + " " + load + "吨" + "\t\t\t" + price);
	}
}
