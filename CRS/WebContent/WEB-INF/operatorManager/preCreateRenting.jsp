<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'preCreateRenting.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	 <script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
	 <link type="text/css" rel="stylesheet" href="<%=basePath%>css/public.css">
	 <script type="text/javascript">
	 
	 	//根据借车时间计算出应付金额
	 	function remarkMoney(){
	 		//获取租车起始时间
	 		var startDate = $("#beginDate").val();
	 		var returnDate = $("#shouldReturnDate").val();
	 		
	 		//去除 “-”符号
	 		startDate = startDate.replace(/[&\|\\\*^%$#@\-]/g,"");
	 		returnDate = returnDate.replace(/[&\|\\\*^%$#@\-]/g,"");
	 		
	 		//判断时间
	 		if(returnDate - startDate <= 0){
	 			alert("还车时间比借车时间还早,你想干啥→_→?帮你清除了,下不为例");
	 			$("#shouldReturnDate").val("");
	 			$("#shouldPayPrice").val("");
	 			$("#imprest").val("");
	 			return;
	 		}
	 		var shouldPay = (returnDate - startDate) * 100;
	 		var zujin = $("#deposit").val();
	 		var money = Math.floor(zujin) + shouldPay
	 		$("#shouldPayPrice").val( money );
	 	}
	 
	 	//日期检测
	 	function dateCheck(dObj){
	 		var dateObj = new Date();
	 		var dateTemp = dateObj.getFullYear()+'-'+((dateObj.getMonth()+1)<10 ? "0" + dateObj.getMonth()+1 : dateObj.getMonth()+1)+'-'+(dateObj.getDate()<10 ? "0"+ dateObj.getDate() : dateObj.getDate());
	 		dObj = dObj.replace(/-/g, "/");
	 		dateTemp = dateTemp.replace(/-/g, "/");
	 		var dt2=new Date(Date.parse(dObj));  
	 		var dt3 = new Date(Date.parse(dateTemp));
	 		if(dt2 < dt3){
	 			return true;
	 		}else{
	 			return false;
	 		}
	 	}
	 	
	 	//起租日期与还车日期时间检测
	 	function beginDateEndDateCheck(beginDate,endDate){
	 		beginDate = beginDate.replace(/-/g, "/");
	 		endDate = endDate.replace(/-/g, "/");
	 		var begin = new Date(Date.parse(beginDate));
	 		var end = new Date(Date.parse(endDate));
	 		if(end >= begin){
	 		    return true;
	 		}else{
	 			return false;
	 		}
	 	}
	 	//检测起租日期是否合法
	 	function beginDateCheck(){
	 	var beginObj =document.getElementById('beginDate');
		 	if(dateCheck(beginObj.value)){
		 		 alert("您输入的时间不合法，请重新输入！");
		 		 beginObj.select();
		 	}
	 	}
	 	//检测还车日期是否合法
	    function shouldReturnDateCheck(){
	    var shouldReturnDate =document.getElementById('shouldReturnDate');
		 	if(dateCheck(shouldReturnDate.value)){
		 		 alert("您输入的时间不合法，请重新输入！");
		 		 shouldReturnDate.select();
		 	}else{
		 	 payMoneyCounts();
		 	}
	    }
	    //提交表单
	    function subForm(){
		var beginObj =document.getElementById('beginDate');
		var shouldReturnDate =document.getElementById('shouldReturnDate');
	 	if(dateCheck(beginObj.value) || dateCheck(shouldReturnDate.value)){
	 	    alert('您选择的日期不合法 请重新选择');
	 	}else{
	 		if(beginDateEndDateCheck(beginObj.value,shouldReturnDate.value)){
				var sp = $("#shouldPayPrice").val();
				var ip = $("#imprest").val();
				var p = $("#price").val();
				if("" == sp || "" == ip || "" == p || sp.length == 0 || ip.length == 0 || p.length == 0){
					alert("请将信息填满再上传");
					return;
				}
	 			document.forms[0].submit();
	 		}else{
		   	alert("起租日期不能大于应还日期，请重新选择时间");
		    }
		}
	}
		//钱数计算
		function payMoneyCounts(){
			var beginObj =document.getElementById('beginDate').value;
			var shouldReturnDate =document.getElementById('shouldReturnDate').value;
			var rentPay = document.getElementById('shouldPayPrice');
			var rentPayCount = document.getElementById('rentprice');
			//押金
			var deposit = document.getElementById('deposit');
			//预付金
			var imprest = document.getElementById('imprest');
			    var obj =  GetTime(parseDate(beginObj),'h');
			    var obj2 = GetTime(parseDate(shouldReturnDate),'h');
			    var moneyCount =obj2 - obj;
		 		var money = Math.round((moneyCount/24)) <= 0? parseInt(rentPayCount.value):(Math.round(moneyCount/24))*parseInt(rentPayCount.value);
				rentPay.value =money;
				imprest.value = money+parseInt(deposit.value);
		}

		//拆分时间
		function parseDate(strdate){
			var strYear=strdate.substring(0,4);
			var strMonth=strdate.substring(5,7);
			var strDay=strdate.substring(8,10);
			var strHours=strdate.substring(11,13);
			var strMinutes=strdate.substring(14,17);
			return new Date(strYear,strMonth,strDay,strHours,strMinutes); 
		}
		//计算小时数
		function GetTime(dateM,datetype){
		     var s;                            // 声明变量。
		     var MinMilli = 1000 * 60;         // 初始化变量。
		     var HrMilli = MinMilli * 60;
		     var DyMilli = HrMilli * 24;
		     s="";
		     if (datetype=="d"){
		    s +=Math.round(Math.abs(dateM/DyMilli))+"天";
		     }else if (datetype=="h"){
		    s +=Math.round(Math.abs(dateM/HrMilli))+"小时"
		     }else if (datetype=="m"){
		    s +=Math.round(Math.abs(dateM/MinMilli))+"分";
		     } else{
		    s +=Math.round(Math.abs(dateM/1000))+"秒"
		     }
	     return parseFloat(s);                        // 返回结果。
       }
       window.onload= function(){
       var dateObj =new Date();
       var beginDate = dateObj.getFullYear()+'-'+((dateObj.getMonth()+1)<10 ? "0" + dateObj.getMonth()+1 : dateObj.getMonth()+1)+'-'+(dateObj.getDate()<10 ? "0"+ dateObj.getDate() : dateObj.getDate());
       		document.getElementById('beginDate').value = beginDate;
       }
	 </script>
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
  </head>
  
  <body>
     <form action="<%=request.getContextPath() %>/rentCarByIdCard" method="post">
     <input type="hidden"  id="rentprice" value="${car.rentprice }"/>
     <input type="hidden" name="method" value="createRentCarTable"/>
     <input type="hidden" id="deposit" name="deposit" value="${car.deposit }"/>
     <input type="hidden" name="returndate" value="">
    <h5><font color="red">${requestScope.msg }</font></h5>
   <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">生成出租单</div></td>
      </tr>
    </table></td>
     <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29"/></td>
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
        <td colspan="2" valign="top"><span class="center_bt">
	<table class="maintable" width="100%" border="0" cellspacing="0" >
    <tr>
      <td width="14%"><div align="center" class="left_txt">出租单编号</div></td>
      <td width="23%"><input style="background-color: #e4e4e4" type="text" name="rentid" id="tableId" value="${requestScope.tableId }" readonly></td>
      <td width="15%"><div align="center" class="left_txt">预付金</div></td>
      <td width="48%"><input type="text" name="imprest" id="imprest">元(当前车辆押金为：${car.deposit })</td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt" class="left_txt">应付金</div></td>
      <td><input type="text" name="payable" id="shouldPayPrice" readonly="readonly" style="background-color: #e4e4e4">元</td>
       <td><div align="center" class="left_txt" class="left_txt">实际交付金额</div></td>
      <td><input type="text" name="priced" id="price">元</td>
      
    </tr>
    <tr>
      <td><div align="center" class="left_txt">起租日期</div></td>
      <td><input class="Wdate" type="date" name="begindate" id="beginDate" onchange="remarkMoney()"></td>
     <td><div align="center" class="left_txt">应归还日期</div></td>
     <td><input class="Wdate" type="date" name="dateable" id="shouldReturnDate" onchange="remarkMoney()"></td>
    </tr>
     <tr>
      <td><div align="center" class="left_txt">出租单状态</div></td>
      <td>
      <select name="status" id="rentFlag">
      	<option value="出租中" class="left_txt">已出租</option>
      	<option value="未出租" class="left_txt">未出租</option>
      </select>
     <td><div align="center" class="left_txt">汽车编号</div></td>
     <td>
    	<input name="carid" value="${car.carid }" readonly="readonly" style="background-color: #e4e4e4">
    </tr>
     <tr>
      <td><div align="center" class="left_txt">客户编号</div></td>
      <td><input type="text" style="background-color: #e4e4e4" name="idcard" id="identity" value="${requestScope.idcard }" readonly></td>
     <td><div align="center" class="left_txt">服务人员编号</div></td>
     <td><input type="text" style="background-color: #e4e4e4" name="uid" id="userName" value="${sessionScope.user.uid }" readonly></td>
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
		<img  src="<%=basePath%>images/carimg/return.gif" onclick="history.back()">
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
