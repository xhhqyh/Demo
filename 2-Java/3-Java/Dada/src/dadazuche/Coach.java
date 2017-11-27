package dadazuche;

//客车--只载人
public class Coach extends Car{
	//构造方法，给变量赋值
	public Coach(String name, int car_people, float price){
		this.car_name = name;
		this.num_people = car_people;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + num_people + "人" + "\t\t\t" + price);
	}
}
