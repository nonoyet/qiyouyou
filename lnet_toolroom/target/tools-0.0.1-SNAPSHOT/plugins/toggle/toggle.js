//使用的路径为common.jsp的contextPath路径
//使用方法： 在将被隐藏和展开操作的外层加一个DIV；
//			再在该DIV中设置属性的title为横条显示的文字内容；
//			将要进行操作的DIV的ID传入外包DIV的tog_div属性；
//			在JS中初始化外包装DIV（调用toggle）:$('DIV_ID').toggle();
jQuery.fn.extend({
	
	mytoggle:function(width){
		var togID = this.attr("id");
		//缓存收缩栏的横幅内容
		var tog_head="<div id='"+togID+"_toggle_head' class='toggle_head'>"+
					 	"<span id="+togID+"_toggle_span>"+
					 		"<img id='"+togID+"_collapseIcon' alt='隐藏' "+
					 			"src='"+contextPath+"/plugins/toggle/images/panel_tool_collapse.gif'>"+
					 		"<img id='"+togID+"_expandIcon' alt='显示' "+
					 			"src='"+contextPath+"/plugins/toggle/images/panel_tool_expand.gif'>"+
					 	"</span>"+
					 	"<label id='"+togID+"_toggle_name'></label>"+
	    			 "</div>";
		//将收缩横条添加到CLASS为toggle的div里面
		//$('div[class=toggle]').prepend(tog_head);
		this.prepend(tog_head);
		//将展开按钮隐藏
		$('#'+togID+'_expandIcon').hide();
		//设置横条显示文字(即显示DIV的title属性的内容)
		//var name=$('div[class=toggle]').attr('title');
		var name = " "+this.attr('toggleTitle');
		$('#'+togID+'_toggle_name').text(name);
		//为SPAN增加单击事件
		$('#'+togID+'_toggle_span').click(function(){
			collepseAndExplan(togID);
		});
		if(width) {
			document.getElementById(togID+"_toggle_head").style.width=width+"px"; 
		}
	},
	
	//提供的隐藏被展开页面的方法
	collepseToggle:function(mainDivID){
		this.hide();
		var VID=$('#'+mainDivID+'_toggle_head img:visible').attr("id");
		var HID=$('#'+mainDivID+'_toggle_head img:hidden').attr("id");
		$('#'+VID).hide();
		$('#'+HID).show();
	},
	//提供的展开被收缩页面的方法
	explanToggle:function(mainDivID){
		this.show();
		var VID=$('#'+mainDivID+'_toggle_head img:visible').attr("id");
		var HID=$('#'+mainDivID+'_toggle_head img:hidden').attr("id");
		$('#'+VID).hide();
		$('#'+HID).show();
	},
	
	showMessage:function(){
		alert(this.attr("id")+":message!");
	}
});


//收缩和展开页面的函数
function collepseAndExplan(mainDivID){
	//	alert('mainDivID'+mainDivID);
	//取得显示图标的ID
	var VID=$('#'+mainDivID+'_toggle_head img:visible').attr("id");
	//取得隐藏图标的ID
	var HID=$('#'+mainDivID+'_toggle_head img:hidden').attr("id");	
	//将显示图标隐藏
	$('#'+VID).hide();
	//将隐藏图标显示
	$('#'+HID).show();
	//从包装DIV的tog_div得到收缩操作的div的ID进行操作
	var togdiv = $('#'+mainDivID).attr('tog_div');
	//若div为可见，则可见的div的ID:SVID将不为空
	var SVID=$('#'+togdiv+':visible').attr("id");
	//若div为隐藏，则隐藏的div的ID:HVID将不为空
	var SHID=$('#'+togdiv+':hidden').attr("id");
	//判断是否可见，若可见，则隐藏，否则显示
	if(SVID!=null){
		$('#'+SVID).hide();
	}else{
		$('#'+SHID).show(); 
	}
}