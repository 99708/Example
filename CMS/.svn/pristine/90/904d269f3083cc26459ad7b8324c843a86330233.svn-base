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
		<title>学基本信息</title>
		<script type="text/javascript">
		&
		</script>
	</head>
	
	<body>
		<div id="container">
			<div id="hd"></div>
			<div id="bd">
				<div id="main">
					<h2 class="subfild">
						<span>基本信息</span>
					</h2>
					<form action="studentServlet.bjsxt?method=updateStudent" method="post">
						<div class="subfild-content base-info">
							<div class="kv-item ue-clear">
								<label>学生姓名</label>
								<div class="kv-item-content">
									<input name="tname" type="text" readonly="readonly" value="${student.sname }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>学生编号</label>
								<div class="kv-item-content">
									<input name="sid" type="text" readonly="readonly" value="${student.sid }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>学生班级</label>
								<div class="kv-item-content">
									<select name="cid" id="cid">
										<option value="${student.classes.cid }">${student.classes.cname }</option>
									</select>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>专业信息</label>
								<div class="kv-item-content">
									<input type="text" id="mname" value="${student.major.mname }" readonly="readonly" style="color: gray;">
									<input type="hidden" name="mid" id="mid" value="${student.major.mid }">
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>年龄</label>
								<div class="kv-item-content">
									<input name="age" type="text" value="${student.age }" />
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>性别</label>
								<div class="kv-item-content">
									<input name="sex" type="text" value="${student.sex }" readonly="readonly" style="color: gray;"/>
								</div>
							</div>
	
							<div class="kv-item ue-clear">
								<label>政治面貌</label>
								<div class="kv-item-content">
									<select name="party">
										<c:if test="${student.party=='团员' }">
											<option value="团员" selected="selected">团员</option>
											<option value="党员" >党员</option>
											<option value="群众" >群众</option>
										</c:if>
										<c:if test="${student.party=='党员' }">
											<option value="团员" >团员</option>
											<option value="党员" selected="selected">党员</option>
											<option value="群众" >群众</option>
										</c:if>
										<c:if test="${student.party=='群众' }">
											<option value="团员" >团员</option>
											<option value="党员" >党员</option>
											<option value="群众" selected="selected">群众</option>
										</c:if>
									</select>
								</div>
							</div>
	
							<div class="kv-item ue-clear time">
								<label>出生日期</label>
								<div class="kv-item-content">
									<input name="birthdate" type="text" placeholder="出生日期"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="${student.birthdate }" style="color: gray;"/> <i
										class="time-icon"></i>
								</div>
							</div>
	
							<div class="kv-item ue-clear">
								<label>身份证号</label>
								<div class="kv-item-content">
									<input name="idcard" type="text" placeholder="身份证号" readonly="readonly" value="${student.idcard }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>联系电话</label>
								<div class="kv-item-content">
									<input name="phone" type="text" placeholder="联系电话" value="${student.phone }"/>
								</div>
							</div>
	
							<div class="kv-item ue-clear time">
								<label>入学日期</label>
								<div class="kv-item-content">
									<input name="hiredate" type="text" placeholder="工作日期"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="${student.enterdate }" style="color: gray;"/> <i
										class="time-icon"></i>
								</div>
							</div>
							
							<div class="kv-item ue-clear">
								<label>家庭住址</label>
								<div class="kv-item-content">
									<input name="phone" type="text" placeholder="联系电话" value="${student.address }"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>健康状况</label>
								<div class="kv-item-content">
									<select>
										<c:if test="${student.health=='优秀' }">
											<option value="优秀" selected="selected">优秀</option>
											<option value="良好">良好</option>
											<option value="较差">较差</option>
										</c:if>
										<c:if test="${student.health=='良好' }">
											<option value="优秀">优秀</option>
											<option value="良好" selected="selected">良好</option>
											<option value="较差">较差</option>
										</c:if>
										<c:if test="${student.health=='较差' }">
											<option value="优秀">优秀</option>
											<option value="良好">良好</option>
											<option value="较差" selected="selected">较差</option>
										</c:if>
									</select>
								</div>
							</div>
	
						</div>
	
						<div class="buttons" style="float: left;">
							<input class="button" type="submit" value="修改" />
						</div>
						<div class="buttons">
							<input class="button" type="button" value="重置" />
						</div>
					</form>
				</div>
				${error }
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#cid").change(function(){
					var cid = $("#cid").val();
					var mid = $("#mid");
					var mname = $("#mname");
					$.ajax({
						data:"",
						type:"post",
						url:"studentServlet.bjsxt?method=findMajor&cid="+cid,
						dataType:"json",
						success:function(rsData){
							mid.val(rsData.mid);
							mname.val(rsData.mname);
						}
					})
				})
				var sel2 = $("#cid")
				$.ajax({
					data:"",
					type:"post",
					url:"studentServlet.bjsxt?method=findClasses",
					dataType:"json",
					success:function(rsData){
						for(var i=0;i<rsData.length;i++){
							sel2.append("<option value="+rsData[i].cid+">"+rsData[i].cname+"</option>");
						}
					}
				})
				alert(${student.major.mid });
			})
		</script>
	</body>
	
	<script type="text/javascript">
		$('select').select();
		showRemind('input[type=text],textarea','color5');
		UM.getEditor('content');
	</script>
</html>
