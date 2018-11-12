<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'expenseAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
			    $(".select1").uedSelect({
					width : 345			  
				});
				
			});
		</script>
		<script type="text/javascript">
			function addPhoto(){
				//获取上传图片li
				var li = $("#uploadphoto");
				//console.info(li);
				//准备添加的dom对象
				var content=$("<span><label>&nbsp;</label><input name='photo' type='file' class='dfinput' /><i></i>"+
				"<input type='button'  class='btn'  value='删除' onclick='removeCurrSpan(this)'/></span>");
				//加入到指定位置
				li.append(content);
			}
			
			function removeCurrSpan(obj){				
				$(obj).parent().remove();
				
			}
			
			function addExpenseItem(id){
				//获取上级标签
				var table = $(id);
				
				//创建当前标签
				var content = $('<tr>'+
				'<td><div class="vocation"><select class="select1" name="type">'+
				'<option value="1">通信费用</option><option value="2">办公室耗材</option><option value="3">住宿费用</option><option value="4">房租水电</option>'+
				'</select></div></td>'+
				'<td><input name="amount" type="text" class="dfinput dfinput_amount" /><i></i></td>'+
				'<td><input name="itemdesc" type="text" class="dfinput" /><i></i></td>'+
				'<td><input type="button"  class="btn"  value="删除" onclick="removeCurrItem(this)"/></td></tr>');
				
				//加入上级标签
				table.append(content);
				 $(".select1").uedSelect({
					width : 345			  
				});
			}
			
			function removeCurrItem(obj){				
				$(obj).parent().parent().remove();
				
			}
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">添加报销</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>
			<form id="expenseFormId">
			<ul class="forminfo">
				<li>
					<label>报销人</label>
					<input id="empid" name="empid" type="text" readonly="readonly" class="dfinput"  value="${empid }"/><i></i></li>
				<li>
					<li>
						<label>报销时间</label>
						<input name="exptime" type="text" class="dfinput" readonly="readonly" value="${nowDateStr }"/><i></i></li>
					<li>
						<li>
							<label>具体报销项</label>
							<input type="button"  class="btn"  value="添加报销项" onclick="addExpenseItem('#table1')"/>
							
							<table border="" cellspacing="" cellpadding="" width="70%" id="table1">
								<tr>
									<td>报销类型</td>
									<td>报销费用</td>
									<td>费用说明</td>
								</tr>
								<tr>
									<td>
										<div class="vocation">
											<select class="select1" name="type">
												<option value="1">通信费用</option>
												<option value="2">办公室耗材</option>
												<option value="3">住宿费用</option>
												<option value="4">房租水电</option>
												<option value="5">其他</option>
											</select>
										</div>
									</td>
									<td><input name="amount" type="text" class="dfinput dfinput_amount" /><i></i></td>
									<td><input name="itemdesc" type="text" class="dfinput" /><i></i></td>
									<td>&nbsp;</td>
								</tr>								
							</table>							
						</li>
						<li>
							
						</li>
						<li>
							<label>报销总额</label>
							<input id="totalamount" name="totalamount" type="text" class="dfinput" /><i></i>
							<input id="totalId" type="button"  class="btn"  value="总计" />
						</li>
						<li id="uploadphoto">
							<label>上传报销图片</label>
							<span>
								<input name="photo" type="file" class="dfinput" /><i></i>
								<input type="button"  class="btn"  value="添加图片" onclick="addPhoto()"/>
							</span>							
						</li>
						<li>
							<label>审批人</label>
							<div class="vocation">
								<input name="nextauditor" type="text" class="dfinput" value="${mgrEmp.realname }"/>
							</div>
						</li>
					<li>
						<label>总备注信息</label>
						<textarea name="expdesc" cols="" rows="" class="textinput"></textarea>
					</li>					
					<li>
						<label>&nbsp;</label>
						<input id="btn" type="button" class="btn" value="确认添加" />
					</li>
			</ul>
		</form>
		</div>
		<script type="text/javascript">
			$(function(){//页面加载的时候执行的方法
				//给总计按钮添加点击事件
				$("#totalId").click(function(){
					var totalAmount = 0;
					//对相同class的值进行遍历
					$(".dfinput_amount").each(function(index, ele){
						totalAmount += Number($(ele).val());
					})
					$("#totalamount").val(totalAmount);
				})
				//给提交按钮添加点击事件
				$("#btn").click(function(){
					//获取表单要进行提交的值
					var formData = $("#expenseFormId").serialize();
					//console.log(formData);
					//使用jquery的ajax进行提交
					$.ajax({
						url:"expenseServlet.servlet?method=addExpense",
						data:formData,
						type:"post",
						dataType:"json",
						success:function(rsDate){
							if(rsDate.code == 1){
								//跳转到我的审核界面
								//TODO 有时间再做
								window.location.href = "myExpense.html";
							}else{
								//显示弹框并刷新当前界面
								alert(rsDate.info);
								window.location.href = window.location.href;
							}
							
						}
					})
				})
			})
		</script>

	</body>

</html>
