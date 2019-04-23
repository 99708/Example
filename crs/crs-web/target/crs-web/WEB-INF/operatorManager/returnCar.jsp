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
        <a href="javascript:;" class="crumbs-label">汽车入库</a>
    </div>
</div>

<div class="formbody">

    <ul class="forminfo">
        <li>
            <label style="width: 150px; height: 32px;">出租单编号<b>*</b></label>
            <input name="" type="text" class="dfinput" /><i></i>
            <input name="" type="button" class="btn" value="查询" />
        </li>
    </ul>

</div>

</body>

</html>
