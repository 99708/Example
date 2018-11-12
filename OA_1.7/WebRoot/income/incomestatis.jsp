<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'incomestatis.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

	   <body style="height: 100%; margin: 0">
	   <div >
	   	<h1 align="center">公司收入统计柱状图</h1>
	   </div>	
       <div id="container" style="height: 90%"></div>
       <script type="text/javascript" src="js/jquery.js"></script>
       <script type="text/javascript" src="js/echarts.js"></script>
       <script type="text/javascript">
      
      	 	//使用jquery的ajax查询收入情况
       		$(function(){
       			$.ajax({
       				url:"incomeServlet.servlet?method=findIncomeByType",
       				data:"",
       				type:"post",
       				datatype:"json",
       				success:function(rsData){
       					//console.log(rsData);
       					//将json数组变成两个数组
       					var typeArr = [];
       					var amountArr = [];
       					
       					//遍历数组
       					for(var i in rsData){
       						
       						typeArr.push(rsData[i].type);
       						amountArr.push(rsData[i].amount);
       						/* console.log(typeArr);
           					console.log(amountArr); */
       					}
       					//使用echarts总数据展示
       					var dom = document.getElementById("container");
       					var myChart = echarts.init(dom);
       					var app = {};
       					option = null;
       					
       					option = {
       						    color: ['#3398DB'],
       						    tooltip : {
       						        trigger: 'axis',
       						        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
       						            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
       						        }
       						    },
       						    grid: {
       						        left: '3%',
       						        right: '4%',
       						        bottom: '3%',
       						        containLabel: true
       						    },
       						    xAxis : [
       						        {
       						            type : 'category',
       						            data : typeArr,
       						            axisTick: {
       						                alignWithLabel: true
       						            }
       						        }
       						    ],
       						    yAxis : [
       						        {
       						            type : 'value'
       						        }
       						    ],
       						    series : [
       						        {
       						            name:'收入',
       						            type:'bar',
       						            barWidth: '60%',
       						            data:amountArr
       						        }
       						    ]
       						};
       					if (option && typeof option === "object") {
       					    myChart.setOption(option, true);
       					}
       				}
       				
       			});
       		})
       
			
		</script>
   </body>
</html>