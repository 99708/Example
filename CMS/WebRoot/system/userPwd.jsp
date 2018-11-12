<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		                    	<input type="text"  name ="uname" id="uname" placeholder="登录名称" 
		                    	value="
		                    	<c:if test="${tea eq null}">${fn:trim(stu.sid)} </c:if>
		                    	<c:if test="${stu eq null}">${fn:trim(tea.tid)}</c:if>
		                    	"
		                    	style="color: gray;" readonly="readonly"/>
		                    </div>
		                </div>
		                <div class="kv-item ue-clear">
		            		<label><span class="impInfo">*</span>新的密码 ： </label>
		            		<div class="kv-item-content">
		                    	<input type="password" name="pwd"  id="pwd"/>
		                    </div>
		                </div>
		                <div class="kv-item ue-clear">
		            		<label><span class="impInfo">*</span>确认密码 ： </label>
		            		<div class="kv-item-content">
		                    	<input type="password" id="pwdagain"/>
		                    </div>
		                </div>
		                
		            </div>
		            <div class="submits" style="float: left;">
		                <input class="submit" id="btn" type="button" value="提交" />
		            </div>
		    		</form>
		           
		            &nbsp;&nbsp;&nbsp;&nbsp;
		         
		        </div>
		    </div>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#btn").click(function(){
					var pwd1 = $("#pwd").val();
					var pwd2 = $("#pwdagain").val();
					var id = $("#uname").val().trim();
					if(pwd1==pwd2){
						$.ajax({
							url:"userServlet.bjsxt?method=updatePwd&id="+id+"&pwd="+pwd1,
							data:"",
							type:"post",
							dataType:"html",
							success:function(rsData){
								alert(rsData);
							}
						})
					}else{
						alert("两次密码不一致")
					}
				})
			})
		</script>
	</body>
</html>
