package com.qiyanhui.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qiyanhui.entity.Student;
import com.qiyanhui.utils.DbHuilder;

/**
 * 	用户处理模型层
 * @author: 祁燕辉
 *
 * 2017年11月18日
 */
public class UserModel {
	
	//添加用户
	public int addUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into stuInfo values(sequence_stu.Nextval, ?, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, stu.getStuNo(), stu.getStuSex(), stu.getStuName());
		
		return i;
	}
	
	//查询所有学生信息
	public List<Student> queryUser(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from stuInfo order by tid";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		
		//定义一个Student类型的集合
		List<Student> stuList = new ArrayList<Student>();

		try {
			while(rs.next()){
				Student stu = new Student();
				stu.setStuNo(rs.getInt("stuNo"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getString("stuSex"));
				stu.setTid(rs.getInt("tid"));
				
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}
	
	//删除学生
	public int deleteUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from StuInfo where tid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, stu.getTid());
		
		return i;
	}
	
	//查询要修改的学生信息
	public List<Student> queryOneUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from stuInfo where tid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, stu.getTid());
		
		//定义一个Student类型的集合
		List<Student> stuList = new ArrayList<Student>();

		try {
			while(rs.next()){
				Student stu2 = new Student();
				stu2.setStuNo(rs.getInt("stuNo"));
				stu2.setStuName(rs.getString("stuName"));
				stu2.setStuSex(rs.getString("stuSex"));
				stu2.setTid(rs.getInt("tid"));
				
				stuList.add(stu2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}
	
	//修改指定的学生信息
	public int editUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "update stuInfo set stuNo=?, stuSex=?, stuName=? where tid = ?";
		int i = DbHuilder.executeUpdate(conn, sql,stu.getStuNo(), stu.getStuSex(), stu.getStuName(), stu.getTid());
		
		return i;
	}
}























