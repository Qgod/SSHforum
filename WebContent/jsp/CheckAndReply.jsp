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
<script type="text/javascript" src="../js/reply.js"></script>
<link href="../css/CheckAndReply.css" rel="stylesheet" type="text/css">
<title>回复</title>
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
	<!-- 中间Content -->
	<div class="Content">
		<div class="Content-title">
			<span>&nbsp;&nbsp;&nbsp;&nbsp;标题：${NowContentInfo.title}</span>
		</div>
		<div class="Content-main">
			<div class="Content-main-left">
				<div class="Content-main-picture">
					<a href="#"><img alt="" src="../images/headP.png"></a>
				</div>
				<div class="Content-main-left-name">
					<a href="#" style="color: Tan;"><span>${NowContentInfo.userInfo.nickname}</span></a>
				</div>
			</div>

			<div class="Content-main-right">
				<span>${NowContentInfo.content}</span>
				<div class="Content-main-showtime">
					<span>Time：${NowContentInfo.createtime}</span>
				</div>
			</div>



		</div>
		<hr>
		<!-- 评论区 -->
		<s:iterator value="#session.ThisComment">
		<div class="comment-region">
				<div class="comment-region-left">
					<div class="comment-region-picture">
						<a href="#"><img alt="" src="../images/headP2.png"></a>
					</div>
					
					<div class="comment-region-left-name">
						<a href="#" style="color: Tan;"><span>${userInfo.nickname}</span></a>
					</div>
					
					<div class="comment-region-praise">
						<span class="glyphicon glyphicon-thumbs-up" ><!-- <a title="赞"> -->(${praisenumber})<!-- </a> --></span>	
						<input type="hidden" value="${id}" name="cm_id"/> 
					</div>
				</div>

				<div class="comment-region-right">
					<span>${comment}</span>
					<div class="comment-region-showtime">
						<span>Time：${commenttime}</span> <span class="replySpan">回复(0)</span>
					</div>
					
				<div class="reply">
					<a href="#"><span>加个小括号：</span></a>哈哈哈<span class="replyTime">回复时间:2016-09-22</span><br>
					<hr>
					<form>
						<textarea rows="2" cols="50" class="form" placeholder="我来说一句...."></textarea>
						<div class="replyBtn">
							<input type="submit" value="我也说一句">
						</div>
					</form>
				</div>
			</div>
		</div>
		
		</s:iterator>
		<div id="paging">
			<a href="" id="beforeaction"><span class="label label-primary">上一页</span></a>
			&nbsp; <a href=""><span class="label label-primary">下一页</span></a> <br>
			<br>
			<div style="padding-right: -35px;">
				<font style="color: gray; font-size: 13px;">共有1页 </font> <br>
				<form action="page_JumpPage" method="post">
					<font style="color: gray; font-size: 13px;"> 直接到第 <input
						type="text" class="JumpPage" name="PageNumber">页
					</font> <input type="submit" value="跳" class="JumpBtn">
				</form>
			</div>
		</div>
		<!-- footer -->
		<hr style="border-color: lightgray;">
		<div class="footer">
			<span class="issueReply">发表评论</span>
			<form action="comment_SaveCommentInfo" method="post">
				<s:token></s:token>
				<textarea rows="10" cols="45" placeholder="妈的我受不了了。我不想写了我操....."
					name="commentInfo.comment"></textarea>
				<input type="submit" class="issueReplyBtn" value="发表">
			</form>
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