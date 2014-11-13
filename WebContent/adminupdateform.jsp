<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="product" content="Metro UI CSS Framework">
<meta name="description" content="Simple responsive css framework">
<meta name="author" content="Sergey S. Pimenov, Ukraine, Kiev">
<link href="css/metro-bootstrap.css" rel="stylesheet">
<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
<link href="css/iconFont.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<link href="js/prettify/prettify.css" rel="stylesheet">
<!-- Load JavaScript Libraries -->
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.widget.min.js"></script>
<script src="js/jquery/jquery.mousewheel.js"></script>
<script src="js/jquery/jquery.dataTables.js"></script>
<script src="js/prettify/prettify.js"></script>
<!-- Metro UI CSS JavaScript plugins -->
<script src="js/load-metro.js"></script>
<!-- Local JavaScript -->
<script src="js/docs.js"></script>
<script src="js/github.info.js"></script>
<script src="js/hitua.js"></script>
<style>
.fl{
float:left
}
.fr{
float:right;
}
.mymargin{
margin-top:40px;
}
.mypic{
margin-top:10px;
}
</style>
<title>Yanoda System 1.0</title>
</head>
<body class="metro">
<header class="bg-dark" data-load="header.html">
<div class="navbar">
<div class="navbar-content">
<a href="admin.jsp" class="element"><span class="icon-grid-view"></span> Yanoda System <sup>1.0</sup></a>
<span class="element-divider"></span>
<a class="pull-menu" href="#"></a>
<div class="no-tablet-portrait">
<span class="element-divider"></span>
<a class="element brand" href="adduser.jsp"><span class="icon-spin"></span></a>
<span class="element-divider"></span>
<div class="element place-right">
<a class="dropdown-toggle" href="index.jsp"><span class="icon-cog"></span></a>
<ul class="dropdown-menu place-right" data-role="dropdown">
<li><a href="changepassword">修改密码</a></li>
<li><a href="logout">退出</a></li>
</ul>
</div>
<span class="element-divider place-right"></span>
<button class="element image-button image-left place-right">
<s:property value="#session.userrealname"></s:property>
<i class="icon-user-2 mypic"></i>
</button>
</div>
</div>
</div>
</header>
<div class="container">
<h1>
<s:a href="admin.action"><i class="icon-arrow-left-3 fg-darker smaller"></i></s:a>
更新文件表信息<h2></h2>
</h1>
<s:form action="adminupdateform" method="post" >
<fieldset>
<label>复命人</label>
<div class="input-control text" data-role="input-control">
<input type="text" name="poster_name" value="<s:property value="#session.postername"/>" placeholder="type text">
</div>
<label>复命文件名</label>
<div class="input-control text" data-role="input-control">
<input type="text" name="form_name" value="<s:property value="#session.formname"/>" placeholder="type text">
</div>
<label>复命文件路径</label>
<div class="input-control text" data-role="input-control">
<input type="text" name="form_realpath" value="<s:property value="#session.formrealpath"/>" placeholder="type text">
<button class="btn-clear" tabindex="-1"></button>
</div>
<label>提交时间</label>
<div class="input-control text" data-role="input-control">
<input type="text" name="form_date" value="<s:property value="#session.formdate"/>" placeholder="type text">
<button class="btn-clear" tabindex="-1"></button>
</div>
<label>下载</label>
<div class="input-control text" data-role="input-control">
<input type="text" name="download" value="<s:property value="#session.download"/>" placeholder="type text">
<button class="btn-clear" tabindex="-1"></button>
</div>
<label>复命状态</label>
<div>
<div class="clearfix">
<div class="input-control radio inline-block" data-role="input-control">
<label class="inline-block">
<input type="radio" name="confirm" value="true" <s:if test="#session.confirm==true">checked</s:if> />
<span class="check"></span>
已审核
</label>
<label class="inline-block">
<input type="radio" name="confirm" value="false" <s:if test="#session.confirm==false">checked</s:if> />
<span class="check"></span>
未审核
</label>
</div>
</div>
</div>
<input type="submit" value="提交更新">
</fieldset>
</s:form>
<s:fielderror fieldName="updateError" />
</div>
</body>
</html>