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
<link href="../css/SearchPage.css" rel="stylesheet" type="text/css">
<title>搜索结果</title>
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
					<form class="navbar-form navbar-left" role="search" action="SearchContent"
						method="post">
						<input type="text" class="form-control" placeholder="搜索您感兴趣的东西" name="searchContent">
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav" id="main_find_message">
						<li><a href="../jsp/MainPage.jsp" id="main"><font>首页</font></a></li>
						<li><a href="#"><font>发现</font></a></li>
						<li><a href="#"><font>消息</font></a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" data-toggle="modal" data-target="#myModal"
							id="sendquestion"><font>提问</font></a></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false" id="personal"><font>${userInfo.nickname}</font>
								<span class="caret"></span></a>
							<ul class="dropdown-menu" id="personalInfo">
								<li><a href="getMycontent"><span class="glyphicon glyphicon-user"
										aria-hidden="true"></span>&nbsp;个人信息</a></li>
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
	<!-- Content -->
	<div class="Content-left">
		<div class="Content-title"> 
			<span>关于“${searchContent}”的相关内容</span>
		</div>
		<hr style="border-color: lightgray;">
		<s:iterator value="#session.ContentList">
		<div class="Content-body">
			<div class="Content-body-head">
				<a href="#"><img alt="" src="../images/headP2.png"></a>
			</div>
			<div class="Content-body-title">
				<a href="CheckInfo?contentid=${id}"><span>${title}</span></a>
			</div>
			<div class="Content-body-name">
				<a href="#"><span>${userInfo.nickname}</span></a>
			</div>
			<div class="Content-body-content">
				${content}
			</div>
		</div>
		</s:iterator>
		<hr>
	</div>
	<div class="Content-right">
		<div class="Content-title">
			<span>相关用户</span>
		</div>
		<hr style="border-color: lightgray;">
		<s:iterator value="#session.UserList">
		<div class="Content-userInfo">
			<div class="Content-userInfo-head">
				<img alt="" src="../images/123.png">
			</div>
			<div class="Content-userInfo-name">
				<a href="#"><span>${nickname}</span></a>
			</div>
			<div class="Content-userInfo-simpleIntorduce">
				<span>${introduce}</span>
			</div>
		</div>
		</s:iterator>
		
	</div>
	
	
	
	<!-- 提问模态框 -->
	<div class="modal fade in" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
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