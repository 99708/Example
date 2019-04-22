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
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/global.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.select.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.grid.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
</head> 
<body>
    <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">当月应还车辆</a>
			</div>
        </div>

        <div id="inner-bd">
          <div class="year-summary">
              <div class="kv-group-outer">
                  <div class="kv-group clearfix">
                  	  <div class="kv-item">
                          <div class="item-lt">起租日期：</div>
                          <div class="item-rt">
                          	<input type="text" id="begindateId" name="begindate" value="" onClick="WdatePicker()" style="width: 150px"/>
                          </div>
                      </div>
                      <div class="kv-item">
                          <div class="item-lt">应归还日期：</div>
                          <div class="item-rt">
                          	<input type="text" id="dateableId" name="dateable" value="" onClick="WdatePicker()" style="width: 150px"/>
                          </div>
                      </div>
                      <div class="kv-item">
                          <div class="item-lt">服务人员编号：</div>
                          <div class="item-rt">
                          		<input type="text" id="uid" name="uid" value="" style="width: 150px"/>
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
                        <td class="comment">出租单编号</td>
                        <td class="comment">起租日期</td>
                        <td class="comment">应归还日期</td>
                        <td class="comment">客户身份证号码</td>
                        <td class="comment">租用车车号</td>
                        <td class="comment">出租单状态</td>
                        <td class="comment">服务人员编号</td>
                      </tr>
                    </thead>
                    <tbody id="tb">
                    </tbody> 
                 </table>
                 
                 <div class="pagin">
					<div class="message">共<i id="countId" class="blue">1256</i>条记录，当前显示第&nbsp;<i id="numId" class="blue">2&nbsp;&nbsp;</i>页</div>
					<ul id="page" class="paginList">
						<li id="up" class="paginItem"><span class="pagepre"></span></li>
						<li id="num" class="paginItem"><a href="javascript:;">0</a></li>
						<li id="next" class="paginItem"><span class="pagenxt"></span></li>
					</ul>
				</div>
    		</div>
              </div>
          </div>
        </div>

    <script type="text/javascript">
    	$('select').select();
    	var pageNum; //当前页
		var pageSize;//分页大小
		var pageCount;//总页数
		var conunt;	//总记录数
		var rData; //查询结果
    
    	$(function(){
    		getData(1,5);
    		$("#btn").click(function(){
    			getData(1,5);
    		});
    		//上一页
    		$("#up").click(function(){
    			if(pageNum > 1){
    				getData(pageNum-1, pageSize);
    			}else{
    				alert("已经是第一页了");
    			}
    		});
    		//下一页
			$("#next").click(function(){
				if(pageNum < pageCount){
    				getData(pageNum+1, pageSize);
    			}else{
    				alert("已经是最后一页了");
    			}
    		});
    		//导出
    		$("#export").click(function(){
    			$.ajax({
        			url:"<%=request.getContextPath() %>/exportExcel",
        			data:"rentalList="+rData,
        			dataType:"json",
        			type:"post",
        			success:function(rsData){
        				if(rsData != 1){
        					alert("导出失败");
        				}else{
        					alert("导出成功");
        				}
        			}
    			});
    		});
    	})
    	
    	function getData(pNum, pSize){
    		var tb = $("#tb");
    		tb.empty();
    		$.ajax({
    			url:"<%=request.getContextPath() %>/selCarReturn",
    			data:"begindate="+$("#begindateId").val()+"&dateable="+$("#dateableId").val()
    			+"&uid="+$("#uid").val()+"&pageNum="+pNum+"&pageSize="+pSize,
    			dataType:"json",
    			type:"post",
    			success:function(rsData){
    				pageNum = rsData.pageNum;
    				pageSize = rsData.pageSize;
    				pageCount = rsData.count;
    				count = rsData.pages;
    				rData = JSON.stringify(rsData.rentalList);
    				
    				for (var i = 0; i < rsData.rentalList.length; i++) {
    					var rental = rsData.rentalList[i];
    					tb.append("<tr>"+
								"<td>"+(i+1)+"</td>"+
		                        "<td>"+rental.rentid+"</td>"+
		                        "<td>"+rental.begindate.substr(0,10)+"</td>"+
		                        "<td>"+rental.dateable.substr(0,10)+"</td>"+
		                        "<td>"+rental.idcard+"</td>"+
		                        "<td>"+rental.carid+"</td>"+
		                        "<td>"+rental.status+"</td>"+
		                        "<td>"+rental.uid+"</td>"+
	                        "</tr>");
					}
    				$("#countId").html(count);//设置总的记录数
    				$("#numId").html(pageNum);//设置当前页码数
    				
    				//显示分页页码
    				$("#num").empty();
    				for(var i=1; i<=pageCount; i++){
    					$("#num").append(
    						"<li id="+i+" class='paginItem'><a href='javascript:;''>"+i+"</a></li>"
    					);
    				}
    				//添加点击事件
    				$("#page a").click(function(){
    					getData($(this).html(), pageSize);
    				});  
    				//添加当前页样式
    				$("#"+pageNum+" a").addClass("paginItem current");
    			}
    		});
    	}
    </script>
</body> 
</html>



