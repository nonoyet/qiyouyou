<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%--添加 标签和公共 jsp --%>
<%@ include file="/pages/jsp/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>奇优优工具屋</title>
    <%-- 引用css和js --%>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="<%=contextPath%>/pages/css/common/common.css" />
	<script type="text/javascript" charset="UTF-8"  src="<%=contextPath%>/pages/js/common/common.js"></script>
	
    <script type="text/javascript" charset="UTF-8"  >
    	$(function(){
    		$.ajax({  //获取字典：民族
				type:'post',  
	      		url:'${Context}/main!querylist',  
	      		data:{},  
	     		cache:false,  
	     		dataType:'json',
	      		success:function(data){  
	      			//alert(JSON.stringify(data));
	      			$('#content').html(data.list+"");
	      		},  
	      		error:function(){}  
	 		});
    	
    	});
    </script>
    
  </head>
  <body  >
		<div id="content" style="width: 100%;height:400px;"></div>
  </body>    
    
</html>
    