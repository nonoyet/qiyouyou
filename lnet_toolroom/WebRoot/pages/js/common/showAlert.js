//美化弹出消息,基于bootstrapdialg
// author : nonoyet
// 2015-08-15
function showMsg(msg){
	BootstrapDialog.show({
        title: '消息提示',
		draggable: true,
		autodestroy:true,	//在dialog关闭的时候，将里面的内容从dialog中移除
		message:msg,
		buttons: [
			{
	            label: '关闭',
	            action: function(dialog) {
	                dialog.close();
	            }
	        }
		]
    });
}

function showMsgWithCallBack(msg,sucessCallBack){
	BootstrapDialog.show({
        title: '消息提示',
		draggable: true,
		autodestroy:true,	//在dialog关闭的时候，将里面的内容从dialog中移除
		message:msg,
		buttons: [
			{
	            label: '确定',
	            action: function(dialog) {
					sucessCallBack();
	                dialog.close();
	            }
	        }
        ]
    });
}
//操作成功后提示弹出框，自动关闭
function showSuccessMsg(msg,sucessCallBack){
	BootstrapDialog.show({
        title: '消息提示',
		draggable: true,
		autodestroy:true,	//在dialog关闭的时候，将里面的内容从dialog中移除
		message:msg,
		onshown: function(dialog){
			setTimeout(function(){
				sucessCallBack();
				dialog.close();
			},1000);
			
    	}
    });
}