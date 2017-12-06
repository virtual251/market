<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>采菇凉的小蘑菇</title>
<link rel="stylesheet" href="css/mycss.css" type="text/css" />
<link rel="stylesheet" href="css/car.css" type="text/css" />
</head>
<script type="text/javascript">
function changeNum(proId,num){
	alert(proId);
	alert(num);
 var xmlhttp=new XMLHttpRequest();
var url="${pageContext.request.contextPath}/changeNumServlet?proId="+proId+"&num="+num;
xmlhttp.onreadystatechange=function(){
	if(xmlhttp.readyState==4&&xmlhttp.status==200){
		var ret=xmlhttp.responseText;
		if(ret==1){
		alert("数据已提交成功");
		}
	}
}
xmlhttp.open("get",url);
xmlhttp.send(null); 
}
function check(){
	alert("haha");
	var checkbox=document.getElementsByClassName("single-input");
	var productIds="";
	var state=0;
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			if(state==0){
			productIds=checkbox[i].name;
			state=1;
			continue;
			}
			if(state==1){
				productIds=productIds+"_"+checkbox[i].name;
			}
		}
	}
	location.href="${pageContext.request.contextPath}/order?method=showOrder&productIds="+productIds;
}
</script>

<body class="main">
	<div class="head">
	<%@include file="head.jsp"%>
<%-- <div class="workspace">
	<div class="left">
		<div><img id="icons_home" src="IMG/home.png"></div>
		<div><a href="index.jsp">金龙首页</a></div>
		</div>
		<div class="right">
		<div><a href="${pageContext.request.contextPath }/myAccount"></a></div>
		<div>|</div>
		<div><a href="">我的订单</a></div>
		</div>
	</div>
	</div> --%>

	<div class="car_search">
	<div class="workspace">
		<div class="icon">
			<div class="icon_img"><img src="IMG/mogu1.png"></div>
			<div class="icon_p"><p>购物车</p></div>
		</div>
		<div class="car_find">
			<input class="car_text" type="text" name="">
			<input class="car_btn" type="submit" name="" value="搜索">
		</div>
		</div>
	</div>
<div id="nocar">
<div class="car">
<div class="workspaces">
	<p class="leader">全部商品</p>
	<div class="car_head">
	<div class="left">
	<div class="car_left">
		<input class="allCheck_input" type="checkbox" name="">
		<div class="allCheck">全选</div>
		<div class="goods">商品</div>
		</div>
	</div>
	<div class="right">
		<div class="price">单价</div>
		<div class="num">数量</div>
		<div class="comment">小计</div>
		<div class="actions">操作</div>
		</div>
	</div>
	<input type="hidden" value="${message }" id="aaa"/>
	<script type="text/javascript">
	window.onload=function(){
		if(document.getElementById("aaa").value=="0"){
			document.getElementById("nocar").innerHTML="<div class='inner'>老铁，购物车是空的，快去买点东西。<br><a href='${pageContext.request.contextPath }/index.jsp'>去购物</a></div>";
		}
		
	}
	</script>
			<c:forEach items="${car }" var="entry" varStatus="vs">
	<div class="single-goods">
		<input class="single-input" type="checkbox" name="${entry.key.id }">
		<div class="single-img">
			<img src="${pageContext.request.contextPath }/upload/${entry.key.img_url}">
		</div>
		<div class="single-p">
			<p>${entry.key.description }</p>
		</div>
		<div class="single-price">
			￥${entry.key.price }
		</div>
		<div class="single-num">
			<input type="text" value="-" onclick="changeNum('${entry.key.id}','${entry.value-1 }')">
			<input id="middle" type="text"  value="${entry.value }" >
			<input type="text" value="+" onclick="changeNum('${entry.key.id}','${entry.value+1 }')">
		</div>
		<div class="single-all">
		${entry.key.price*entry.value }
		</div>
		<div class="single-action">
			<a href="${pageContext.request.contextPath }/deleteCarServlet?id=${entry.key.id}">删除</a>
			<a href="${pageContext.request.contextPath }/findBookInfoServlet?id=${entry.key.id}">查看</a>
		</div>
	</div>
	</c:forEach>
	</div>
</div>
<div class="intotle">
<div class="workspace">
	<input type="checkbox" name="">
	<div class="allCheck">全选</div>
	<div class="goods">删除选中的商品</div>
	<div>已选择0件商品</div>
	<div>总价：￥0.00</div>
	<div><a href="#" onclick="check()">去结算</a></div>
	</div>
</div>
</div>
	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>
