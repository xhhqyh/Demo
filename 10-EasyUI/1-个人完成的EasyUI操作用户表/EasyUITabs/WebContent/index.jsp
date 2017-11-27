<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tags</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/user.js"></script>
</head>
<body>
	<!-- 表头 -->
	<div id="tdHead">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true',text:'新增用户'" id="addId"></a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:'true',text:'修改用户'" id="updateId"></a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:'true',text:'删除用户'" id="delId"></a>
	</div>
	
	<!-- 表格 -->
	<table id="tabid" class="easyui-datagrid" style="width:400px;height:300px"
				 data-options="
				 	rownumbers:true,
				 	url:'queryUser_user.action',
				 	method:'get',
				 	fitColumns:true,
				 	singleSelect:true,
				 	pagination:true,
					pageSize:5,
					pageList:[2,3,4,5,10],
					toolbar:'#tdHead'
				 ">
		<thead>
			<tr>
				<th data-options="field:'ck', checkbox:true"></th>
				<th data-options="field:'userid', width:100">ID</th>
				<th data-options="field:'uName', width:100">姓名</th>
				<th data-options="field:'uAge', width:100">年龄</th>
			</tr>
		</thead>
	</table>
	
	<div id="addUser" class="easyui-dialog" title="添加用户" style="width:400px;height:200px;"   
        data-options="closed: true,resizable:true,modal:true">   
	    <form id="ff" method="post" >
	    	<div style="display: none">   
		        <label for="name">Id:</label>   
		        <input type="text" name="userid" />   
		    </div>  
		    <div >   
		        <label for="name">用户名:</label>   
		        <input class="easyui-validatebox" type="text" name="uName" data-options="required:true" />   
		    </div> <br>  
		    <div>   
		        <label for="email">年龄:</label>   
		        <input class="easyui-validatebox" type="text" name="uAge" data-options="required:true" />   
		    </div>   
		</form>
		<div align="center">
		      <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:'true',text:'提交'" id="submitId"></a>
			  <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:'true',text:'取消'" onclick="javascript:$('#addUser').dialog('close')"></a> 
		</div>
	</div>
</body>
</html>



















