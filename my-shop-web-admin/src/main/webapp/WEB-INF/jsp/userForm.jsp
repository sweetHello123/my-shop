<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\9 0009
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>用户表单</title>
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
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title" style="padding-bottom: 10px">${user.id==null?"新增":"编辑"}用户</h3>

                            <%--@elvariable id="user" type="com.china.myshop.domain.TbUser"--%>
                            <form:form id="inputForm" cssClass="form-horizontal" action="/user/save" method="post"
                                       modelAttribute="user">
                                <div class="box-body">
                                    <div class="form-group" hidden>
                                        <div class="col-sm-10">
                                            <form:input path="id"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required email" path="email"
                                                        placeholder="请输入邮箱"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">密码</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="password"
                                                        placeholder="请输入密码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="col-sm-2 control-label">用户名</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="username"
                                                        placeholder="请输入用户名"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-2 control-label">手机号</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required phone" path="phone"
                                                        placeholder="请输入手机号"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="box-footer">
                                    <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                    <button type="submit" class="btn btn-info pull-right">提交</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../common/copyRight.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>
<!-- jquery Validation表单校验插件js -->
<script src="<%=basePath%>static/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="<%=basePath%>static/plugins/jquery-validation/additional-methods.min.js"></script>
<script src="<%=basePath%>static/plugins/jquery-validation/messages_zh.js"></script>
<!-- 自定义验证规则js -->
<script src="<%=basePath%>static/js/form-validate.js"></script>
<script>
    $(function () {
        $("#userForm").validate();
    });
</script>
</body>
</html>
