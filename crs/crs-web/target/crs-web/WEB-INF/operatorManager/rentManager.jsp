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
	<link href="<%=request.getContextPath() %>/css/amazeui.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
</head>
<body>
<div class="container">
	<div id="inner-hd">
		<div class="crumbs">
			<i class="crumbs-arrow"></i>
			<a href="javascript:;" class="crumbs-label">出租单管理</a>
		</div>
	</div>

	<div id="inner-bd">
		<div class="year-summary">
			<div class="kv-group-outer">
				<div class="kv-group clearfix">
					<div class="kv-item">
						<div class="item-lt">出租单编号：</div>
						<div class="item-rt">
							<input type="text" id="rentid" name="rentid" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
						</div>
					</div>
					<div class="kv-item">
						<div class="item-lt">客户姓名：</div>
						<div class="item-rt">
							<input type="text" id="cname" name="cname" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
						</div>
					</div>
					<div class="kv-item">
						<div class="item-lt">汽车编号：</div>
						<div class="item-rt">
							<input type="text" id="carid" name="carid" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
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
						<td class="comment">出租单号</td>
						<td class="comment">客户姓名</td>
						<td class="comment">汽车编号</td>
						<td class="comment">预付金</td>
						<td class="comment">实付金额</td>
						<td class="comment">应付金</td>
						<td class="comment">应归还日期</td>
						<td class="comment">归还日期</td>
						<td class="comment">操作员编号</td>
						<td class="comment">操作</td>
					</tr>
					</thead>
					<tbody id="tb">
					</tbody>
				</table>
			</div>
			<div class="am-margin am-cf">
				<hr/>
				<p class="am-fl">共 <i id="countId" class="blue">0</i> 条记录,当前显示第 <i id="numId" class="blue">0</i> / <i id="pageId" class="blue">0</i>页</p>
				<ol id="page" class="am-pagination am-fr">
					<li id="up" ><a href="javascript:void(0)">&laquo;</a></li>
					<li id="num" class="am-active"><a href="#">0</a></li>
					<li id="next" ><a href="javascript:void(0)">&raquo;</a></li>
				</ol>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    var pageNum; //当前页
    var pageSize;//分页大小
    var pageCount;//总页数
    var conunt;	//总记录数
    var rData; //查询结果
    var navigationNumber = 5;//(每页的)导航个数
    var begin;//导航栏的起始数
    var end ;//导航的结束数

    $(function(){
        getData(1,5);
        $("#btn").click(function(){
            getData(1,5);
        });
    });

    function getData(pNum, pSize){
        var tb = $("#tb");
        tb.empty();
        $.ajax({
            url: "<%=request.getContextPath() %>/selRental",
            data: "rentid=" + $("#rentid").val() + "&carid=" + $("#carid").val()
            + "&cname=" + $("#cname").val() + "&pageNum=" + pNum + "&pageSize=" + pSize,
            dataType: "json",
            type: "post",
            success: function (rsData) {

                pageNum = rsData.pageNum;
                pageSize = rsData.pageSize;
                count = rsData.count;
                pageCount = rsData.pages;

                for (var i = 0; i < rsData.rentalList.length; i++) {
                    var rental = rsData.rentalList[i];
                    if(rental.returndate != null){
                        rental.returndate = rental.returndate.substr(0,10);
					}else{
                        rental.returndate = "";
                    }
                    tb.append(
                        "<tr>"+
                        "<td>"+(i+1)+"</td>"+
                        "<td>"+rental.rentid+"</td>"+
                        "<td>"+rental.customer.cname+"</td>"+
                        "<td>"+rental.carid+"</td>"+
                        "<td>"+rental.deposit+"</td>"+
                        "<td>"+rental.priced+"</td>"+
                        "<td>"+rental.payable+"</td>"+
                        "<td>"+rental.dateable.substr(0,10)+"</td>"+
                        "<td>"+rental.returndate+"</td>"+
                        "<td>"+rental.uid+"</td>"+
                        "<td>" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"showRental('"+rental.rentid+"')\">查看</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"upRental('"+rental.rentid+"')\">修改</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"deRental('"+rental.rentid+"')\">删除</a>" +
                        "</td>"+
                        "</tr>");
                }

                $("#countId").html(count);//设置总的记录数
                $("#pageId").html(pageCount);//设置总的分页数
                $("#numId").html(pageNum);//设置当前页码数

                //显示分页页码
                $("#page").empty();

                //导航栏第一个位置的数(begin)
                begin = Math.max(pageNum - Math.floor(navigationNumber/2), 1);
                //导航栏最后一个位置的数(end)
                end = Math.min(begin + navigationNumber - 1, pageCount);
                //特殊情况处理
                if(end - begin < 4){
                    begin = Math.max(end - 4, 1);
                }

                $("#page").append("<li id='up'><a href='javascript:;''>&laquo;</a></li>");
                for(var i=begin; i<=end; i++){
                    $("#page").append(
                        "<li id="+i+"><a href='javascript:;''>"+i+"</a></li>"
                    );
                }
                $("#page").append("<li id='next'><a href='javascript:;''>&raquo;</a></li>");

                //添加点击事件
                $("#page a").click(function(){
                    if($(this).html() != "«" && $(this).html() != "»"){
                        getData($(this).html(), pageSize);
                    }else if($(this).html() == "«"){
                        //上一页
                        $("#up").click(function(){
                            if(pageNum > 1){
                                getData(pageNum-1, pageSize);
                            }else{
                                alert("已经是第一页了");
                            }
                        });
                    }else{
                        //下一页
                        $("#next").click(function(){
                            if(pageNum < pageCount){
                                getData(pageNum+1, pageSize);
                            }else{
                                alert("已经是最后一页了");
                            }
                        });
                    }
                });

                //添加当前页样式
                $("#"+pageNum).addClass("am-active");
            }
        });
    }
</script>
<script>
    //查看出租单详细信息
    function showRentid(rentid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/selOneCar?carid="+carid;
    }

    //修改出租单信息
    function upRentid(rentid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/upCarView?carid="+carid;
    }

    //删除出租单信息
    function delRentid(rentid) {
        if(window.confirm("您确定要这么做吗？")){
            window.location.href=window.location.href="<%=request.getContextPath() %>/delCar?carid="+carid;
        }else{
            return false;
        }
    }

</script>
</body>
</html>



