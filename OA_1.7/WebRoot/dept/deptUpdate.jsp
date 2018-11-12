<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deptUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="deptServlet.servlet?method=updateDept" method="post">
	    <ul class="forminfo">
		    <li><label>部门编号</label><input name="deptno" type="text" class="dfinput" value="${dept.deptno }"/> </li>
		    <li><label>部门名称</label><input name="deptname" type="text" class="dfinput"  value="${dept.deptname }"/></li>
		    <li><label>办公地点</label><input name="location" type="text" class="dfinput" value="${dept.location }"/></li>
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认修改"/></li>
	    </ul>
    </form>
    
    </div>


</body>

</html>
