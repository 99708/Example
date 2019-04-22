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
        <a href="javascript:;" class="crumbs-label">添加用户</a>
    </div>
</div>

<div class="formbody">

    <form action="<%=request.getContextPath() %>/addCustomers" id="formId" method="post">
        <ul class="forminfo">
            <li>
                <label>身份证号码<b>*</b></label>
                <input name="idcard" id="idcard" type="text" class="dfinput" />
                <span id="idcardSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>姓名<b>*</b></label>
                <input name="cname" id="cname" type="text" class="dfinput" /><i></i>
                <span id="cnameSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>性别</label><cite>
                <input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="sex" type="radio" value="女" />女</cite>

            </li>
            <li>
                <label>联系地址<b>*</b></label>
                <input name="address" id="address" type="text" class="dfinput" />
                <span id="addressSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>联系电话<b>*</b></label>
                <input name="phone" id="phone" type="text" class="dfinput" />
                <span id="phoneSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>职业</label>
                <input name="job" id="job" type="text" class="dfinput" />
            </li>
            <li>
                <label>设置密码<b>*</b></label>
                <input name="pwd" id="pwd" type="text" class="dfinput" />
                <span id="pwdSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>&nbsp;</label>
                <input id="sure" type="submit" class="btn" value="确认保存" />
            </li>
        </ul>
    </form>

</div>
    <script type="text/javascript">

        //非空校验
        $(function () {
            $("#formId").submit(function(){
                $("#idcard,#cname,#address,#phone,#pwd").trigger("blur");
                if($(".error").length > 0){
                    alert("请检查你的输入");
                    return false;
                }else{
                    return true;
                }
            });

            $("#idcard").blur(function(){
                var idcard = $("#idcard").val();
                if(idcard.length < 1){
                    $("#idcardSpan").text("用户名不能为空").addClass("error").removeClass("ok");
                }else{
                    //如果非空进行唯一检查
                    $.get("<%=request.getContextPath() %>/selCusByIdcard",{idcard:idcard},function(data){
                        eval("var data2 ="+data);
                        if(data2){
                            $("#idcardSpan").text("").addClass("ok").removeClass("error");
                        }else{
                            $("#idcardSpan").text("该身份证已经登记了");
                        }
                    })
                }
            });
            $("#cname").blur(function(){
                var cname = $("#cname").val();
                if(cname.length < 1){
                    $("#cnameSpan").text("姓名不能为空").addClass("error").removeClass("ok");
                }else{
                    $("#cnameSpan").text("").addClass("ok").removeClass("error")
                }
            });
            $("#address").blur(function(){
                var address = $("#address").val();
                if(address.length < 1){
                    $("#addressSpan").text("联系地址不能为空").addClass("error").removeClass("ok");
                }else {
                    $("#addressSpan").text("").addClass("ok").removeClass("error")
                }
            });
            $("#phone").blur(function(){
                var phone = $("#phone").val();
                if(phone.length < 1){
                    $("#phoneSpan").text("联系电话不能为空").addClass("error").removeClass("ok");
                }else {
                    $("#phoneSpan").text("").addClass("ok").removeClass("error")
                }
            });
            $("#pwd").blur(function(){
                var pwd = $("#pwd").val();
                if(pwd.length < 1){
                    $("#pwdSpan").text("密码不能为空").addClass("error").removeClass("ok");
                }else {
                    $("#pwdSpan").text("").addClass("ok").removeClass("error")
                }
            });
        })
    </script>
</body>

</html>
