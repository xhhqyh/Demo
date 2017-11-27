$(document).ready(function(){
	//利用ajax获取查询结果
	var url = "/StuInfo/User/query_user.action";
	$.ajax({
		"url" : url,
		"dataType" : "json",
		"success" : function(data){
			$("#tabId td").remove();
			for(var i=0; i<data.stuList.length; i++){
				var str = "<tr align='center'>" +
				"<td>"+data.stuList[i].tid+"</td>" +
				"<td>"+data.stuList[i].stuNo+"</td>" +
				"<td>"+data.stuList[i].stuName+"</td>" +
				"<td>"+data.stuList[i].stuSex+"</td>" +
				"<td><a href='/StuInfo/delete_user.action?stu.tid="+data.stuList[i].tid+"'>删除</a></td>" +
				"<td><a href='/StuInfo/update_user.action?stu.tid="+data.stuList[i].tid+"'>修改</a></td>" +
				"</tr>";
				
				$("#tabId").append(str);
			}
		},
		"error" : function(data){
		}
	});
	
});




















