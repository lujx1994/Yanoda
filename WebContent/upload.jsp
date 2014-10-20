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

    <title>Metro UI CSS : Metro Bootstrap CSS Library</title>
</head>
<body class="metro">
    <header class="bg-dark" data-load="header.html">
    <div class="navbar">
                <div class="navbar-content">

                    <a href="/" class="element"><span class="icon-grid-view"></span> Yanoda System <sup>1.0</sup></a>
                    <span class="element-divider"></span>

                    <a class="pull-menu" href="#"></a>
                    <ul class="element-menu">
                        <li>
                            <a class="dropdown-toggle" href="#">Base CSS</a>
                            <ul class="dropdown-menu" data-role="dropdown">
                                <li><a href="requirements.html">Requirements</a></li>
                                <li>
                                    <a href="#" class="dropdown-toggle">General CSS</a>
                                    <ul class="dropdown-menu" data-role="dropdown">
                                        <li><a href="global.html">Global styles</a></li>
                                        <li><a href="grid.html">Grid system</a></li>
                                        <li><a href="typography.html">Typography</a></li>
                                        <li><a href="tables.html">Tables</a></li>
                                        <li><a href="forms.html">Forms</a></li>
                                        <li><a href="buttons.html">Buttons</a></li>
                                        <li><a href="images.html">Images</a></li>
                                    </ul>
                                </li>
                                <li class="divider"></li>
                                <li><a href="responsive.html">Responsive</a></li>
                                <li class="disabled"><a href="layouts.html">Layouts and templates</a></li>
                                <li class="divider"></li>
                                <li><a href="icons.html">Icons</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="dropdown-toggle"  href="#">Community</a>
                            <ul class="dropdown-menu" data-role="dropdown">
                                <li class="disabled"><a href="http://blog.metroui.net">Blog</a></li>
                                <li class="disabled"><a href="http://forum.metroui.net">Community Forum</a></li>
                                <li class="divider"></li>
                                <li><a href="https://github.com/olton/Metro-UI-CSS">Github</a></li>
                                <li class="divider"></li>
                                <li><a href="https://github.com/olton/Metro-UI-CSS/blob/master/LICENSE">License</a></li>
                            </ul>
                        </li>
                    </ul>

                    <div class="no-tablet-portrait">
                        <span class="element-divider"></span>
                        <a class="element brand" href="#"><span class="icon-spin"></span></a>
                        <a class="element brand" href="#"><span class="icon-printer"></span></a>
                        <span class="element-divider"></span>

                        <div class="element input-element">
                            <form>
                                <div class="input-control text">
                                    <input type="text" placeholder="Search...">
                                    <button class="btn-search"></button>
                                </div>
                            </form>
                        </div>

                        <div class="element place-right">
                            <a class="dropdown-toggle" href="index.jsp"><span class="icon-cog"></span></a>
                            <ul class="dropdown-menu place-right" data-role="dropdown">
                                <li><a href="#">Products</a></li>
                                <li><a href="#">Download</a></li>
                                <li><a href="#">Support</a></li>
                                <li><a href="#">Buy Now</a></li>
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
            DataTables<small class="on-right">plugin</small>
        </h1>

<!--         <p class="padding20 bg-grayLighter">
            DataTables is a plug-in for the jQuery Javascript library written by <a href="http://www.sprymedia.co.uk/">SpryMedia</a>. It is a highly flexible tool, based upon the foundations of progressive enhancement, which will add advanced interaction controls to any HTML table.
        </p> -->

<!--         <p class="description">
            Metro UI CSS provides style support for DataTables.
        </p> -->

             <form>
                <fieldset>
                    <legend>Legend</legend>
                    <div class="input-control file" data-role="input-control">
                        <input type="file">
                        <button class="btn-file"></button>
                    </div>
                    <div class="input-control checkbox" data-role="input-control">
                        <label class="inline-block">
                            <input type="checkbox" />
                            <span class="check"></span>
                            Check me out
                        </label>
                        <label class="inline-block">
                            <input type="checkbox" checked />
                            <span class="check"></span>
                            Check me out
                        </label>
                        <label class="inline-block">
                            Check me out
                            <input type="checkbox" disabled/>
                            <span class="check"></span>
                        </label>
                        <label class="inline-block">
                            Check me out
                            <input type="checkbox" disabled checked/>
                            <span class="check"></span>
                        </label>
                        <label class="inline-block">
                            Intermediate
                            <input type="checkbox" data-show="intermediate"/>
                            <span class="check"></span>
                        </label>
                    </div>

                    <div>
                        <div class="clearfix">
                        <div class="input-control radio inline-block" data-role="input-control">
                            <label class="inline-block">
                                <input type="radio" name="r1" checked />
                                <span class="check"></span>
                                R1
                            </label>
                            <label class="inline-block">
                                <input type="radio" name="r1"  />
                                <span class="check"></span>
                                R1
                            </label>
                        </div>
                        <div class="input-control radio default-style inline-block" data-role="input-control">
                            <label class="inline-block">
                                <input type="radio" name="r2" checked />
                                <span class="check"></span>
                                R1
                            </label>
                            <label class="inline-block">
                                <input type="radio" name="r2" />
                                <span class="check"></span>
                                R2
                            </label>
                        </div>
                        </div>
                        <div class="input-control switch" data-role="input-control">
                            <label class="inline-block" style="margin-right: 20px">
                                Switch me
                                <input type="checkbox" checked/>
                                <span class="check"></span>
                            </label>
                            <label class="inline-block">
                                <input type="checkbox" disabled/>
                                <span class="check"></span>
                                Switch disabled
                            </label>
                        </div>
                    </div>

                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                    <input type="button" value="Button">

                    <div style="margin-top: 20px">
                    </div>

                </fieldset>
            </form>
        </div>

    <script src="js/hitua.js"></script>

</body>
</html>