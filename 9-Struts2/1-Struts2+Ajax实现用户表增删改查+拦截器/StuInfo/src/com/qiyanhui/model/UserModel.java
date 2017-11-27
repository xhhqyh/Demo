package com.qiyanhui.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qiyanhui.entity.Student;
import com.qiyanhui.utils.DbHuilder;

/**
 * 	�û�����ģ�Ͳ�
 * @author: �����
 *
 * 2017��11��18��
 */
public class UserModel {
	
	//����û�
	public int addUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into stuInfo values(sequence_stu.Nextval, ?, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, stu.getStuNo(), stu.getStuSex(), stu.getStuName());
		
		return i;
	}
	
	//��ѯ����ѧ����Ϣ
	public List<Student> queryUser(){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from stuInfo order by tid";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		
		//����һ��Student���͵ļ���
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
	
	//ɾ��ѧ��
	public int deleteUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from StuInfo where tid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, stu.getTid());
		
		return i;
	}
	
	//��ѯҪ�޸ĵ�ѧ����Ϣ
	public List<Student> queryOneUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from stuInfo where tid = ?";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, stu.getTid());
		
		//����һ��Student���͵ļ���
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
	
	//�޸�ָ����ѧ����Ϣ
	public int editUser(Student stu){
		Connection conn = DbHuilder.getConn();
		String sql = "update stuInfo set stuNo=?, stuSex=?, stuName=? where tid = ?";
		int i = DbHuilder.executeUpdate(conn, sql,stu.getStuNo(), stu.getStuSex(), stu.getStuName(), stu.getTid());
		
		return i;
	}
}























