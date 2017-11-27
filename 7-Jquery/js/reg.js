

window.onload = function(){
	//验证昵称  (3~6个字符，且不能包含@和#号)
	var name = document.getElementById("name");
	var d = name.onblur = function(){
		var nameRegex=/^[^@#]{2,5}$/;
		if(!nameRegex.test(name.value)){
	 		document.getElementById("nameid").innerHTML="<span style='color:red;'>* 昵称为2~5个字符，且不能包含”@”和“#“字符</span>";
	 		return false;
	 	}else{
	 		document.getElementById("nameid").innerHTML="";
	 		return true;
	 	}
	}
	
	//验证密码 （长度在6个字符到16个字符、不能包含空格、不能是9位以下的纯数字）
	var pass = document.getElementById("pass");
	var a = pass.onkeyup = function(){
		//验证长度
		var passReg = /^.{6,16}$/;
		//验证空格
		var passReg2 = /^[^ ]+$/;
		//验证纯数字
		var passReg3 = /^\d{1,9}$/;
		
		var a = passReg.test(pass.value);   true
		var b = passReg2.test(pass.value);   false
		var c = passReg3.test(pass.value);   true
		
		var p = document.getElementById("p");
		
		if(!a || !b || c){
			p.style="display:block";
		}else{
			p.style="display:none;";
		}
		
		if(!a){
			document.getElementById("p-1").style="color:red";
		}else{
			document.getElementById("p-1").style="color:#000";
		}
		
		if(!b){
			document.getElementById("p-2").style="color:red";
		}else{
			document.getElementById("p-2").style="color:#000";
		}
		
		if(c){
			document.getElementById("p-3").style="color:red";
		}else{
			document.getElementById("p-3").style="color:#000";
		}
		
		if(!a || !b || c){
			return false;
		}else{
			return true;
		}
	}
	
	//验证密码是否一样  (3~6个字符，且不能包含@和#号)
	var pass = document.getElementById("pass");
	var repass = document.getElementById("repass");
	var b = repass.onblur = function(){
		if(pass.value !== repass.value){
	 		document.getElementById("repassid").innerHTML="<span style='color:red;'>* 两次密码不一致</span>";
	 		return false;
	 	}else{
	 		document.getElementById("repassid").innerHTML="";
	 		return true;
	 	}
	}
	
	//验证手机号 
	var phone = document.getElementById("phone");
	var c = phone.onblur = function(){
		var nameRegex=/^(((1[3456789][0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		if(!nameRegex.test(phone.value)){
	 		document.getElementById("phoneid").innerHTML="<span style='color:red;'>* 手机号不正确</span>";
	 		return false;
	 	}else{
	 		document.getElementById("phoneid").innerHTML="";
	 		return true;
	 	}
	}
}












