<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../bootstrap3/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="../bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">  
*{  
 margin:0;  
 padding:0;  
}  
body{  
 padding:10px;  
 font-family:Arial;  
}  
#ididid{  
 width:150px;  
 line-height:20px;  
 overflow:hidden;  
 border:1px solid #999;  
}  
</style>  
</head>  
<body>  
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">加载模态框</button> 
 
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
  <div class="modal-dialog">  
    <div class="modal-content">  
      <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">返回</button>  
        <h4 class="modal-title" style="font-family: 微软雅黑;">提问</h4>  
      </div>  
      <div class="modal-body">  
        <input type="text">  
      </div>  
      <div class="modal-footer">  
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
        <button type="button" class="btn btn-primary">Save changes</button>  
      </div>  
    </div><!-- /.modal-content -->  
  </div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
</body>  
</html>