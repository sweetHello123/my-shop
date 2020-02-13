<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\8\28 0028
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //获取虚拟目录名
    String path = request.getContextPath();
    //获取项目URI
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录页面</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="<%=basePath%>static/plugins/iCheck/square/blue.css">

    <!-- jQuery 3 -->
    <script src="<%=basePath%>static/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="<%=basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="<%=basePath%>static/plugins/iCheck/icheck.min.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>我的商城</b></a>
    </div>

    <!-- login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">欢迎管理员登录</p>
        <span id="message" style="color: red">${msg}</span><br>
        <form action="<%=basePath%>login" method="post">
            <div class="input-group form-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                <input id="email" type="email" class="form-control" name="email" placeholder="邮箱" value="${user.email}">
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input id="password" type="password" class="form-control fa-eye-slash" name="password" placeholder="密码"
                       value="${user.password}">
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="checkbox icheck">
                        <label>
                            <input id="psw_checkbox" type="checkbox">显示密码
                        </label>
                    </div>
                </div>
                <div class="col-md-4" style="padding-left: 50px;">
                    <button type="reset" class="btn btn-default btn-block btn-flat" style="width: 80px"
                            onclick="reset()">重置
                    </button>
                </div>
                <div class="col-md-4" style="padding-left: 21px">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" style="width: 80px"
                            onclick="return check()">登录
                    </button>
                </div>
            </div>
        </form>
        <a href="#">忘记密码</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" class="text-center">注册</a>
    </div>
</div>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
        });

        var $password = $("#password");
        var password = $password[0];

        var $pswCheckbox = $("#psw_checkbox");
        //点击获取的是操作之前复选框的状态
        $pswCheckbox.on("ifClicked", function (e) {
            //点击前是未勾选状态，点击完变为已勾选
            if (e.target.checked) {
                password.type = "password";
            }
            //勾选后
            else {
                password.type = "text";
            }
        });
    });

    function check() {
        var email = $("#email").val();
        var password = $("#password").val();
        if (email.length == 0 || password.length == 0) {
            $("#message").text("用户名与密码不能为空");
            return false;
        }
        return true;
    }

    function reset() {
        $("#email").val("");
        $("#password").val("");
    }

</script>
</body>
</html>
