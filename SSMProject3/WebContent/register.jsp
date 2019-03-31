<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		var username = false;
		var password = false;
		var passwordSure = false;
		//用户名验证
		$(":text:eq(0)").blur(function() {
			if($(this).val() == ""){
				$(this).next().css("color","green").html("X");
				username = false;
			}else{
				$(this).next().css("color","red").html("√");
				username = true;
			}
		})
		//密码验证
		$(":password:eq(0)").blur(function() {
			if(!$(this).val().match(/^\w{6,12}$/)){
				$(this).next().css("color","green").html("X");
				password = false;
			}else{
				$(this).next().css("color","red").html("√");
				password = true;
			}
		})
		//确认密码验证
		$(":password:eq(1)").blur(function() {
			if($(this).val() == "" || $(this).val() != $(":password:eq(0)").val()){
				$(this).next().css("color","green").html("X");
				passwordSure = false;
			}else{
				$(this).next().css("color","red").html("√");
				passwordSure = true;
			}
		})
		
		$(":submit").click(function(){
			if(username == false || password == false || passwordSure == false || $(":file").val() == ""){
				alert("请添加完整信息");
				return false;
			}
		})
	})
</script>
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
	用户名:<input type="text" name="username"/><span></span><br/>
	密码:<input type="password" name="password"/><span></span><br/>
	确认密码:<input type="password" name="passwordSure"/><span></span><br/>
	头像:<input type="file" name="file"/><br/>
	<input type="submit" value="注册"/>
</form>
</body>
</html>