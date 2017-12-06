<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="css/mycss.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
 <div class="workspace">
 <c:forEach items="${pb.products }" var="b" varStatus="status">
 <a href="${pageContext.request.contextPath }/findBookInfoServlet?id=${b.id}">
			<div class="eachone">
			<div class="detail">
				<img style="width:230px;height: 250px; " src="${pageContext.request.contextPath }/upload/${b.img_url}">
				<p class="money">¥${b.price }</p>
				<p class="description">${b.description }</p>
				<p class="comment"><span>800+</span>评价</p>
			</div>
		</div>
		</a>
		</c:forEach>
	<div class="fenye">
		<div class="up"><a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=${pb.category}">上一页</a></div>
		<div class="page"><a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${1}&category=${pb.category}">1</a></div>
			<div class="page"><a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${2}&category=${pb.category}">2</a></div>
				<div class="page">3</div>
					<div class="page">4</div>
						<div class="page">5</div>
							<div class="page">6</div>
							<span>...</span>
		<div class="down"><a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&category=${pb.category}">下一页</a></div>
	</div>
	</div>



</body>
</html>
