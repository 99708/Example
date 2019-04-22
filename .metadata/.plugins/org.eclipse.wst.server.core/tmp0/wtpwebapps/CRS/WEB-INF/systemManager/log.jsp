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
	
	<script type="text/javascript">
	
		$(function(){
			
			//声明变量记录当前的页码数
    		var pageNum;
			//声明变量记录总的页码数
			var pages;
			
			//获取起始数据
			getData(1,6);
			
			//查询按钮
			$("#serchbtn").click(function(){
				alert("有毒？");
				getData(1,6);
			})
			
			
			
			//封装ajax分页功能函数
	    	function getData(pn,ps){
			
				//查询条件
				var oper = $("#logInfo").val(); //内容
				var uid = $("#uname").val(); //操作员
				var opertime = $("#dateableId").val(); //事件时间
    			
					$.ajax({
						url : "<%=request.getContextPath() %>/findslfLogNow" ,
						data : "oper="+oper+"&uname="+uname+"&opertime="+opertime
									+"&num="+pn+"&pageSize="+ps,
						dataType : "json" ,
						type : "post" ,
						success : function(rsData){
							
							//获取当次请求的页码数
	    					 pageNum=rsData.num;
	    					 pages=rsData.pages;
	    					 
	    					//获取表格对象
    						var tb=$("#tb");
    						tb.empty();
    						
    						//填充表格
    						for(var i = 0;i<rsData.slf.length;i++){
    							tb.append("<tr> "+
    			                        "<td>"+rsData.slf[i].sid+"</td> "+
    			                        "<td>"+rsData.slf[i].uid+"</td> "+
    			                        "<td>"+rsData.slf[i].oper+"</td> "+
    			                        "<td>"+rsData.slf[i].opertime+"</td> "+
    			                     "</tr>");
    						}
    						
    						//记录总数据量
    						$("#count").html(rsData.count);
    						//当前显示页数
    						$("#num").html(pageNum);
    						//获取页码对象
    						var ps = $("#pages");
    						//清空页面
    						ps.empty();
    						//填充页码
    						//填出上一页按钮
    						ps.append("<li class='paginItem'> "+
    						"<a href='javascript:;' id='prePage'> "+
    						"<span class='pagepre'></span> "+
    						"</a> "+
    						"</li>");
    						//遍历页码
    						for(var n = 1; n<=pages; n++){
    							ps.append("<li class='paginItem'><a href='javascript:;' class='pageDrump'>"+n+"</a></li>");
    						}
    						//填出下一页按钮
    						ps.append("<li class='paginItem'> "+
    						"<a href='javascript:;' id='nextPage'> "+
    						"<span class='pagenxt'></span> "+
    						"</a> "+
    						"</li>");
    						
    						//给页码添加点击事件
    						$("a.pageDrump").click(function(){
    							getData($(this).html(), 6);
    						})
    						
    						//声明上一页和下一页点击事件
    						//下一页功能
							$("#nextPage").click(function(){
								if(pageNum<pages){
									getData(pageNum+1, 6);
								}else{
									alert("已经是最后一页");
								}
							})
							//上一页功能
							$("#prePage").click(function(){
								if(pageNum>1){
									getData(pageNum-1, 6);
								}else{
									alert("已经是第一页");
								}
			})
    						
							
						}

					});
				}
			})
	
	</script>
	
	
	
</head> 
<body>
    <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">日志管理</a>
			</div>
        </div>

        <div id="inner-bd">
          <div class="season-summary">
              <div class="kv-group-outer">
                  <div class="kv-group clearfix">
                      <div class="kv-item">
                          <div class="item-lt">年份：</div>
                          <div class="item-rt">
                              <input name="" id="" type="text">
                          </div>
                      </div>
                      <div class="kv-item">
                          <div class="item-lt">部门内设机构：</div>
                          <div class="item-rt">
                              <select>
                                  <option>办公室</option>
                              </select>
                          </div>
                      </div>
                  </div>
              </div>
          </div><!--season-summary-->
          <div class="year-summary">
              <div class="kv-group-outer">
                  <div class="kv-group clearfix">
                  	      <div class="kv-item">
	                          <div class="item-lt">日志内容：</div>
	                          <div class="item-rt">
	                          		<input type="text" id="logInfo" name="logInfo" value="" style="width: 150px"/>
	                          </div>
                  	      </div>
                  	      <div class="kv-item">
	                         <div class="item-lt">用户ID：</div>
	                         <div class="item-rt">
	                          		<input type="text" id="uname" name="uname" value="" style="width: 150px"/>
	                         </div>
                  	      </div>
                  	      <div class="kv-item">
	                          <div class="item-lt">事件时间：</div>
	                          <div class="item-rt">
	                          	<input type="text" id="dateableId" name="dateable" value="" onClick="WdatePicker()" style="width: 150px"/>
                        	  </div>
                      </div>
                      <div class="button-group">
					        <div class="button current">
					            <span class="button-label" id="serchbtn">查询</span>
					        </div>
					   </div>
                      </div>
                  </div>
              </div>
              <div class="table-zone">
                  <table>
                    <thead>
                      <tr>
                        <td class="number">序号</td>
                        <td class="name">用户ID</td>
                        <td class="detail">日志内容</td>
                        <td class="file">事件时间</td>
                      </tr>
                    </thead>
                    <tbody id="tb">
                    	
                    </tbody>
                 </table>
                 
                 <div class="pagin">
				<div class="message">共<i class="blue" id="count"></i>条记录，当前显示第&nbsp;<i class="blue" id="num">2</i>&nbsp;页</div>
				<ul class="paginList" id="pages">
					<li class="paginItem"><a href="javascript:;" id="prePage"><span class="pagepre"></span></a></li>
						<li class="paginItem"><a href="javascript:;">1</a></li>
						<li class="paginItem"><a href="javascript:;">3</a></li>
						<li class="paginItem"><a href="javascript:;">4</a></li>
						<li class="paginItem"><a href="javascript:;">5</a></li>
						<li class="paginItem"><a href="javascript:;">10</a></li>
					<li class="paginItem"><a href="javascript:;" id="nextPage"><span class="pagenxt"></span></a></li>
				</ul>
			</div>
    </div>
              </div>
          </div>
        </div>
    </div>

</body> 
</html>



