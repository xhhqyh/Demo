$(document).ready(function(){
	var url = "" ;
	
	//删除方法
	$("#delId").click(function(){
		//判断是否有选中
		var rows = $("#tabid").datagrid("getChecked");
		if(rows){
			$.messager.confirm('确认', '您确定要删除吗?', function(r){
				//r是是否确认删除的返回值，是(true),否(false)
				if(r){
					$.ajax({
						'url':'delUser_user.action',
						'data':{'user.userid':rows[0].userid},
						'dataType':'JSON',
						'type':'POST',
						'success':function(data){
							//刷新
							$('#tabid').datagrid('reload');  
							//在有下角弹出消息提示
							$.messager.show({
								title:'消息框',
								msg:data.msg
							});
						}
					});
				}
			});
		}
	});
	
	//打开添加用户对话框
	$("#addId").click(function(){
		url = 'addUser_user.action';
		//清空表单数据
		$("#ff").form('clear');
		$("#addUser").dialog({
			closed: false,
			title: '新增用户',
			iconCls: 'icon-add'
		});
	});
	
	//打开修改用户对话框
	$("#updateId").click(function(){
		url = 'updateUser_user.action';
		$("#ff").form('clear');
		var rows = $('#tabid').datagrid('getChecked');
		if(rows.length == 1){
			//读取记录填充到表单中。数据参数可以是一个字符串或一个对象类型，如果是字符串则作为远程URL，否则作为本地记录。
			$('#ff').form('load',rows[0]);
			$("#addUser").dialog({
				closed: false,
				title: '修改用户',
				iconCls: 'icon-edit'
			});
		}else{
			$.messager.show({
				title:'我的消息',
				msg:'请选择一行数据'
			});
		}
	});
	
	//新增/修改用户
	$("#submitId").click(function(){
		$("#ff").form('submit', {
			url:url,
			onsubmit:function(){
				//判断表单是否为空
				return $(this).form('validate');
			},
			"success":function(data){
				//把data转成json
				data = JSON.parse(data);
				if(data.isOk=='success'){
					$('#addUser').dialog('close')
					$('#tabid').datagrid('reload');   
					$.messager.show({
						title:'我的消息',
						msg:data.msg
					});
				}else{
					$.messager.show({
						title:'我的消息',
						msg:data.msg
					});
				}
			}
		});
	});
	
});

























