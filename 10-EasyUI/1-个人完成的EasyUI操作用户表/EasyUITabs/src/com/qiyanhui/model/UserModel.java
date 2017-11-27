package com.qiyanhui.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.qiyanhui.entiy.User;
import com.qiyanhui.utils.DbHuilder;

/**�û�ģ�Ͳ�
 * @author: �����
 *
 * 2017��11��27��
 */
public class UserModel {
	
	/**
	 * ��ѯUserInfo������������
	 * @return ����һ��int���͵�����
	 */
	public int queryCount(){
		int num = 0 ;
		Connection conn = DbHuilder.getConn();
		String sql = "select count(*) num from UserInfo";
		ResultSet rs = DbHuilder.executeQuery(conn, sql);
		try {
			while(rs.next()){
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	/**
	 * ����UserInfo����������
	 * @param pageSize
	 * @param currentPage
	 * @return ����һ������
	 */
	public List<User> queryUserInfo(Integer pageSize,Integer currentPage){
		Connection conn = DbHuilder.getConn();
		String sql = "select * from (select rownum rn, u.* from UserInfo u) t where t.rn>? and t.rn<? order by userid desc";
		ResultSet rs = DbHuilder.executeQuery(conn, sql, (currentPage-1)*pageSize, (currentPage*pageSize+1));
		
		List<User> userLists = new ArrayList<User>();
		
		try {
			while(rs.next()){
				User user = new User(rs.getInt("userid"), rs.getString("uName"), rs.getInt("uAge"));
				userLists.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userLists;
	}
	
	/**
	 * ɾ��ָ���û�
	 * @param userid
	 * @return ����һ��Ӱ������
	 */
	public int delUser(int userid){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from UserInfo where userid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, userid);
		return i;
	}
	
	/**
	 * ����û�
	 * @param user
	 * @return ����һ��Ӱ������
	 */
	public int addUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into UserInfo values(se_user.nextval, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, user.getuName(), user.getuAge());
		return i;
	}

	/**
	 * �޸��û�
	 * @param user
	 * @return ����Ӱ������
	 */
	public int updateUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "update UserInfo set uName=?,uAge=? where userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, user.getuName(), user.getuAge(), user.getUserid());
		return i;
	}
	

}

















