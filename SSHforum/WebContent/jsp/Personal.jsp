<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<link href="../css/Personal.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/Personal.js"></script>

<title>个人信息</title>
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
						<li><a href="#" id="main"><font>首页</font></a></li>
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
								<li><a href="getMycontent"><span
										class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;个人信息</a></li>
								<li><a data-toggle="modal" data-target="#myModal-received"
									style="cursor: pointer;"> <span
										class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp;
										私信 &nbsp;<span class="badge">0</span>
								</a></li>
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
	<!-- 中间Content -->
	<div class="Content_Personal">
		<div class="PersonalInfo">
			<span class="glyphicon glyphicon-user"></span>&nbsp;<span>${userInfo.nickname}>>完善个人信息</span>
			<hr>
			<div class="PersonalInfo_detail">
				<span class="warning"></span>
				<div id="AddressInfo">

					<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<span>完善居住地址&nbsp;&nbsp;&nbsp;<span
						id="font1">${userInfo.address}</span></span><br>
				</div>
				<div id="AddressText">
					<input type="text" class="form-control" placeholder="居住地址"
						style="float: left; width: 200px;" name="address"> <input
						type="button" class="button-style" value="提交" id="alterAddress">
				</div>
				<div id="WorkInfo">
					<span class="glyphicon glyphicon-glass"></span>&nbsp;<span>完善工作信息&nbsp;&nbsp;&nbsp;<span
						id="font2">${userInfo.worktype}</span></span><br>
				</div>
				<div id="WorkText">
					<input type="text" class="form-control" placeholder="工作信息"
						style="float: left; width: 200px; width: 200px;" name="worktype">
					<input type="button" class="button-style" value="提交"
						id="alterWorktype">
				</div>

				<div id="EducationInfo">
					<span class="glyphicon glyphicon-briefcase"></span>&nbsp;<span>完善教育背景&nbsp;&nbsp;&nbsp;<span
						id="font3">${userInfo.education}</span></span><br>
				</div>
				<div id="EducationText">

					<select class="form-control" style="width: 120px; float: left;"
						name="education">
						<option value=""></option>
						<option value="博士以上">博士以上</option>
						<option value="博士">博士</option>
						<option value="硕士">硕士</option>
						<option value="本科">本科</option>
						<option value="高中">高中</option>
						<option value="初中">初中</option>
						<option value="初中以下">初中以下</option>
					</select> <input type="button" class="button-style" value="提交"
						id="alterEducation">

				</div>
				<div id="IntroduceMyself">
					<span class="glyphicon glyphicon-heart"></span>&nbsp;<span>一句话介绍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
						id="font4">${userInfo.introduce}</span></span>
				</div>
				<div id="IntroduceText">

					<input type="text" class="form-control" placeholder="一句话介绍"
						style="float: left; width: 200px;" name="introduce"> <input
						type="button" class="button-style" value="提交" id="alterIntroduce">

				</div>
			</div>
		</div>
		<br>
		<div class="Myquestion">
			<span>我的问题</span>
			<hr>
			<s:iterator value="#session.mycontentinfo">
				<div class="browseNumber" title="回复量">
					<span>${replys}</span>
				</div>
				<div class="question">
					<a href="CheckInfo?contentid=${id}"> ${title} </a>
				</div>
				<hr>
			</s:iterator>
		</div>
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