function sfJs(cellvalue, options, rowObject){
	if("undefined" == typeof(cellvalue)){
		return "&nbsp;";
	}
	if("0" == cellvalue){
		return "否";
	}
	if("1" == cellvalue){
		return "是"
	}
	return "&nbsp;";
}