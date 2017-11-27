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

	//��ѯ�����û���Ϣ
	public void queryUser() throws IOException{
		//��õ�ǰҳ���ÿҳ��ʾ���ݵ�������
		Integer cuttentPage = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		
		List<User> userLists = usermodel.queryUserInfo(pageSize, cuttentPage);
		
		//�½�һ��map����
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total", usermodel.queryCount()); //total��Ҫ��ʾ���ݵ�������
		data.put("rows", userLists); //����Ҫ��ʾ������
		
		//��map����ת����json
		JSONObject json = JSONObject.fromObject(data);
	
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
	}
	
	//ɾ���û�
	public void delUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		int i = usermodel.delUser(user.getUserid());
		
		if(i>0){
			System.out.println("ɾ���ɹ�");
			//��Ӧ��������
			
			json.put("msg", "ɾ���ɹ�");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			System.out.println("ɾ��ʧ��");
			//��Ӧ��������
			
			json.put("msg", "ɾ��ʧ��");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
	
	//����û�
	public void addUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		User user = new User(uName, uAge);
		
		int i = usermodel.addUser(user);
		
		if(i>0){
			json.put("isOk", "success");
			json.put("msg", "��ӳɹ�");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			json.put("isOk", "error");
			json.put("msg", "���ʧ��");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
	
	//�޸��û�
	public void updateUser() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		
		User user = new User(userid, uName, uAge);
		
		int i = usermodel.updateUser(user);
		
		if(i>0){
			json.put("isOk", "success");
			json.put("msg", "�޸ĳɹ�");
			writer.println(json);
			writer.flush();
			writer.close();
		}else{
			json.put("isOk", "error");
			json.put("msg", "�޸�ʧ��");
			writer.println(json);
			writer.flush();
			writer.close();
		}
	}
}















