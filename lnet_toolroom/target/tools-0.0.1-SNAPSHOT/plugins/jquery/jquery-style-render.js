/*
 * Title:
 * Description:
 * Aucthor: rancococ
 * Email: rancococ@hotmail.com
 * Create Date:2010-06-08
 * Copyright 2010
 */ 
(function($){
	$(function(){
		$("input[type='text']").each(function(){
			$(this).css({ border: "1px solid #AEC2CD", height: "18px" });
		});
		$("textarea").each(function(){
			$(this).css({ border: "1px solid #AEC2CD", height: "46px" });
		});
	});
})(jQuery);