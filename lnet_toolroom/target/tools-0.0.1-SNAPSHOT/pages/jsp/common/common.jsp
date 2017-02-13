<%@ page language="java" import="java.util.*,com.lnet.util.*,com.lnet.util.*,com.lnet.entities.*,com.egf.common.util.StringUtils" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String scheme = request.getScheme();
	String serverName = request.getServerName();
	int serverPort = request.getServerPort();
	String contextPath = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv="Pragma" content="no-cache">
		<META http-equiv="Cache-Control" content="no-cache">
		<META http-equiv="Cache-Control" content="no-store">
		<META http-equiv="Expires" content="0">
		<%--  公共css --%>
		<link rel="stylesheet" type="text/css" href="<%=contextPath %>/pages/css/common/common.css" >
		
		<%--  jquery --%>
		<script  type="text/javascript" charset="UTF-8" src="<%=contextPath %>/plugins/jquery/jquery-2.1.4.min.js"></script>
		
		<script type="text/javascript">
			var scheme = '<%=scheme%>';
			var serverName = '<%=serverName%>';
			var serverPort = '<%=serverPort%>';
			var contextPath = '<%=contextPath%>';
			var urlPrefix = scheme + '://' + serverName + ':' + serverPort + contextPath;
		</script>
	</head>
</html>