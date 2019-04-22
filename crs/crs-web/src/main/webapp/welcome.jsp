<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	  <title>无标题文档</title>
	  <link href="css/style.css" rel="stylesheet" type="text/css" />
	  <link href="css/base.css" rel="stylesheet">
	  <script type="text/javascript" src="js/jquery.js"></script>

  </head>


  <body>

  <div class="place">
	  <div id="inner-hd">
		  <div class="crumbs">
			  <i class="crumbs-arrow"></i>
			  <a href="javascript:void(0);" class="crumbs-label">首页</a>
		  </div>
	  </div>
  </div>
  <div class="mainindex">
	  <div class="welinfo">
		  <span><img src="images/welcome.jpg" alt="welcome"  width="100%" height="100%" style="z-index:-100;position:absolute;left:0;top:0;"/></span>
		  <span class="welcome">欢迎访问997汽车租赁系统</span>
	  </div>
  </div>
  </body>
</html>
