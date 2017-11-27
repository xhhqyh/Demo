package com.qiyanhui.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiyanhui.entity.Student;
import com.qiyanhui.entity.User;
import com.qiyanhui.model.UserModel;

import net.sf.json.JSONObject;

public class UserAction extends ActionSupport implements RequestAware, SessionAware{
	private Student stu ;
	private String msg;
	private Map request;
	private Map session;
	private User user;
	private UserModel usermodel = new UserModel();

	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
	
	//增加用户
	public String add(){
		int i = usermodel.addUser(stu);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//删除用户
	public String delete(){
		int i = usermodel.deleteUser(stu);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//查询要修改用户的信息
	public String update(){
		List<Student> stuList = usermodel.queryOneUser(stu);
		request.put("stuList", stuList);
		if(stuList != null){
			return "update";
		}else{
			return ERROR;
		}
	}
	
	//修改用户
	public String edit(){
		int i = usermodel.editUser(stu);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//查询用户
	public void query(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		List<Student> stuList = usermodel.queryUser();

		if(stuList != null){
			try {
				JSONObject json = new JSONObject();
				json.put("stuList", stuList);
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//检测登录
	public String login(){
		if(user.getUsername().equals("user") && user.getPassword().equals("123")){
			session.put("userLogin", user.getUsername());
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	@Override
	public void setRequest(Map request) {
		this.request = request;
		
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
		
	}


}






















