package com.qiyanhui.entiy;

/**
 * �û����ݷ�װ
 * @author: �����
 *
 * 2017��11��27��
 */
public class User {
	private int userid = 0 ;
	private String uName = "" ;
	private int uAge = 0 ;
	
	public User() {

	}
	
	public User(String uName, int uAge) {
		super();
		this.uName = uName;
		this.uAge = uAge;
	}
	
	public User(int userid, String uName, int uAge) {
		super();
		this.userid = userid;
		this.uName = uName;
		this.uAge = uAge;
	}
	
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
	
	
}
