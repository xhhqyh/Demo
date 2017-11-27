
$(document).ready(function(){
	
	//验证昵称  (3~6个字符，且不能包含@和#号)
	$("#name").blur(function(){
		var str = $("#name").val();
		var nameRegex=/^[^@#]{2,5}$/;
		if( !nameRegex.test(str) ){
			$("#nameid").html("<span style='color:red;'>* 昵称为2~5个字符，且不能包含”@”和“#“字符</span>");
			return true;
		}else{
			$("#nameid").html("");
			return false;
		}
	});
	
	//验证密码 （长度在6个字符到16个字符、不能包含空格、不能是9位以下的纯数字）
	$("#pass").keyup(function(){
		//验证长度
		var passReg = /^.{6,16}$/;
		//验证空格
		var passReg2 = /^[^ ]+$/;
		//验证纯数字
		var passReg3 = /^\d{1,9}$/;
		
		var a = passReg.test($("#pass").val());   
		var b = passReg2.test($("#pass").val());   
		var c = passReg3.test($("#pass").val()); 
		
		if(!a || !b || c){
			$("#p").css("display", "block");
		}else{
			$("#p").css("display", "none");
		}
		
		if(!a){
			$("#p-1").css("color", "red");
		}else{
			$("#p-1").css("color", "#000");
		}
		
		if(!b){
			$("#p-2").css("color", "red");
		}else{
			$("#p-2").css("color", "#000");
		}
		
		if(c){
			$("#p-3").css("color", "red");
		}else{
			$("#p-3").css("color", "#000");
		}
		
		if(!a || !b || c){
			return false;
		}else{
			return true;
		}
		
	});
	
	//验证密码是否一样  (3~6个字符，且不能包含@和#号)
	$("#repass").blur(function(){
		if( $("#repass").val() != $("#pass").val()){
			$("#repassid").html("<span style='color:red;'>* 两次密码不一致</span>");
			return false;
		}else{
			$("#repassid").html("");
			return true;
		}
	});
	
	//验证手机号 
	$("#phone").blur(function(){
		var str = $("#phone").val();
		var phoneRegex=/^(((1[3456789][0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		if( !phoneRegex.test(str) ){
			$("#phoneid").html("<span style='color:red;'>* 手机号不正确</span>");
			return true;
		}else{
			$("#phoneid").html("");
			return false;
		}
	});
	
	
});
