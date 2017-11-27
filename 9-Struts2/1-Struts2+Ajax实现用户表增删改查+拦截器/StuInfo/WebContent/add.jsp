<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Struts2学生信息管理</title>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="main">
		<div class="add" id="addId">
			<c:choose>
				<c:when test="${empty stuList}">
					<form action="/StuInfo/add_user.action" method="post">
						<table border="0px" cellspacing="0px" cellpadding="0px" width="300px" height="140px">
							<tr>
								<td>学号:</td>
								<td><input type="text" name="stu.stuNo" /></td>
							</tr>
							<tr>
								<td>姓名:</td>
								<td><input type="text" name="stu.stuName" /></td>
							</tr>
							<tr>
								<td>性别:</td>
								<td>
									<input type="radio" name="stu.stuSex" id="men" value="男" checked="checked"/><label for="men">男</label>
									<input type="radio" name="stu.stuSex" id="women" value="女"/><label for="women">女</label>
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" id="addBtn" value="添加" /></td>
							</tr>
						</table>
					</form>
				</c:when>
				<c:otherwise>
					<form action="/StuInfo/edit_user.action" method="post" id="formId">
						<table border="0px" cellspacing="0px" cellpadding="0px" width="300px" height="140px">
							<c:forEach items="${stuList }" var="stu">
							<tr>
								<td>学号:</td>
								<td><input type="text" name="stu.stuNo" value="${stu.stuNo }"/></td>
							</tr>
							<tr>
								<td>姓名:</td>
								<td><input type="text" name="stu.stuName" value="${stu.stuName }"/></td>
								<input type="hidden" name="stu.tid" value="${stu.tid }"/>
							</tr>
							<tr>
								<td>性别:</td>
								<td>
									<input type="radio" name="stu.stuSex" id="men" <c:if test="${stu.stuSex == '男'}">checked="checked"</c:if> value="男"/><label for="men">男</label>
									<input type="radio" name="stu.stuSex" id="women" <c:if test="${stu.stuSex == '女'}">checked="checked"</c:if> value="女"/><label for="women">女</label>
								</td>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="2"><input type="submit" id="btn" value="修改" /></td>
							</tr>
						</table>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>