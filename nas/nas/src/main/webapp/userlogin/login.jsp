<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
html {
	width: 100%;
	height: 100%;
	overflow: hidden;
	font-style: sans-serif;
}

body {
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	margin: 0;
	background-color: #4A374A;
}

#login {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}

#login h1 {
	color: #fff;
	text-shadow: 0 0 10px;
	letter-spacing: 1px;
	text-align: center;
}

h1 {
	font-size: 2em;
	margin: 0.67em 0;
}

input {
	width: 278px;
	height: 30px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	text-shadow: 1px 1px 1px;
	border-top: 1px solid #312E3D;
	border-left: 1px solid #312E3D;
	border-right: 1px solid #312E3D;
	border-bottom: 1px solid #56536A;
	border-radius: 4px;
	background-color: #2D2D3F;
}

.but {
	width: 300px;
	min-height: 20px;
	display: block;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: 0;
}
</style>
<script type="text/javascript">
    window.onload=function(){
    	var z=document.getElementById("z");
		z.onclick=function(){
		var yh=document.getElementById("yh");	
			yh.innerHTML="<font color='red'>长度为4-11</font>"
			
		};
    	z.onblur=function(){
			var z=document.getElementById("z");
			var lg=z.value.length;
			if((lg>0&&lg<=3)||lg>11){var yh=document.getElementById("yh");	
			yh.innerHTML="<font color='red'>输入错误，重新输入</font>"
			}
			else if(lg==0){var yh=document.getElementById("yh");	
    		yh.innerHTML="<font color='red'>不能为空</font>"
    		}
			else{var yh=document.getElementById("yh");	
			yh.innerHTML="<font color='red'>输入正确</font>"}
			
		}
    	var m=document.getElementById("m");
    	m.onclick=function(){
    	var mm=document.getElementById("mm");	
    		mm.innerHTML="<font color='red'>长度为4-11</font>"
    		
    	};
    	m.onblur=function(){
    		var m=document.getElementById("m");
    		var lg=m.value.length;
    		if((lg<=3&&lg>0)||lg>11){var yh=document.getElementById("mm");	
    		yh.innerHTML="<font color='red'>输入错误，重新输入</font>"
    		}else if(lg==0){var yh=document.getElementById("mm");	
    		yh.innerHTML="<font color='red'>不能为空</font>"
    		}
    		else{var mm=document.getElementById("mm");	
    		mm.innerHTML="<font color='red'>输入正确</font>"}
    		
    	}
    	
    }
</script>
</head>
<body>
<body>
	<div id="login">
		<h1>nas用户登录界面</h1>
		<form action="/nas/userlogin" method="post">
			<input type="text" name="zhanghao" placeholder="用户名" id="z"></input><span
				id="yh"></span> <input type="password" name="mima" placeholder="密码"
				id="m"></input> <span id="mm"></span> <input type="submit"
				value="登录">
			</button>
		</form>
	</div>
</body>
</body>
</html>