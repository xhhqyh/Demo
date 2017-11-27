package dadazuche;

//货车--只载货
public class Truck extends Car{
	//构造方法，给变量赋值
	public Truck(String name, float load, float price){
		this.car_name = name;
		this.load = load;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + load + "吨" + "\t\t\t" + price);
	}
}
