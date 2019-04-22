<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>car.jsp</title>
	<link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/work_summary.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div class="container">
	<div id="inner-hd">
		<div class="crumbs">
			<i class="crumbs-arrow"></i>
			<a href="javascript:;" class="crumbs-label">检查单管理</a>
		</div>
	</div>

	<div id="inner-bd">
		<div class="year-summary">
			<div class="kv-group-outer">
				<div class="kv-group clearfix">
					<div class="kv-item">
						<div class="item-lt">检查单编号：</div>
						<div class="item-rt">
							<input type="text" id="checkid" name="checkid" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
						</div>
					</div>
					<div class="kv-item">
						<div class="item-lt">检查日期：</div>
						<div class="item-rt">
							<input type="text" id="begindateId" name="begindate" value="" onClick="WdatePicker()" style="width: 200px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
						</div>
					</div>
					<div class="kv-item">
						<div class="item-lt">出租单编号：</div>
						<div class="item-rt">
							<input type="text" id="rentid" name="rentid" value="" style="width: 190px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
						</div>
					</div>
					<div class="button-group">
						<div class="button current">
							<span class="button-label" id="btn">查询</span>
						</div>
						<div class="button current">
							<span class="button-label" id="export">导出Excel</span>
						</div>
					</div>
				</div>
			</div>
			<div class="table-zone">
				<table>
					<thead>
					<tr>
						<td class="number">序号</td>
						<td class="comment">检查单编号</td>
						<td class="comment">检查日期</td>
						<td class="comment">问题</td>
						<td class="comment">赔费</td>
						<td class="comment">出租单编号</td>
						<td class="comment">检查员名称</td>
						<td class="comment">操作</td>
					</tr>
					</thead>
					<tbody id="tb">
					</tbody>
				</table>


			</div>
		</div>
	</div>
</div>
</body>
</html>



