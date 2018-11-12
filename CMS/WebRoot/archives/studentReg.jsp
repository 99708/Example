<%@ page language="java" isELIgnored="false" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
				<form action="studentServlet.bjsxt?method=addStudent" method="post">
					<div class="subfild-content base-info">
						<div class="kv-item ue-clear">
							<label><span class="impInfo">*</span>学生班级</label>
							<div class="kv-item-content">
								<select id="classes" name="classes">
								</select>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学生年级</label>
							<div class="kv-item-content">
								<input name="gcode" id="gcode" type="text" readonly="readonly"/>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学生专业</label>
							<div class="kv-item-content">
								<input name="major" id="major" type="text" readonly="readonly" />
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学生姓名</label>
							<div class="kv-item-content">
								<input name="sname" type="text" placeholder="学生姓名" />
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学生性别</label>
							<div class="kv-item-content">
								<input type="radio" name="sex" value="男" checked="checked" />男 <input
									type="radio" name="sex" value="女" />女
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>学生年龄</label>
							<div class="kv-item-content">
								<input name="age" onkeyup="this.value=this.value.replace(/\D/g,'')" type="text" placeholder="学生年龄" />
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>身份证号</label>
							<div class="kv-item-content">
								<input name="idcard" type="text" placeholder="身份证号" />
							</div>
						</div>
						<div class="kv-item ue-clear time">
							<label>出生日期</label>
							<div class="kv-item-content">
								<input name="birthdate" type="text" placeholder="出生日期"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <i
									class="time-icon"></i>
							</div>
						</div>
						<div class="kv-item ue-clear time">
							<label>入学日期</label>
							<div class="kv-item-content">
								<input name="enterdate" type="text" placeholder="入学日期"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <i
									class="time-icon"></i>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>家庭地址</label>
							<div class="kv-item-content">
								<input name="address" type="text" placeholder="家庭地址" />
							</div>
						</div>

						<div class="kv-item ue-clear">
							<label>家庭电话</label>
							<div class="kv-item-content">
								<input name="phone" type="text" placeholder="家庭电话" />
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>政治面貌</label>
							<div class="kv-item-content">
								<select name="party">
									<option value="党员">党员</option>
									<option value="团员">团员</option>
									<option value="群众">群众</option>
								</select>
							</div>
						</div>
						<div class="kv-item ue-clear">
							<label>健康状况</label>
							<div class="kv-item-content">
								<select name="health">
									<option value="优秀">优秀</option>
									<option value="良好">良好</option>
									<option value="较差">较差</option>
								</select>
							</div>
						</div>
					</div>

					<div class="buttons" style="float: left;">
						<input class="button" type="submit" value="提交" />
					</div>
					<div class="buttons">
						<input id="res" class="button" type="button" value="重置" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var sel = $("#classes");
			$.ajax({
					date:"",
					type:"post",
					url:"studentServlet.bjsxt?method=findClasses",
					dataType:"json",
					success:function(rsData){						
						for(var i=0;i<rsData.length;i++){
							sel.append("<option value="+rsData[i].cid+">"+rsData[i].cname+"</option>");
						}
					}
			})				
			$("#classes").change(function() {
				var cid = $("#classes").val();
				$.ajax({
					url : "studentServlet.bjsxt?method=findMajor&cid=" + cid,
					type : "post",
					data : "",
					dataType : "json",
					success : function(rsData) {
						$("#major").val(rsData.mname);
					}
				})
				$.ajax({
					url : "studentServlet.bjsxt?method=findGcode&cid=" + cid,
					type : "post",
					data : "",
					dataType : "json",
					success : function(rsData) {
						console.log(rsData)
						$("#gcode").val(rsData);
					}
				})
			})

			$("#res").click(function() {

			})
		})
	</script>
</body>

<script type="text/javascript">
	$('select').select();
	showRemind('input[type=text],textarea', 'color5');
	UM.getEditor('content');
</script>
</html>
