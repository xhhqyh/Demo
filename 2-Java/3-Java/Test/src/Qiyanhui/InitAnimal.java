package Qiyanhui;

public class InitAnimal {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Animal animal = dog; //��������ת�� �Զ�����ת��
		if(animal instanceof Dog){
			Dog dog2 = (Dog)animal;
		}else{
			System.out.println("�޷�����Dog����ת��");
		}
		
		if(animal instanceof Cat){
			Cat cat = (Cat)animal;
		}else{
			System.out.println("�޷�����Cat����ת��");
		}
	}
}
