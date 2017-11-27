package com.qiyanhui.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.qiyanhui.entiy.User;
import com.qiyanhui.model.UserModel;

import net.sf.json.JSONObject;

public class UserAction {
	private User user ;
	private static UserModel usermodel = new UserModel();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private int userid = 0 ;
	private String uName = "" ;
	private int uAge = 0 ;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuAge() {
		return uAge;
	}

	public void setuAge(int uAge) {
		this.uAge = uAge;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//查询所有用户信息
	public void queryUser() throws IOException{
		//获得当前页码和每页显示数据的总条数
		Integer cuttentPage = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		
		List<User> userLists = usermodel.queryUserInfo(pageSize, cuttentPage);
		
		//新建一个map集合
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", usermodel.queryCount()); //total：要显示数据的总条数
		data.put("rows", userLists); //我们要显示的数据
		
		//把map集合转换成json
		JSONObject json = JSONObject.fromObject(data);
	
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
	}
	
	//删除用户
	public void delUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		int i = usermodel.delUser(user.getUserid());
		
		if(i>0){
			System.out.println("删除成功");
			//响应网络请求
			
			json.put("msg", "删除成功");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			System.out.println("删除失败");
			//响应网络请求
			
			json.put("msg", "删除失败");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
	
	//添加用户
	public void addUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		User user = new User(uName, uAge);
		
		int i = usermodel.addUser(user);
		
		if(i>0){
			json.put("isOk", "success");
			json.put("msg", "添加成功");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			json.put("isOk", "error");
			json.put("msg", "添加失败");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
	
	//修改用户
	public void updateUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		User user = new User(userid, uName, uAge);
		
		int i = usermodel.updateUser(user);
		
		if(i>0){
			json.put("isOk", "success");
			json.put("msg", "修改成功");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			json.put("isOk", "error");
			json.put("msg", "修改失败");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
}















