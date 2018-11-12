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
    
    <title>My JSP 'empAdd.jsp' starting page</title>
    
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
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
			
		});
	</script>
	<script type="text/javascript">
		KE.show({id:"ecp",width:"800px",height:"300px"});
	</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">添加员工</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>
			
			<form action="empServlet.servlet?method=addEmp" method="post">
				<ul class="forminfo">
				<li>
					<label>用户名</label>
					<input name="empid" type="text" class="dfinput" /></li>
				<li>
					<li>
						<label>真实姓名</label>
						<input name="realname" type="text" class="dfinput" /><i></i></li>
					<li>
						<label>性别</label><cite>
						<input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="女" />女<i>也可以根据身份证号自动获取</i></cite>
						
					</li>
					<li>
						<label>出生日期</label>
						<input name="birthdate" type="text" class="dfinput" onfocus="WdatePicker({skin:'whyGreen',lang:'en'})" /><i>也可以根据身份证号自动获取</i></li>
					<li>
					<li>
						<label>入职时间</label>
						<input name="hiredate" type="text" class="dfinput" onfocus="WdatePicker()"/><i></i></li>
					
					<li>
						<label>离职时间</label>
						<input name="leavedate" type="text" class="dfinput" onfocus="WdatePicker()"/><i></i></li>
					<li>
						<label>是否在职</label><cite>
						<input name="onduty" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="onduty" type="radio" value="0" />否</cite>
					</li>
					<li>
						<label>员工类型</label><cite>
						<input name="emptype" type="radio" value="1" checked="checked" />基层员工&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="emptype" type="radio" value="2" />各级管理人员</cite>
					</li>
					<li>
						<label>所属部门<b>*</b></label>
						<div class="vocation">
							<select name="deptno" class="select1">
								<c:forEach var="dept" items="${deptList }">
									<option value="${dept.deptno }">${dept.deptname }</option>
								</c:forEach>
							</select>
						</div>

					</li>
					<li>
						<label>从事岗位<b>*</b></label>
						<div class="vocation">
							<select name="posid" class="select1">
								<c:forEach var="position" items="${positionList }">
									<option value="${position.posid }">${position.pname }</option>
								</c:forEach>
							</select>
						</div>

					</li>
					<li>
						<label>直接上级<b>*</b></label>						
						<div class="vocation">
							<select  name="mgrempid" class="select1">
								<c:forEach var="mgrEmp" items="${mgrEmpList }">
									<option value="${mgrEmp.empid }">${mgrEmp.realname }</option>
								</c:forEach>
							</select>							
						</div>
						&nbsp;&nbsp;
						<input name="" type="text" class="dfinput"  placeholder="也可以在此输入首字母帮助显示"/>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" />
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emercontactperson" cols="" rows="" id="ecp" class="textinput"></textarea>
					</li>
					<li>
						<label>身份证号</label>
						<input name="idcard" type="text" class="dfinput" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="submit" class="btn" value="确认添加" />
					</li>
			</ul>
			</form>
			

		</div>

	</body>

</html>
