<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-color: #EEF2FB;
			}
	</style>
  </head>
  
  <body>
    <center><div class="left_txt"><img src="images/icon-mail2.gif" width="16" height="11"> 客户服务邮箱：610418406@qq.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="images/icon-phone.gif" width="17" height="14"> <a href="http://weibo.com/u/1629563394">官方微博：http://weibo.com/u/aiyobucuoo</a></div></center>
  </body>
</html>
