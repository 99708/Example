<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCustomers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
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
		function changeUserPwd(pwd,idcard){
	   		window.location.href="changePwd?idcard="+idcard+"&pwd="+pwd;
	   	}
	</script>
  </head>
  
  <body>
    <form action="upCus" method="post">
  	<input type="hidden" name="method" value="updateCustomers" id="method"/>
  	<input type="hidden" name="pwd" value="${requestScope.cus.pwd }"/>
   <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">更新用户</div></td>
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
     	 <table class="maintable" width="97%" border="0" cellspacing="0">
    <tr>
      <td width="14%"><div align="center" class="left_txt">身份证</div></td>
      <td width="23%"><input type="text" name="idcard" id="idcard" value="${requestScope.cus.idcard }" readonly></td>
      <td width="15%"><div align="center" class="left_txt">姓名</div></td>
      <td width="48%"><input type="text" name="cname" id="cname" value="${requestScope.cus.cname }"></td>
    </tr>
    <tr>
       <td><div align="center" class="left_txt">地址</div></td>
      <td><input type="text" id="address" name="address" value="${requestScope.cus.address }"></td>
       <td><div align="center" class="left_txt">性别</div></td>
       <td>
     <select name="sex" id="sex"  style="width: 80px;">
     <c:choose>
     	<c:when test="${requestScope.cus.sex eq '男'}">
     	    <option value="男" selected>男</option>
			<option value="女">女</option>
     	</c:when>
     	<c:otherwise>
     	    <option value="男">男</option>
			<option value="女" selected>女</option>
     	</c:otherwise>
     </c:choose>
		</select>
      </td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">电话</div></td>
      <td><input type="text" name="phone" id="phone" value="${requestScope.cus.phone }"></td>
     <td><div align="center" class="left_txt">职业</div></td>
     <td><input type="text" name="job" id="job" value="${requestScope.cus.job }"></td>
     </tr>
  </table>
    <table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center">
		<img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img  src="<%=basePath%>images/carimg/reset.gif" onclick="reset()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <img  src="<%=basePath%>images/carimg/changepw.gif" onclick="changeUserPwd('${requestScope.cus.pwd}','${requestScope.cus.idcard }')" style="cursor: hand;">
		</div>
	  </td>
	</tr>
	<tr>
		<td height="30" background="<%=basePath%>images/tab/bg.gif"></td>
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
    <td background="images/mail_rightbg.gif">&nbsp;</td>
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
