<%@ page language="java" import="java.util.*,java.net.*"  pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/mycss.css" type="text/css" />
<link rel="stylesheet" href="css/car.css" type="text/css" />
<%
String username="";
String display="inline-block";
Cookie[] cookies=request.getCookies();
if(cookies==null){
	username="请登录";
}else{
	if(request.getSession().getAttribute("user")!=null){
		for(int i=0;i<cookies.length;i++){
			if("username".equals(cookies[i].getName())){
				username=URLDecoder.decode(cookies[i].getValue(),"utf-8");
				display="none";
				break;
			}
			}
	}else{
	username+="请登录";
	}
}
%>
<div class="head">
<div class="mainhead">
		<div class="workspace">
		<div class="head_left"><img id="icons_home" src="IMG/home.png">
		<a href="index.jsp">金龙首页</a></div>
			<ul class="ul">
				<li><a id="user" href="${pageContext.request.contextPath }/myAccount"><%=username %></a></li>
				<li style="display:<%=display %>;"><a href="register.jsp">免费注册</a></li>
				<li><a href="">我的订单</a></li>
				<li><a href="">帮助中心</a></li>
				<li><a href="">客户服务</a></li>
			</ul>
		</div>
	</div>
</div>