<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/echarts.js"></script>
</head>
  <body style="height: 100%; margin: 0">
  <div >
  	<h1 align="center">公司收入统计柱状图</h1>
  </div>	
     <div id="container" style="height: 90%"></div>
     <script type="text/javascript">
	     $(function(){
	    	var dom = document.getElementById("container");
	   		var myChart = echarts.init(dom);
	   		var app = {};
	   		option = null;
	   		$.ajax({
	   			url:"<%=request.getContextPath() %>/selIncomeVO",
	   			data:"",
	   			dataType:"json",
	   			type:"post",
	   			success:function(rsData){
	   				var xArr = [];
	   				var yArr = [];
	   				for ( var i in rsData) {
	   					xArr[i] = rsData[i].month+"月";
	   					yArr[i] = rsData[i].money;
					}
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
   					            data : xArr,
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
   					            name:'收入统计',
   					            type:'bar',
   					            barWidth: '60%',
   					            data:yArr
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