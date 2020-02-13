/**
 * 封装dropzone对文件上传的函数
 * @type {{init}}
 */
var myDropzone = function () {

    var defaultDropzoneOpts = {
        url: "", //必须填写
        paramName: "dzFile",//默认为file
        dictDefaultMessage: "点击上传或拖动文件至此",
        maxFiles: 1,//一次性上传的文件数量上限
        maxFilesize: 2, //MB
        addRemoveLinks: true,//增加移除文件的链接,默认为false
        dictRemoveFile: '移除文件',
        dictCancelUpload: '取消',
        dictCancelUploadConfirmation: "取消上传该文件?",
        acceptedFiles: ".jpg,.jpeg,.doc,.docx,.ppt,.pptx,.txt,.avi,.pdf,.mp3,.zip", //上传的类型
        parallelUploads: 3,
        dictMaxFilesExceeded: "您最多只能上传" + this.maxFiles + "个文件！",
        dictInvalidFileType: "你不能上传该类型文件",
        dictFallbackMessage: "浏览器不受支持",
        dictResponseError: "文件上传失败!",
        dictFileTooBig: "文件过大,上传失败!"
    }

    /**
     * 初始化dropzone
     */
    var handlerInitDropzone = function (opts) {
        //关闭dropzone自动发现
        Dropzone.autoDiscover = false;
        //继承传入的参数项
        $.extend(defaultDropzoneOpts, opts);
        console.log(defaultDropzoneOpts.paramName);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    }

    return {
        initDropzone: function (opts) {
            handlerInitDropzone(opts);
        }
    }
}();
