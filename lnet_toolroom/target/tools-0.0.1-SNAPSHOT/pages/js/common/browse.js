//判断浏览器版本js
// author : nonoyet
// 2016-11-25
/**
 * 浏览器类型
 * @return
 * 浏览器型号如IE,Firfox,Android,Iphone,Ipad
 */
function browseType(){
	var browser = getBrowser();
	if(browser.versions.mobile){
		if(browser.versions.android){
			return "Android";
		}else if(browser.versions.iPhone){
			return "Ipnone";
		}else if(browser.versions.iPad){
			return "Ipad";
		}
	}else{
		var explorer =navigator.userAgent,browse;  
	    if (explorer.indexOf("MSIE") >= 0){  
	        //ie   
	        browse = "ie";  
	    }else if (explorer.indexOf("Firefox") >= 0) {  
	        // firefox 火狐  
	        browse = "Firefox";  
	    }else if(explorer.indexOf("Chrome") >= 0){  
	        //Chrome 谷歌  
	        browse = "Chrome";  
	    }else if(explorer.indexOf("Opera") >= 0){  
	        //Opera 欧朋  
	        browse = "Opera";  
	    }else if(explorer.indexOf("Safari") >= 0){  
	        //Safari 苹果浏览器  
	        browse = "Safari";  
	    }else if(explorer.indexOf("Netscape")>= 0) {   
	        //Netscape  
	        browse = "Netscape";   
	    }  
	    return browse;
	}
}
/**
 * 设备类型
 * @return
 * phone or pc
 */
function deviceType(){
	var browser = getBrowser();
	if(browser.versions.mobile){
		return "phone";
	}else{
		return "pc";
	}
}

function getBrowser(){
	return browser = {  
		    versions:function(){   
	    var u = navigator.userAgent, app = navigator.appVersion;   
	    return {//移动终端浏览器版本信息   
	        trident: u.indexOf("Trident") > -1, //IE内核  
	        presto: u.indexOf("Presto") > -1, //opera内核  
	        webKit: u.indexOf("AppleWebKit") > -1, //苹果、谷歌内核  
	        gecko: u.indexOf("Gecko") > -1 && u.indexOf("KHTML") == -1, //火狐内核  
	        mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端  
	        ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端  
	        android: u.indexOf("Android") > -1 || u.indexOf("Linux") > -1, //android终端或者uc浏览器  
	        iPhone: u.indexOf("iPhone") > -1 , //是否为iPhone或者QQHD浏览器  
	        iPad: u.indexOf("iPad") > -1, //是否iPad  
	        webApp: u.indexOf("Safari") == -1 //是否web应用程序，没有头部与底部  
	        };  
	    }(),  
	    language:(navigator.browserLanguage || navigator.language).toLowerCase()  
	} 
}