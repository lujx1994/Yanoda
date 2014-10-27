<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<title>登录</title>
<style>
*{
	padding:0px;
	margin:0px;
	}
body{
	font-family:Arial, Helvetica, sans-serif;
	background:url(images/bgimage.jpg);
	background-size:cover; /* image cover the background */
	font-size:13px;
	}
img{
	border:0;
	}
.lg{width:468px; height:468px; margin:100px auto; background:url(images/login_bg.png) no-repeat;}
.lg_top{ height:200px; width:468px;}
.lg_main{width:400px; height:180px; margin:0 25px;}
.lg_m_1{
	width:290px;
	height:100px;
	padding:60px 55px 20px 55px;
}
.ur{
	height:37px;
	border:0;
	color:#666;
	width:232px;
	margin:4px 28px;
	background:url(images/user.png) no-repeat;
	padding-left:10px;
	font-size:15pt;
	font-family:Arial, Helvetica, sans-serif;
}
.pw{
	height:37px;
	border:0;
	color:#666;
	width:232px;
	margin:4px 28px;
	background:url(images/password.png) no-repeat;
	padding-left:10px;
	font-size:15pt;
	font-family:Arial, Helvetica, sans-serif;
}

.bn{width:330px; height:72px; background:url(images/enter.png) no-repeat; border:0; display:block; font-size:18px; color:#FFF; font-family:Arial, Helvetica, sans-serif; font-weight:bolder;}
.lg_foot{
	height:80px;
	width:330px;
	padding: 6px 68px 0 68px;
}
</style>
</head>
<body class="b">
<div class="lg">
<s:form action="login" method="post">
    <div class="lg_top"></div>
    <div class="lg_main">
        <div class="lg_m_1">
        <input name="user_name" class="ur" style="font-family:微软雅黑, Helvetica, sans-serif;"/>
        <input name="user_password" type="password"  class="pw" />
        </div>
    </div>
    <div class="lg_foot">
    <input type="submit" value="登 陆" class="bn" />
    </div>
</s:form>
</div>
</body>
</html>