package com.qiyanhui.interceptor;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserLoginInterceptor extends MethodFilterInterceptor{
	//private Map session;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//时间判断，必须是6-18才能访问
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		if(6<hour && hour<18){
			String userlogin = (String) session.getAttribute("userLogin");
			System.out.println(userlogin);
			if(userlogin != null && (!"".equals(userlogin))){
				String result = arg0.invoke();
				return result;
			}else{
				return "loginerror";
			}
		}else{
			return "timeOut";
		}
	}

	//@Override
	/*public void setSession(Map session) {
		this.session = session;
		
	}
*/
}














