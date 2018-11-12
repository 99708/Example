<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dutyAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
  </head>

	<body>
	
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">考勤管理</a></li>
	    <li><a href="#">签到签退</a></li>
	    </ul>
	    </div>
	    
	    <div class="formbody">
	    
	    <div class="formtitle"><span>基本信息</span></div>
	    
	    <ul class="forminfo">
	    	<li><label>&nbsp;</label><input name="" type="button" class="btn" value="签到"/> 每天签到一次，不可重复签到</li>
	        <li><label>&nbsp;</label></li>
	    	<li><label>&nbsp;</label></li>
	      	<li><label>&nbsp;</label><input name="" type="button" class="btn" value="签退"/>可重复签退，以最后一次签退为准</li>
	    </ul>
	    </div>
		<script type="text/javascript">
			$(function(){
				var flag = false;
				$.ajax({
					url:"dutyServlet.serlet?method=findSign",
					type:"post",
					data:"",
					dataType:"json",
					success:function(rsData){
						console.log(rsData);
					}
				})
			})
		</script>
	
	</body>

</html>
