<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>汽车租赁系统</h3>
                <form name="myform" id="myform" action="<%=request.getContextPath() %>/login" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="uid" id="uid" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="text" placeholder="请输入用户名">
                        <span id="reglogininfo" class="us_uer_erro"></span>
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="pwd" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="请输入密码">
                        <span id="userloginpassword" class="us_uer_erro" >${userError }</span>
                    </div>
                    <div class="input_outer">
                        <span class="us_yzm"></span>
                        <input name="code" id="code" maxLength=4 size=10 class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;width: 40%;"value="" type="text" placeholder="请输入验证码">
                        <span class="us_uers">
              <cite><img id="verifyid" alt="验证码" width="120px" height="45px" src="jsp/validate/image" /></cite>
            </span>
                        <span id="uservalidate" class="us_uer_erro">${codeError }</span>
                    </div>
                    <div class="mb2"><a class="act-but submit" href="javascript:void(0);" id="check" style="color: #FFFFFF">登录</a></div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
<script type="text/javascript">
    if(window.parent.length > 0){
        window.parent.location = "login.jsp";
    }
    $(function () {
        $("#check").click(function () {
            $("#uid, #password, #code").trigger("blur");
            if($(".error").length > 0){
                alert("请检查你的输入");
            }else{
                $("#myform").submit();
            }
        });

        $("#uid").blur(function(){
            var uid = $("#uid").val();
            if(uid.length < 1){
                $("#reglogininfo").text("用户名不能为空").addClass("error").removeClass("ok");
            }else{
                $("#reglogininfo").text("").addClass("ok").removeClass("error")
            }
        });
        $("#password").blur(function(){
            var uid = $("#password").val();
            if(uid.length < 1){
                $("#userloginpassword").text("密码不能为空").addClass("error").removeClass("ok");
            }else{
                $("#userloginpassword").text("").addClass("ok").removeClass("error")
            }
        });
        $("#code").blur(function(){
            var uid = $("#code").val();
            if(uid.length < 1){
                $("#uservalidate").text("验证码不能为空").addClass("error").removeClass("ok");
            }else {
                $("#uservalidate").text("").addClass("ok").removeClass("error")
            }
        });

    })
</script>
</body>
</html>
