	window.onload=function(){
	var isplayend=false;
	var prev=document.getElementById("prev");
	var next=document.getElementById("next");
	var focus=document.getElementsByClassName("focus")[0];
	var list=document.getElementsByClassName("focusImg")[0];
	var button=document.getElementsByClassName("button")[0].getElementsByTagName('span');
	var index=1;
	play();
	focus.onmouseout=play;
	focus.onmouseover=stop;
	prev.onclick=function(){
		if(!isplayend){
		if(index==1){
			index=5;
		}else{
			index=index-1;
		}
		
		turn(1000);
			showButton();
	}
	
	}
	next.onclick=function(){
		if(!isplayend){
		if(index==5){
			index=1;
		}else{
		index=index+1;
	}	
	
		turn(-1000);
		showButton();
	}
		
	}
	function turn(offset){
		isplayend=true;
		var alltime=600;
		var eachtime=10;
		var speed=offset/(alltime/eachtime);
		var newleft=parseInt(list.style.left)+offset;
		function go(){
		if((speed<0 && parseInt(list.style.left)>newleft)||(speed>0 && parseInt(list.style.left)<newleft)){
			list.style.left=parseInt(list.style.left)+speed+"px";
			setTimeout(go,eachtime);
		}else{
		isplayend=false;
		list.style.left=newleft+"px";
		if(parseInt(list.style.left)>-1000){
			list.style.left=-5000+"px";
			return;
		}else if(parseInt(list.style.left)<-5000){
			list.style.left=-1000+"px";
			return;
		}

		}
	}
	go();
		
}
for(var i=0;i<button.length;i++){
	button[i].onclick=function(){
		var myIndex=this.getAttribute("index");
		run=-1000*(myIndex-index);
		turn(run);
		index=parseInt(myIndex);
		showButton();
	}
}
function showButton(){
	for(var i=0;i<button.length;i++){
		if(button[i].className=='on'){
			button[i].className='';
			break;
		}
	}
	button[index-1].className='on';
}
function play(){
	timer=setInterval(function(){
		next.onclick();
	},5000);
}

function stop(){
	clearInterval(timer);
}

}

