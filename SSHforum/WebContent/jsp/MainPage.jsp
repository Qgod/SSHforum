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
<link href="../css/MainPage.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/TextSize.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#GoodPoint").mouseover(function() {
			$(this).css("background-color", "lightgray");
		});
		$("#GoodPoint").mouseout(function() {
			$(this).css("background-color", "Azure");
		});
		$("#beforeaction").click(function() {
			if ($("#now").val() == 0) {
				//..
			}
		});

	});
</script>
<title>xxxxx-首页</title>

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
										私信 &nbsp;<span class="badge">${userInfo.privateletternumber}</span>
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
	<!-- Content -->
	<!-- 以下是中间Content -->
	<div id="Content">
		<!-- 左边Content -->
		<div id="Content_Left">
			<div id="new">
				<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp;<span>最新动态</span>
			</div>
			<hr style="border-color: lightgray">
			<s:iterator value="#session.contentInfo">

				<div id="replyNumber" title="回复">
					<font style="color: #698ebf;">&nbsp;${replys}</font>
				</div>
				<div id="details">
					<div id="topic">
						话题：${topic} <font style="color: gray; float: right;">创建时间：${createtime}</font>
					</div>
					<div id="title">
						<a href="CheckInfo?contentid=${id}" style="color: #259;">${title}</a>
					</div>
					<div id="from">
						<a
							href="checkOtherUserInfo_showTheUserInfo?NowUserInfoid=${userInfo.id}"
							style="font-weight: 700;">${userInfo.nickname}</a>&nbsp;&nbsp;&nbsp;<font
							style="color: gray;">${userInfo.introduce}</font>
					</div>
					<div id="MainText">&nbsp;&nbsp;&nbsp;&nbsp; ${content}</div>
					<hr style="border-color: lightgray;">
				</div>

			</s:iterator>
			<div id="paging">
				<a href="page_BeforePage?NowPage=${NowPage-1}" id="beforeaction"><span
					class="label label-primary">上一页</span></a> &nbsp; <input type="hidden"
					value="${NowPage-1}" id="now"> <a
					href="page_AfterPage?NowPage=${NowPage+1}"><span
					class="label label-primary">下一页</span></a> <br> <br>
				<div style="padding-right: -35px;">
					<font style="color: gray; font-size: 13px;">共有${PerPage}页 </font> <br>
					<form action="page_JumpPage" method="post">
						<font style="color: gray; font-size: 13px;"> 直接到第 <input
							type="text" class="JumpPage" name="PageNumber">页
						</font> <input type="submit" value="跳" class="JumpBtn">
					</form>
				</div>
			</div>
		</div>
		<!-- 右边Content-->
		<div id="Content_Right">
			<div class="myInfo">
				<ul class="nav nav-stacked">
					<li><a href="#"><span class="glyphicon glyphicon-pencil"></span>&nbsp;我的草稿</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-bookmark"></span>&nbsp;我的收藏</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-th"></span>&nbsp;话题广场</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-ok"></span>&nbsp;我关注的问题</a></li>
				</ul>
			</div>
			<hr style="border-color: lightgray;">
			<div class="others"></div>
		</div>
	</div>
	<script type="text/javascript">
		testAuto('MainText', 140);
	</script>
	<!-- 接受私信模态框 -->
	<div class="modal fade in" id="myModal-received" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content"
				style="height: 500px; width: 640px; margin-top: 10px; margin-right: 150px;">
				<div class="modal-header">
					<h4 class="modal-title">您有${userInfo.privateletternumber}条私信</h4>
				</div>
				<s:iterator value="#session.myprivateletter">
					<div class="modal-body" style="font-family: 微软雅黑; color: gray;">
						<div>
							来自<a href="checkOtherUserInfo_showTheUserInfo?NowUserInfoid=${userInfo.id}"><span>${userInfo.nickname}：</span></a>
							<font style="float: right; color:gray;font-size: 10px;">创建时间:${createtime}</font>
						</div>
						<div style="padding-left: 80px; padding-top:30px;">
							<span>${lettercontent}</span>
							<div style="margin-left: 450px;">
								<a href="#"><span>回复</span></a>&nbsp;&nbsp;&nbsp;<a href="#"><span>删除</span></a>
							</div>
						</div>
					</div>
				</s:iterator>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal"
						class="privateLetter-btn">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



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