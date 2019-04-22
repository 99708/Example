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
    <script type="text/javascript" src="<%=request.getContextPath() %>/editor/kindeditor.js"></script>

    <script type="text/javascript">
        KE.show({id:"ecp",width:"800px",height:"300px"});
    </script>
</head>

<body>

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">查看汽车详情</a>
    </div>
</div>

<div class="formbody">
    <form id="formId" action="<%=request.getContextPath() %>/insCar" method="post" enctype="multipart/form-data">
        <ul class="forminfo">
            <li>
                <label>汽车编号</label>
                <label>${car.carid }</label>
            </li>
            <li>
                <label>汽车型号</label>
                <label>${car.type }</label>
            </li>
            <li>
                <label>汽车颜色</label>
                <label>${car.color }</label>
            </li>
            <li>
                <label>汽车价格</label>
                <label>${car.price }</label>
            </li>
            <li>
                <label>汽车租金</label>
                <label>${car.rentprice }</label>
            </li>
            <li>
                <label>租用情况</label>
                <label>${car.status }</label>
            </li>
            <li>
                <label>汽车图片</label>
                <label><img src=<%=request.getContextPath() %>/Car-Photo/${car.img } width="80px" height="50px"/></label>
            </li>
            <li style="margin-top: 60px;">
                <label>汽车简介</label>
                <textarea name="desc" cols="" rows="" id="ecp" class="textinput">${car.desc }</textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input id="suer" type="button" class="btn" value="返回" style="margin-top: 30px;"/>
            </li>
        </ul>
    </form>
</div>
<script type="text/javascript">
    $("#suer").click(function () {
        window.location.href="<%=request.getContextPath() %>/jsp/carManager/findCar";
    });
</script>
</body>

</html>
