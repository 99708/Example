<%@ page language="java" isELIgnored="false"  import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	  <head>
		    <base href="<%=basePath%>">
		    
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<link rel="stylesheet" type="text/css" href="css/style.css" />
			<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
			<link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
			<link href="umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
			<script type="text/javascript" src="js/jquery.js"></script>
			<script type="text/javascript" src="js/global.js"></script>
			<script type="text/javascript" src="js/jquery.select.js"></script>
			<script type="text/javascript" src="js/WdatePicker.js"></script>
			<script type="text/javascript">
			</script>
			<script type="text/javascript" src="js/umeditor.config.js"></script>
			<script type="text/javascript" src="js/editor_api.js"></script>
			<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
			<title>用户注册</title>
	</head>

	<body>
		<div id="container">
			<div id="hd">
		    </div>
		    <div id="bd">
		    	<div id="main">
		            <h2 class="subfild">
		            	<span>用户注册</span>
		            </h2>
		    		<form action="userServlet.bjsxt?method=add" method="post">
		    			        <div class="subfild-content base-info">
		                <div class="kv-item ue-clear">
		            		<label><span class="impInfo">*</span>登录名称 ： </label>
		            		<div class="kv-item-content">
		                    	<input type="text"  name ="uname" id="uname" placeholder="登录名称" />
		                    </div>
		                </div>
		                <div class="kv-item ue-clear">
		            		<label><span class="impInfo">*</span>登录密码 ： </label>
		            		<div class="kv-item-content">
		                    	<input type="text" name="pwd"  id="pwd" placeholder="登录密码" />
		                    </div>
		                </div>
		                <div class="kv-item ue-clear">
		            		<label><span class="impInfo">*</span>用户昵称 ： </label>
		            		<div class="kv-item-content">
		                    	<input type="text" name="name"  id="name"placeholder="用户昵称" />
		                    </div>
		                </div>
		                <div class="kv-item ue-clear">
		                	<label>权限</label>
		                	<div class="kv-item-content">
		                    	<select name="rid" >
		                        	<option value="1">学生</option>
		                        	<option value="2">老师</option>
		                        	<option value="3">管理员</option>
		                        </select>
		                        
		                    </div>
		                </div>
		            </div>
		            <div class="submits" style="float: left;">
		                <input class="submit" type="submit" value="提交" />
		            </div>
		    		</form>
		           
		            &nbsp;&nbsp;&nbsp;&nbsp;
		            <div>
		            	<c:if test="${i>0 }">
		            	 添加成功！
		            	</c:if>
		            	<c:if test="${i<0 }">
		            	 添加失败！
		            	</c:if>
		            </div>
		        </div>
		    </div>
		</div>
	</body>

<script type="text/javascript">
	$('select').select();
	showRemind('input[type=text],textarea','color5');
	UM.getEditor('content');


</script>
</html>