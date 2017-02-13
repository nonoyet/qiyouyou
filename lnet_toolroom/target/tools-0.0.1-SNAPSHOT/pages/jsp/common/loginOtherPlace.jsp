<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误页面</title>
<link href="${Context }/pages/css/errorPage_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${Context }/pages/js/jquery.js"></script>

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
	    <h2>你账号已经在其他地方登录，被迫下线</h2>
    	<p>可以尝试关闭浏览器重新登录或者联系管理员来解决出现的问题！</p>
    </div>
</body>

</html>
