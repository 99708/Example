<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'updateRenttable.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
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
	function subForm() {
		document.forms[0].submit();
	}
</script>
</head>

<body>
	<form action="<%=request.getContextPath() %>/updateAllStatus" method="post">		
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="17" valign="top" background="images/mail_leftbg.gif"><img
					src="images/left-top-right.gif" width="17" height="29" /></td>
				<td valign="top" background="images/content-bg.gif">
					<table width="100%" height="31" border="0" cellpadding="0"
						cellspacing="0" class="left_topbg" id="table2">
						<tr>
							<td height="31"><div class="titlebt">修改出租单</div></td>
						</tr>
					</table>
				</td>
				<td width="16" valign="top" background="images/mail_rightbg.gif"><img
					src="images/nav-right-bg.gif" width="16" height="29" />
				</td>
			</tr>
			<tr>
				<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
				<td valign="top" bgcolor="#F7F8F9">
					<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" valign="top">&nbsp;</td>
							<td>&nbsp;</td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" valign="top"><span class="left_bt">
								<table class="maintable" width="100%" border="0" cellspacing="0">
									<tr>
										<td width="12%" height="27">
											<div align="center" class="left_txt">出租单编号：</div>
										</td>
										<td width="13%" class="left_txt">
											<input type="hidden" name="rentid" value="${rental.rentid }">
											<input type="hidden" name="carid" value="${rental.carid }">
											<input type="hidden" name="idcard" value="${rental.idcard }">
											${rental.rentid }
										</td>
										<td width="14%">&nbsp;</td>
										<td width="14%">&nbsp;</td>
										<td width="20%">
											<div align="center" class="left_txt">预付金：</div>
										</td>
										<td width="27%" class="left_txt"><fmt:formatNumber
												type="currency" value="${rental.deposit }" /></td>
									</tr>
									<tr>
										<td width="12%" height="27">
											<div align="center" class="left_txt">应付金：</div>
										</td>
										<td width="13%" class="left_txt"><fmt:formatNumber
												type="currency" value="${rental.payable }" /></td>
										<td width="14%">&nbsp;</td>
										<td width="14%">&nbsp;</td>
										<td width="20%">
											<div align="center" class="left_txt">实际交付金额：</div>
										</td>
										<td width="27%" class="left_txt"><input type="text"
											name="priced" id="price" value="${rental.priced }"></td>
									</tr>
									<tr>
										<td width="12%" height="27">
											<div align="center" class="left_txt">起租日期：</div>
										</td>
										<td width="13%" class="left_txt"><input class="Wdate"
											type="date" name="begindate" id="beginDate"
											value="${rental.begindate }" /></td>

										<td width="14%">&nbsp;</td>
										<td width="14%">&nbsp;</td>
										<td width="20%">
											<div align="center" class="left_txt">应归还日期：</div>
										</td>
										<td width="27%" class="left_txt"><input class="Wdate"
											type="date" name="dateable" id="shouldReturnDate"
											value="${rental.dateable }" /></td>
									</tr>
									<tr>
										<td width="12%" height="27">
											<div align="center" class="left_txt">归还日期：</div>
										</td>
										<td width="13%" class="left_txt"><input class="Wdate"
											type="date" name="returndate" id="returnDate"
											value="${rental.returndate }" /></td>
										<td width="14%">&nbsp;</td>
										<td width="14%">&nbsp;</td>
										<td width="20%">
											<div align="center" class="left_txt">出租单状态：</div>
										</td>
										<td width="27%"><select name="status">
											<c:choose>
												<c:when test="${rental.status eq '未出租'}">
													<option value="未出租" selected class="left_txt">未出租</option>
													<option value="已出租" class="left_txt">已出租</option>
												</c:when>
												<c:otherwise>
													<option value="未出租" class="left_txt">未出租</option>
													<option value="已出租" selected class="left_txt">已出租</option>
												</c:otherwise>
											</c:choose>
										</select></td>
									</tr>
									<tr>
										<td width="12%" height="27">
											<div align="center" class="left_txt">服务人员编号</div>
										</td>
										<td width="13%" class="left_txt">${rental.uid }</td>
									</tr>
									<tr>
										<td colspan="6" align="center">
											<img src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<img src="<%=basePath%>images/carimg/return.gif"
											onclick="history.back()"></td>
										<td>
											${info }
										</td>
									</tr>
								</table>									
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr align="center" bgcolor="#EEF2FB">
									<td height="19" colspan="6" class="titleLine"
										bgcolor="#EEF2FB">
										<div align="left">
											<p>&nbsp;</p>
											<p>&nbsp;</p>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td height="23" colspan="6"><div align="center"
											class="left_txt">客户信息</div></td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td><div align="center" class="left_txt">身份证：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.idcard }</font>
										</div></td>
									<td><div align="center" class="left_txt">姓名：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.cname }</font>
										</div></td>
									<td><div align="center" class="left_txt">性别：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.sex }</font>
										</div></td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td><div align="center" class="left_txt">地址：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.address }</font>
										</div></td>
									<td><div align="center" class="left_txt">电话：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.phone }</font>
										</div></td>
									<td><div align="center" class="left_txt">职业：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${customer.job }</font>
										</div></td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr align="center" bgcolor="#EEF2FB">
									<td height="19" colspan="6" class="titleLine"
										bgcolor="#EEF2FB">
										<div align="left">
											<p>&nbsp;</p>
											<p>&nbsp;</p>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td height="23" colspan="6"><div align="center"
											class="left_txt">车信息</div></td>

								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td><div align="center" class="left_txt">车号：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${car.carid }</font>
										</div></td>
									<td><div align="center" class="left_txt">型号：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${car.type}</font>
										</div></td>
									<td><div align="center" class="left_txt">颜色：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red">${car.color }</font>
										</div></td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td><div align="center" class="left_txt">价值：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red"><fmt:formatNumber type="currency"
													value="${car.price }" /></font>
										</div></td>
									<td><div align="center" class="left_txt">租金：</div></td>
									<td><div align="center" class="left_txt">
											<font color="red"><fmt:formatNumber type="currency"
													value="${car.rentprice }" /></font>
										</div></td>
									<td><div align="center" class="left_txt">押金：</div></td>
									<td><br>
									<div align="center" class="left_txt">
											<font color="red"><fmt:formatNumber type="currency"
													value="${car.deposit }" /> </font>
										</div>
										<br></td>
								</tr>
								<tr>
									<td colspan="6"><hr color="#99CCFF"></td>
								</tr>
								<tr>
									<td>
										<div align="center" class="left_txt">租用情况：</div>
									</td>
									<td>
										<div align="center" class="left_txt">
											<font color="red"> 
												<c:choose>
													<c:when test="${status eq '已出租' }">已出租</c:when>
													<c:otherwise>未出租</c:otherwise>
												</c:choose>
											</font>
										</div>
									</td>
									<td>
										<div align="center" class="left_txt">简介：</div>
									</td>
									<td>
										<div align="center" class="left_txt">
											<font color="red">${car.desc }</font>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="6">
										<hr color="#99CCFF">
									</td>
								</tr>
							</table>
						</table>
	
	
	</form>
		
</body>
</html>
