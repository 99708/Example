<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登录后台管理系统</title>
    
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
	<script src="js/cloud.js" type="text/javascript"></script>
	
	<script language="javascript">
		$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    })  
	});  
	</script> 
	
	</head>
	
	<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	
	
	
	    <div id="mainBody">
	      <div id="cloud1" class="cloud"></div>
	      <div id="cloud2" class="cloud"></div>
	    </div>  
	
	
		<div class="logintop">    
		    <span>欢迎访问尚学堂OA系统</span>    
		    <ul>
		    <li><a href="#">回首页</a></li>
		    <li><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    </ul>    
		    </div>
		    
		    <div class="loginbody">
		    
		    <span class="systemlogo"></span> 
		       
		    <div class="loginbox loginbox2">
		    <form action="loginServlet.servlet?method=login" method="post">
			    <ul>
				    <li><input name="empid" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
				    <li>
				    	<input name="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/><br />
				    	<font color="red">${error_name }</font>
				    </li>
				    <li class="yzm">
					    <span>
					    	<input name="verify" type="text" value="验证码" onclick="JavaScript:this.value=''"/>
					    </span>
					    
				    	<cite>
				    		<img id="varifyId" alt="验证码" src="system/validate/image.jsp" width="110" height="46">
				    	</cite> 
			    		<font color="red">${error }</font>
				    </li>
				    <li>
				    	<input type="submit" class="loginbtn" value="登录"/>
				    	<label>
				    		<input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a>
				    	</label>
				    </li>
			    </ul>
		    </form>
		    
		    
		    </div>
	    
	    </div>
	    
	</body>
	
</html>
