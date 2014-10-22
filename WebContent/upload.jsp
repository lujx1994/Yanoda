<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Yanoda System 1.0</title>
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
                                <li><a href="#">修改密码</a></li>
                                <li><a href="#">退出</a></li>
                            </ul>
                        </div>
                        <span class="element-divider place-right"></span>
                        <button class="element image-button image-left place-right">
                            Sergey Pimenov
                            <img src="images/me.jpg"/>
                        </button>
                    </div>
                </div>
            </div>
    </header>
    <div class="container">
        <h1>
            <a href="index.jsp"><i class="icon-arrow-left-3 fg-darker smaller"></i></a>
            上传
        </h1>

<!--         <p class="padding20 bg-grayLighter">
            DataTables is a plug-in for the jQuery Javascript library written by <a href="http://www.sprymedia.co.uk/">SpryMedia</a>. It is a highly flexible tool, based upon the foundations of progressive enhancement, which will add advanced interaction controls to any HTML table.
        </p> -->

<!--         <p class="description">
            Metro UI CSS provides style support for DataTables.
        </p> -->

             <form>
                <fieldset>
                   	<div style="margin-top: 10px">
                    </div>
                    <legend>请选择上传文件</legend>
                    <div class="input-control file" data-role="input-control">
                        <input type="file">
                        <button class="btn-file"></button>
                    </div>

                    <div>
                        <div class="input-control switch" data-role="input-control">
                            <label class="inline-block" style="margin-right: 20px">
                               	报告已上传消息
                                <input type="checkbox" checked/>
                                <span class="check"></span>
                            </label>
                        </div>
                    </div>
                    
                    <div style="margin-top: 10px">
                    </div>

                    <input type="submit" value="提交">
                    <input type="reset" value="重置">

                    <div style="margin-top: 20px">
                    </div>

                </fieldset>
            </form>
        </div>

    <script src="js/hitua.js"></script>

</body>
</html>