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
