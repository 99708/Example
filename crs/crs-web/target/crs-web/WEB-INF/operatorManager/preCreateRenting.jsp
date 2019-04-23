<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>


    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });

        });
    </script>
</head>

<body>

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">生成出租单</a>
    </div>
</div>

<div class="formbody">
    <form id="formId" action="<%=request.getContextPath() %>/rentCarByIdCard" method="post">
        <ul class="forminfo">
            <li>
                <label>出租单编号</label>
                <input name="rentid" id="rentid"  type="text" class="dfinput" value="${requestScope.tableId }" readonly/>
                <span id="rentidSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>预付金<b>*</b></label>
                <input name="deposit" id="imprest" type="text" class="dfinput" />
                <span id="imprestSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>应付金</label>
                <input name="payable" id="payable" type="text" class="dfinput" readonly="readonly"/>
                <span id="payableSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>实付金额<b>*</b></label>
                <input name="priced" id="priced" type="text" class="dfinput" />
                <span id="pricedSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>起租日期<b>*</b></label>
                <input name="begindate" id="begindate" type="text" class="dfinput" onClick="WdatePicker()"/>
                <span id="begindateSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>应归还日期<b>*</b></label>
                <input name="dateable" id="dateable" type="text" class="dfinput" onClick="WdatePicker()"/>
                <span id="dateableSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>出租单状态<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="status" id="status">
                        <option value="已出租" selected>已出租</option>
                    </select>
                </div>
            </li>
            <li>
                <label>汽车编号</label>
                <input name="carid" id="carid" type="text" class="dfinput" value="${car.carid }" readonly="readonly"/>
                <span id="caridSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>客户身份证号</label>
                <input name="idcard" id="idcard" type="text" class="dfinput" value="${requestScope.idcard }" readonly="readonly"/>
                <span id="idcardSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>操作员编号</label>
                <input name="uid" id="uid" type="text" class="dfinput" value="${sessionScope.user.uid }" readonly="readonly"/>
                <span id="uidSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>&nbsp;</label>
                <input type="submit" class="btn" value="确认保存" /><i></i>
                <input type="submit" class="btn" value="返回" />
            </li>
        </ul>
    </form>
</div>
<script type="text/javascript">
    //非空校验
    $(function () {
        $("#formId").submit(function(){
            $("#imprest,#priced,#begindate,#dateable").trigger("blur");
            if($(".error").length > 0){
                alert("请检查你的输入");
                return false;
            }else{
                return true;
            }
        });

        $("#imprest").blur(function(){
            var imprest = $("#imprest").val();
            if(imprest.length < 1){
                $("#imprestSpan").text("预付金不能为空").addClass("error").removeClass("ok");
            }else{
                $("#imprestSpan").text("").addClass("ok").removeClass("error");
            }
        });
        $("#priced").blur(function(){
            var priced = $("#priced").val();
            if(priced.length < 1){
                $("#pricedSpan").text("实付金额不能为空").addClass("error").removeClass("ok");
            }else{
                $("#pricedSpan").text("").addClass("ok").removeClass("error")
            }
        });
        $("#begindate").blur(function(){
            var begindate = $("#begindate").val();
            if(begindate.length < 1){
                $("#begindateSpan").text("起租日期不能为空").addClass("error").removeClass("ok");
            }else {
                $("#begindateSpan").text("").addClass("ok").removeClass("error")
            }
        });
        $("#dateable").blur(function(){
            var dateable = $("#dateable").val();
            if(dateable.length < 1){
                $("#dateableSpan").text("应归还日期不能为空").addClass("error").removeClass("ok");
            }else {
                $("#dateableSpan").text("").addClass("ok").removeClass("error");
                remarkMoney("${car.rentprice}");
            }
        });
    })
</script>
<script type="text/javascript">
    function remarkMoney(price){
        //获取租车起始时间
        var startDate = $("#begindate").val();
        //获取租车应归还时间
        var returnDate = $("#dateable").val();

        //去除 “-”符号
        startDate = startDate.replace(/[&|\*^%$#@-]/g, "");
        returnDate = returnDate.replace(/[&|\*^%$#@-]/g, "");

        //判断时间
        if(returnDate - startDate <= 0){
            alert("还车时间比借车时间还早,你想干啥→_→?帮你清除了,下不为例");
            $("#dateable").val("");
            $("#payable").val("");
            return;
        }
        var shouldPay = (returnDate - startDate) * price;
        $("#payable").val(shouldPay);
    }
</script>
</body>

</html>
