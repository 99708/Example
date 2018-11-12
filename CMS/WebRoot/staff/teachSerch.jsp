<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>任课教师查询</title>
		<meta charset="UTF-8"/>
	</head>
	
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		
	function leaveOffice(tid ){
		
		if(confirm("你确定将编号为"+tid+"的老师辞掉吗?")){
			
			$.ajax({
				url : "teacherServlet.bjsxt?method=teacherLeaveOffice" ,
				data : "tid="+tid ,
				type : "post" ,
				dataType : "json" ,
				success : function(rsData){
						if(rsData > 0){
							alert("离职成功!");
							window.location.reload();
						}else{
							alert("这位老师似乎还不想离职呢!");
						}
					}
			
			})
			
		}
	}
	
		$(function(){
			
			serchTeacher("getTeacherByTname");
			
			//下拉框的值，1 = 教师姓名 ，2 = 任职科目
			var serchid = $("#serchid").val();
			//搜索内容
			var serchText = $("#serchText").val();
			
			$("#subid").click(function(){
				
				serchid = $("#serchid").val();
				
				$("#tb").empty();
				
				if(serchid == 1){
					serchTeacher("getTeacherByTname");
				}else if(serchid == 2){
					serchTeacher("getTeacherBySubname");
				}else{
					alert("系统错误,请稍后重试 ! ");
				}
				
			})
			
			function serchTeacher(method){
				
				serchText = $("#serchText").val();
				
				$.ajax({
					
					url : "teacherServlet.bjsxt?method="+method ,
					data : "serchText="+serchText ,
					type : "post" ,
					dataType : "json" ,
					success : function(rsData){
						for (var i = 0; i < rsData.length; i++) {
							$("#tb").append( " <tr> "+
												"<td>"+rsData[i].tid+"</td> "+
												"<td>"+rsData[i].name+"</td> "+
												"<td>"+rsData[i].sex+"</td> "+
												"<td>"+rsData[i].hiredate+"</td> "+
												"<td>"+rsData[i].subname+"</td> "+
												"<td> "+
													"<a href = 'javascript:void(0)' id='delWho' name='delWho' onclick = ' leaveOffice("+rsData[i].tid+") '>离职</a> "+
												"</td> "+
											"</tr> " );
						}
					}
				
				})
				
			}
			
		})
		
		
		
	</script>
	
	<style type="text/css">
		
		/*a标签全局CSS*/
		a{
			text-decoration:none;
			color: chocolate;
			font-size: 14px;
			font-weight: bold;
		}
		a:hover{
			text-decoration: underline;
			color: red;
		}
		
		/*table标签全局CSS*/
		table{
			text-align: center;
			border-collapse:collapse;
		}
		td{
			width: 110px;
			height: 8px;
			font-size: 10px;
			font-weight: bold;
		}
		
	</style>
	
	
	
	<body>
		
		<div id="showDiv" style="border: solid 0px; border-color: gray; height: 840px;width: 800px;margin: auto;">
			<span id="showSpan" style="float: right; margin-right:36px;">
				<br />
                <div id="serch" style="float: left;">
                	请输入查询条件 : 
                	<select id = "serchid" name = "serchid" style="height: 22px;">
                        <option value="1">教师姓名</option>
                        <option value="2">任职科目</option>
                    </select>
                </div>
				<input type="text" name="serchText" id="serchText" value="" />
				<input type="button" name="subid" id="subid" value="提交" />
				<input type="checkbox" name="" id="" value="" />查询历史记录
			</span><br /><br /><br />
			<table align="center" border="1px" cellspacing="" cellpadding="5px" id="showTable">
				<thead>
					<tr>
						<td>教师编号</td>
						<td>教师姓名</td>
						<td>教师性别</td>
						<td>任职日期 </td>
						<td>任职科目</td>
						<td>维护</td>
					</tr>
				</thead>
				
				<tbody id = "tb" name = "tb">
				
				</tbody>
				
			</table>
			<p style="color: steelblue;"></p>
		</div>
		
		
	</body>
</html>