<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\19 0019
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>类目管理</title>
    <link rel="stylesheet" href="<%=basePath%>static/plugins/treeTable/vsStyle/jquery.treeTable.css"/>
    <jsp:include page="../common/header.jsp"/>
    <script src="<%=basePath%>static/js/checkbox-init.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/nav.jsp"/>
    <jsp:include page="../common/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>类目管理</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <!-- 操作结束提示信息 -->
                    <c:if test="${result!=null}">
                        <div class="alert alert-${result.statusCode==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="icon fa fa-ban"></i>${result.message}
                        </div>
                    </c:if>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">类目列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/contentCategory/form" class="btn btn-default"><i class="fa fa-plus-circle"></i>新增</a>
                            <button class="btn btn-default" onclick="Checkbox.deleteMulti('/user/delete')"><i
                                    class="fa fa-trash-o"></i>删除
                            </button>
                            <a class="btn btn-default"><i class="fa fa-level-down"></i>导入</a>
                            <a class="btn btn-default"><i class="fa fa-level-up"></i>导出</a>
                        </div>

                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${contentCategories}" var="contentCategory">
                                    <tr id="${contentCategory.id}" pId="${contentCategory.parentId}">
                                        <td>${contentCategory.id}</td>
                                        <td>${contentCategory.name}</td>
                                        <td>${contentCategory.sortOrder}</td>
                                        <td>
                                            <a href="/contentCategory/form?id=${contentCategory.id}" type="button"
                                               class="btn btn-primary btn-sm">
                                                <i class="fa fa-edit"></i>编辑
                                            </a>&nbsp;&nbsp;
                                            <button href="#" type="button" class="btn btn-danger btn-sm">
                                                <i class="fa fa-trash-o"></i>删除
                                            </button>&nbsp;&nbsp;
                                            <a href="/contentCategory/form?parentCategory.id=${contentCategory.id}&parentCategory.name=${contentCategory.name}"
                                               type="button" class="btn btn-default btn-sm">
                                                <i class="fa fa-plus"></i>新增下级
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../common/copyRight.jsp"/>

    <div class="control-sidebar-bg"></div>

    <!-- 提示模态框 -->
    <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p id="modal-alert-message">${message}&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                    <button id="btn-ok" type="button" class="btn btn-primary">确定</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 详情模态框 -->
    <div class="modal fade" id="modal-detail">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">用户详情</h4>
                </div>
                <div class="modal-body">
                    <p id="modal-detail-message">&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary pull-right" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>static/plugins/treeTable/jquery.treeTable.js"></script>
<script>
    $(function () {
        $("#treeTable").treeTable({
            //设置按第二列展示树,默认为第一列序号0
            column: 1,
            expandLevel: 3
        });
    });

</script>
</body>
</html>

