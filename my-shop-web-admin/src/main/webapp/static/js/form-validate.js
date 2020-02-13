/**
 * 封装表单校验规则
 * @type {{init}}
 */
var Validate = function () {
    var handlerInitValidate = function () {
        //表单校验出错状态显示
        $("#inputForm").validate({
            errorElement: "span",
            errorClass: "help-block",

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    /**
     * 增加自定义验证规则
     */
    var handlerCustomvalidate = function () {
        $.validator.addMethod("phone", function (value, element) {
            var length = value.length;
            var phone = /^1[3456789]\d{9}$/;
            return this.optional(element) || (length == 11 && phone.test(value));
        }, "手机号码格式错误");
    };

    return {
        init: function () {
            handlerCustomvalidate();
            handlerInitValidate();
        }
    }
}();

$(function () {
    Validate.init();
});