package dadazuche;

//Ƥ��--���������ػ�
public class pika extends Car{
	//���췽������������ֵ
	public pika(String name, int car_people, float load, float price){
		this.car_name = name;
		this.num_people = car_people;
		this.load = load;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + num_people + "��" + " " + load + "��" + "\t\t\t" + price);
	}
}
