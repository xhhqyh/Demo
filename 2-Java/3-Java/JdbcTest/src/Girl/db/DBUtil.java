package Girl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 这个工具类提供数据库的连接
 * @author 小灰灰
 */
public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/test";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	//写一个静态块,最早执行
	static{
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库的连接
		    conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//对外提供一个方法，以获取这个连接
	public static  Connection getConnection(){
		return conn;
	}
}
