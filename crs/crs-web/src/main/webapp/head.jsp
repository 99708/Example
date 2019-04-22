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
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
  </head>
  <body style="background:url(images/topbg.gif) repeat-x;">
  <div class="topleft">
    <a href="javascript:void(0)" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
  </div>
  <div class="topright">
    <ul>
      <li><a href="javascript:void(0)" target="_self" onClick="logout();">退出</a></li>
    </ul>
    <div class="user">
      <span >${user.role.rname}：<b style="width: 50px;">${user.uname }</b> 您好,感谢登陆使用！</span>
    </div>
  </div>
    <script type="text/javascript">
        function logout(){
            if (confirm("您确定要退出系统吗？")){
                document.location = "exitLogin";
            }else{
                return false;
            }
        }
    </script>
  </body>
</html>
