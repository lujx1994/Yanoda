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

    <title>日历</title>
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
                        <a class="element brand" href="daymanage.jsp"><span class="icon-spin"></span></a>
                        <span class="element-divider"></span>

                        <div class="element place-right">
                            <a class="dropdown-toggle" href="index.jsp"><span class="icon-cog"></span></a>
                            <ul class="dropdown-menu place-right" data-role="dropdown">
                                <li><a href="updateuser.jsp">个人中心</a></li>
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
            提醒
        </h1>
    	
    	<div class="accordion with-marker mymargin" data-role="accordion" data-closeany="false">
                <div class="accordion-frame fl">
                    <a class="heading bg-lightBlue fg-white" href="#">&nbsp&nbsp&nbsp&nbsp日提醒&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <div class="content">
                        <p><s:property value="#session.message"></s:property></p>
                        <a href="upload.jsp"><button class="primary">文件上传</button></a>
                    </div>
                </div>
                <div class="accordion-frame fl">
                    <a class="heading ribbed-green fg-white" href="#">&nbsp&nbsp&nbsp&nbsp旬提醒&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <div class="content">
                    	<s:if test="#session.month==9||#session.month==19||#session.month==29">
                        <p><s:property value="#session.message"></s:property></p>
                        </s:if>
                        <s:else>
                        <p>无需上传旬报表</p>
                        </s:else>
                        <a href="upload.jsp"><button class="primary">文件上传</button></a>
                    </div>
                </div>
                <div class="accordion-frame fl">
                    <a class="heading ribbed-red fg-white" href="#">&nbsp&nbsp&nbsp&nbsp月提醒&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <div class="content">
                    	<s:if test="#session.month==31||#session.month==30">
                        <p><s:property value="#session.message"></s:property></p>
                        </s:if>
                        <s:else>
                        <p>无需上传月报表</p>
                        </s:else>
                        <a href="upload.jsp"><button class="primary">文件上传</button></a>
                    </div>
                </div>
        </div>
        
        
         <div style="margin-top: 200px">
        </div>
        <s:if test="#session.range!=3">
        <h1>
	            <a href="index.jsp"><i class="icon-arrow-left-3 fg-darker smaller"></i></a>
	            	本人今日上传表情况
	    </h1>
	    </s:if>
	        
	   
        
        <s:if test="#session.form!=NULL">
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
                <tr class="">
                <td><s:property value="#session.username"/></td>
                <td class="right"><s:property value="#session.form_name"/></td>
                <td class="right"><s:property value="#session.form_date"/></td>
                <td class="right"><a href=<s:property value="#session.download"/>><i class="icon-floppy on-left"></i>下载</a></td>
                </tr>
                </tbody>
            </table>
            </s:if>
    	
    </div>
</body>
</html>