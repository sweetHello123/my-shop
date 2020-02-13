<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\8\28 0028
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <jsp:include page="../common/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../common/nav.jsp" />
    <jsp:include page="../common/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                主页
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
    </div>

    <jsp:include page="../common/copyRight.jsp" />

    <div class="control-sidebar-bg"></div>
</div>
</body>
</html>
