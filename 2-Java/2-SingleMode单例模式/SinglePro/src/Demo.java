
public class Demo {
	
	public static void main(String[] args) {
		// 面试题： 你知道哪些设计模式？ 单例模式怎么写？
		//单例模式
		
		Student2 st2 = Student2.getSingleStu();
		st2.setStuName("gaozhiwen");
		st2.setAge(22);
		st2.setSex('男');
		st2.setStuId(111);
		System.out.println("==============");
		System.out.println("single --> "+st2.getStuName());
		System.out.println("single --> "+st2.getAge());
		System.out.println("single --> "+st2.getSex());
		System.out.println("single --> "+st2.getStuId());
		System.out.println("==============");
		Student2 st3 = Student2.getSingleStu();
		st3.setStuName("wangyahui");
		System.out.println("single 2--> "+st2.getStuName());
		System.out.println("single 2--> "+st3.getStuName());
		System.out.println("single 2--> "+st3.getAge());
		System.out.println("single 2--> "+st3.getSex());
		System.out.println("single 2--> "+st3.getStuId());
		System.out.println("==============");
		
		
		
		
		
//		Student stu1 = new Student();
//		stu1.setAge(12);
//		stu1.setSex('女');
//		stu1.setStuId(111);
//		stu1.setStuName("zhangsan");
//		
//		Student stu2 = new Student();
//		stu2.setAge(14);
//		stu2.setSex('男');
//		stu2.setStuId(222);
//		stu2.setStuName("lisi");
//		
//		System.out.println(stu1.getStuName());
//		System.out.println(stu2.getStuName());
//		System.out.println(stu1.getStuName());
	}

}
