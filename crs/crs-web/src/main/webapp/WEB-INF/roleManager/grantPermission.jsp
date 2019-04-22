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
    <link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.ztree.excheck.min.js"></script>

    <script type="text/javascript">
        var zTreeObj;
        var setting = {
            check : {
                enable : true
            },
            data : {
                simpleData : {
                    enable : true
                }
            }
        };

        $(function(){
            $.ajax({
                url:"<%=request.getContextPath() %>/grantPermission?rname="+"${role.rname}",
                type:"post",
                dataType:"json",
                success:initzTree
            });
        });
        //回调函数
        function initzTree(data){
            //初始化树
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, data);

            //展开树结点
            zTreeObj.expandAll(true);
        }
    </script>

</head>

<body>

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">配置 [${role.rname}] 角色的权限</a>
    </div>
</div>

<div class="formbody">
    <div class="button-group">
        <div class="button current" style="margin-left: 20px;">
            <span class="button-label" id="save">保存</span>
        </div>
        <div class="button current">
            <span class="button-label" id="back">取消</span>
        </div>
    </div>

    <div class="table-zone">
        <form id="formId" action="<%=request.getContextPath() %>/upPermission" method="post">
            <input type="hidden" name="rid" value="${role.rid}"/>
            <input type="hidden" id="moduleIds" name="moduleIds" value="" />
            <ul id="treeDemo" class="ztree"></ul>
        </form>
    </div>

</div>
<script type="text/javascript">
    //获取所有选择的节点
    $("#save").click(function () {
        var nodes = new Array();
        nodes = zTreeObj.getCheckedNodes(true);		//取得选中的结点
        var str = "";
        for (i = 0; i < nodes.length; i++) {
            if (str != "") {
                str += ",";
            }
            str += nodes[i].id;
        }
        $('#moduleIds').val(str);
        $("#formId").submit();
    });
    //点击取消按钮
    $("#back").click(function () {
       window.location.href="<%=request.getContextPath() %>/jsp/roleManager/roleList";
    });
</script>
</body>

</html>
