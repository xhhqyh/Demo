package dadazuche;

//�ͳ�--ֻ����
public class Coach extends Car{
	//���췽������������ֵ
	public Coach(String name, int car_people, float price){
		this.car_name = name;
		this.num_people = car_people;
		this.price = price;
	}
	
	public String toString(){
		return (car_name + "\t" + num_people + "��" + "\t\t\t" + price);
	}
}
