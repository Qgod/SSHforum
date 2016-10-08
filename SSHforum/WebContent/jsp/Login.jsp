<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/Login.css" rel="stylesheet" type="text/css">
<link href="../css/removePoint.css" rel="stylesheet" type="text/css">
<title>Shit</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#username1").mouseout(function() {
			var text = $(this).val();
			$("#username2").val(text);
		});
	});
</script>
</head>
<body>
	<div id="Content">
		<h2>Login</h2>
		<br /> <br />
		<hr>
		<s:actionerror
			style="font-size:1.0em;
							  margin-left:135px;
							  color:RosyBrown;
							  font-family: Microsoft YaHei;" />

		<form style="margin-left: 110px;" action="Login" method="post">
			<input type="text" name="userInfo.username" width="50%"
				placeholder="USERNAME" class="form-control" id="username1">
			<br/> <input type="password" name="userInfo.password" width="50%"
				placeholder="PASSWORD" class="form-control"> <br> <input
				type="submit" value="立即登录" class="btn btn-default" id="submit">
		</form>
	</div>
	<br>

	<hr>
	<div id="action">
		<p>or</p>
		<br>
		<form action="Change_getUsername" method="post">
			<input type="hidden" name="user_name" id="username2" />
			<!-- <a href="../jsp/alterPassword.jsp" style="text-decoration: underline;">忘记密码?</a> -->
			<input type="submit" value="忘记密码?" class="btn btn-xs"
				style="background-color: WhiteSmoke;">
		</form>
		<br> <br>
		<p>
			*没有账号?立即<a href="../jsp/Regist.jsp"
				style="text-decoration: underline;">注册</a>
		<p>
	</div>
</body>
</html>