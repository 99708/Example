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
    
    <title>My JSP 'empInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
			
		});
</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">员工信息详情</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<label>${showEmp.empid }</label>
				</li>
				<li>
					<li>
						<label>真实姓名</label>
						<label>${showEmp.realname }</label>
					</li>
					<li>
						<label>性别</label>
						<label>${showEmp.sex }</label>						
					</li>
					<li>
						<label>出生日期</label>
						<label>${showEmp.birthdate }</label>
					</li>
					<li>
					<li>
						<label>入职时间</label>
						<label>${showEmp.hiredate }</label>
					</li>
					
					<li>
						<label>离职时间</label>
						<label>${showEmp.leavedate }</label>
					</li>
					<li>
						<label>是否在职</label>
						<c:if test="${showEmp.onduty == 1 }">
							<label>在职</label>
						</c:if>
						<c:if test="${showEmp.onduty == 0 }">
							<label>离职</label>
						</c:if>
						
					</li>
					<li>
						<label>所属部门</label>
						<c:if test="${showEmp.dept.deptno == 1}">
							<label>总裁办</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 2}">
							<label>教学部</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 3}">
							<label>咨询部</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 4}">
							<label>教务部</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 5}">
							<label>宿管部</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 6}">
							<label>财务部</label>
						</c:if>
						<c:if test="${showEmp.dept.deptno == 8}">
							<label>嘻嘻</label>
						</c:if>
						

					</li>
					<li>
						<label>从事岗位</label>
						<c:if test="${showEmp.position.posid == 1}">
							<label>总裁</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 2}">
							<label>教学经理</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 3}">
							<label>咨询经理</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 4}">
							<label>咨询师</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 5}">
							<label>讲师</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 6}">
							<label>财务经理</label>
						</c:if>
						<c:if test="${showEmp.position.posid == 7}">
							<label>程序员</label>
						</c:if>

					</li>
					<li>
						<label>直接上级</label>						
						<label>${showEmp.mgremp.empid }</label>	
					</li>
					<li>
						<label>联系方式</label>
						<label>${showEmp.phone }</label>
					</li>
					<li>
						<label>QQ号</label>
						<label>${showEmp.qq }</label>
					</li>
					<li>
						<label>紧急联系人信息</label>
						<label>${showEmp.emercontactperson }</label>
					</li>
					<li>
						<label>身份证号</label>
						<label>${showEmp.idcard }</label>
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="button" onclick="callBack()" class="btn" value="返回" />
					</li>
			</ul>

		</div>
		<script type="text/javascript">
			function callBack (){
				window.location.href = "empServlet.servlet?method=findEmpList";
			}
		</script>

	</body>

</html>
