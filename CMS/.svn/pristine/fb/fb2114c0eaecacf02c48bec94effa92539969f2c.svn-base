<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		
		<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
		<link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
		<link href="umeditor/themes/default/_css/umeditor.css" type="text/css"
			rel="stylesheet">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/global.js"></script>
		<script type="text/javascript" src="js/jquery.select.js"></script>
		<script type="text/javascript" src="js/WdatePicker.js"></script>
		<script type="text/javascript">
			window.UMEDITOR_HOME_URL = 'umeditor/'; // 请换成绝对路径
		</script>
		<script type="text/javascript" src="js/umeditor.config.js"></script>
		<script type="text/javascript" src="js/editor_api.js"></script>
		<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
		<title>老师基本信息</title>
	</head>
	
	<body>
		<div id="container">
			<div id="hd"></div>
			<div id="bd">
				<div id="main">
					<h2 class="subfild">
						<span>基本信息</span>
					</h2>
					<div class="subfild-content base-info">
						<div class="kv-item ue-clear">
							<label>教师编号</label>
							<div class="kv-item-content">
								<label>${teacher.tid }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>教师姓名</label>
							<div class="kv-item-content">
								<label>${teacher.tname }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>教师年龄</label>
							<div class="kv-item-content">
								<label>${teacher.age }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>教师性别</label>
							<div class="kv-item-content">
								<label>${teacher.sex }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>婚姻状况</label>
							<div class="kv-item-content">
								<label>${teacher.marry }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>政治面貌</label>
							<div class="kv-item-content">
								<label>${teacher.party }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>民族</label>
							<div class="kv-item-content">
								<label>${teacher.nation }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学历</label>
							<div class="kv-item-content">
								<label>${teacher.education }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>出生日期</label>
							<div class="kv-item-content">
								<label>${teacher.birthdate }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>身份证号</label>
							<div class="kv-item-content">
								<label>${teacher.idcard }</label>
							</div>
						</div>
						<div class="kv-item ue-clear time">
							<label>联系电话</label>
							<div class="kv-item-content">
								<label>${teacher.phone }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>工作日期</label>
							<div class="kv-item-content">
								<label>${teacher.hiredate }</label>
							</div>
						</div>
	
						<div class="kv-item ue-clear">
							<label>授课专业</label>
							<div class="kv-item-content">
								<label>${teacher.major.mname }</label>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>工作介绍</label>
							<div class="kv-item-content">
								<label>${teacher.desc }</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/skin/jquery.js"></script>
		<script type="text/javascript">
			$(function() {
	
			})
		</script>
	</body>
	
	<script type="text/javascript">
		$('select').select();
		showRemind('input[type=text],textarea', 'color5');
		UM.getEditor('content');
	</script>
</html>
