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
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
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
	function changeUserPwd(uid,pwd){
   		 window.location.href="upUserPwd?uid="+uid+"&pwd="+pwd; 
   	}
</script>
  </head>
  
  <body>
    <form action="updateUser" method="post">
  	<input type="hidden" name="method" value="updateUser" id="method"/>
  	<input type="hidden" name="pwd" value="${requestScope.u.pwd }"/>
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
     	<table width="100%" border="0" cellpadding="0" cellspacing="0">
     		 <tr>
      <td width="14%"><div align="center" class="left_txt">登录名</div></td>
      <td width="23%"><input type="text" name="uid" id="uid" value="${requestScope.u.uid }" readonly="readonly"></td>
      <td width="15%"><div align="center" class="left_txt">身份证</div></td>
      <td width="48%"><input type="text" name="idcard" id="idcard"  value="${requestScope.u.idcard }">*</td>
    </tr>
    <tr>
       <td><div align="center" class="left_txt">联系电话</div></td>
      <td><input type="text" name="phone" id="phone" value="${requestScope.u.phone }">*</td>
         <td><div align="center" class="left_txt">姓名</div></td>
      <td><input type="text" id="uname" name="uname" value="${requestScope.u.uname }">*</td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">地址</div></td>
      <td><input type="text" name="address" id="address" value="${requestScope.u.address }">*</td>
     <td><div align="center" class="left_txt">性别</div></td>
      <td>
     <select NAME="sex" id="sex" style="width: 105px;">
			<c:choose>
				<c:when test="${requestScope.u.sex eq '男'}">
					<option value="男" selected="selected">男</option>
			        <option value="女">女</option>
				</c:when>
				<c:otherwise>
				    <option value="男" >男</option>
			        <option value="女" selected="selected">女</option>
				</c:otherwise>
			</c:choose>
		</select>

      </td>
     
    </tr>
    <tr>
      <td><div align="center" class="left_txt">职位 </div></td>
      <td><input type="text" name="position" id="position" value="${requestScope.u.position }">*</td>
      <td><div align="center" class="left_txt">用户类型</div></td>
      <td>
         <select name="rid" id="rid">
        	<c:choose>
        		<c:when test="${requestScope.u.rid ==1}">
        		<option  value="1" selected="selected">销售</option>
        		<option value="2">管理员</option>
        		</c:when>
        		<c:otherwise>
        		<option  value="1" >销售</option>
        		<option value="2"selected="selected">管理员</option>
        		</c:otherwise>
        	</c:choose>
        </select>
      </label></td>
    </tr>
    <tr>
    
      
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
		  <img  src="<%=basePath%>images/carimg/changepw.gif" onclick="changeUserPwd('${requestScope.u.uid }','${requestScope.u.pwd} ')" style="cursor: hand;">
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
