<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="JDBC.DBConn,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%!
//定义全局变量
int count = 0; //表中共有多少条数据
int a = 4;     //每页多少条数据
int b = 0;     //共分多少页
int c = 1;     //当前页数
int min = 1;   //查询最小值
int max = 4;   //查询最大值
%>
<%
DBConn.getConn();
//将表中的记录数查出来放在count中
String sql = " SELECT COUNT(*) count FROM users ";
ResultSet rs = DBConn.connQuery(sql);
if(rs.next()){
	count = rs.getInt("count");
}

//计算共有多少页，不能整除就将页数加一
if (count % a == 0 ){
	b = count / a;
}else if (count % a != 0){
	b = count / a + 1;
}

//根据不同的请求切换到不同的页面
String flag = request.getParameter("flag");
	if ("first".equals(flag)){                  //首页
		min = 1;
		max = 4;
		c = 1;
	}else if ("shang".equals(flag)  && c > 1){  //上一页
		min = min - a;
		max = max - a;
		c = c - 1;
	}else if ("xia".equals(flag) && c < b){     //下一页
		min = min + a;
		max = max + a;
		c = c + 1;
	}else if ("last".equals(flag)){             //最后一页
		min = a * (b - 1) + 1;
		max = count;
		c = b;
		
	}

%>

<table align="center" border="1" cellspacing="0" width="200px">
	<tr height="30px" align="center">
		<td width="100px">ID</td>
		<td width="100px">账号</td>
		<td width="100px">密码</td>
	</tr>
	<%
	//分页取出数据库数据
	String sql2 = " SELECT * FROM (SELECT s.*, ROWNUM rn FROM users s)u WHERE rn between ? and ? ";
	ResultSet rs2 = DBConn.connQuery(sql2, min, max);
	while(rs2.next()){
	%>
	<tr height="30px" align="center">
		<td><%=rs2.getString("userId") %></td>
		<td><%=rs2.getString("userName") %></td>
		<td><%=rs2.getString("userPwd") %></td>
	</tr>
	<%}%>
	
</table>

	<p align="center">
		<a href="index.jsp?flag=first">首页</a>&nbsp;
		<a href="index.jsp?flag=shang">上一页</a>&nbsp;
		<a href="index.jsp?flag=xia">下一页</a>&nbsp;
		<a href="index.jsp?flag=last">末页</a>&nbsp;
		<a>第<%= c %>页</a>&nbsp;
		<a>共<%= b%>页</a>
	</p>
	
<!-- 下面注释的可以实现在最后一页时隐藏下一页，第一页时隐藏上一页
	<p align="center">
		<a href="index.jsp?flag=first">首页</a>&nbsp;
		<% if(c > 1){ %>
			<a href="index.jsp?flag=shang">上一页</a>&nbsp;
		<% } %>
		<% if( c < b ){ %>
			<a href="index.jsp?flag=xia">下一页</a>&nbsp;
		<% } %>
		<a href="index.jsp?flag=last">末页</a>&nbsp;
		<a>第<%= c %>页</a>&nbsp;
		<a>共<%= b%>页</a>
	</p>
-->
<% DBConn.connClose(); %>
</body>
</html>