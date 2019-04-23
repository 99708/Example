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
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>

</head>
<body>
<div class="container">
    <div id="inner-hd">
        <div class="crumbs">
            <i class="crumbs-arrow"></i>
            <a href="javascript:;" class="crumbs-label">查询用户信息</a>
        </div>
    </div>

    <div id="inner-bd">
        <div class="year-summary">
            <div class="kv-group-outer">
                <div class="kv-group clearfix">
                    <div class="kv-item">
                        <div class="item-lt">账号：</div>
                        <div class="item-rt">
                            <input type="text" id="uid" name="uid" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                        </div>
                    </div>
                    <div class="kv-item">
                        <div class="item-lt">用户名：</div>
                        <div class="item-rt">
                            <input type="text" id="uname" name="uname" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                        </div>
                    </div>
                    <div class="kv-item">
                        <div class="item-lt">职位：</div>
                        <div class="item-rt">
                            <input type="text" id="rname" name="rname" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                        </div>
                    </div>
                    <div class="button-group">
                        <div class="button current">
                            <span class="button-label" id="btn">查询</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-zone">
                <table>
                    <thead>
                    <tr>
                        <td class="number">序号</td>
                        <td class="comment">账号</td>
                        <td class="comment">身份证号码</td>
                        <td class="comment">姓名</td>
                        <td class="comment">性别</td>
                        <td class="comment">职位</td>
                        <td class="comment">操作</td>
                    </tr>
                    </thead>
                    <tbody id="tb">
                    </tbody>
                </table>
            </div>
            <div class="am-margin am-cf">
                <hr/>
                <p class="am-fl">共 <i id="countId" class="blue">0</i> 条记录,当前显示第 <i id="numId" class="blue">0</i> / <i id="pageId" class="blue">0</i> 页</p>
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

    $(function(){
        getData(1,5);
        $("#btn").click(function(){
            getData(1,5);
        });
    })

    function getData(pNum, pSize){
        var tb = $("#tb");
        tb.empty();
        $.ajax({
            url:"<%=request.getContextPath() %>/selUser",
            data:"uid="+$("#uid").val()+"&cname="+$("#cname").val()
            +"&uname="+$("#uname").val()+"&rname="+$("#rname").val()+"&pageNum="+pNum+"&pageSize="+pSize,
            dataType:"json",
            type:"post",
            success:function(rsData) {
                pageNum = rsData.pageNum;
                pageSize = rsData.pageSize;
                count = rsData.count;
                pageCount = rsData.pages;

                for (var i = 0; i < rsData.lu.length; i++) {
                    var user = rsData.lu[i];
                    tb.append(
                        "<tr>"+
                        "<td>"+(i+1)+"</td>"+
                        "<td>"+user.uid+"</td>"+
                        "<td>"+user.idcard+"</td>"+
                        "<td>"+user.uname+"</td>"+
                        "<td>"+user.sex+"</td>"+
                        "<td>"+user.role.rname+"</td>"+
                        "<td>" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"showUser('"+user.uid+"')\">查看</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"upUser('"+user.uid+"')\">修改</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"delUser('"+user.uid+"')\">删除</a>" +
                        "</td>"+
                        "</tr>");
                }

                $("#countId").html(count);//设置总的记录数
                $("#numId").html(pageNum);//设置当前页码数
                $("#pageId").html(pageCount);//设置当前页码数

                //显示分页页码
                $("#page").empty();
                $("#page").append("<li id='up'><a href='javascript:;''>&laquo;</a></li>");
                for(var i=1; i<=pageCount; i++){
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
<script type="text/javascript">
    //查看用户信息
    function showUser(uid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/selUserById?uid="+uid;
    }

    //修改用户信息
    function upUser(uid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/updateUserView?uid="+uid;
    }
    //删除用户信息
    function delUser(uid) {
        if(window.confirm("您确定要这么做吗？")){
            window.location.href=window.location.href="<%=request.getContextPath() %>/delUser?uid="+uid;
        }else{
            return false;
        }
    }
</script>
</body>
</html>



