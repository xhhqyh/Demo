package Demo2;

/*
 * 比较String和StringBuffer的区别
 * 运行结果：
 * 		学海无涯苦作舟
		String 的str1 的hascode为：-2054942391
		String 的str1 的hascode为：1658835910
		学海无涯苦作舟，人间正道是苍桑
		StringBuffer 的 hascode 为：366712642
		添加字符串后StringBuffer的hascode为：366712642
		sb1=弟子规,圣人,海纳百川教
		sb2=弟子规,圣人,海纳百川教
 * */
public class Test {
	public static void main(String[] args) {
		//String的实验
		String str1 = "学海无涯苦作舟";
		System.out.println(str1);
		System.out.println("String 的str1 的hascode为：" + str1.hashCode());
		str1 = str1 + "，人间正道是苍桑";
		System.out.println("String 的str1 的hascode为：" + str1.hashCode());
		System.out.println(str1);
		
		//StringBuffer的实验比较
		StringBuffer sb1 = new StringBuffer("弟子规");
		System.out.println("StringBuffer 的 hascode 为：" + sb1.hashCode());
		StringBuffer sb2 = sb1.append(",圣人教");  //注意sb1和sb2指向同一个地址
		System.out.println("添加字符串后StringBuffer的hascode为：" + sb2.hashCode());
		sb2.insert(6, ",海纳百川");
		System.out.println("sb1=" + sb1);
		System.out.println("sb2=" + sb2);
	}
}


























