<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>

</head>

<body>

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">查看用户</a>
    </div>
</div>

<div class="formbody">

    <ul class="forminfo">
        <li>
            <label>账号</label>
            <label>${u.uid}</label>
        </li>
        <li>
            <label>身份证号码</label>
            <label>${u.idcard}</label>
        </li>
        <li>
            <label>姓名</label>
            <label>${u.uname}</label>
        </li>
        <li>
            <label>性别</label>
            <label>${u.sex}</label>
        </li>
        <li>
            <label>联系地址</label>
            <label>${u.address}</label>
        </li>
        <li>
            <label>联系电话</label>
            <label>${u.phone}</label>
        </li>
        <li>
            <label>职位</label>
            <label>${u.role.rname}</label>
        </li>
        <li>
            <label>&nbsp;</label>
            <input id="sure" type="button" class="btn" value="返回" />
        </li>
    </ul>

</div>
<script type="text/javascript">
    $("#sure").click(function () {
        window.location.href="<%=request.getContextPath() %>/jsp/userManager/findUser";
    });
</script>
</body>

</html>
