package Girl.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Girl.dao.GoddessDao;
import Girl.model.Goddess;

/**
 * 控制层：主要逻辑处理，接收视图层的请求，控制模型层数据处理
 * @author 小灰灰
 */
public class GoddessAction {
	//添加
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.addGoddess(goddess);
	}
	
	//得到一个女神
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
	}
	
	//修改
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
	}
	
	//删除
	public void del(Integer[] ids) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(ids);
	}
	
	//查询
	public List<Goddess> query() throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	
	//模糊匹配
	public List<Goddess> queryname(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}
}































