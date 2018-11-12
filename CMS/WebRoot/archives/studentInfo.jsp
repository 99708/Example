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
window.UMEDITOR_HOME_URL = 'umeditor/';  // 请换成绝对路径
</script>
<script type="text/javascript" src="js/umeditor.config.js"></script>
<script type="text/javascript" src="js/editor_api.js"></script>
<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
<title>学生基本信息</title>
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
						<label><span class="impInfo">*</span>学生班级</label>
						<div class="kv-item-content">
							<label>${student.classes.cname }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生专业</label>
						<div class="kv-item-content">
							<label>${student.major.mname }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生年级</label>
						<div class="kv-item-content">
							<label>${student.gcode }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生编号</label>
						<div class="kv-item-content">
							<label>${student.sid }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生姓名</label>
						<div class="kv-item-content">
							<label>${student.sname }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生性别</label>
						<div class="kv-item-content">
							<label>${student.sex }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>学生年龄</label>
						<div class="kv-item-content">
							<label>${student.age }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>身份证号</label>
						<div class="kv-item-content">
							<label>${student.idcard }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>入学日期</label>
						<div class="kv-item-content">
							<label>${student.enterdate }</label>
						</div>
					</div>
					<div class="kv-item ue-clear time">
						<label>出生日期</label>
						<div class="kv-item-content">
							<label>${student.birthdate }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>家庭地址</label>
						<div class="kv-item-content">
							<label>${student.address }</label>
						</div>
					</div>

					<div class="kv-item ue-clear">
						<label>家庭电话</label>
						<div class="kv-item-content">
							<label>${student.phone }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>政治面貌</label>
						<div class="kv-item-content">
							<label>${student.party }</label>
						</div>
					</div>
					<div class="kv-item ue-clear">
						<label>健康状况</label>
						<div class="kv-item-content">
							<label>${student.health }</label>
						</div>
					</div>
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
