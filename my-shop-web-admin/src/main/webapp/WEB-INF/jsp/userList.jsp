<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\9 0009
  Time: 16:32
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
    <title>用户列表</title>
    <jsp:include page="../common/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/nav.jsp"/>
    <jsp:include page="../common/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>用户管理</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${result!=null}">
                        <div class="alert alert-${result.statusCode==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="icon fa fa-ban"></i>${result.message}
                        </div>
                    </c:if>

                    <div class="box box-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                            <div class="row" style="padding-top: 12px">
                                <div class="box-body">
                                    <div class="row form-horizontal">
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-3 control-label">邮箱</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="email" name="email"
                                                           placeholder="邮箱"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-3 control-label">用户</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="username"
                                                           name="username" placeholder="邮箱"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-3 control-label">手机</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="phone" name="phone"
                                                           placeholder="手机"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="col-sm-3">
                                                <button type="reset" class="btn btn-default pull-right"
                                                        onclick="reset()">重置
                                                </button>
                                            </div>
                                            <div class="col-sm-3">
                                                <button class="btn btn-info pull-right" onclick="search()">查询</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/user/form" class="btn btn-default"><i class="fa fa-plus-circle"></i>新增</a>
                            <button class="btn btn-default" onclick="Checkbox.deleteMulti('/user/delete')">
                                <i class="fa fa-trash-o"></i>删除
                            </button>
                            <a class="btn btn-default"><i class="fa fa-level-down"></i>导入</a>
                            <a class="btn btn-default"><i class="fa fa-level-up"></i>导出</a>
                            <button class="btn btn-primary" onclick="displaySearch()"><i class="fa fa-search"></i>搜索
                            </button>
                        </div>

                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" class="minimal check_main">
                                    </th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>手机号</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
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
                    <button id="btn-cancel" type="button" class="btn btn-default pull-left" data-dismiss="modal">取消
                    </button>
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
<script src="<%=basePath%>static/js/checkbox-init.js"></script>
<script>
    var _dataTable;

    $(function () {
        var columns = [
            {
                //复选框
                data: function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal">';
                }
            },
            {data: 'username'},
            {data: 'email'},
            {data: 'phone'},
            {data: 'updateTime'},
            {
                //操作框
                data: function (row, type, val, meta) {
                    //定义查看的url
                    var viewUrl = "/user/view?id=" + row.id;
                    //定义删除的url
                    var delUrl = "/user/delete";

                    return '<button class="btn btn-default btn-sm" onclick="Checkbox.view(\'' + viewUrl + '\')"><i class="fa fa-search"></i>查看</button>&nbsp;&nbsp;'
                        + '<a href="/user/form?id=' + row.id + '" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;'
                        + '<button class="btn btn-danger btn-sm" onclick="Checkbox.deleteSingle(\'' + row.id + '\',\'' + delUrl + '\')"><i class="fa fa-trash-o"></i>删除</button>';
                }
            }
        ];

        _dataTable = Checkbox.initDataTable("/user/page", columns);
    });

    function search() {
        var email = $("#email").val();
        var username = $("#username").val();
        var phone = $("#phone").val();
        var param = {
            "email": email,
            "username": username,
            "phone": phone
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }

    /**
     * 搜索框动态展示
     */
    function displaySearch() {
        $(".box-search").css("display") == "none" ? $(".box-search").show("fast") : $(".box-search").hide("fast");
    }

    /**
     * 重置搜索输入框
     */
    function reset() {
        $("#email").val("");
        $("#username").val("");
        $("#phone").val("");
    }

</script>
</body>
</html>
