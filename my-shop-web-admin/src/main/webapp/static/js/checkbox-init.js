/**
 * 封装checkbox
 * @type {{init}}
 */
var Checkbox = function () {
    /**
     * 私有属性
     */
    var check_main;

    var check_all;

    //定义一个存放id的数组
    var idArray;

    /**
     * 私有方法(初始化ICheck)
     */
    var handlerInitCheckbox = function () {
        //激活iCheck复选框样式
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        //获取控制端Checkbox
        check_main = $("input[type=checkbox].minimal.check_main");

        //获取全部Checkbox
        check_all = $("input[type=checkbox].minimal");

    };

    /**
     * Checkbox全选功能
     */
    var handlerCheckboxAll = function () {
        check_main.on("ifClicked", function (e) {
            console.log(e.target.checked);
            //判断主选框是否为选中状态
            if (e.target.checked) {
                check_all.iCheck("uncheck");
            } else {
                check_all.iCheck("check");
            }
        });

    };

    /**
     * 单个删除
     */
    var handlerDeleteSingle = function (id, url) {
        idArray = new Array();
        idArray.push(id);

        $("#modal-alert-message").html("是否确定删除数据项");
        $("#modal-default").modal("show");

        $("#btn-ok").bind("click", function () {
            handlerDeleteData(url);
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        idArray = new Array();

        //获取全部checkbox
        check_all.each(function () {
            var _id = $(this).attr("id");
            //将选中的元素id存入数组
            if (_id != null && _id != "undefined" && $(this).is(":checked")) {
                idArray.push(_id);
            }
        });

        //判断是否选择了数据项
        if (idArray.length == 0) {
            $("#modal-alert-message").html("你还没有选择任何数据,至少选择一项");
        } else {
            $("#modal-alert-message").html("是否确定删除已选项");
        }
        //弹出提示模态框
        $("#modal-default").modal("show");

        //给模态框的确认按钮绑定事件
        $("#btn-ok").bind("click", function () {
            //处理确认按钮
            handlerDeleteData(url);
        });
    };

    /**
     * 处理异步删除
     * @param url
     */
    function handlerDeleteData(url) {
        //点击确认后先关闭模态框
        $("#modal-default").modal("hide");
        //没有选择数据项则不做处理
        if (idArray.length == 0) {

        }
        //否则做删除操作
        else {
            //ajax提交删除请求
            $.ajax({
                "url": url,
                "type": "post",
                "data": {"ids": idArray.join(",")},//将js数组转为字符串
                "dataType": "json",
                "success": function (data) {
                    //请求完了后解绑确认按钮
                    $("#btn-ok").unbind();
                    //请求成功
                    if (data.statusCode = 200) {
                        //重新绑定确认按钮,点击事件为刷新页面
                        $("#btn-ok").bind("click", function () {
                            window.location.reload();
                        });
                    }
                    //请求失败
                    else {
                        //重新绑定确认按钮,点击事件为关闭模态框
                        $("#btn-ok").bind("click", function () {
                            $("#modal-default").modal("hide");
                        });
                    }
                    $("#btn-cancel").css("display", "none");

                    //展示模态框
                    $("#modal-alert-message").html(data.message);
                    $("#modal-default").modal("show");
                }
            });
        }
    }

    /**
     * 初始化DataTable
     */
    var handlerInitDataTable = function (url, columns) {
        var dataTable = $("#dataTable").DataTable({
            //去除可选条目数
            "lengthChange": false,
            //去除排序规则
            "ordering": false,
            "processing": true,
            //去除搜索框
            "searching": false,
            //服务端处理数据表
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            //dataTable数据列表
            "columns": columns,
            //国际化
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "无数据",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            //回调事件:dataTable表格重新绘制
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });
        return dataTable;
    };

    /**
     * 查看详情
     */
    var handlerView = function (url) {
        //ajax请求将html类型数据装载进模态框
        $.ajax({
            "url": url,
            "type": "get",
            // "dataType": "html",
            "success": function (data) {
                $("#modal-detail-message").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        deleteSingle: function (id, url) {
            handlerDeleteSingle(id, url);
        },

        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        initDataTable: function (url, columns) {
            return handlerInitDataTable(url, columns);
        },

        view: function (url) {
            handlerView(url);
        }
    }
}();

$(function () {
    Checkbox.init();
});

