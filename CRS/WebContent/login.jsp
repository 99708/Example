<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}
-->
</style>
<script type="text/javascript">
if(window.parent.length > 0){
			window.parent.location = "login.jsp";
		}
</script>
<script language="JavaScript">
//刷新验证码
		function reloadImg(url){
		 document.getElementById('img1').src ="ValidateCodeServlet.do?"+Math.random();
		}
function correctPNG()
{
    var arVersion = navigator.appVersion.split("MSIE")
    var version = parseFloat(arVersion[1])
    if ((version >= 5.5) && (document.body.filters)) 
    {
       for(var j=0; j<document.images.length; j++)
       {
          var img = document.images[j]
          var imgName = img.src.toUpperCase()
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
          {
             var imgID = (img.id) ? "id='" + img.id + "' " : ""
             var imgClass = (img.className) ? "class='" + img.className + "' " : ""
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
             var imgStyle = "display:inline-block;" + img.style.cssText 
             if (img.align == "left") imgStyle = "float:left;" + imgStyle
             if (img.align == "right") imgStyle = "float:right;" + imgStyle
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
             var strNewHTML = "<span " + imgID + imgClass + imgTitle
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" 
             img.outerHTML = strNewHTML
             j = j-1
          }
       }
    }    
}
       
    </script>
    <script type="text/javascript">
    //登陆名提示
    
    function click_loginusername_input(){
			document.getElementById('reglogininfo').className="s1";
			document.getElementById('reglogininfo').innerHTML="登录名6-12位字符组成(包括大小写字母，数字，下划线)";
	}
	//登陆名错误提示
	
	function check_loginusername_input(){
		var re = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;
		var login = document.getElementById('username').value;
	
		if ( login == '' || login == null ) {
			document.getElementById('reglogininfo').className="s2";
			document.getElementById('reglogininfo').innerHTML="系统检测到你未有任何输入，此项为必填内容，请重新填写！";
		}else if(!re.test(login)){
	    	document.getElementById('reglogininfo').className="s2";
			document.getElementById('reglogininfo').innerHTML="你输入的内容不符合规范，请重新填写！";
	    }else{
			document.getElementById('reglogininfo').className = 's3';
			document.getElementById('reglogininfo').innerHTML = '输入的内容符合规范，可以使用！';
		}
	}	
       //密码提示
       function click_loginuserpwd_input(){
         	document.getElementById('userloginpassword').className="s1";
			document.getElementById('userloginpassword').innerHTML="密码4-12位字符组成(包括大小写字母，数字，下划线)";
       }
       //密码错误提示
       function check_loginuserpwd_input(){
       		var re = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;
		var login = document.getElementById('password').value;
		if ( login == '' || login == null) {
			document.getElementById('userloginpassword').className="s2";
			document.getElementById('userloginpassword').innerHTML="系统检测到你未有任何输入，此项为必填内容，请重新填写！";
		}else if(!re.test(login)){
	    	document.getElementById('userloginpassword').className="s2";
			document.getElementById('userloginpassword').innerHTML="你输入的内容不符合规范，请重新填写！";
	    }else{
			document.getElementById('userloginpassword').className = 's3';
			document.getElementById('userloginpassword').innerHTML = '输入的内容符合规范，可以使用！';
		}
       }
       //验证码提示
       function click_validate_input(){
         	document.getElementById('uservalidate').className="s1";
			document.getElementById('uservalidate').innerHTML="验证码不能为空";
       }
       //验证码为空提示
       function check_validate_input(){
		var login = document.getElementById('code').value;
		if ( login == '' || login == null ) {
			document.getElementById('uservalidate').className="s2";
			document.getElementById('uservalidate').innerHTML="系统检测到你未有任何输入，此项为必填内容，请重新填写！";
		}else{
			document.getElementById('uservalidate').className = 's3';
			document.getElementById('uservalidate').innerHTML = '输入的内容符合规范，可以使用！';
		}
       }
       function subForm(){
       var userNameRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;
       var userPwdRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;
       var userName = document.getElementById('username');
       var userPwd = document.getElementById('password');
       var code = document.getElementById('code');
       if(userName.value == '' || !userNameRegex.test(userName.value)){
       		userName.onfocus();
       		return false;
       }
       	if(userPwd.value == '' || !userPwdRegex.test(userPwd.value)){
       		userPwd.onfocus();
       		return false;
       	}
       	if(code.value == '' || code.value == null){
       		code.onfocus();
       		return false;
       	}
       }
    </script>
    <style type="text/css">
	.s1{
	border:1pt double #BDD6E8;
	height:16pt;
	padding: 2pt inherit;
	text-align:center;
	color: #0099CC;
	background-color: #E5EAFE;
    }
	.s2{
		border:1pt double #FF0000;
		height:16pt;
		padding: 2pt inherit;
		text-align:center;
		color: #e50000;
		background-color: #fff2f2;
	}
	.s3{
		border:1pt double #00dd00;
		height:16pt;
		padding: 2pt inherit;
		text-align:center;
		color: #009900;
		background-color: #f2fdf2;
	}
	</style>
    <link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
   <table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="images/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>1- 地区商家信息网门户站建立的首选方案...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>2- 一站通式的整合方式，方便用户使用...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3- 强大的后台系统，管理内容易如反掌...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="images/icon-demo.gif" width="16" height="16"><a href="http://www.mycodes.net" target="_blank" class="left_txt3"> 使用说明</a> </td>
                      <td width="35%"><img src="images/icon-login-seaver.gif" width="16" height="16"><a href="http://www.mycodes.net" class="left_txt3"> 在线客服</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">${requestScope.msg}</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2">
                    <form name="myform" action="<%=request.getContextPath() %>/login" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">用户名：&nbsp;&nbsp;</span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input name="uid" id="uid" class="editbox4" value="10000" size="20"><span id="reglogininfo"></span></td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" type="password" size="20" name="pwd" value="123456" id="password">
                              <img src="images/luck.gif" width="19" height="18"><span id="userloginpassword" style="color: red">${userError }</span></td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" ><span class="login_txt">验证码：</span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class=wenbenkuang name="code" id="code" type=text value="" maxLength=4 size=10/>
                             	  <cite><img id="verifyid" alt="验证码" width="114px" height="46px" src="jsp/validate/image" /></cite> 
                              	<span id="uservalidate" style="color: red">${codeError }</span>
                              </td>
                          </tr>
                          <tr>
                          
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 陆" /> </td>
                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="showConfirmMsg1()"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="images/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 2009-2010 www.mycodes.net</span></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
