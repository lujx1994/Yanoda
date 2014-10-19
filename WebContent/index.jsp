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
    <link href="js/prettify/prettify.css" rel="stylesheet">

    <!-- Load JavaScript Libraries -->
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/jquery/jquery.widget.min.js"></script>
    <script src="js/jquery/jquery.mousewheel.js"></script>
    <script src="js/jquery/jquery.easing.1.3.min.js"></script>
    <script src="js/prettify/prettify.js"></script>
    <script src="js/holder/holder.js"></script>

    <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/load-metro.js"></script>

    <!-- Local JavaScript -->
    <script src="js/docs.js"></script>
    <script src="js/github.info.js"></script>

    <title></title>

    <style>
        .container {
            width: 1280px;
        }
        .main{
        	margin-left: 50px;
        	margin-bottom: 70px;
        }
        .mytime{
        	margin-top: 180px;
        }
        body{
			height: 630px;
			background: url(images/mainbg.jpg);
			background-size: cover;
		}
    </style>
</head>
<body class="metro">
    <div class="container">
        <header class="margin20 nrm nlm">
            <div class="clearfix">
                <div class="place-right">
                    <form>
                        <div class="input-control text size6 margin20 nrm">
                            <input type="text" name="q" placeholder="Search...">
                            <button class="btn-search"></button>
                        </div>
                    </form>
                </div>
                <a class="place-left" href="#" title="">
                    <h1>Yanoda System</h1>
                </a>
            </div>

<!--             <div class="main-menu-wrapper">
                <ul class="horizontal-menu nlm">
                    <li><a href="#">news</a></li>
                    <li><a href="#">sports</a></li>
                    <li><a href="#">entertainment</a></li>
                    <li><a href="#">money</a></li>
                    <li><a href="#">autos</a></li>
                    <li><a href="#">living</a></li>
                    <li><a href="#">health</a></li>
                    <li class="place-right">
                        <a href="#" class="dropdown-toggle">options</a>
                        <ul class="dropdown-menu place-right" data-show="hover">
                            <li><a href="#">Go to Classic MSN</a></li>
                            <li><a href="#">MSN Worldwide</a></li>
                        </ul>
                    </li>
                </ul>
            </div> -->
        </header>
        
        <div class="main-content clearfix main">
            <div class="tile-area no-padding clearfix">
                <div class="tile-group no-margin no-padding1 clearfix" style="width: 100%;">
                    <div class="tile quadro double-vertical ol-transparent">
						<div class="tile-content">
							<div class="carousel" data-controls="false" data-width="100%" data-height="100%" data-role="carousel" style="width: 100%; height: 100%;">
								<div class="slide" style="left: -510px;">
								<img src="images/1.jpg">
								</div>
								<div class="slide" style="left: 0px; display: block;">
								<img src="images/2.jpg">
								</div>
								<div class="slide" style="left: -510px; display: block;">
								<img src="images/3.jpg">
								</div>
							</div>
						</div>
                    </div>
                    <div class="tile quadro double-vertical ol-transparent">
						<div class="tile-content icon bg-darkRed">
						<i class="icon-play-alt"></i>
						</div>
						<div class="brand bg-black">
							<span class="label fg-white">Player</span>
							<div class="badge bg-darkRed paused"></div>
						</div>
                    </div>
                    <div class="tile double ol-transparent">
                    	<div class="tile-content icon bg-amber">
						<i class="icon-alarm-clock"></i>
						</div>
						<div class="brand">
							<span class="label fg-white">时间</span>
						</div>
                    </div>
                    <div class="tile ol-transparent">
						<div class="tile-content icon bg-darkRed">
							<i class="icon-upload-3"></i>
						</div>
						<div class="brand">
							<span class="label fg-white">上传</span>
						</div>
                    </div>
                    <div class="tile ol-transparent">
						<div class="tile-content icon bg-darkBlue">
							<i class="icon-download-2"></i>
						</div>
						<div class="brand">
							<span class="label fg-white">下载</span>
						</div>
                    </div>
                    <div class="tile ol-transparent">
						<div class="tile-content icon bg-darkPink">
							<i class="icon-bell"></i>
						</div>
						<div class="brand">
							<span class="label fg-white">提醒</span>
							<span class="badge bg-orange">3</span>
						</div>
                    </div>
                    <div class="tile ol-transparent">
                    	<div class="tile-content icon bg-green">
							<i class="icon-mail"></i>
						</div>
                    	<div class="brand">
							<span class="label fg-white">邮件</span>
						</div>
                    </div>
                    <div class="tile double ol-transparent">
                        <div class="tile-content icon bg-blue">
							<i class="icon-rainy-3"></i>
						</div>
                    	<div class="brand">
							<span class="label fg-white">天气</span>
						</div>
                    </div>
                </div>
            </div>
        </div> <!-- End of tiles -->
        
        <footer>
            <div class="bottom-menu-wrapper">
                <ul class="horizontal-menu compact">
                    <li>&copy; 2015 Yanoda</li>
                    <li><a href="#">Privacy</a></li>
                    <li><a href="#">Legal</a></li>
                    <li><a href="#">Advertise</a></li>
                    <li><a href="#">Help</a></li>
                    <li><a href="#">Feedback</a></li>
                </ul>
            </div>
        </footer>
    </div>

    <script src="js/hitua.js"></script>

</body>
</html>