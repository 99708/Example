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
    <link href="<%=request.getContextPath() %>/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/editor/kindeditor.js"></script>

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

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">添加角色信息</a>
    </div>
</div>

<div class="formbody">
    <form id="formId" action="<%=request.getContextPath() %>/insRole" method="post">
        <ul class="forminfo">
            <li>
                <label>角色名称<b>*</b></label>
                <input name="rname" id="rname"  type="text" class="dfinput" value="${roleName}" readonly/>
                <span id="caridSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>角色描述</label>
                <textarea name="rdesc" cols="" rows="" id="ecp" class="textinput"></textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input type="submit" class="btn" value="确认保存" />
            </li>
        </ul>
    </form>
</div>
</body>

</html>
