package Girl.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Girl.db.DBUtil;
import Girl.model.Goddess;

/**
 * 模型层：主要是通过对数据的操作
 * 		1、在操作之前必须连接数据库
 * 		2、新增女屌丝方法
 * 		3、修改女屌丝方法
 * 		4、删除女屌丝方法
 * 		5、查找女屌丝方法
 * 		6、根据名字模糊查找女屌丝方法
 * @author 小灰灰
 */
public class GoddessDao {
	//新增女神
	public void addGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          "insert into imooc_goddess" +
				  "(user_name,sex,age,birthday,email,mobile," +
		          "create_user,create_date,update_user,update_date,isdel)" +
				  "values(" +
		          "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		
		//预编译SQL语句
		//这个方法会将这个SQL语句加载到驱动程序的执行程序中，但是并不直接执行
		//当调用Excute()方法时真正执行
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//因为我们传进的是java.util类型的值，但是需要java.sql类型的值,因此要进行转换
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}
	
	//修改女神
	public void updateGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " update imooc_goddess " +
				  " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
		          " update_user=?,update_date=current_date(),isdel=? " +
				  " where id=?";
		
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//因为我们传进的是java.util类型的值，但是需要java.sql类型的值,因此要进行转换
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7,g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9,g.getId());
		ptmt.execute();
	}
	
	//删除女神
	public void delGoddess(Integer[] ids) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " delete from imooc_goddess " +
				  " where id=?";
		
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//同时删除多个数据
		for(int i=0; i<ids.length; i++){
			ptmt.setInt(1,ids[i]);
			ptmt.execute();
		}
	}
	
	//查询女神
	public List<Goddess> query() throws Exception{
		Connection conn=DBUtil.getConnection();
		//通过数据库的连接操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			
			//执行查询语句
			ResultSet rs=stmt.executeQuery("select id,user_name,age from imooc_goddess");
			
			//返回一个List
			List<Goddess> gs=new ArrayList<Goddess>();
			Goddess g=null;
			while(rs.next()){
				g=new Goddess();
				//把在数据库中查询到的值通过类Goddess获取到
				g.setId(rs.getInt("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getInt("age"));
				
				gs.add(g);
			}
			return gs;
	}
	
		//根据姓名查询女神
		public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
			List<Goddess> gs=new ArrayList<Goddess>();
			
			Connection conn=DBUtil.getConnection();
			StringBuilder sb=new StringBuilder();
			
			//注意这里加一个1=1很重要的一个点，也是开发中经常用到的一个点
			sb.append("select * from imooc_goddess where 1=1");
			
			if(params!=null && params.size()>0){
				for(int i=0; i<params.size(); i++){
					Map<String, Object> map=params.get(i);
					sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
				}
			}
			
			PreparedStatement ptmt=conn.prepareStatement(sb.toString());
			ResultSet rs=ptmt.executeQuery();
				
			Goddess g=null;
			while(rs.next()){
				g=new Goddess();
				g.setId(rs.getInt("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getInt("age"));
				g.setSex(rs.getInt("sex"));
				g.setBirthday(rs.getDate("birthday"));
				g.setEmail(rs.getString("email"));
				g.setMobile(rs.getString("mobile"));
				g.setCreate_date(rs.getDate("create_date"));
				g.setCreate_user(rs.getString("create_user"));
				g.setUpdate_date(rs.getDate("update_date"));
				g.setUpdate_user(rs.getString("update_user"));
				g.setIsdel(rs.getInt("isdel"));
				
				gs.add(g);
			}
			return gs;
		}
	
	//查询单个女神
	public Goddess get(Integer id) throws SQLException{
		Goddess g=null;
		Connection conn=DBUtil.getConnection();
		//参数用？占位符占用
		String sql="" + 
		          " select * from imooc_goddess " +
				  " where id=?";
		//预编译SQL语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//传参，给预编译符赋值
		ptmt.setInt(1,id);
		//此地不能使用execute()这个是执行操作，我们要使用查询操作
		//然后会得到一个结果集
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			g=new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
}






























