<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/mycss.css" type="text/css" />
<script type="text/javascript">
	function www() {
		var a=new Array();
		a=document.getElementsByClassName("encode");
		for(var i=0;i<a.length;i++){
			var haha=a[i].getAttribute("href");
			a[i].href=encodeURI(haha);
		}
		}
	</script>
<div class="search">
		<div class="workspace">
			<div class="logo leftArea">
				<img src="IMG/mogu.png">
			</div>
			<form action="${pageContext.request.contextPath}/mohuServlet"
			method="post">
			<div class="searchBox leftArea">
				<input type="text" name="name" class="search_text"></input>
				<input type="submit" value="搜索" class="search_btn"></input>
			</div>
			</form>
			<div class="shopCar rightArea">
				<img src="IMG/gouwuce.png">
				<a href="${pageContext.request.contextPath }/showCar?method=show">购物车</a>
			</div>
		</div>
	</div>
	<div class="navBox clearfix">
		<div class="workspace" onclick="www()">
			<div class="shopClass">
				<h3><a id="allGoods" href="${pageContext.request.contextPath}/pageServlet">全部商品</a><span>>></span></h3>
			</div>
			<ul class="nav">
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=公仔"><span>公仔类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=动物"><span>动物类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=卡通"><span>卡通类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=电动"><span>电动类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=芭比"><span>芭比类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=手办"><span>手办类</span></a></li>
				<li><a class="encode" href="${pageContext.request.contextPath}/pageServlet?category=饰品"><span>饰品类</span></a></li>
			</ul>
		</div>
	</div>
	