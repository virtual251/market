<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/car.css" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("yanzheng").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</head>


<body class="main">
	<%-- <%@include file="head.jsp"%>
	导入头
	<%@include file="menu_search.jsp"%>导入导航条与搜索

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/user?method=register"
			method="post">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册 ${user_msg }</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%">
								<input type="text" class="textinput"
									name="email" /></td>
								<td><font color="#999999">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td>
									<input type="text" class="textinput" name="username" />
								</td>
								<td><font color="#999999">用户名设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" /></td>
								<td><font color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" /></td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput" name="ckcode"/>
								</td>
								<td>${ckcode_msg }</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/imageCode" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="images/signup.gif" name="submit" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div> --%>
<div class="regist_head">
	<div class="regist_head_workspace">
		<div class="left">		
			<img src="IMG/mogu1.png">
			<div class="welcome">欢迎登录</div>
		</div>
		<div class="right">
			<p class="right_p">已有账号？</p>
			<a class="right_a" href="">请登录</a>
		</div>
	</div>
</div>
<div class="regist_body">
	<div class="regist_body_workspace">
		<form action="${pageContext.request.contextPath}/user?method=register"  method="post">
			<div class="input">
			<p class="users">用&nbsp;户名</p>
			<input class="username" placeholder="请输入用户名" type="text" name="username">
			</div>
			<div class="input">
			<p>&nbsp;邮&nbsp;&nbsp&nbsp;&nbsp;箱</p>
			<input type="email" placeholder="请输入您的邮箱号"  name="email">
			</div>
			<div class="input">
			<p>&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码</p>
			<input type="password" placeholder="请设置密码" name="password">
			</div>
			<div class="input">
			<p>确认密码</p>
			<input type="password" placeholder="请再次确认密码" name="repassword">
			</div>
			<div class="input">
			<p>&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话</p>
			<input type="tel" placeholder="请输入您的手机号" name="telephone">
			</div>
			<div class="input">
			<p>验证码</p>
			<input type="text" placeholder="请填写验证码" name="ckcode">
			<a href="javascript:void(0);" onclick="changeImage()"><img id="yanzheng" width="180" height="30" src="${pageContext.request.contextPath}/imageCode"></a>
			</div>
			<div class="input" id="submit">
			<input type="submit" value="立即注册">
			</div>
		</form>
	</div>
</div>
<div class="workspace">
<div class="foot">
	<div class="foot1">关于我们</div>
	<div class="foot2">|</div>
	<div class="foot3">联系我们</div>
	<div class="foot4">|</div>
	<div class="foot5">人才招聘</div>
	<div class="foot6">|</div>
	<div class="foot7">商家入驻</div>
	<div class="foot8">|</div>
	<div class="foot9">广告服务</div>
	<div class="foot10">|</div>
	<div class="foot11">手机金龙</div>
	<div class="foot12">|</div>
	<div class="foot13">友情链接</div>
	<div class="foot14">|</div>
	<div class="foot15">销售联盟</div>
	<div class="foot16">|</div>
	<div class="foot17">金龙社区</div>
	<div class="foot18">|</div>
	<div class="foot19">金龙公益</div>
	</div>
	<div id="disclaimer">
		本站仅用于学习交流，通过使用本站内容随之而来的风险与本站无关。
	</div>
</div>
</body>
</html>
