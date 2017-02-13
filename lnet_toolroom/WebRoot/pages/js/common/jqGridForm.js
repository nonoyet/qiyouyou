// 常用的公共方法
// author : nonoyet
// 2015-08-05
/**
 * jqgrid隐藏或显示列
 * @param isHide
 * 		为true时隐藏列,为false时显示列
 * @param colArr
 * 		操作数组
 * @return
 */
function hideOrShowCol(isHide,colArr){
	if(isHide){
		for(i=0;i<colArr.length;i++){
			jQuery("#gt").setGridParam().hideCol(colArr[i]).setGridWidth(windowWidth());
		}
	}else{
		for(i=0;i<colArr.length;i++){
			jQuery("#gt").setGridParam().showCol(colArr[i]).setGridWidth(windowWidth());
		}
	}
}

//浏览器视口的高度
function windowHeight() {
    var de = document.documentElement;

    return self.innerHeight || (de && de.clientHeight) || document.body.clientHeight;
}
//浏览器视口的宽度
function windowWidth() {
    var de = document.documentElement;
    var w_p = self.innerWidth || (de && de.clientWidth) || document.body.clientWidth;
    return w_p;
    
}
/* 浏览器垂直滚动位置 */
function scrollY() {
    var de = document.documentElement;

    return self.pageYOffset || (de && de.scrollTop) || document.body.scrollTop;
}

//子页面返回时执行刷新
function comeBack() {
   exit_confirm = false;
   var iframeObject = document.getElementById("insertEditFrame");
   iframeObject.style.display = "none";
   iframeObject.src = "";
   
   $("#gt").trigger("reloadGrid");
}
/**
 * 传递id,第一个显示和第二个隐藏
 * 多个#隔开
 * @param arrays
 * @return
 */
function showHidden(arrays,arr2){
   var strs = new Array(); 
   strs = arrays.split("#"); 
   for(var i=0;i<strs.length;i++ ){ 
	  if(document.getElementById(strs[i])){
	     document.getElementById(strs[i]).style.display = "inline";
	  }
   } 
   
   strs = arr2.split("#"); 
   for(var i=0;i<strs.length;i++ ){ 
	  if(document.getElementById(strs[i])){
	     document.getElementById(strs[i]).style.display = "none";
	  }
   } 
   
}

/** 列表展示内容 **/
function listDivHeight() {

    var total = windowHeight();//屏幕高度
    var location = document.getElementById("location").offsetHeight;//所处位置
    var showConds = document.getElementById("showConds").offsetHeight;//已选条件
    var divBottom = document.getElementById("pager2").offsetHeight;//列表控件
    var colHeight = total-location-showConds-divBottom-80-235;
    document.getElementById("dataList").style.height = colHeight+"px";//屏幕宽度
    return colHeight;

}
//查询表单清空数据   queryform表单名称
function searchForm(queryform){
	
	var obj = null;
	for (var i = 0; i <= queryform.elements.length - 1; i++) {
	    obj = queryform.elements[i];
	    if (obj.tagName == "INPUT") {//输入框 obj.type == "text"
	        obj.setAttribute("value", "");
	    }
	    if (obj.tagName == "INPUT" && obj.type == "checkbox") {//复选框
	        obj.setAttribute("checked", false);
	    }
	    
	    if (obj.tagName == "SELECT") {//下拉列表
	        obj.options[0].selected = true;
	    }
	    if (obj.tagName == "INPUT" && obj.type == "radio") {//单选按钮
	        obj.setAttribute("checked", false);
	    }
	}
}

/*****************************新增加公用模块******************************/
//展示查询条件弹出框
function showQueryDialog(){
	BootstrapDialog.show({
        title: '查询条件',
		draggable: true,
		autodestroy:true,	//在dialog关闭的时候，将里面的内容从界面上移除
		message:$('#queryFormField'),
		buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
				
				searchByForm();
            }
        }, {
            label: '重置',
            action: function(dialog) {
                $("#queryform")[0].reset();	
                $("#managerorgid").val("");
        		//dialog.close();
            }
        }],
        onhidden:function(dialog){
        	$('#hiddlenField').append($('#queryFormField'));		//将移除的内容存放在隐藏块中
        }
    });
}

//展示自定义字段弹出框
function showCustomDialog(){
	BootstrapDialog.show({
        title: '自定义显示字段',
		draggable: true,
		autodestroy:true,	//在dialog关闭的时候，将里面的内容从界面上移除
		message:$('#customField'),
		buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
				hideField();
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }],
        onhidden:function(dialog){
        	$('#hiddlenField').append($('#customField'));		//将移除的内容存放在隐藏块中
        }
    });
}


function hideOrShowCol1(isHide,colArr){
	if(isHide){
		for(i=0;i<colArr.length;i++){
			jQuery("#gt").setGridParam().hideCol(colArr[i]).setGridWidth($('#gtContainer').width());
		}
	}else{
		for(i=0;i<colArr.length;i++){
			jQuery("#gt").setGridParam().showCol(colArr[i]).setGridWidth($('#gtContainer').width());
		}
	}
}

//根据查询条件搜索
function searchByForm(){
	jQuery("#gt").jqGrid('setGridParam', {
		 url : queryPath,
		 page: 1,
		 postData: $('#queryform').serializeJson()
	}).trigger("reloadGrid");
}
//隐藏列
function hideField(){
	//获取未选中字段数组
	var hideArr = $("#customField").find("input[name='cb']").not("input:checked").map(function(){
       	return this.value;
    }).get();
	//获取选中字段数组		 		
	var showArr = $("#customField").find("input[name='cb']:checked").map(function(){
       	return this.value;
    }).get();
    
    hideOrShowCol1(true,hideArr);
    hideOrShowCol1(false,showArr);
}
//刷新列表
function refreshGrid(){
	jQuery("#gt").trigger("reloadGrid");
}

