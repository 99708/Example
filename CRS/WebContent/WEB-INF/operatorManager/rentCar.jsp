<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rentCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #EEF2FB;
		}
	</style>
	<script type="text/javascript">
		function subForm(){
			document.forms[0].submit();
		}
	</script>
	<script type="text/javascript">
		function fun(){
			var idcard = $("#idcard").val();
			$.get("checkIdcard",{idcard:idcard},function(data){
				var butHtml = '<div align="right" class="left_txt"><font color="red">客户不存在</font></div>';
				var flag =eval(data);
				if(flag){
				butHtml ='<img  src="<%=basePath%>images/carimg/continue.gif" onclick="subForm()" style="cursor: hand;" >';
				}
				$('#but').html(butHtml);
			});
		}
	</script>
  </head>
  
  <body>
   <form action="rentCar" method="post">
   <h5><font color="red">${requestScope.msg }</font></h5>
  <!--  	<input type="hidden" name="method" value="preCreateRentCarTable"/> -->
  <input type="hidden" name="method" value="findCar"/>
   <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">汽车出租</div></td>
      </tr>
    </table></td>
     <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><span class="left_bt">
	<table class="maintable" border="0" width="100%" cellspacing="0">
		<tr>
			<td width="22%" class="searchfontlist">
			<div align="right" class="left_txt">客户身份证号：</div></td>
			<td width="19%">
			<div align="left">
			  <input type="text" name="idcard" id="idcard" onblur="fun()"/></div></td>
			<td width="13%"><div align="center" id="but"></div></td>
			<td width="46%"></td>
		</tr>
	</table>
</span>
	</td>
      </tr>
      <tr>
        <td valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
        </table></td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif" >&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
   </form>
  </body>
</html>
