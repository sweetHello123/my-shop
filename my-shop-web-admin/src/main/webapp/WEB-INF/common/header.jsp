<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\9 0009
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/bootstrap/dist/css/bootstrap.min.css">

    <!-- 字体css -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/font-awesome/css/font-awesome.min.css">

    <!-- 图标css -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/Ionicons/css/ionicons.min.css">

    <!-- 主题样式 -->
    <link rel="stylesheet" href="<%=basePath%>static/dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="<%=basePath%>static/dist/css/skins/_all-skins.min.css">

    <!-- Morris chart -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/morris.js/morris.css">

    <link rel="stylesheet" href="<%=basePath%>static/bower_components/jvectormap/jquery-jvectormap.css">

    <!-- Date Picker -->
    <link rel="stylesheet"
          href="<%=basePath%>static/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

    <!-- Daterange picker -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/bootstrap-daterangepicker/daterangepicker.css">

    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="<%=basePath%>static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <!-- iCheck复选单选美化插件css -->
    <link rel="stylesheet" href="<%=basePath%>static/plugins/iCheck/all.css">

    <!-- 树表格插件css -->
    <link rel="stylesheet" href="<%=basePath%>static/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <!-- jQuery 3 -->
    <script src="<%=basePath%>static/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- jQuery UI 1.11.4 -->
    <script src="<%=basePath%>static/bower_components/jquery-ui/jquery-ui.min.js"></script>

    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.7 -->
    <script src="<%=basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Morris.js charts -->
    <script src="<%=basePath%>static/bower_components/raphael/raphael.min.js"></script>
    <script src="<%=basePath%>static/bower_components/morris.js/morris.min.js"></script>

    <!-- Sparkline -->
    <script src="<%=basePath%>static/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>

    <!-- jvectormap -->
    <script src="<%=basePath%>static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="<%=basePath%>static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

    <!-- jQuery Knob Chart -->
    <script src="<%=basePath%>static/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>

    <!-- daterangepicker -->
    <script src="<%=basePath%>static/bower_components/moment/min/moment.min.js"></script>
    <script src="<%=basePath%>static/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- datepicker -->
    <script src="<%=basePath%>static/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

    <!-- Bootstrap WYSIHTML5 -->
    <script src="<%=basePath%>static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

    <!-- Slimscroll -->
    <script src="<%=basePath%>static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>

    <!-- FastClick -->
    <script src="<%=basePath%>static/bower_components/fastclick/lib/fastclick.js"></script>

    <!-- AdminLTE App -->
    <script src="<%=basePath%>static/dist/js/adminlte.min.js"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <%--<script src="<%=basePath%>/static/dist/js/pages/dashboard.js"></script>--%>

    <!-- AdminLTE for demo purposes -->
    <%--<script src="<%=basePath%>/static/dist/js/demo.js"></script>--%>

    <!-- iCheck 1.0.1 -->
    <script src="<%=basePath%>static/plugins/iCheck/icheck.min.js"></script>

    <!-- DataTables -->
    <script src="<%=basePath%>static/bower_components/datatables.net/js/jquery.dataTables.js"></script>
    <script src="<%=basePath%>static/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
</body>
</html>
