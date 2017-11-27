package Qiyanhui;

public class InitAnimal {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Animal animal = dog; //向下类型转换 自动类型转换
		if(animal instanceof Dog){
			Dog dog2 = (Dog)animal;
		}else{
			System.out.println("无法进行Dog类型转换");
		}
		
		if(animal instanceof Cat){
			Cat cat = (Cat)animal;
		}else{
			System.out.println("无法进行Cat类型转换");
		}
	}
}
