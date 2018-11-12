<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/skin_/login.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.select.js"></script>
 <title>数字管理系统_用户登录</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div id="main">
    	<form action="loginServlet.bjsxt?method=login" method="post">
    	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
                <div class="input username" id="username">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="userName" name="userName"/>
                         
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <input type="password" id="password" name="password" />
                       
                </div>
                
                <div class="input validate" id="validate">
                      <li class="yzm">
                      <cite>
						    	<img id="verifyid" alt="验证码" width="65px" height="37px" src="system/validate/image.jsp" />
						    </cite> 
					    <span><input name="verify" type="text"    placeholder="验证码"  /></span>
					    	<!-- 生成并展示验证码 -->
						    
					    </li>
					    <li>${error }</li>
					     <li>${error_name }</li>
                </div>
                <div class="styleArea">
                    <div class="styleWrap">
                        <select name="rid" id="rid" >
                            <option value="1">学生</option>
                            <option value="2">教师</option>
                            <option value="3">管理员</option>
                        </select>
                    </div>
                </div>
                <div id="btn" class="loginButton">
                    <input type="submit" class="sub" value="登录"  />
                </div>
            </div>
    	
    	</form>
        	
        </div>
        <div id="ft">CopyRight&nbsp;2014&nbsp;&nbsp;版权所有&nbsp;&nbsp;Uimaker.com 仅供学习参考 &nbsp;&nbsp;苏ICP备09003079号</div>
    </div>
   
</div>
</body>
<script type="text/javascript">
	//整个页面
 	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	//登陆页面框
	 var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	$('select').select(); 
	$(function(){
		
		$("#verifyid").click(function(){
			//随机 数防止浏览器缓存  new Date().getTime() 
			$(this).attr("src" ,"system/validate/image.jsp?"+new Date().getTime() );
		})
		
	})
		//定时刷新验证码，防止session过期
		window.setInterval(function(){
			$("#verifyid").attr("src" ,"system/validate/image.jsp?"+new Date().getTime() );
		}, 1000*60*10);//10分钟刷新一次

</script>
</html>

