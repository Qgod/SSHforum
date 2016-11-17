<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<link href="../css/ChangePassword.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(e){
		
			console.log($(this).val());
			console.log($("#password").val());
			if($("#password").val()==$("#repassword").val())
			{
				 $("#span").html("<font>两次密码一致</font>");
				 $("#formSubmit").submit();
				document.getElementById("submit").removeAttribute("disabled"); 
				
			}
			else
			{
				e.preventDefault();
				 $("#span").html("<font>两次密码不一致</font>"); 				 
				// document.getElementById("submit").disabled = "true";
			}
		});
	});
</script>
<title>重置密码</title>
</head>
<body>
	<div id="Content">
		<h2>Set Password</h2>
		<br/>
		<br/>
		<hr>
		<form style="margin-left:110px;" action="Change_changePassword" method="post" id="formSubmit">
			<span id="span" style="font-family: 微软雅黑; color: DarkRed"></span>
			<input type="password" placeholder="PASSWORD" name="userInfo.password" class="form-control" id="password"> 
			<br>
			<input type="password" placeholder="REPASSWORD" class="form-control" id="repassword"> 
			<br>
			<input type="submit" value="修改密码" class="btn btn-default" id="submit">
		</form>
	</div>
</body>
</html>