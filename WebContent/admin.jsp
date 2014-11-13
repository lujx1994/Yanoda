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
	<script type="text/javascript">  
		function del(){  
		    if(confirm("一经删除,不可恢复,是否现在删除?")){  
		        return true;  
		    }  
		    return false;  
		}  
	</script> 
    
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

    <title>管理员</title>
    
</head>
<body class="metro">
    <header class="bg-dark" data-load="header.html">
    <div class="navbar">
                <div class="navbar-content">

                    <a href="#" class="element"><span class="icon-grid-view"></span> Yanoda System <sup>1.0</sup></a>
                    <span class="element-divider"></span>

                    <a class="pull-menu" href="#"></a>

                    <div class="no-tablet-portrait">
                        <span class="element-divider"></span>
                        <span class="element-divider"></span>

                        <div class="element place-right">
                            <a class="dropdown-toggle" href="index.jsp"><span class="icon-cog"></span></a>
                            <ul class="dropdown-menu place-right" data-role="dropdown">
                                <li><a href="changepassword">修改密码</a></li>
                                <li><a href="logout">安全退出</a></li>
                            </ul>
                        </div>
                        <span class="element-divider place-right"></span>
                        <button class="element image-button image-left place-right">
                            管理员
                            <i class="icon-user-2 mypic"></i>
                        </button>
                    </div>
                </div>
            </div>
    </header>
    <div class="container">
	        <h1>
	            <a href="#"><i class="icon-arrow-left-3 fg-darker smaller"></i></a>
	            	管理员
	        </h1>
	        
	        <div style="margin-top: 40px">
            </div>
            
            
            
			<div class="tab-control" data-role="tab-control" id="tab-with-event">
			    <ul class="tabs">
			        <li class="active"><a href="#_page_1">用户表</a></li>
			        <li><a href="#_page_2">文件表</a></li>
			        <!-- <i class="icon-spin"></i> -->
			        <button class="place-right"><s:a href="admin.action">刷新</s:a></button>
			    </ul>
			    <div class="frames">
			        <div class="frame" id="_page_1">
			            <table class="table striped bordered hovered">
			                <thead>
			                <tr>
			                	<th class="text-left">ID</th>
			                    <th class="text-left">用户名</th>
			                    <th class="text-left">用户密码</th>
			                    <th class="text-left">用户真实姓名</th>
			                    <th class="text-left">下级用户</th>
			                    <th class="text-left">用户级别</th>
			                </tr>
			                </thead>
			
			                <tbody>
			                <s:iterator value="#request.alluserlist" id="us">
			                <tr class="">
			                <td><s:property value="#us.id"/></td>			                
			                <td class="right"><s:property value="#us.user_name"/></td>
			                <td class="right"><s:property value="#us.user_password"/></td>
			                <td class="right"><s:property value="#us.user_realname"/></td>
			                <td class="right"><s:property value="#us.lower_users"/></td>
			                <td class="right">
				                <s:if test="#us.range==1">部门经理</s:if>
				                <s:elseif test="range==2">分管领导</s:elseif>
				                <s:elseif test="range==3">总经理</s:elseif>
				                <s:elseif test="range==4">超级管理员</s:elseif>
				                <s:else>未知职位</s:else>
				                <s:if test="#us.user_name=='admin'">
				                <p class="place-right"><s:a href="showUserBeforeUpdate.action?user.id=%{#us.id}">修改超级管理员</s:a></p>
				                </s:if>
				                <s:else>
				                <p class="place-right"><s:a href="showUserBeforeUpdate.action?user.id=%{#us.id}">修改</s:a></p>
								<p class="place-right"><s:a href="deleteuser.action?user.id=%{#us.id}" onclick="return del()">删除</s:a>|</p>
								</s:else>
			                </td>
			                </tr>
			                </s:iterator>
			                </tbody>
			            </table>
			            <a href="adminadduser.jsp"><button>新增用户</button></a>
			        </div>
			        
			        <div class="frame" id="_page_2">
						<table class="table striped bordered hovered">
			                <thead>
			                <tr>
			                	<th class="text-left">ID</th>
			                    <th class="text-left">复命人</th>
			                    <th class="text-left">复命文件名</th>
			                    <th class="text-left">复命文件路径</th>
			                    <th class="text-left">提交时间</th>
			                    <th class="text-left">下载</th>
			                    <th class="text-left">复命状态</th>
			                </tr>
			                </thead>
			
			                <tbody>
			                <s:iterator value="#request.allformlist" id="fo">
			                <tr class="">
			                <td><s:property value="#fo.id"/></td>
			                <td class="right"><s:property value="#fo.poster_name"/></td>
			                <td class="right"><s:property value="#fo.form_name"/></td>
			                <td class="right"><s:property value="#fo.form_realpath"/></td>
			                <td class="right"><s:property value="#fo.form_date"/></td>
			                <td class="right"><s:property value="#fo.download"/></td>
			                <td class="right">
			                <s:if test="#fo.confirm==true">已审核</s:if>
			                <s:else>未审核</s:else>
			                <p class="place-right"><s:a href="showFormBeforeUpdate.action?form.id=%{#fo.id}">修改</s:a></p>
							<p class="place-right"><s:a href="deleteform.action?form.id=%{#fo.id}" onclick="return del()">删除</s:a>|</p>
			                </td>
			                </tr>
			                </s:iterator>
			                </tbody>
			            </table>
					</div>
					
			    </div>
			</div>
			


        </div>
        
		<script>
		    $(function(){
		        $("#tab-with-event").tabcontrol().bind("tabcontrolchange", function(event, frame){
		        /* 	window.location.href="AdminAction.action"; */
		        })
		    })
		</script>
</body>
</html>