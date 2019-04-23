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
        <a href="javascript:;" class="crumbs-label">汽车出租</a>
    </div>
</div>

<div class="formbody">

    <ul class="forminfo">
        <li>
            <label style="width: 150px; height: 32px;">客户身份证号码<b>*</b></label>
            <input name="idcard" id="idcard" type="text" class="dfinput" /><i></i>
            <input type="button" class="btn" value="查询" id="btn" />
        </li>
    </ul>

</div>
    <script type="text/javascript">
        $("#btn").click(function () {
            var idcard = $("#idcard").val();
            $.get("<%=request.getContextPath() %>/checkIdcard",{idcard:idcard},function(data){
                if(eval(data)){//客戶存在
                    window.location.href="<%=request.getContextPath() %>/rentCar?idcard="+idcard;
                }else{//客戶不存在
                    if (confirm("该客戶不存在，是否添加该客戶")){//到添加客戶界面
                        window.location.href="<%=request.getContextPath() %>/jsp/custManager/addCustomers";
                    }else{//清空搜索框中的内容
                        $("#roleName").val("");
                    }
                }
            });
        });
    </script>
</body>

</html>
