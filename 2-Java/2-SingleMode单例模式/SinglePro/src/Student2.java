
public class Student2 {

	private int stuId ;
	private String stuName = "";
	private char sex = 'ÄÐ' ;
	private int age ;
	
	private static Student2 student2 = null ;
	
	private Student2(){
		
	}
	
	public static Student2 getSingleStu(){
		if(student2 == null){
			student2 = new Student2();
		}
		return student2;
	}
	
	
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	


}
