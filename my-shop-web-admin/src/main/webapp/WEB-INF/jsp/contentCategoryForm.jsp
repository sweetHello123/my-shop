<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\10\4 0004
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>类目表单</title>
    <jsp:include page="../common/header.jsp"/>
    <script src="<%=basePath%>static/plugins/jquery-validation/jquery.validate.min.js"></script>
    <script src="<%=basePath%>static/plugins/jquery-validation/additional-methods.min.js"></script>
    <script src="<%=basePath%>static/plugins/jquery-validation/messages_zh.js"></script>
    <script src="<%=basePath%>static/js/form-validate.js"></script>
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
                    <c:if test="${result!=null}">
                        <div class="alert alert-${result.statusCode==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="icon fa fa-ban"></i>${result.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title" style="padding-bottom: 10px">
                                ${contentCategory.id==null?"新增":"编辑"}类目
                            </h3>

                            <%--@elvariable id="contentCategory" type="com.china.myshop.domain.TbContentCategory"--%>
                            <form:form id="inputForm" cssClass="form-horizontal" action="/contentCategory/save"
                                       method="post" modelAttribute="contentCategory">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">父级类目</label>
                                        <div class="col-sm-10">
                                            <form:hidden path="parentCategory.id"
                                                         value='<%=request.getParameter("parentCategory.id")%>'/>

                                            <form:input cssClass="form-control required" path="parentCategory.name"
                                                        value='<%=request.getParameter("parentCategory.name")%>'
                                                        placeholder="/" disabled="true"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">类目名称</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="name"
                                                        placeholder="请输入类目名称"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="sortOrder" class="col-sm-2 control-label">类目排序</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="sortOrder"
                                                        placeholder="请输入类目排序"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="box-footer">
                                    <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                    <button id="btn-submit" type="submit" class="btn btn-info pull-right">提交</button>
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
<script>

</script>
</body>
</html>
