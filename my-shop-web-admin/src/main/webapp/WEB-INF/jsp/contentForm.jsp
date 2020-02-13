<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\9\22 0022
  Time: 15:58
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
    <title>内容表单</title>
    <!-- 树形结构插件css -->
    <link rel="stylesheet" href="<%=basePath%>static/plugins/zTree/css/zTreeStyle/zTreeStyle.css"/>

    <!-- 上传文件插件css -->
    <link rel="stylesheet" href="<%=basePath%>static/plugins/dropzone-4.2.0/dist/basic.css"/>
    <link rel="stylesheet" href="<%=basePath%>static/plugins/dropzone-4.2.0/dist/dropzone.css"

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
            <h1>内容管理</h1>
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
                            <h3 class="box-title" style="padding-bottom: 10px">${content.id==null?"新增":"编辑"}内容</h3>

                            <%--@elvariable id="content" type="com.china.myshop.domain.TbContent"--%>
                            <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post"
                                       modelAttribute="content">
                                <div class="box-body">
                                    <div class="form-group" hidden>
                                        <div class="col-sm-10">
                                            <form:input path="id"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">父级类目</label>
                                        <div class="col-sm-10">
                                            <form:hidden id="categoryId" path="contentCategory.id"
                                                         value="${content.contentCategory.id}"/>
                                            <input id="categoryName" class="form-control" placeholder="请选择"
                                                   readonly="true" data-toggle="modal" data-target="#modal-tree"
                                                   value="${content.contentCategory.name}" required/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">标题</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="title"
                                                        placeholder="请输入标题"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="subTitle" class="col-sm-2 control-label">子标题</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="subTitle"
                                                        placeholder="请输入子标题"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="description" class="col-sm-2 control-label">描述</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="description"
                                                        placeholder="请输入描述"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="url" class="col-sm-2 control-label">链接</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="url"
                                                        placeholder="请输入链接"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="picture" class="col-sm-2 control-label">图片</label>
                                        <div class="col-sm-10">
                                            <form:input cssClass="form-control required" path="picture"
                                                        placeholder="请输入图片"/>
                                            <!-- dropzone上传文本域 -->
                                            <div id="dropz" class="dropzone"></div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">详情</label>
                                        <div class="col-sm-10">
                                            <!-- 用于存放富文本编辑器里的内容的隐藏域 -->
                                            <form:hidden path="info"/>
                                            <div id="editor">${content.info}</div>
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

    <!-- 树形结构模态框 -->
    <div class="modal fade" id="modal-tree">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">树形结构</h4>
                </div>
                <div class="modal-body">
                    <p id="modal-message">
                    <ul id="myTree" class="ztree"></ul>
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                    <button id="btn-ok" type="button" class="btn btn-primary">确定</button>
                </div>
            </div>
        </div>
    </div>

    <div class="control-sidebar-bg"></div>
</div>
<!-- 树形结构插件js -->
<script src="<%=basePath%>static/plugins/zTree/js/jquery.ztree.core.min.js"></script>

<!-- 上传文件插件js -->
<script src="<%=basePath%>static/plugins/dropzone-4.2.0/dist/min/dropzone.min.js"></script>

<script src="<%=basePath%>static/js/dropzone-init.js"></script>

<script type="text/javascript" src="<%=basePath%>static/plugins/wangEditor/wangEditor.min.js"></script>
<script>
    $(function () {
        var setting = {
            //设置树形数据不能多选
            view: {
                selectedMulti: false
            },
            //异步加载
            async: {
                enable: true,
                url: "/contentCategory/treeData",
                type: "get",
                autoParam: ["id"]
            }
        };
        $.fn.zTree.init($("#myTree"), setting);

        $("#btn-ok").bind("click", function () {
            //获取树对象
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            //获取选中的节点
            var selectedNodes = zTree.getSelectedNodes();
            if (selectedNodes.length == 0) {
                alert("请选择一个节点");
            } else {
                var node = selectedNodes[0];
                $("#categoryId").val(node.id);
                $("#categoryName").val(node.name);
                $("#modal-tree").modal("hide");
            }
        });

        initWangEditor();

        // $("#contentForm").validate();
    });

    /**
     * 调用封装好的dropzone初始化函数
     */
    myDropzone.initDropzone({
        id: "#dropz",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#picture").val(data.fileName);
            });
            this.on("removedfile", function () {
                $("#picture").val("");
            });
        }
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor() {
        var E = window.wangEditor;
        var editor = new E('#editor');

        // 配置服务器端地址(上传对应的接口)
        editor.customConfig.uploadImgServer = '/upload';

        //定义上传文件名(接口方法中的文件参数)
        editor.customConfig.uploadFileName = 'wangEdFile';

        editor.create();

        $("#btn-submit").bind("click", function () {
            var contentHtml = editor.txt.html();
            $("#info").val(contentHtml);
        });
    }

</script>
</body>
</html>
