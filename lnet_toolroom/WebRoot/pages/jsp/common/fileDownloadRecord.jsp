<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%--添加 标签和公共 jsp --%>
<%@ include file="/pages/jsp/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>文件下载记录</title>
	    <%-- 使ie9以下浏览器支持bootstrap --%>
		<!--[if lt IE 9]>
		<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/respond.min.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/html5shiv.js"></script>
		<![endif]-->

		<%-- bootstrap插件 --%>
		<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap/css/font-awesome.min.css" />
		<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/bootstrap.min.js"></script>
	
    	<script type="text/javascript" charset="UTF-8"  >
    		
    	</script>
  	</head>
  	<body  >
		<table class="table table-bordered table-hover">
			<tbody>
				<tr>
					<th style="width:15%;">
						序号
					</th>
					<th style="width:25%;">
						时间
					</th>
					<th style="width:15%;">
						下载人
					</th>
					<th style="width:25%;">
						部门
					</th>
					<th style="width:20%;">
						ip地址
					</th>
				</tr>
				<s:iterator status="entity" id="object" value="fjXzjlbList">
					<tr>
					<td style="width:15%;">
						#<s:property value="#entity.count " />
					</td>
					<td style="width:25%;">
						<s:property value="xtCzsj " />
					</td>
					<td style="width:15%;">
						<s:property value="xtCzrxm " />
					</td>
					<td style="width:25%;">
						<s:property value="xtCzrbm " />
					</td>
					<td style="width:20%;">
						<s:property value="xtCzIp " />
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	
  	</body>    
    
</html>
    