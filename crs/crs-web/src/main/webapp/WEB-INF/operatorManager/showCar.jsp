<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>car.jsp</title>
	<link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
	<%--<link href="<%=request.getContextPath() %>/css/work_summary.css" rel="stylesheet">--%>
	<link href="<%=request.getContextPath() %>/css/style2.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/amazeui.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>

</head>
<body>

<div id="inner-hd">
	<div class="crumbs">
		<i class="crumbs-arrow"></i>
		<a href="javascript:;" class="crumbs-label">客户选车</a>
	</div>
</div>
<div id="selectList" class="screenBox screenBackground">

	<dl class=" listIndex" attr="terminal_os_s">
		<dt>级　　别：</dt>
		<dd style="width: 820px;">
			<a href="javascript:void(0)" values2="" values1="" attrval="手动紧凑型轿车">手动紧凑型轿车</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="经济型轿车">经济型轿车</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="商务型轿车">商务型轿车</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="豪华型轿车">豪华型轿车</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="SUV 6至15座商务车">SUV 6至15座商务车</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="个性车">个性车</a>
		</dd>
	</dl>

	<dl class="listIndex" attr="terminal_brand_s">
		<dt>品　　牌：</dt>
		<dd style="width: 820px;">
			<a href="javascript:void(0)" values2="" values1="" attrval="奥迪">奥迪</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="宝马">宝马</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="奔驰">奔驰</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="本田">本田</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="标致">标致</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="大众">大众</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="丰田">丰田</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="福特">福特</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="凯迪拉克">凯迪拉克</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="马自达">马自达</a>
			<a href="javascript:void(0)" values2="" values1="" attrval="斯柯达">斯柯达</a>
		</dd>
	</dl>

	<dl class="listIndex" attr="价格范围">
		<dt>租　　金：</dt>
		<dd style="width: 820px;">
			<a href="javascript:void(0)" values2="499" values1="1" attrval="0-150">1-499</a>
			<a href="javascript:void(0)" values2="999" values1="500" attrval="151-300">500-999</a>
			<a href="javascript:void(0)" values2="1999" values1="1000" attrval="301-500">1000-1999</a>
			<a href="javascript:void(0)" values2="2999" values1="2000" attrval="501-1000">2000-2999</a>
			<a href="javascript:void(0)" values2="4999" values1="3000" attrval="1000-3000">3000-4999</a>
			<a href="javascript:void(0)" values2="0" values1="5000" attrval="3000以上">5000以上</a>
		</dd>
	</dl>
</div>
<div style="margin-left: 10px;">
	<img src="<%=request.getContextPath() %>/images/carstyle.png">
	<table border="0" width="100%" cellspacing="0" cellpadding="0">
		<tbody>
		<tr>
			<td colspan="4">
				<hr style="margin:0px; background-color:#7AA3DD; height:2px; border:none;"/>
			</td>
		</tr>
		<c:forEach var="car" items="${requestScope.carList }">
			<tr>
				<td>
					<img src="<%=request.getContextPath() %>/Car-Photo/${car.img} " style="width: 200px"/>
				</td>
				<td>
					汽车类型：${car.type }<br/>
					汽车颜色：${car.color }
				</td>
				<td>
					租车价格：${car.rentprice }<br/>
					押金：${car.deposit }
				</td>
				<td>
					<input type="button" value="租车" onclick="rentCar('${car.carid }')"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<hr style="margin:0px; background-color:#7AA3DD; height:2px; border:none;"/>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
	<script type="text/javascript">
		//租车事件
        function rentCar(carid) {
            window.location.href=window.location.href="<%=request.getContextPath() %>/rentCarNow?carid="+carid+"&idcard="+"${idcard}";
        }
	</script>
</body>
</html>



