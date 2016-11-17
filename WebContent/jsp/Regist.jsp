<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="../js/ValidateUsername.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/Regist.css" rel="stylesheet" type="text/css">
<title>注册</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(e){
			$("input").each(function(){
				if($(this).val()!="")
				{
					$("#formSubmit").submit();
				}
				else
				{
					e.preventDefault();
					$("#span").html("<font>请填写完整的信息!</font>")
				}
			});
		});
		
		$(function(){
			$(":input[name='userInfo.username']").change(function(){
				var val = $(this).val();
				val = $.trim(val);
				if(val != "")
				{
					var url = "viladateUsername";
					var args={"username":val,"time":new Date()};
					
					$.post(url, args, function(data){
						$("#span").html(data);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="Content">
		<h2>Sign In</h2>
		<br/>
		<p style="font-family:'Trebuchet MS', sans-serif; font-size: 1.6em;color: black;">Share your shit knowledge with the world.</p>
		<hr>
		<br/>
		<form style="margin-left:110px;" action="saveUserInfo" method="post" id="formSubmit">
			<span id="span"></span>
			<input type="text" name="userInfo.username" width="50%" placeholder="USERNAME"  class="form-control" id="username">	
			<input type="password" name="userInfo.password" width="50%" placeholder="PASSWORD"  class="form-control">
			<input type="tel" name="userInfo.phoneNumber" width="50%"  placeholder="PHONENUMBER" class="form-control">
			<input type="email" name="userInfo.email" width="50%"  placeholder="E-MAIL"  class="form-control">
			<input type="text" name="userInfo.nickname" width="50%"  placeholder="NICKNAME"  class="form-control">
			<br>
			<input type="text" name="userInfo.question" width="50%"  class="form-control" placeholder="QUESTION"><span>例如:我最爱的美食是什么？</span>
			<input type="text" name="userInfo.answer" width="50%"  class="form-control" placeholder="ANSWER">
			<br>
			<input type="hidden" name="userInfo.address" value="暂无"/>
			<input type="hidden" name="userInfo.worktype" value="暂无"/>
			<input type="hidden" name="userInfo.education" value="暂无"/>
			<input type="hidden" name="userInfo.introduce" value="暂无"/>
			<input type="hidden" name="userInfo.privateletternumber" value=0>
			<input type="submit" value="立即注册" class="btn btn-default" id="submit">
		</form>
	</div>
	<hr>
	<div id="action">
		<p>*已有账号，立即<a href="../jsp/Login.jsp" style="text-decoration: underline;">登录</a>。<p>
	</div>
</body>
</html>