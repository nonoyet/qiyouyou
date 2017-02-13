<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%--添加 标签和公共 jsp --%>
<%@ include file="/pages/jsp/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>奇优优工具平台</title>
    <%-- 引用css和js --%>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/pages/css/pt/firstpage/style.css"/>
	<script type="text/javascript" src="<%=contextPath%>/plugins/jquery/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/pages/js/pt/firstpage/jquery.sticky.js"></script>
	
	<script type="text/javascript" src="<%=contextPath%>/pages/js/common/browse.js"></script>
	
	<%-- 使ie9以下浏览器支持bootstrap --%>
	<!--[if lt IE 9]>
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/respond.min.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/html5shiv.js"></script>
	<![endif]-->

	<%-- bootstrap插件 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap/css/font-awesome.min.css" />
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap/js/bootstrap.min.js"></script>
	<%-- bootstrap下拉选插件 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap-select/dist/css/bootstrap-select.css">
	<script src="<%=contextPath%>/plugins/bootstrap-select/dist/js/bootstrap-select.js"></script>
	<script src="<%=contextPath%>/plugins/bootstrap-select/js/i18n/defaults-zh_CN.js"></script>
	
	<%-- bootstrap树形选择插件 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap-treeview/dist/bootstrap-treeview.min.css">
	<script src="<%=contextPath%>/plugins/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>
	
	<%-- bootstrap表单验证插件 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrapValidator/dist/css/bootstrapValidator.min.css">
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrapValidator/dist/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrapValidator/dist/js/language/zh_CN.js"></script>
	
	<%-- bootstrap弹出框 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap-dialog/dist/css/bootstrap-dialog.min.css" />
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap-dialog/dist/js/bootstrap-dialog.min.js"></script>
	
	<%-- bootstrap时间选择插件--%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/bootstrap-datetimepicker/dist/css/bootstrap-datetimepicker.css" />
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap-datetimepicker/dist/js/moment-with-locales.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/plugins/bootstrap-datetimepicker/dist/js/bootstrap-datetimepicker.js"></script>
	
	<%-- bootstrap风格分页插件 --%>
	<link rel="stylesheet" href="<%=contextPath%>/plugins/jBootstrapPage/jBootsrapPage.css" />
	<script type="text/javascript" src="<%=contextPath%>/plugins/jBootstrapPage/jBootstrapPage.js"></script>
	
	<%-- 美化常用的alert弹出 --%>
	<script type="text/javascript" charset="UTF-8"  src="<%=contextPath%>/pages/js/common/showAlert.js"></script>
	
	<script type="text/javascript" src="<%=contextPath%>/pages/js/common/canvas-nest.min.js"></script>
	
	<script>
    	$(window).load(function(){
      		$("#menu").sticky({ topSpacing: 0 });
    	});
  	</script>
  	</head>
  	<body>
		<div class="container-fluid banner text-center" id="banner"> 
    		<div class="row">
    			<div class="col-md-12 line">
        			<div class="tablebox">
        				<div class="banner-text" id="bannertext">
            				<h1 class="hostyle" id="heads">welcome</h1>
            				<p class="pstyle">奇优优工具平台</p>
            				<a href="#features" class="page-scroll arrow"><i class="fa fa-angle-down"></i></a> 
          				</div>
      				</div>
      			</div>
  			</div>
  		</div>
		<div class="navbar menubar" id="menu">
    		<div class="container">
    			<div class="navbar-header"> 
    				<button type="button" class="navbar-toggle menu-button" data-toggle="collapse" data-target="#myNavbar">
						<span class="glyphicon glyphicon-align-justify"></span>
		 			</button>
    				<a class="navbar-brand logo" href="#">奇优优(QiYouYou.com)</a> 
    			</div>
    			<div>
    				<nav class="collapse navbar-collapse" id="myNavbar" role="navigation">
        				<ul class="nav navbar-nav navbar-right navstyle">
        					<li><a href="#banner" class="page-scroll active">首页</a></li>
        					<li><a href="#features" class="page-scroll">目标</a></li>
        					<li><a href="#gallery" class="page-scroll">工具</a></li>
        					<li><a href="#about" class="page-scroll">关于</a></li>
        					<li><a href="#testimonials" class="page-scroll">反馈</a></li>
        					<li><a href="#contact" class="page-scroll">联系作者</a></li>
      					</ul>
      				</nav>
      			</div>
  			</div>
  		</div>
		<div class="features" id="features">
    		<div class="container">
    			<div class="row">
        			<div class="col-md-12 col-sm-12 col-xs-12">
        				<div class="alldesc">
            				<div class="col-md-6 col-sm-6 col-xs-12 centertext">
            					<p class="all-td">我们有一个目标，成为最好的</p>
            					<h2>工具平台</h2>
          					</div>
            				<div class="col-md-6 col-sm-6 col-xs-12">
            					<p class="desc">一款在线工具平台，减少测试和开发时间，提高项目开发效率。优秀的产品决定于细节,我们就要给你这样高逼格的范儿.</p>
          					</div>
          				</div>
      				</div>
        			<div class="col-md-6 col-sm-6 col-xs-12 featurebox">
        				<div class="feature-icons"> <img src="${Context }/pages/images/pt/firstpage/idea.png"/></div>
        				<div class="fh-desc">
            				<h3>思维碰撞</h3>
            				<p>一个人的思维是有限的，大家的智慧是无限的。不经意间的一语，指尖跳过的数个字符也许就打开了一扇通往新世界的大门。</p>
          				</div>
      				</div>
        			<div class="col-md-6 col-sm-6 col-xs-12 featurebox">
        				<div class="feature-icons"> <img src="${Context }/pages/images/pt/firstpage/time.png"/> </div>
        				<div class="fh-desc">
            				<h3>高效办公</h3>
            				<p>有时缺的不是能力，而是缺少一种高效的工具,时间是宝贵的，集无数人的宝贵思想凝结而成的工具助力起飞。梦想再也不是在路上</p>
          				</div>
      				</div>
        			<div class="col-md-6 col-sm-6 col-xs-12 featurebox">
        				<div class="feature-icons"> <img src="${Context }/pages/images/pt/firstpage/money.png"/> </div>
        				<div class="fh-desc">
            				<h3>应用免费</h3>
            				<p>纯技术，纯兴趣，爱创新，爱分享。</p>
          				</div>
      				</div>
       				<div class="col-md-6 col-sm-6 col-xs-12 featurebox">
       					<div class="feature-icons"> <img src="${Context }/pages/images/pt/firstpage/support.png"/> </div>
       					<div class="fh-desc">
           					<h3>技术支持</h3>
           					<p>java web,android,oracle,mysql,linux技术支持</p>
       					</div>
   					</div>
      			</div>
  			</div>
  		</div>
		<div class="gallery" id="gallery">
    		<div class="container">
    			<div class="row">
        			<div class="col-md-12 col-sm-12 col-xs-12">
        				<div class="alldesc">
            				<div class="col-md-6 col-sm-6 col-xs-12 centertext">
            					<p class="all-td">这里总有你需要的</p>
            					<h2>工具屋</h2>
          					</div>
            				<div class="col-md-6 col-sm-6 col-xs-12">
            					<p class="desc">最新、最全、最常用的web和移动端工具</p>
          					</div>
          				</div>
      				</div>
        			<div class="col-md-12 col-sm-12 col-xs-12">
        				<div class="sorting pull-left">
            				<div class="filter pull-left filimg" data-filter=".category-1">常用</div>
            				<div class="filter pull-left filimg" data-filter=".category-3">最新</div>
            				<div class="filter pull-left filimg" data-filter="all">所有</div>
          				</div>
      				</div>
       				<div class="col-md-12 col-sm-12 col-xs-12">
        				<div class="galleryimg" id="galleryimg">
            				<div class="grid mix category-1 category-2 category-3 col-md-4 col-sm-6 col-xs-6" data-myorder="1">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash004.jpg" alt="img13"/>
									<figcaption>
										<h2><span>BeJson<span></h2>
										<p>处理json相关的工具</p>
										<a target="_blank" href="http://www.bejson.com/">bejson</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-1 category-2 category-3 col-md-4 col-sm-6 col-xs-6" data-myorder="2">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash009.jpg" alt="img13"/>
									<figcaption>
										<h2><span>color scheme designer</span></h2>
										<p>辅助配置颜色</p>
										<a target="_blank" href="http://www.peise.net/tools/web/">配色网</a>
									</figcaption>			
								</figure>
          					</div>
       						<div class="grid mix category-1 category-2 category-3 col-md-4 col-sm-6 col-xs-6" data-myorder="3">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash0010.jpg" alt="img13"/>
									<figcaption>
										<h2> <span>在线ps</span></h2>
										<p>一个可以在线处理ps的网站</p>
										<a target="_blank" href="http://www.webps.cn/">看图网站</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-2 col-md-4 col-sm-6 col-xs-6" data-myorder="4">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash002.jpg" alt="img13"/>
									<figcaption>
										<h2><span>身份证</span></h2>
										<p>一款处理身份证相关信息的工具</p>
										<a href="#">idcard</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-3 col-md-4 col-sm-6 col-xs-6" data-myorder="5">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash006.jpg" alt="img13"/>
									<figcaption>
										<h2>第五个 <span>Imagine</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-1 col-md-4 col-sm-6 col-xs-6" data-myorder="6">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash004.jpg" alt="img13"/>
									<figcaption>
										<h2>第六个 <span>Sun</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-2 col-md-4 col-sm-6 col-xs-6" data-myorder="7">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash0010.jpg" alt="img13"/>
									<figcaption>
										<h2>第七个 <span>Rain</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-1 col-md-4 col-sm-6 col-xs-6" data-myorder="8">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash002.jpg" alt="img13"/>
									<figcaption>
										<h2>第八个 <span>Heart</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
           					<div class="grid mix category-1 col-md-4 col-sm-6 col-xs-6" data-myorder="9">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash004.jpg" alt="img13"/>
									<figcaption>
										<h2>第九个 <span>Sun</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
          					<div class="grid mix category-1 col-md-4 col-sm-6 col-xs-6" data-myorder="10">
								<figure class="effect-Beauty">
									<img src="${Context }/pages/images/pt/firstpage/unsplash004.jpg" alt="img13"/>
									<figcaption>
										<h2>第十个 <span>Sun</span></h2>
										<p>Beauty did not need any help. Everybody knew that.</p>
										<a href="#">View more</a>
									</figcaption>			
								</figure>
          					</div>
      					</div>
      				</div>
  				</div>
  			</div>
			<div class="notes">
	    		<div class="container">
	    			<div class="row">
	        			<div class="col-md-9 col-sm-10 col-12">
	        				<p>如果你有什么好的工具可以提供给我们，如果你有什么好的想法，请告诉我们，如果你有什么好的意见，请email我们，联系邮箱359371760@qq.com</p>
	      				</div>
	        			<div class="col-md-3 col-sm-2 col-xs-12 text-center">
	        				<button>更多</button>
	      				</div>
	      			</div>
	  			</div>
	  		</div>
  		</div>
		<div class="about" id="about">
   			<div class="container">
   				<div class="row">
       				<div class="col-md-12 col-sm-12 col-xs-12">
       					<div class="alldesc">
           					<div class="col-md-6 col-sm-6 col-xs-12 centertext">
           						<p class="all-td">这么酷的网站，你一定想知道</p>
           						<h2>关于</h2>
         						</div>
           					<div class="col-md-6 col-sm-6 col-xs-12">
           						<p class="desc">通过统计发现，下面几种浏览器常访问网站.</p>
         						</div>
         					</div>
     					</div>
       				<div class="col-md-12 col-sm-12 col-xs-12">
       					<div class="progresscount">
           					<div class="col-md-6 col-sm-6 col-xs-12">
           						<div class="col-md-6 col-sm-6 col-xs-6 block">
               						<div class="counter-item">
               							<h5>开发周期</h5>
               							<div class="timer" data-from="0" data-to="2" data-speed="1000" data-refresh-interval="50"></div>
             							</div>
             						</div>
           						<div class="col-md-6 col-sm-6 col-xs-6">
               						<div class="counter-item">
               							<h5>今日访问量</h5>
               							<div id="today_access" class="timer" data-from="0" data-to="0" data-speed="1000" data-refresh-interval="50"></div>
             							</div>
             						</div>
         						</div>
           					<div class="col-md-6 col-sm-6 col-xs-12" id="browswType"></div>
         					</div>
         				</div>
     				</div>
     			</div>
 			</div>
			<div class="testimonials" id="testimonials">
				<div class="container">
    				<div class="row">
        				<div class="col-md-12 col-sm-12 col-xs-12">
        					<div class="alldesc">
            					<div class="col-md-6 col-sm-6 col-xs-12 centertext">
            						<p class="all-td">你有什么想告诉我们的</p>
            						<h2>反馈</h2>
          						</div>
            					<div class="col-md-6 col-sm-6 col-xs-12">
            
          						</div>
          					</div>
      					</div>
            			<div class="col-md-12 col-sm-12 col-xs-12">
            				<div class="quotes">
                				
                			</div>
            			</div>        
        			</div>
    			</div>
				<div class="subscribe-social" style="margin-top: 20px;"> 
					<div class="container">
	    				<div class="row">
	        				<div class="col-md-8 col-sm-12 col-xs-12">
	                     		<div class="col-md-8 col-sm-10 col-xs-12">
	                     			<div class="row">
		                     			<div class="col-md-5">
		                     				<label class="radio" style="color:white;">
												<input type="radio" name="optionsRadios" id="optionsRadios1" value="0" checked>
										  		提供建议
											</label>
		                     			</div>>
		                     			<div class="col-md-5">
		                     				<label class="radio" style="color:white;">
										  		<input type="radio" name="optionsRadios" id="optionsRadios2" value="1">
										  		提交bug
											</label>
		                     			</div>
	                     			</div>
	                     			<div class="row">
			  							<div class="form-group">
			    							<textarea id="feedbackMsg" type="text" class="form-control" maxlength="250" id="email" rows="5" placeholder="给出你的建议或网站问题"></textarea> 
			  							</div>
			  						</div>
			  						<div class="row" style="margin-top: 20px;">
			  							<div class="form-group">
			    							<input id="feedbackLinkman" type="text" class="form-control" maxlength="20" id="email" placeholder="联系人名称">
			  							</div>
			  						</div>
			  						<div class="row" style="margin-top: 20px;">
			  							<div class="form-group">
			    							<input id="feedbackAddr" type="text" class="form-control" maxlength="20" id="email" placeholder="联系方式:如QQ,电话，地址等等">
			  							</div>
			  						</div>
	                        		<div class="row" style="margin-top: 20px;">
		  								<button type="submit" class="btn btn-or" onclick="feedback()">发布</button>
	                        		</div>
	                        	</div>
	                        	<div class="col-md-4 col-sm-2 col-xs-12 ">
	                        		<div class="row">
		                     			&nbsp;
	                     			</div>
	                     			<div class="row">
		                     			&nbsp;
	                     			</div>
	                        	</div>
	            			</div>
	            			<div class="col-md-4 col-sm-12 col-xs-12 text-center">
	            				<ul class="social">
	                				<li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
	                    			<li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
	                    			<li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
	                    			<li><a href="#"><i class="fa fa-linkedin-square"></i></a></li>
	                    		</ul>
	                		</div>
	            		</div>
	        		</div>
	    		</div>
			</div>
			<div class="address" id="contact" style="margin-top: 60px;">
				<div class="container">
	    			<div class="row">
	        			<div class="col-md-12 col-sm-12 col-xs-12">
	        				<div class="alldesc">
	            				<div class="col-md-6 col-sm-6 col-xs-12 centertext">
	            					<p class="all-td">加班很累，希望提供一份不加班工作的老板</p>
	            					<h2>联系作者</h2>
	          					</div>
	            				<div class="col-md-6 col-sm-6 col-xs-12 centertext">
	            					<div class="row">
		            					<div class="col-md-1 info"><p>day</p></div>
		            					<div class="col-md-11 info"><p>：2016.11.17</p></div>
	            					</div>
	            					<div class="row">
		            					<div class="col-md-1 info"><p>link</p></div>
		            					<div class="col-md-11 info"><p>：li&nbsp;&nbsp;jiang</p></div>
	            					</div>
	            					<div class="row">
		            					<div class="col-md-1 info"><p>email</p></div>
		            					<div class="col-md-11 info"><p>：359371760@qq.com</p></div>
	            					</div>
	          					</div>
	          				</div>
	      				</div>        
	        		</div>
	    		</div>
			</div>
			<footer class="foot"> 
				<div class="container">
	    			<div class="row">
	        			<div class="col-md-12 col-sm-12 col-xs-12">
	            			<h4 class="foot-logo">QiYouYou.com</h4>
	            		</div>
	            		<div class="col-md-12 col-xs-12 col-sm-12 text-center">
	            			<p class="foot-text">Copyright &copy; 2016.lnet All rights reserved.</p>
	            		</div>
	        		</div>
	    		</div>
			</footer>

<!-- 无刷新排序 -->
<script type="text/javascript" src="<%=contextPath%>/pages/js/pt/firstpage/jquery.mixitup.js"></script> 
<!-- 自动计数 -->
<script type="text/javascript" src="<%=contextPath%>/pages/js/pt/firstpage/jquery.countTo.js"></script> 
<!-- 滚动监听 -->
<script type="text/javascript" src="<%=contextPath%>/pages/js/pt/firstpage/jquery.waypoints.min.js"></script> 
<!-- 评论显示 -->
<script type="text/javascript" src="<%=contextPath%>/pages/js/pt/firstpage/jquery.quovolver.js"></script>
<script>

	$(function(){
	    var windowH = $(window).height();
	    var bannerH = $('#banner').height();
	  
	    if(windowH > bannerH) {                            
	        $('#banner').css({'height':($(window).height() - 68)+'px'});
			$('#bannertext').css({'height':($(window).height() - 68)+'px'});
	    }                                                                               
	 
	          
	});
	
	$(function(){
  		$('#galleryimg').mixItUp();
	});
	
</script>
<script>

	$(document).ready(function () {
		$(document).on("scroll", onScroll);
		$('a[href^="#"]').on('click', function (e) {
			e.preventDefault();
			$(document).off("scroll");

			$('a').each(function () {
				$(this).removeClass('active');
			})

			$(this).addClass('active');
			var target = this.hash;
			$target = $(target);

			$('html, body').stop().animate({
				'scrollTop': $target.offset().top
			}, 500, 'swing', function () {
				window.location.hash = target;
				$(document).on("scroll", onScroll);
			});

		});
	});

	function onScroll(event){
		var scrollPosition = $(document).scrollTop();
		$('.nav li a').each(function () {
			var currentLink = $(this);
			var refElement = $(currentLink.attr("href"));
			if (refElement.position().top <= scrollPosition && refElement.position().top + refElement.height() > scrollPosition) {
				$('.nav li a').removeClass("active");
				currentLink.addClass("active");
			}
			else{
				currentLink.removeClass("active");
			}
		});
	}
	</script>
	<script type="text/javascript">
		$(function(){
			$.ajax({			//添加访问记录
				type:'post',
				url:'${Context}/firstpage!addBrowseAccess',
				data:{"browseAccess.deviceType":deviceType(),"browseAccess.browseType":browseType},
				cache:false,
				dataType:'json',
				async:false,
				success:function(data){
					if(data.success){
						
					}else{
						showMsg(data.msg);
					}
				},
				error:function(){
				}
				
			});
			$.ajax({		//获取今日访问记录
				type:'post',
				url:'${Context}/firstpage!todayAccess',
				data:{},
				cache:false,
				dataType:'json',
				async:false,
				success:function(data){
					if(data.success){
						$('#today_access').attr("data-to",""+data.total);
						$('.timer').countTo();
					}
				},
				error:function(){}
			});
			
			$.ajax({
				type:'post',
				url:'${Context}/firstpage!browseType',
				data:{},
				cache:false,
				dataType:'json',
				async:false,
				success:function(data){
					if(data.success){
						var json = data.list;
						var browsTypeHtml = "";
						for(var i=0;i<json.length;i++){
							browsTypeHtml += "<div class=\"progresstitle\"> "
		                				+"<h5>"+json[i].browse_type+"</h5>"
	                					+"<div class=\"progress progress-style\">"
	                					+"<div class=\"progress-bar progress-bar-striped\" role=\"progressbar\" aria-valuenow=\""+json[i].precent+"\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+json[i].precent+"%\"> "+json[i].precent+"% </div>"
	              						+"</div>"
	              					+"</div>";
          				}
						
						$('#browswType').html(browsTypeHtml);
					}
				},
				error:function(){}
			});
			
			getFeedbackList();
		});
		
		function feedback(){
			var chkRadio = $('input:radio[name="optionsRadios"]:checked').val();
			var msg = $('#feedbackMsg').val();
			var linkman = $('#feedbackLinkman').val();
			var linkaddr = $('#feedbackAddr').val();
			
			if(msg == "" || msg == null){
				showMsg("建议或问题不能为空");
				return;
			}
			
			if(linkman == "" || linkman == null){
				showMsg("联系人不能为空");
				return;
			}
			
			$.ajax({
				type:'post',
				url:'${Context}/feedBack!save',
				data:{
					"feedBack.type":chkRadio,
					"feedBack.feedMsg":msg,
					"feedBack.linkman":linkman,
					"feedBack.linkaddr":linkaddr
				},
				cache:false,
				dataType:'json',
				success:function(data){
					if(data.success){
						showMsgWithCallBack("感谢你提出的宝贵意见",function(){
							alert("哈哈");
							window.location.reload();
						});
					}
				},
				error:function(){}
			});
		}
		
		function getFeedbackList(){
			$.ajax({
				type:'post',
				url:'${Context}/feedBack!queryList',
				data:{
					
				},
				cache:false,
				dataType:'json',
				success:function(data){
					var feedbacklistHtml = "";
					if(data.success){
						var json = data.list;
						for(var i=0;i<json.length;i++){
							var typeHint = "建议";
							if(json[i].type == "1"){
								typeHint = "bug";
							}
							feedbacklistHtml += "<blockquote> "
                    							+"	<p>"+json[i].feedmsg+"</p>"
                        						+"	<p class='name'><span style='color:red'>["+typeHint+"]</span>"+json[i].linkman+"("+json[i].creator_ip+"),"+json[i].creator_time+"</p>"
                    							+"</blockquote>";
						}
					}
					$('.quotes').append(feedbacklistHtml);
					$('.quotes').quovolver({
				    	equalHeight   : true
				    });
				},
				error:function(){}
			});
		}
	</script>
</body>
</html>
