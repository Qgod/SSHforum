<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<link href="../css/ChangePassword.css" rel="stylesheet" type="text/css">
<title>修改密码</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#question").dblclick(function(){
			document.getElementById("question").removeAttribute("readonly");
		});
		$("#username").dblclick(function(){
			document.getElementById("username").removeAttribute("readonly");
		});
	});
</script>
</head>
<body>
	<div id="Content">
		<h2>Modify Password</h2>
		<br/>
		<br/>
		<hr>
		<s:actionerror
			style="font-size:1.2em;
							  margin-left:135px;
							  color:RosyBrown;
							  font-family: Microsoft YaHei;" />
		<form style="margin-left:110px;" action="Change_validateQuestion" method="post">
			<input type="text" placeholder="USERNAME" name="userInfo.username" class="form-control" value="${user.username}" readonly="readonly" id="username"> 
			<br>
			<br>
			<input type="text" placeholder="QUESTION" name="userInfo.question" class="form-control" value="${user.question}" readonly="readonly" id="question"> 
			<input type="text" placeholder="ANSWER" name="userInfo.answer" class="form-control"> 
			<br>
			<input type="submit" value="验证" class="btn btn-default">
		</form>
	</div>
		
</body>
</html>