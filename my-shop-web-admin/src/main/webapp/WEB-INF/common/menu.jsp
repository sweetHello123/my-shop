<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\9 0009
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <title>菜单栏</title>
</head>
<body>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/img/admin.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${session_user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单栏</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-user"></i><span>用户管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active">
                        <a href="/user/list"><i class="fa fa-circle-o"></i>用户列表</a>
                        <a href="/user/form"><i class="fa fa-circle-o"></i>用户表单</a>
                    </li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i><span>类目管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li class="active">
                        <a href="/contentCategory/list"><i class="fa fa-circle-o"></i>类目展示</a>
                        <a href="/content/list"><i class="fa fa-circle-o"></i>内容列表</a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
</body>
</html>
