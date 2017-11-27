package Girl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Girl.action.GoddessAction;
import Girl.model.Goddess;

public class TestAction {
	public static void main(String[] args) throws Exception {
		GoddessAction action=new GoddessAction();
		
		/*//查询测试
		List<Goddess> result=action.query();
		
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
		}
		*/
		
		//添加测试
		Goddess g=new Goddess();
		
		g.setUser_name("小青");
		g.setSex(1);
		g.setAge(25);
		g.setBirthday(new Date());
		g.setEmail("12345@qq.com");
		g.setMobile("11111111");
		g.setIsdel(0);
		
		action.add(g);
		
		
		//有参数查询测试
		List<Map<String, Object>> params=new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小青'");
		 
		params.add(map);
		List<Goddess> result=action.queryname(params);
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i).getId()+":"+result.get(i).getUser_name());
		}
	}
}



















