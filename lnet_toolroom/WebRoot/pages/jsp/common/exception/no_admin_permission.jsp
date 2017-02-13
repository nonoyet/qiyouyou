<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误页面</title>
<link href="${Context }/pages/css/common/errorPage_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${Context }/plugins/jquery/jquery-1.9.1.min.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 


</head>


<body style="background:#edf6fa;">

    
    <div class="error">
    
    <h2>操作失败，只有管理员才能执行该操作！</h2>
    <p>如果对此仍有疑问？请联系管理员！</p>
    <!-- 
    <div class="reindex"><a href="index.jsp" target="_parent">返回首页</a></div>
     -->
    
    </div>


</body>

</html>
