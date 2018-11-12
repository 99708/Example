<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'expensestatis.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="js/echarts.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
			    $(".select1").uedSelect({
					width : 345			  
				});
				
				$("#select1").change();
			});
			
		</script>
	</head>

	<body style="height: 100%; margin: 0">
		<div style="height: 10%px; width: 500px;  margin:0px auto;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			请选择支出时间段：
			<select class="select1" id="select1" onchange="changePie(this.value)">
				<option value="100">当月</option>
				<option value="300">上月</option>
				<option value="500">近3个月</option>
				<option value="1000">近半月</option>
			</select>			
		</div>
		<div id="container" style="height: 85%; margin-top: 40px;"></div>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					url:"paymentServlet.servlet?method=findPaymentByType",
					data:"",
					datatype:"json",
					type:"post",
					success:function(rsData){
						console.log(rsData);
						
						var typeArr = [];
						
						//遍历
						for(var i in rsData){
							var paymentvo = rsData[i];
							typeArr.push(paymentvo.name)
						}
						console.log(typeArr);
						
						var dom = document.getElementById("container");
						var myChart = echarts.init(dom);
						var app = {};
						option = null;
						option = {
							    title : {
							        text: '520支出统计',
							        subtext: '纯属虚构如有雷同不胜荣幸',
							        x:'center'
							    },
							    tooltip : {
							        trigger: 'item',
							        formatter: "{a} <br/>{b} : {c} ({d}%)"
							    },
							    legend: {
							        orient: 'vertical',
							        left: '80%',
							        data: typeArr
							    },
							    series : [
							        {
							            name: '支出情况',
							            type: 'pie',
							            radius : '55%',
							            center: ['50%', '60%'],
							            data:rsData,
							            itemStyle: {
							                emphasis: {
							                    shadowBlur: 10,
							                    shadowOffsetX: 0,
							                    shadowColor: 'rgba(0, 0, 0, 0.5)'
							                }
							            }
							        }
							    ]
							};
						if (option && typeof option === "object") {
						    myChart.setOption(option, true);
						}
					}
				});
			});
		</script>     
			       
	</body>
</html>
