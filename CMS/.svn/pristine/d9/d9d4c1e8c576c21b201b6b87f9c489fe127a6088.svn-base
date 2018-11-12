<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
		<title>教师基本信息</title>
	</head>
	
	<body>
		<div id="container">
			<div id="hd"></div>
			<div id="bd">
				<div id="main">
					<h2 class="subfild">
						<span>基本信息</span>
					</h2>
					<form action="teacherServlet.bjsxt?method=updateTeacher" method="post">
						<div class="subfild-content base-info">
							<div class="kv-item ue-clear">
								<label>教师姓名</label>
								<div class="kv-item-content">
									<input name="tname" type="text" readonly="readonly" value="${teacher.tname }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>教师编号</label>
								<div class="kv-item-content">
									<input name="tid" type="text" readonly="readonly" value="${teacher.tid }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>年龄</label>
								<div class="kv-item-content">
									<input name="age" type="text" value="${teacher.age }" />
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>性别</label>
								<div class="kv-item-content">
									<input name="sex" type="text" value="${teacher.sex }" readonly="readonly" style="color: gray;"/>
								</div>
							</div>
	
							<div class="kv-item ue-clear">
								<label>结婚状态</label>
								<div class="kv-item-content">
									<c:if test="${teacher.marry=='未婚' }">
										<input type="radio" name="marry" value="未婚" checked="checked"/>未婚
										<input type="radio" name="marry" value="已婚" />已婚
										<input type="radio" name="marry" value="丧偶" />丧偶
									</c:if>
									<c:if test="${teacher.marry=='已婚' }">
										<input type="radio" name="marry" value="未婚" />未婚
										<input type="radio" name="marry" value="已婚" checked="checked"/>已婚
										<input type="radio" name="marry" value="丧偶" />丧偶
									</c:if>
									<c:if test="${teacher.marry=='丧偶' }">
										<input type="radio" name="marry" value="未婚" />未婚
										<input type="radio" name="marry" value="已婚" />已婚
										<input type="radio" name="marry" value="丧偶" checked="checked"/>丧偶
									</c:if>
									
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>政治面貌</label>
								<div class="kv-item-content">
									<select name="party">
										<c:if test="${teacher.party=='团员' }">
											<option value="团员" selected="selected">团员</option>
											<option value="党员" >党员</option>
											<option value="群众" >群众</option>
										</c:if>
										<c:if test="${teacher.party=='党员' }">
											<option value="团员" >团员</option>
											<option value="党员" selected="selected">党员</option>
											<option value="群众" >群众</option>
										</c:if>
										<c:if test="${teacher.party=='群众' }">
											<option value="团员" >团员</option>
											<option value="党员" >党员</option>
											<option value="群众" selected="selected">群众</option>
										</c:if>
									</select>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>民族</label>
								<div class="kv-item-content">
									<input name="nation" type="text" readonly="readonly" value="${teacher.nation }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>学历</label>
								<div class="kv-item-content">
									<select name="education">
										<c:if test="${teacher.education=='小学及以下' }">
											<option value="小学及以下" selected="selected">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='初中' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中" selected="selected">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='高中' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中" selected="selected">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='专科' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科" selected="selected">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='本科' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科" selected="selected">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='硕士' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士" selected="selected">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='博士' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士" selected="selected">博士</option>
											<option value="博士后">博士后</option>
										</c:if>
										<c:if test="${teacher.education=='博士后' }">
											<option value="小学及以下">小学及以下</option>
											<option value="初中">初中</option>
											<option value="高中">高中</option>
											<option value="专科">专科</option>
											<option value="本科">本科</option>
											<option value="硕士">硕士</option>
											<option value="博士">博士</option>
											<option value="博士后" selected="selected">博士后</option>
										</c:if>
									</select>
								</div>
							</div>
	
							<div class="kv-item ue-clear time">
								<label>出生日期</label>
								<div class="kv-item-content">
									<input name="birthdate" type="text" placeholder="出生日期"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="${teacher.birthdate }" style="color: gray;"/> <i
										class="time-icon"></i>
								</div>
							</div>
	
							<div class="kv-item ue-clear">
								<label>身份证号</label>
								<div class="kv-item-content">
									<input name="idcard" type="text" placeholder="身份证号" readonly="readonly" value="${teacher.idcard }" style="color: gray;"/>
								</div>
							</div>
							<div class="kv-item ue-clear">
								<label>联系电话</label>
								<div class="kv-item-content">
									<input name="phone" type="text" placeholder="联系电话" value="${teacher.phone }"/>
								</div>
							</div>
	
							<div class="kv-item ue-clear time">
								<label>工作日期</label>
								<div class="kv-item-content">
									<input name="hiredate" type="text" placeholder="工作日期"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="${teacher.hiredate }" style="color: gray;"/> <i
										class="time-icon"></i>
								</div>
							</div>
	
							<div class="kv-item ue-clear">
								<label>授课专业</label>
								<div class="kv-item-content">
									<select name="mid" id="mid">
										<option value="${teacher.major.mid }">${teacher.major.mname }</option>
									</select>
								</div>
							</div>
	
							<h2 class="subfild">
								<span>工作简介</span>
							</h2>
	
							<div class="subfild-content remarkes-info">
								<div class="kv-item ue-clear">
									<div class="kv-item-content">
										<textarea name="desc" placeholder="工作简介" id="content"
											style="width:800px;height:240px;"value="${teacher.desc }"></textarea>
									</div>
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
				var sel = $("#mid")
				$.ajax({
					data:"",
					type:"post",
					url:"teacherServlet.bjsxt?method=findMajor",
					dataType:"json",
					success:function(rsData){
						for(var i=0;i<rsData.length;i++){
							sel.append("<option value="+rsData[i].mid+">"+rsData[i].mname+"</option>");
						}
					}
				})
			})
		</script>
	</body>
	
	<script type="text/javascript">
		$('select').select();
		showRemind('input[type=text],textarea','color5');
		UM.getEditor('content');
	</script>
</html>
