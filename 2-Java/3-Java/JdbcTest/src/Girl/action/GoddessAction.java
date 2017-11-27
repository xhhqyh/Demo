package Girl.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Girl.dao.GoddessDao;
import Girl.model.Goddess;

/**
 * ���Ʋ㣺��Ҫ�߼�����������ͼ������󣬿���ģ�Ͳ����ݴ���
 * @author С�һ�
 */
public class GoddessAction {
	//���
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.addGoddess(goddess);
	}
	
	//�õ�һ��Ů��
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
	}
	
	//�޸�
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	//ɾ��
	public void del(Integer[] ids) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(ids);
	}
	
	//��ѯ
	public List<Goddess> query() throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	
	//ģ��ƥ��
	public List<Goddess> queryname(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}
}































