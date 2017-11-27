#  Java数据库-JDBC基础知识
	
[toc]

## 一、JDBC简介
JDBC是连接java应用程序和数据库之间的桥梁。

### 1、什么是JDBC?
		
	   为支持Java程序的数据库操作功能，Java语言采用了专门的Java数据库编程接口JDBC(Java Database Connectivity)。JDBC类库中的类依赖于驱动程序管理器，不同数据库需要不同的驱动程序。驱动程序管理器的作用是通过JDBC驱动程序建立与数据库的连接。

### 2、什么是JDBC API？

	    Java应用程序通过JDBC API（java.sql）与数据库连接，而实际的动作则由JDBC驱动程序管理器（JDBC Driver Manager）通过JDBC驱动程序与数据库系统进行连接。

![这里写图片描述](http://img.blog.csdn.net/20170703154520182?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzE2ODMxMjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

JDBC库中所包含的API任务通常与数据库使用：
	
	* 连接到数据库

	* 创建SQL或MySQL语句

	* 在数据库中执行SQL或MySQL查询

	* 查看和修改记录
	

比如：![这里写图片描述](http://img.blog.csdn.net/20170703154718962?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzE2ODMxMjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


---
## 二、JDBC女屌丝实例详解
	
### 1、编程准备

**1、编程准备**
		
	* 明确目的：需求（做什么）
                -拥有女神禁区，享有查看，添加，修改，删除等功能。
    * 指导思想：概设详设（怎么做）
    * 工具准备：MySQL，MyEclipse，Navicat
    * 埋头苦干：编码
    * 实战演练：测试
    * 大功告成：系统上线


 **2、JDBC使用详解**

	JDBC编程步骤：
    * 加载驱动程序：Class.forName(driverClass)
      加载Mysql驱动：Class.forName("com.mysql.jdbc.Driver");
      加载Oracle驱动：Class.forName("oracle。jdbc.driver.OracleDriver");
      
    * 获得数据库连接：
      DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc","root","root");
      
    * 创建Statement对象：
      conn.createStatement();





 **4、详细设计**

![这里写图片描述](http://img.blog.csdn.net/20170703160756086?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzE2ODMxMjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![这里写图片描述](http://img.blog.csdn.net/20170703160851484?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzE2ODMxMjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

---

### 2、打通数据库

---

先新建Java 工程，将jar包导进去：
 加载驱动到Eclipse中
	
	*  复制驱动到项目的lib下--> 右键BuildPath --> Add to Build Path
然后新建相应的数据库和表。

编写DBUtil.java

```java
package Girl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 这个工具类提供数据库的连接
 * @author 小灰灰
 */
public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/test";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	//写一个静态块,最早执行
	static{
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库的连接
		    conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//对外提供一个方法，以获取这个连接
	public static  Connection getConnection(){
		return conn;
	}
}

```

---

###  3、搭建模型层

---
编写Goddess.java
文件：封装数据表字段，方便数据的存取

```java
package Girl.model;
import java.util.Date;

/**
 * 封装数据表字段
 * @author 小灰灰
 *
 */
public class Goddess {
	//数据表字段
	private Integer id;
	private String user_name;
	private Integer sex=1; //给性别一个默认值为1
	private Integer age;
	private Date birthday;
	private String email;
	private String mobile;
	private String create_user;
	private String update_user;
	private Date create_date;
	private Date update_date;
	private Integer isdel=0;
	
	//生成get()和set()方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "Goddess [id=" + id + ", user_name=" + user_name + ", sex=" + sex + ", age=" + age + ", birthday="+ birthday + ", email=" + email + ", mobile=" + mobile + ", create_user=" + create_user+ ", update_user=" + update_user + ", create_date=" + create_date + ", update_date=" + update_date+ ", isdel=" + isdel + "]";
	}
}

```

然后编写模型层的数据处理类：GoddessDao.java--(CRUD操作)

```java
package Girl.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Girl.db.DBUtil;
import Girl.model.Goddess;

/**
 * 模型层：主要是通过对数据的操作
 * 		1、在操作之前必须连接数据库
 * 		2、新增女屌丝方法
 * 		3、修改女屌丝方法
 * 		4、删除女屌丝方法
 * 		5、查找女屌丝方法
 * 		6、根据名字模糊查找女屌丝方法
 * @author 小灰灰
 */
public class GoddessDao {
	//新增女神
	public void addGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          "insert into imooc_goddess" +
				  "(user_name,sex,age,birthday,email,mobile," +
		          "create_user,create_date,update_user,update_date,isdel)" +
				  "values(" +
		          "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		
		//预编译SQL语句
		//这个方法会将这个SQL语句加载到驱动程序的执行程序中，但是并不直接执行
		//当调用Excute()方法时真正执行
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//因为我们传进的是java.util类型的值，但是需要java.sql类型的值,因此要进行转换
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}
	
	//修改女神
	public void updateGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " update imooc_goddess " +
				  " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
		          " update_user=?,update_date=current_date(),isdel=? " +
				  " where id=?";
		
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//因为我们传进的是java.util类型的值，但是需要java.sql类型的值,因此要进行转换
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7,g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9,g.getId());
		ptmt.execute();
	}
	
	//删除女神
	public void delGoddess(Integer[] ids) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " delete from imooc_goddess " +
				  " where id=?";
		
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//同时删除多个数据
		for(int i=0; i<ids.length; i++){
			ptmt.setInt(1,ids[i]);
			ptmt.execute();
		}
	}
	
	//查询女神
	public List<Goddess> query() throws Exception{
		Connection conn=DBUtil.getConnection();
		//通过数据库的连接操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			
			//执行查询语句
			ResultSet rs=stmt.executeQuery("select id,user_name,age from imooc_goddess");
			
			//返回一个List
			List<Goddess> gs=new ArrayList<Goddess>();
			Goddess g=null;
			while(rs.next()){
				g=new Goddess();
				//把在数据库中查询到的值通过类Goddess获取到
				g.setId(rs.getInt("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getInt("age"));
				
				gs.add(g);
			}
			return gs;
	}
	
		//根据姓名查询女神
		public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
			List<Goddess> gs=new ArrayList<Goddess>();
			
			Connection conn=DBUtil.getConnection();
			StringBuilder sb=new StringBuilder();
			
			//注意这里加一个1=1很重要的一个点，也是开发中经常用到的一个点
			sb.append("select * from imooc_goddess where 1=1");
			
			if(params!=null && params.size()>0){
				for(int i=0; i<params.size(); i++){
					Map<String, Object> map=params.get(i);
					sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
				}
			}
			
			PreparedStatement ptmt=conn.prepareStatement(sb.toString());
			ResultSet rs=ptmt.executeQuery();
				
			Goddess g=null;
			while(rs.next()){
				g=new Goddess();
				g.setId(rs.getInt("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getInt("age"));
				g.setSex(rs.getInt("sex"));
				g.setBirthday(rs.getDate("birthday"));
				g.setEmail(rs.getString("email"));
				g.setMobile(rs.getString("mobile"));
				g.setCreate_date(rs.getDate("create_date"));
				g.setCreate_user(rs.getString("create_user"));
				g.setUpdate_date(rs.getDate("update_date"));
				g.setUpdate_user(rs.getString("update_user"));
				g.setIsdel(rs.getInt("isdel"));
				
				gs.add(g);
			}
			return gs;
		}
	
	//查询单个女神
	public Goddess get(Integer id) throws SQLException{
		Goddess g=null;
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " select * from imooc_goddess " +
				  " where id=?";
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setInt(1,id);
		//此地不能使用execute()这个是执行操作，我们要使用查询操作
		//然后会得到一个结果集
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			g=new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
}
```
PS：CRUD：增加(Create)、读取(Retrieve)（重新得到数据-->高级应用：报表、分页）、更新(Update)和删除(Delete)

---
###  4、搭建控制层

---
控制层起到一个桥梁的作用，连接模型层和视图层


编写GoddessAction.java

```java
package Girl.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Girl.dao.GoddessDao;
import Girl.model.Goddess;

/**
 * 控制层：主要逻辑处理，接收视图层的请求，控制模型层数据处理
 * @author 小灰灰
 */
public class GoddessAction {
	//添加
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.addGoddess(goddess);
	}
	
	//得到一个女神
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
	}
	
	//修改
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	//删除
	public void del(Integer[] ids) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(ids);
	}
	
	//查询
	public List<Goddess> query() throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	
	//模糊匹配
	public List<Goddess> queryname(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}
}
```

---
### 5、搭建视图层


---
  1、流程：
        * 程序启动后，一直保持在运行状态
        * 循环接收控制台的输入参数
        * 调用Action(控制层)响应，并将返回结果展示在控制台中
        * 直到输入特定的输入标记(如EXIT)后，程序退出
        
    2、问题点
        * 循环接收参数
        * 某个功能的保持



编写类View.java

```java
package Girl.view;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Girl.action.GoddessAction;
import Girl.model.Goddess;

/**
 * 视图层：该层主要解决2个问题
 * 		1、怎么让程序一直运行
 * 			while循环，scan.hasNext()函数是当有输入时一直循环，否则不循环
 * 		2、怎么保证一个功能运行完在执行其他功能
 * 			* 定义一个步数，然后一步步增加
 * 			* 定义一个常量，标记当前功能操作
 * @author 小灰灰
 */
public class View {
	//提示语
	private static final String CONTEXT="欢迎来到女屌丝禁区:\n" +
										"[M]:主菜单\n" +
										"[Q]:查看全部女屌丝的信息\n" +
										"[G]:查看某位女屌丝的详细信息\n" +
										"[S]:根据姓名模糊查询女屌丝信息\n" +
										"[A]:添加女屌丝信息\n" +
										"[U]:更新女屌丝信息\n" +
										"[D]:删除女屌丝信息\n" +
										"[B]:退出当前功能，返回主菜单\n" +
										"[E]:退出女屌丝禁区\n" +
										"请输入您要体验的项目:";
	
	//操作标记
	private static final String OPERATION_MIAN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args) throws SQLException {
		System.out.println(CONTEXT);
		
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		Goddess goddess=new Goddess();
		GoddessAction action=new GoddessAction();
		//定义一个记忆变量,记忆上一次是请求的哪一个模块
		String prenious=null;
		//步骤标记
		Integer step=1;
		
		//while循环，scan.hasNext()函数是当有输入时一直循环，否则不循环
		while(scan.hasNext()){
			String in=scan.next().toString();
			//退出女屌丝禁区
			if(OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("您以成功退出女屌丝禁区");
				break;
			}
			
			//返回当前主菜单
			if(OPERATION_MIAN.equals(in.toUpperCase()) || OPERATION_MIAN.substring(0, 1).equals(in.toUpperCase())){
				step = 1;
				prenious = null;
				System.out.println(CONTEXT);
			}
			
			//退出当前功能，返回主菜单
			if(OPERATION_BREAK.equals(in.toUpperCase()) || OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())){
				//返回当前主菜单
				step = 1;
				prenious = null;
				System.out.println(CONTEXT);
			}
			
			//查看全部女屌丝功能
			if(OPERATION_QUERY.equals(in.toUpperCase()) || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<Goddess> list=action.query();
					//然后将返回内容输出
					for (Goddess goddess2 : list) {
						System.out.println("编号:" + goddess2.getId()+ " 姓名:"+goddess2.getUser_name());
					}
					System.out.println("请输入您要体验的项目:");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//查看某位女神的详细信息
			if(OPERATION_GET.equals(in.toUpperCase()) || OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_GET.equals(prenious)){
				prenious=OPERATION_GET;
				if(1==step){
					System.out.println("请输入要查看女屌丝的[ID]:");
				}else if(2==step){
					try {
						goddess=action.get(Integer.valueOf(in));
						if (goddess != null) { 
							step = 1;
							prenious = null;
							System.out.println("编号：" + goddess.getId() +
									"\n姓名：" + goddess.getUser_name() +
									"\n性别：" + (goddess.getSex() == 1 ? "女":"男") +
									"\n年龄：" + goddess.getAge() + "\n生日：" +
									goddess.getBirthday() + "\n邮箱：" +
									goddess.getEmail() + "\n手机号：" +
									goddess.getMobile()); 
						}else {
							step = 1; 
							prenious = null; 
							System.out.println("查询的女神不存在！"); 
						}
					} catch (NumberFormatException e) {
						step = 1;
						prenious = null;
						System.out.println("请输入正确的女屌丝[ID]:");
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("查询女屌丝详细信息失败!!!");
					}
				}
				//步数加1
				if(OPERATION_GET.equals(prenious)){
					step++;
				}
			}
			
			//根据姓名，模糊查询
			if(OPERATION_SEARCH.equals(in.toUpperCase()) || OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_SEARCH.equals(prenious)){
				prenious=OPERATION_SEARCH;
				if(1==step){
					System.out.println("请输入要查询的女屌丝的姓名，以查看详细信息：");
				}else if(2==step){
					List<Map<String, Object>> params=new ArrayList<Map<String, Object>>();
					
					Map<String, Object> map=new HashMap<String, Object>();
					//追加的SQL语句字段
					map.put("name", "user_name");
					map.put("rela", "=");
					map.put("value", "'"+in+"'");
					
					params.add(map);
					List<Goddess> result;
					try {
						result = action.queryname(params);
						for(int i=0; i<result.size(); i++){
							System.out.println("编号：" + result.get(i).getId() +
									"\n姓名：" + result.get(i).getUser_name() +
									"\n性别：" + (result.get(i).getSex() == 1 ? "女":"男") +
									"\n年龄：" + result.get(i).getAge() + "\n生日：" +
									result.get(i).getBirthday() + "\n邮箱：" +
									result.get(i).getEmail() + "\n手机号：" +
									result.get(i).getMobile()); 
						}
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("查询女屌丝信息失败");
					}
				}
				if(OPERATION_SEARCH.equals(prenious)){
					step++;
				}
			}
			
			//新增女屌丝
			if(OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)){
				prenious=OPERATION_ADD;
				if(1==step){
					System.out.println("请输入女屌丝的[姓名]");
				}else if(2==step){
					goddess.setUser_name(in);
					System.out.println("请输入女屌丝的[年龄]");
				}else if(3==step){
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女屌丝[生日],格式：yyyy-MM-dd");
				}else if(4==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("请输入女屌丝的[邮箱]");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入");
						step=3;
					}
				}else if(5==step){
					goddess.setEmail(in);
					System.out.println("请输入女屌丝的[手机号]");
				}else if(6==step){
					goddess.setMobile(in); 
					
					try {
						action.add(goddess);
						System.out.println("新增女屌丝成功");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("新增女屌丝失败");
					}
				}
				
				if(OPERATION_ADD.equals(prenious)){
					step++;
				}
			}
			
			//女屌丝更新功能	
			if(OPERATION_UPDATE.equals(in.toUpperCase()) || OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_UPDATE.equals(prenious)){

				prenious = OPERATION_UPDATE;
				if(1==step){
					System.out.println("请输入要修改的女屌丝的[ID]:");
				}else if(2==step){
					try{
						Integer id = Integer.valueOf(in);
						goddess = action.get(id);
						if(goddess == null){
							step = 1;
							System.out.println("您要更新的"+ id +"号女屌丝不存在");
						}
					}catch (NumberFormatException e){
						step = 1;
						System.out.println("请输入正确的女屌丝[ID]：");
					}catch (Exception e){
						step = 1;
						System.out.println("您要更新的[ID]女屌丝不存在");
					}
					
					System.out.println("请输入女屌丝[姓名],如不更新此字段，输入null");
				}else if(step == 3){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setUser_name(in);
					}
					
					System.out.println("请输入女屌丝[年龄],如不更新此字段，输入null");
				}else if(step == 4){
					try {
						if(!"null".equalsIgnoreCase(in)){
							Integer age = Integer.valueOf(in);
							goddess.setAge(age);
						}
					} catch (NumberFormatException e) {
						step = 3;
						System.out.println("请输入正确的女屌丝[年龄]:");
					}
					System.out.println("请输入女神[生日]，格式为yyyy-MM-dd：(如不更新该字段，则输入null)");
				}else if(step == 5){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						if (!"null".equalsIgnoreCase(in)) { 
							goddess.setBirthday(sdf.parse(in));
						}
						System.out.println("请输入女神[邮箱]：(如不更新该字段，则输入null)"); 
					} catch (ParseException e) { 
						step = 4; 
						System.out.println("请输入正确的女神的[生日]："); 
					}
				}else if (step == 6){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setEmail(in);
					}
					System.out.println("请输入女神[手机号],如果不更新此项输入null！");
				}else if (step == 7){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setMobile(in);
					}
					
					try {
						action.edit(goddess);
						System.out.println("更新女屌丝信息成功！");
						step = 1;
						prenious = null;
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("更新女屌丝信息失败！");
					}
				}
				if(OPERATION_UPDATE.equals(prenious)){
					step++;
				}
			}
			
			//删除女屌丝功能
			if(OPERATION_DELETE.equals(in.toUpperCase()) || OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_DELETE.equals(prenious)){
				prenious = OPERATION_DELETE;
				if(step == 1){
					System.out.println("请输入要删除的女屌丝的[ID]:(删除多个用逗号隔开，如1,2,...)");
				}else if(step == 2){
					try {
						String[]  ss = in.split(",");
						Integer[] ids = new Integer[ss.length];
						for(int i=0; i<ss.length; i++){
							ids[i] = Integer.parseInt(ss[i]);
						}
						action.del(ids);
						System.out.println("删除女屌丝成功!");
						step = 1;
						prenious = null;
					} catch (NumberFormatException e) {
						step = 1;
						System.out.println("请输入正确的女屌丝[ID]");
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("删除女屌丝失败");
					}
					
				}
				if(OPERATION_DELETE.equals(prenious)){
					step++;
				}
			}
		}
	}
}
```

### 6、测试结果

![这里写图片描述](http://img.blog.csdn.net/20170703164326464?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzE2ODMxMjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


---
## 三、JDBC总结


---
1、JDBC的基本概念：

	JDBC是连接数据库的桥梁；
	是由Java语言编写的类和接口组成，可以为多种数据库提供统一的访问。

2、采用MVC三层结构:

	DB（数据库）、Model（模型层）、Control（控制层）、View（视图层）

	模型层（DB + DAO）：封装了实现类
	控制层：负责调用模型层
	视图层调用控制层

3、JDBC各种连接方式的对比：

	1、JDBC + ODBC桥的方式。特点：需要数据库的ODBC驱动，仅适用于微软的系统
		这种方式，JDBC将调用传递给ODBC，然后ODBC再调用本地的数据库驱动代码。

	2、JDBC + 厂商API的形式。特点：厂商API一般使用C编写
		这种方式，JDBC将调用直接传递给厂商API的服务，然后在调用本地的数据库驱动。

	3、JDBC + 厂商Database Connection Server + DataBase的形式。
		特点：在JAVA与DATABASE之间架起了一台专门用于数据库连接的服务器（一般有数据库厂商提供）
		这种方式，JDBC将调用传递给中间服务器，中间服务器再将调用转换成数据库能够被调用的形式，在调用数据库服务器。中间增设数据库服务器能够提升效率，但不如直接操作数据库便捷。

	4、JDBC + DATABASE的连接方式。
		特点：这使得Application与数据库分开，开发者只需关心内部逻辑的实现而不需注重数据库连接的具体实现。（没有中间环节，是推荐方式！）


>**本实例参考慕课网视频**
