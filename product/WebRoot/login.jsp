<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>卖菇凉的小蘑菇</title>

<link rel="stylesheet" href="css/mycss.css" type="text/css" />
</head>

<body class="main">
	
<div class="workspace">
<div class="login_head">
	<img src="IMG/mogu.png">
	<div class="login_welcome">欢迎登录</div>
</div>
</div>
<div class="login_notice">
<div class="workspace">
	依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证。
	</div>
</div>
<div class="login_motou">
<div class="login_loginBox">
<div class="login_login">
	<div class="login_notice">金龙不会以任何理由要求您转账汇款，谨防诈骗。</div>
	<div class="login_search">
		<div class="login_search_1">扫码支付</div>
		<div class="login_search_2">|</div>
		<div class="login_search_3">账户登录</div>
	</div>
	<div>${user_msg }</div>
		<form action="${pageContext.request.contextPath }/user?method=login" method="post">
		<div class="login_username">
		<img src="IMG/user.png">
		<input type="text" placeholder="手机/邮箱/用户名" name="username">
		</div>
		<div class="login_password">
		<img src="IMG/word.png">
		<input type="password" placeholder="密码" name="password">
		</div>
		<a class="login_forget" href="#">忘记密码</a>
		<input type="submit" name="submit" value="登录">
	</form>
	<a class="login_regist" href="register.jsp">免费注册</a>
	</div>
</div>
</div>
<div class="workspace">
<div class="login_foot">
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
	<div class="login_disclaimer">
		本站仅用于学习交流，通过使用本站内容随之而来的风险与本站无关。
	</div>
</div>


</body>
</html>
