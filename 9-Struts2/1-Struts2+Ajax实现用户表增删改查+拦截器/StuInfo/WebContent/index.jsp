<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Struts2学生信息管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="main">
		<div class="show" id="showId">
			<p class="show-p1">学生信息管理 | <a id="a-1" href="${pageContext.request.contextPath}/add.jsp">增加</a></p>
			<table border="1px" cellspacing="0px" cellpadding="0px" width="400px" id="tabId">
				<tr>
					<th>ID</th>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th colspan="2">操作</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>