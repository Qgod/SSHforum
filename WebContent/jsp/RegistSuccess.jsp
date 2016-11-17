<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- <meta http-equiv=refresh content="5;url=../jsp/Login.jsp"> -->
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<title>注册成功..</title>
<style type="text/css">
body {
	background-color: WhiteSmoke;
}

h2{
	font-family:'Trebuchet MS', sans-serif;
	color:RosyBrown;
	font-size: 3.1em;
	text-align: center;
	margin-top:100px;
}
div{
	text-align: center; 
	font-family: 微软雅黑; 
	color:CadetBlue;
}
.btn-default{
	border-color: BurlyWood;
	background-color: CadetBlue;
	margin-left:700px;
	width:10%;
	font-family: Microsoft YaHei;
	font-size: 1.2em;
	color: white;
}

</style>
</head>
<body>
	<h2>Registration success</h2>
	<hr>
	<div style="margin-left:-270px;">
		<span style="font-size: 2.0em;">您现在可以：</span>
		<br>
		<br>
	</div>
	<div style="margin-left:-72px; font-size: 1.7em;">
		<span>吃饭</span><br/>
		<span>睡觉</span><br/>
		<span>去死</span><br/>
	</div>
	<br/>
	<br/>
	<input type="button"  value="立即体验" class="btn btn-default" onclick="window.location='../jsp/Login.jsp';" id="button">
</body>
</html>