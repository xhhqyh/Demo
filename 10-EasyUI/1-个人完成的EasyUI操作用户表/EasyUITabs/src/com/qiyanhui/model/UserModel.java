package com.qiyanhui.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.qiyanhui.entiy.User;
import com.qiyanhui.utils.DbHuilder;

/**用户模型层
 * @author: 祁燕辉
 *
 * 2017年11月27日
 */
public class UserModel {
	
	/**
	 * 查询UserInfo表中数据总数
	 * @return 返回一个int类型的数字
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
	 * 返回UserInfo的所有数据
	 * @param pageSize
	 * @param currentPage
	 * @return 返回一个集合
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
	 * 删除指定用户
	 * @param userid
	 * @return 返回一个影响行数
	 */
	public int delUser(int userid){
		Connection conn = DbHuilder.getConn();
		String sql = "delete from UserInfo where userid = ?";
		int i = DbHuilder.executeUpdate(conn, sql, userid);
		return i;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return 返回一个影响行数
	 */
	public int addUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "insert into UserInfo values(se_user.nextval, ?, ?)";
		int i = DbHuilder.executeUpdate(conn, sql, user.getuName(), user.getuAge());
		return i;
	}

	/**
	 * 修改用户
	 * @param user
	 * @return 返回影响行数
	 */
	public int updateUser(User user){
		Connection conn = DbHuilder.getConn();
		String sql = "update UserInfo set uName=?,uAge=? where userid=?";
		int i = DbHuilder.executeUpdate(conn, sql, user.getuName(), user.getuAge(), user.getUserid());
		return i;
	}
	

}

















