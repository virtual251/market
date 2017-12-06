var interval;

function startSecond() {

	interval = window.setInterval("changeSecond()", 1000);

};
/*var g=function(id){
	if(id.substr(0,1)=='.'){
		return document.getElementsByClassName(id.substr(1));
	}
	return document.getElementById(id);
};*/
/*function searchName(str){
	var xmlhttp= new XMLHttpRequest();
	str=encodeURIComponent(encodeURIComponent(str));
	var url="${pageContext.request.contextPath}/mohuServlet";
	url=url+"?category="+str;
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			if(xmlhttp.status==200){
			alert("异步查询成功");
			}
			}
	}*/
	
function changeSecond() {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;

	svalue = svalue - 1;

	if (svalue == 0) {
		window.clearInterval(interval);
		location.href = "index.jsp";
		return;
	}

	second.innerHTML = svalue;
}

//获取XMLHttpRequest对象
function getXMLHttpRequest() {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for all new browsers
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {// code for IE5 and IE6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	return xmlhttp;

}