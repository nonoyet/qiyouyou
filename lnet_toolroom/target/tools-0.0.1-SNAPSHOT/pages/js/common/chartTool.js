//图表显示工具,基于echart3.0
// author : nonoyet
// 2016-10-24

/**
 * 显示柱状图
 * @param showId
 * 		需要显示的组件
 * @param title
 * 		标题
 * @param xArr
 * 		x轴标签
 * @param yJson
 * 		y轴数据(json数组)
 * @param barDescArr
 * 		每种柱形图数据描述
 */
function barChart(showId,title,xArr,yJson,barDescArr){
	var chart = echarts.init(document.getElementById(showId));
	
	var seriesArr = new Array();
	for(var i=0;i<yJson.length;i++){
		var tmp = {
	        name: barDescArr[i],
	        type: 'bar',
	        data: yJson[i],
	        label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
	        animationDelay: function (idx) {
	            return idx * 10;
	        }
	    };
		seriesArr.push(tmp);
	}
	
	option = {
	    title: {
	        text: title
	    },
	    legend: {
	        data: barDescArr,
	        align: 'left'
	    },
	    toolbox: {
	        // y: 'bottom',
	        feature: {
	            magicType: {
	                type: ['line','bar','stack', 'tiled']
	            },
	            dataView: {},
	            saveAsImage: {
	                pixelRatio: 2
	            }
	        }
	    },
	    tooltip: {},
	    xAxis: {
	        data: xArr,
	        silent: false,
	        splitLine: {
	            show: false
	        }
	    },
	    yAxis: {
	    	
	    },
	    series: seriesArr,
	    animationEasing: 'elasticOut',
	    animationDelayUpdate: function (idx) {
	        return idx * 5;
	    }
	};
	
	chart.setOption(option);
}
/**
 * 饼图
 * @param showId
 * 		需要显示的组件
 * @param title
 * 		标题
 * @param valArr
 * 		值数组
 * @param descArr
 * 		值描述
 * @param pieType
 * 		饼图类型(可选范围[0-3])
 * @return
 */
function pieChart(showId,title,valArr,descArr,pieType){
	var chart = echarts.init(document.getElementById(showId));
	
	var roseChart = "";
	var radiusArr = ['0%', '70%'];
	
	if(pieType == "0"){
		roseChart = "";
	}else if(pieType == "1"){
		roseChart = "angle";
	}else if(pieType == "2"){
		roseChart = "";
		radiusArr[0] = '20%';
	}else if(pieType == "3"){
		roseChart = "angle";
		radiusArr[0] = '20%';
	}
		
	
	var dataArr = new Array();
	for(var i=0;i<valArr.length;i++){
		var tmp = {value:valArr[i], name:descArr[i]}
		
		dataArr.push(tmp);
	}
	option = {
		    title : {
		        text: title,
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: descArr
		    },
		    series : [
		        {
		            name: '',
		            type: 'pie',
		            radius : radiusArr,
		            center: ['50%', '60%'],
		            data:dataArr,
		            roseType: roseChart,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	
	chart.setOption(option);
}
/**
 * 折线图
 * @param showId
 * 		需要显示的组件
 * @param title
 * 		标题
 * @param xArr
 * 		x轴标签数组
 * @param yJson
 * 		y轴数据(json数组)
 * @param lineDescArr
 * 		每条折线描述
 * @return
 */
function lineChart(showId,title,xArr,yJson,lineDescArr){
	var chart = echarts.init(document.getElementById(showId));
	
	var seriesArr = new Array();
	for(var i=0;i<yJson.length;i++){
		var tmp = {
	            name:lineDescArr[i],
	            type:'line',
	            areaStyle: {normal: {}},		//这个加上显示区域,不加显示线
	            label: {
	                normal: {
	                    show: true,
	                    position: 'top'
	                }
	            },
	            data:yJson[i]
	        };
		seriesArr.push(tmp);
	}
	
	option = {
		    title: {
		        text: title
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:lineDescArr
		    },
		    toolbox: {
		        feature: {
			    	magicType: {
		                type: ['line','bar','stack', 'tiled']
		            },
		            dataView: {},
		            saveAsImage: {}
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : xArr
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : seriesArr
		};
	chart.setOption(option);
}
/**
 * 显示地图
 * @param showId
 * 		需要显示的组件
 * @param whereMap
 * 		地图名称
 * @return
 */
function mapChart(showId,title,whereMap){
	var chart = echarts.init(document.getElementById(showId));
	chart.setOption({
		title: {
	        text: title
	    },
	    series: [{
	        type: 'map',
	        map: whereMap
	    }]
	});
}