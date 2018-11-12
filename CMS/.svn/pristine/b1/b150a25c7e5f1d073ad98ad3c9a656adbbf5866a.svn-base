<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'resultinput.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
<link href="umeditor/themes/default/_css/umeditor.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/umeditor.config.js"></script>
<script type="text/javascript" src="js/editor_api.js"></script>
<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
	<div id="container">

		<div id="bd">
			<div id="main">
				<h2 class="subfild">
					<span>成绩录入</span>
				</h2>
				<form action="scoreServlet.bjsxt?method=updateScoreByid" method="post">
					<table border="" cellspacing="" cellpadding="" width="70%"
						id="table1">
						<tr>
							<td>所带课程</td>
							<td>
								<div class="vocation">
									<select class="select1" name="subjectId"
										style="width: 330px; height: 28px; margin-bottom: 10px">
										<option value="-1">---请选择---</option>
										<c:forEach items="${subjectList }" var="subject">
											<option value="${subject.subid }">${subject.subname }</option>
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>学生姓名</td>
							<td>
								<div class="vocation">
									<select id="studentId" class="select1" name="studentId"
										style="width: 330px; height: 28px; margin-bottom: 10px">
										<option value="-1">---请选择---</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>课程成绩</td>
							<td><input name="score" type="text" class="dfinput"
								style="width: 330px; height: 28px" /><i></i></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="button" type="submit" value="添加" style="margin-top: 20px" />
							</td>
							
						</tr>

					</table>
				</form>

			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("select").change(function(){
				//获取下拉框的value
				var val = $(this).val();
				var name = $(this).attr("name");
				//获取下一个下拉框
				if($(this).attr("id") != "studentId"){
					//清空第二个下拉框中的内容
					$("#studentId").empty();
					//发送ajax请求
					$.ajax({
						url:"scoreServlet.bjsxt",
						data:"method=findStudentBySubid&value="+val,
						dataType:"json",
						type:"post",
						success:function(rsDate){
							//遍历结果
							for(var i in rsDate){
								var stu = rsDate[i];
								//创建option
								var $option = $("<option>");
								//设置option的value的值和text内容
								$option.val(stu.sid);
								$option.html(stu.sname);
								//将option添加到第二个下拉框
								$("#studentId").append($option);
							}
							
						}
					});
				}
				
				
			});
			
		});	
	
	</script>
</body>

</html>
