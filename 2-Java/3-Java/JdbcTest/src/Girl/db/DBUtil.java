package Girl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ����������ṩ���ݿ������
 * @author С�һ�
 */
public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/test";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	//дһ����̬��,����ִ��
	static{
		try {
			//������������
			Class.forName("com.mysql.jdbc.Driver");
			//������ݿ������
		    conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�����ṩһ���������Ի�ȡ�������
	public static  Connection getConnection(){
		return conn;
	}
}
