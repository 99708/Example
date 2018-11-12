<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="deptAdd.html" target="rightFrame" class="selected"><img src="images/icon01.png" title="添加部门" /><h2>添加部门</h2></a></li>
    <li><a href="empAdd.html" target="rightFrame"><img src="images/icon02.png" title="添加员工" /><h2>添加员工</h2></a></li>
    <li><a href="empList.html"  target="rightFrame"><img src="images/icon03.png" title="员工管理" /><h2>员工管理</h2></a></li>
    <li><a href="expenseAdd.html"  target="rightFrame"><img src="images/icon04.png" title="添加报销" /><h2>添加报销</h2></a></li>
    <li><a href="dutyAdd.html" target="rightFrame"><img src="images/icon05.png" title="签到签退" /><h2>签到签退</h2></a></li>
    <li><a href="myInfo.html"  target="rightFrame"><img src="images/icon06.png" title="我的信息" /><h2>我的信息</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="tech.html" target="rightFrame">帮助</a></li>
    <li><a href="loginServlet.servlet?method=loginOut" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    	<span><a href="empServlet.servlet?method=showEmp&empid=${emp.empid }" target="rightFrame">${emp.empid }</a></span>
    </div>    
    
    </div>

</body>
</html>
