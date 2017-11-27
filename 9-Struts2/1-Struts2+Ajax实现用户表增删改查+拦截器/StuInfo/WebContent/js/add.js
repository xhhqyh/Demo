$(document).ready(function(){
	
	$("#addBtn").click(function(){
		var url = "/StuInfo/User/add_user.action";
		var jsonStr = $("#formId").serialize();
		console.log(jsonStr);
		$.ajax({
			"url" : url,
			"data" : jsonStr,
			"type" : "POST",
			"dataType" : "json",
			"success" : function(data){
				/*$("#tabId td").remove();
				for(var i=0; i<data.stuList.length; i++){
					var str = "<tr align='center'>" +
					"<td>"+data.stuList[i].tid+"</td>" +
					"<td>"+data.stuList[i].stuNo+"</td>" +
					"<td>"+data.stuList[i].stuName+"</td>" +
					"<td>"+data.stuList[i].stuSex+"</td>" +
					"<td><a href='/StuInfo/User/delete_user.action?tid="+data.stuList[i].tid+"'>删除</a></td>" +
					"<td><a href=''>修改</a></td>" +
					"</tr>";
					
					$("#tabId").append(str);
				}*/
			},
			"error" : function(data){
				
			}
		});
	});
	
});




















