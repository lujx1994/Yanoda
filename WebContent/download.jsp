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

    <title></title>
    
</head>
<body class="metro">
    <header class="bg-dark" data-load="header.html">
    <div class="navbar">
                <div class="navbar-content">

                    <a href="index.jsp" class="element"><span class="icon-grid-view"></span> Yanoda System <sup>1.0</sup></a>
                    <span class="element-divider"></span>

                    <a class="pull-menu" href="#"></a>

                    <div class="no-tablet-portrait">
                        <span class="element-divider"></span>
                        <a class="element brand" href="upload.jsp"><span class="icon-spin"></span></a>
                        <span class="element-divider"></span>

                        <div class="element place-right">
                            <a class="dropdown-toggle" href="index.jsp"><span class="icon-cog"></span></a>
                            <ul class="dropdown-menu place-right" data-role="dropdown">
                                <li><a href="#">个人中心</a></li>
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
	            <a href="index.jsp"><i class="icon-arrow-left-3 fg-darker smaller"></i></a>
	            	文件下载
	        </h1>
	        
	        <div style="margin-top: 40px">
            </div>
            
            <table class="table striped bordered hovered">
                <thead>
                <tr>
                    <th class="text-left">复命人</th>
                    <th class="text-left">复命文件名</th>
                    <th class="text-left">上传时间</th>
                    <th class="text-left">下载</th>
                </tr>
                </thead>

                <tbody>
                <s:iterator value="formList">
                <tr class="">
                <td><s:property value="poster_name"/></td>
                <td class="right"><s:property value="form_name"/></td>
                <td class="right"><s:property value="form_date"/></td>
                <td class="right"><a href=<s:property value="download"/>><i class="icon-floppy on-left"></i>下载</a></td>
                </tr>
                </s:iterator>
                </tbody>
            </table>

        </div>
</body>
</html>