<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<link href="../css/OtherPerson.css" rel="stylesheet" type="text/css">
<title>${NowUserInfo.nickname}的shit主页</title>
</head>
<body>
	<!-- head -->
	<div id="head">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="../jsp/MainPage.jsp"><font>Shit</font></a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search"
						action="SearchContent" method="post">
						<input type="text" class="form-control" placeholder="搜索您感兴趣的东西"
							name="searchContent">
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav" id="main_find_message">
						<li><a href="../jsp/MainPage.jsp" id="main"><font>首页</font></a></li>
						<li><a href="#"><font>发现</font></a></li>
						<li><a href="#"><font>消息</font></a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" data-toggle="modal"
							data-target="#myModal-issue" id="sendquestion"><font>提问</font></a></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false" id="personal"><font>${userInfo.nickname}</font>
								<span class="caret"></span></a>
							<ul class="dropdown-menu" id="personalInfo">
								<li><a href="getMycontent"><span
										class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;个人信息</a></li>
								<li><a data-toggle="modal" data-target="#myModal-received" style="cursor: pointer;">
									<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp; 私信 &nbsp;<span class="badge">0</span>
									</a>
								</li>
								<li><a href="#"><span class="glyphicon glyphicon-cog"
										aria-hidden="true"></span>&nbsp;设置</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="../jsp/Login.jsp"><span
										class="glyphicon glyphicon-off" aria-hidden="true"></span>&nbsp;退出</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="Content-otherInfo">
		<div class="Content-otherInfo-nickname">
			<span>${NowUserInfo.nickname}</span>
		</div>
		<div class="Content-otherInfo-head">
			<img alt="" src="../images/headP.png">
		</div>
		<div class="Content-otherInfo-detailInfo">
			<span class="glyphicon glyphicon-glass"></span>&nbsp;&nbsp;&nbsp;<span>行业：${NowUserInfo.worktype}</span><br>
			<span class="glyphicon glyphicon-map-marker"></span>&nbsp;&nbsp;&nbsp;<span>位置：${NowUserInfo.address}</span><br>
			<span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;&nbsp;<span>教育：${NowUserInfo.education}</span>
		</div>
		<div class="Content-otherInfo-Intorduce">
			<span>${NowUserInfo.introduce}</span>
		</div>
		<hr style="border-color: lightgray; margin-top: 100px;">

		<div class="privateLetter">
			<button class="privateLetter-btn" data-toggle="modal"
				data-target="#myModal-letter">私信</button>
		</div>
	</div>
	<div class="Content-Others-issue-title">他的提问</div>
	<s:iterator value="#session.NowContentInfo">
		<div class="Content-Others-issue">
			<br>
			<div class="Content-Others-issue-replyNumber">
				<span title="回复量">${replys}</span>
			</div>
			<div class="Content-Others-issue-content">
				<a href="CheckInfo?contentid=${id}"><span>${title}</span></a>
			</div>
		</div>
	</s:iterator>





	<!-- 私信模态框 -->
	<div class="modal fade in" id="myModal-letter" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content"
				style="height: 240px; width: 420px; margin-left: 70px;">
				<form action="privateLetter_SendPrivateLetter" method="post">
					<s:token></s:token>
					<div class="modal-header">
						<h4 class="modal-title">私信</h4>
					</div>
					<div class="modal-body" style="font-family: 微软雅黑; color: gray;">
						<span>发给：${NowUserInfo.nickname}</span>
					</div>
					<div style="margin-left: 22px;">
						<textarea rows="4" cols="50"
							style="border-color: lightgray; border-radius: 5px; font-family: 微软雅黑;" name="privateLetter.lettercontent"></textarea>
					</div>
					<div class="modal-footer">
						<button type="submit" class="privateLetter-btn">发送</button>
						<button type="button" data-dismiss="modal"
							class="privateLetter-btn">关闭</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- 提问模态框 -->
	<div class="modal fade in" id="myModal-issue" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="issueContent" method="post">
					<s:token></s:token>
					<div class="modal-header">
						<h4 class="modal-title">提问</h4>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control" placeholder="在这里写下你要bb的标题"
							name="contentInfo.title"> <br>
						<textarea rows="5" cols="70" placeholder="在这里写下你要bb的内容"
							class="form-control" name="contentInfo.content"></textarea>
						<br> <input type="text" class="form-control"
							placeholder="话题（至少添加一个话题,如：健身、时尚、美食等话题）" name="contentInfo.topic">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">发布</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>