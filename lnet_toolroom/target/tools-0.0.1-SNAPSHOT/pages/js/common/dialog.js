/**
 * 打开对话框
 * 
 * @param dialogTitle
 * @param dialogWidth
 * @param dialogHeight
 * @param dialogUrl
 * @param dialogParamIn
 * @param dialogCallback
 * @return
 */
var openDialog = function(dialogTitle, dialogWidth, dialogHeight, dialogUrl, dialogParamIn, dialogCallback) {
	var dialogOptions = {
        autoOpen : false,
        closeOnEscape : false,
        width : dialogWidth,
        height : dialogHeight,
        modal : true,
        bgiframe : true,
        title : dialogTitle,
        zIndex : 9999,
        overlay : {
            opacity : 100
        },
        open : function() {
        },
        close : function(event, ui) {
            clearDialog();
        },
        buttons : {}
    };
    var dialogContent = "";
    dialogContent += "<iframe ";
    dialogContent += "id='_ifContent' ";
    dialogContent += "src='" + dialogUrl + "' ";
    dialogContent += "width='100%' ";
    dialogContent += "height='100%' ";
    dialogContent += "align='top' ";
    dialogContent += "marginwidth='0' ";
    dialogContent += "marginheight='0' ";
    dialogContent += "scrolling='auto' ";
    dialogContent += "frameborder='0' ";
    //去掉背景透明
    //dialogContent += "style='filter:chroma(color=#ffffff)' ";
    dialogContent += "></iframe> ";

    var index = 0;
    while (true) {
        // 不存在div时创建
        if (window.top.$('#dialogDiv' + index).length == 0) {
            $(window.top.document.body).append("<div id='dialogDiv" + index + "'></div>");
            break;
        } else {
            // 已被创建，但被清空的直接使用
            if (window.top.$('#dialogDiv' + index).html() == "") {
                break;
            }
        }
        index++;
    }
    ;

    
    var dialogDiv = window.top.$('#dialogDiv' + index);
    dialogDiv.data('paramIn', dialogParamIn);
    dialogDiv.data('paramOut', null);
    dialogDiv.data('callback', dialogCallback);
    dialogDiv.dialog(dialogOptions);
    dialogDiv.html(dialogContent);
    dialogDiv.dialog("open");
};

/**
 * 关闭对话框
 * 
 * @return
 */
var closeDialog = function() {
    getDialogDiv().dialog("close");
};

/**
 * 清空对话框
 * 
 * @return
 */
var clearDialog = function() {
    var dialogDiv = getDialogDiv();
    dialogDiv.empty();
    dialogDiv.data('paramIn', null);
    dialogDiv.data('paramOut', null);
    dialogDiv.data('callback', null);
};

/**
 * 取得对话框传入参数
 * 
 * @return
 */
var getDialogParamIn = function() {
    return getDialogDiv().data('paramIn');
};

/**
 * 设置对话框传入参数
 * 
 * @param dialogParamIn
 * @return
 */
var setDialogParamIn = function(dialogParamIn) {
    getDialogDiv().data('paramIn', dialogParamIn);
};

/**
 * 取得对话框返回结果
 * 
 * @return
 */
var getDialogParamOut = function() {
    return getDialogDiv().data('paramOut');
};

/**
 * 设置对话框返回结果
 * 
 * @param dialogParamOut
 * @return
 */
var setDialogParamOut = function(dialogParamOut) {
    getDialogDiv().data('paramOut', dialogParamOut);
};

/**
 * 执行传入的回调函数
 * 
 * @param cbParam
 * @return
 */
var doDialogCallback = function(cbParam) {
	
    var callback = getDialogDiv().data('callback');
    if (callback) {
        if (cbParam) {
            callback(cbParam);
        } else {
            callback();
        }
    }
    closeDialog();
};

/**
 * 取得DialogIndex
 * 
 * @return
 */
var getDialogDiv = function() {
    var index = 0;
    while (true) {
        if (window.top.$('#dialogDiv' + (index + 1)).html() == null
                || window.top.$('#dialogDiv' + (index + 1)).html() == "") {
            break;
        }
        index++;
    }
    return window.top.$('#dialogDiv' + index);
};
