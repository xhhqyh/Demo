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
 * ģ�Ͳ㣺��Ҫ��ͨ�������ݵĲ���
 * 		1���ڲ���֮ǰ�����������ݿ�
 * 		2������Ů��˿����
 * 		3���޸�Ů��˿����
 * 		4��ɾ��Ů��˿����
 * 		5������Ů��˿����
 * 		6����������ģ������Ů��˿����
 * @author С�һ�
 */
public class GoddessDao {
	//����Ů��
	public void addGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//�����ã�ռλ��ռ��
		String sql="" + 
		          "insert into imooc_goddess" +
				  "(user_name,sex,age,birthday,email,mobile," +
		          "create_user,create_date,update_user,update_date,isdel)" +
				  "values(" +
		          "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		
		//Ԥ����SQL���
		//��������Ὣ���SQL�����ص����������ִ�г����У����ǲ���ֱ��ִ��
		//������Excute()����ʱ����ִ��
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//���Σ���Ԥ�������ֵ
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//��Ϊ���Ǵ�������java.util���͵�ֵ��������Ҫjava.sql���͵�ֵ,���Ҫ����ת��
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}
	
	//�޸�Ů��
	public void updateGoddess(Goddess g) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//�����ã�ռλ��ռ��
		String sql="" + 
		          " update imooc_goddess " +
				  " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
		          " update_user=?,update_date=current_date(),isdel=? " +
				  " where id=?";
		
		//Ԥ����SQL���
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//���Σ���Ԥ�������ֵ
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//��Ϊ���Ǵ�������java.util���͵�ֵ��������Ҫjava.sql���͵�ֵ,���Ҫ����ת��
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7,g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9,g.getId());
		ptmt.execute();
	}
	
	//ɾ��Ů��
	public void delGoddess(Integer[] ids) throws SQLException{
		Connection conn=DBUtil.getConnection();
		//�����ã�ռλ��ռ��
		String sql="" + 
		          " delete from imooc_goddess " +
				  " where id=?";
		
		//Ԥ����SQL���
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//ͬʱɾ���������
		for(int i=0; i<ids.length; i++){
			ptmt.setInt(1,ids[i]);
			ptmt.execute();
		}
	}
	
	//��ѯŮ��
	public List<Goddess> query() throws Exception{
		Connection conn=DBUtil.getConnection();
		//ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
			Statement stmt = conn.createStatement();
			
			//ִ�в�ѯ���
			ResultSet rs=stmt.executeQuery("select id,user_name,age from imooc_goddess");
			
			//����һ��List
			List<Goddess> gs=new ArrayList<Goddess>();
			Goddess g=null;
			while(rs.next()){
				g=new Goddess();
				//�������ݿ��в�ѯ����ֵͨ����Goddess��ȡ��
				g.setId(rs.getInt("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getInt("age"));
				
				gs.add(g);
			}
			return gs;
	}
	
		//����������ѯŮ��
		public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
			List<Goddess> gs=new ArrayList<Goddess>();
			
			Connection conn=DBUtil.getConnection();
			StringBuilder sb=new StringBuilder();
			
			//ע�������һ��1=1����Ҫ��һ���㣬Ҳ�ǿ����о����õ���һ����
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
	
	//��ѯ����Ů��
	public Goddess get(Integer id) throws SQLException{
		Goddess g=null;
		Connection conn=DBUtil.getConnection();
		//�����ã�ռλ��ռ��
		String sql="" + 
		          " select * from imooc_goddess " +
				  " where id=?";
		//Ԥ����SQL���
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		//���Σ���Ԥ�������ֵ
		ptmt.setInt(1,id);
		//�˵ز���ʹ��execute()�����ִ�в���������Ҫʹ�ò�ѯ����
		//Ȼ���õ�һ�������
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






























