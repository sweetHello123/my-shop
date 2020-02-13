<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\9 0009
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户详情</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table" style="width: 500px">
        <tbody>
        <tr>
            <td width="200px">用户名:</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td width="200px">邮箱:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td width="200px">手机号:</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <td width="200px">创建时间:</td>
            <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td width="200px">更新时间:</td>
            <td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
