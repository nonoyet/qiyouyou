<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%--添加 标签和公共 jsp --%>
<%@ include file="/pages/jsp/common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>echarts demo演示页面</title>
	
	<%-- echarts图表插件 --%>
	<script type="text/javascript" src="${Context }/plugins/echarts-3.0/echarts.js"></script>
	<script type="text/javascript" src="${Context }/pages/js/common/chartTool.js"></script>
	<!-- 地图需要额外的js支持 -->
	<script type="text/javascript" src="${Context }/plugins/echarts-3.0/map/henan.js"></script>
	<script type="text/javascript" src="${Context }/plugins/echarts-3.0/map/china.js"></script>
	
	</head>
	<body  >
		<div id="main1" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main2" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main3" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main4" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main5" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main6" style="width: 1000px;height:500px;margin-top: 50px"></div>
		<div id="main7" style="width: 1000px;height:500px;margin-top: 50px"></div>
  	</body>    
	<script type="text/javascript">
	
		<%-- 柱形图 --%>
		var a = ['数据1','数据2','数据3'];
		var b = [[7,9,4],[2,8,12]];
		var c = ['收入','支出'];
		barChart('main1','柱形图演示demo',a,b,c);	
		
		
		
		<%-- 折线图--%>
		var a = ['星期一','星期二','星期三'];
		var b = [[7,9,4],[2,8,12]];
		var c = ['收入','支出'];
		lineChart('main2','折线图演示demo',a,b,c);	
		
		
		
		<%-- 饼图--%>
		var a = [32,55,23,47,75];
		var b = ['文件','演讲','通告','便签','要闻'];
		pieChart('main3','饼图演示demo',a,b,0)
		pieChart('main4','饼图演示demo',a,b,1)
		pieChart('main5','饼图演示demo',a,b,2)
		pieChart('main6','饼图演示demo',a,b,3)
		
		
		
		<%-- 地图--%>
		mapChart('main7','河南省地图演示demo','河南');	
	</script>    
</html>
    