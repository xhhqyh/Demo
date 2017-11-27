package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	 private static final String DRIVER = "oracle.jdbc.driver.OracleDriver" ;
	 private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl" ;
	 private static final String NAME = "scott";
	 private static final String PWD = "tiger";
	 private static Connection conn ;
	 
	 
	 public static Connection getConn()  {
		 try{
			if(conn == null){
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL,NAME,PWD);
			}
		 } catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		} 
		 return conn ;
	 }
	 
	 public static int connUpdate(String sql,Object... parm) {
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				for(int i=0;i<parm.length;i++){
					ps.setObject(i+1, parm[i]);
				}

				return ps.executeUpdate(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return 0 ;
	 }
	 
	 
	 public static ResultSet connQuery(String sql,Object... parm){
			try {
				PreparedStatement ps;
				 ResultSet rs = null ;
				ps = conn.prepareStatement(sql);
				for(int i=0;i<parm.length;i++){
					ps.setObject(i+1, parm[i]);
				}
				rs = ps.executeQuery(); 
				return rs ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null ;
			
	 }
	 
	 public static void connClose(){
//		 4£¬¹Ø±ÕÁ¬½Ó	
			try {
				if(conn!=null){
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
}
