package dadazuche;

//����--ֻ�ػ�
public class Truck extends Car{
	//���췽������������ֵ
	public Truck(String name, float load, float price){
		this.car_name = name;
		this.load = load;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + load + "��" + "\t\t\t" + price);
	}
}
