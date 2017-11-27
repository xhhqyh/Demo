package com.hp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fenye {
	
	public static int fenye(Connection conn,String tableName){
		String sql = "select count(*) total from "+tableName;
		//System.out.println(sql);
		ResultSet rs = DBHelper.executeQuery(conn, sql);
		try{
			rs.next();
		}catch (SQLException el) {
			// TODO: handle exception
			el.printStackTrace();
		}
		int ws=0;
		try{
			ws = rs.getInt("total");
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int i = ws%5;
		if(i>0){
			return(ws/5 + 1);
		}else{
			 return(ws/5);
		}
	}

}
