<%-- 
    Document   : header
    Created on : Nov 4, 2017, 11:22:26 AM
    Author     : PhiLong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/styles/header.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
<style>
    @media (min-width: 767px) {
        .navbar-nav .dropdown-menu .caret {
            transform: rotate(-90deg);
        }
    }
</style>
<script>
    $(document).ready(function() {
        $('.navbar a.dropdown-toggle').on('click', function(e) {
            var $el = $(this);
            var $parent = $(this).offsetParent(".dropdown-menu");
            $(this).parent("li").toggleClass('open');

            if(!$parent.parent().hasClass('nav')) {
                $el.next().css({"top": $el[0].offsetTop, "left": $parent.outerWidth() - 4});
            }

            $('.nav li.open').not($(this).parents("li")).removeClass("open");

            return false;
        });
    });
</script>
<header class="header_area">
    
    <div class="clearfix"></div>
    
    <!--Phần menu chính và tìm kiếm -->
    
    <section class="main_menu_area">
        <div class="container-fluid">
            
            <!--Phần menu chính-->
            
            <div class="navbar navbar-default navbar-fixed-top" role="navigation" style="border-color: #2c2c2c;; background-color: #2c2c2c;">
                <div class="col-sm-12">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="HomeServlet">HTTC Team</a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="HomeServlet">Trang Chủ</a></li>
                            <li>
                                <a href="searchServlet?action=viewDog&search=dog">Chó</a>
                            </li>
                            <li>
                                <a href="searchServlet?action=viewCat&search=cat">Mèo</a>
                            </li>
                            <li>
                                <a href="searchServlet?action=viewHamster&search=hamster">Hamster</a>
                            </li>
                            <li>
                                <a href="searchServlet?action=viewOther&search=other">Khác</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav">
                            <div class="navbar-brand pull-right search_area">
                                <form class="form" action="searchServlet" method="post" >
                                    <input type="hidden" action="user" value="1">
                                    <div class="input-group">
                                        <input type="text" name="search"class="input_search">
                                        <span class="span" >
                                            <button type="submit" class="bt_submit" value="" style="background:black;">
                                                <i class="fa fa-search"><img class="img_search" src="images/search.png"/></i>
                                            </button>
                                        </span>
                                    </div>
                                </form>
                            </div>
                        </ul>
                        <ul class="nav navbar-nav" style="margin-left: 5%;">
                            <li><a class="giohang" href="cartServlet"><span class="glyphicon glyphicon-shopping-cart"></span>Giỏ hàng</a></li>
                            <li style="height: 50px;">
                                <div align="center" style="margin-top: 17px;">
                                    <span style="color:white;">Xin chào:</span>
                                    <a href="ProFileServlet?email=${account.email}" style="text-decoration: none;" class="personal" href="cartServlet" name="email">
                                        <span style="color: #337ab7;">${account.lastName}</span>
                                    </a>
                                </div>
                            </li>
                            <li><a class="a_menu xemtin" style="text-transform: lowercase;" href="PostingServlet">Xem Tin</a></li>
                            <li><a class="dangtin1" href="PostingServlet?action=taotin&amp;email=${account.email}">Đăng tin</a></li>
                            <li><a class="giohang" href="LogoutServlet">Đăng xuất</a></li>
                        </ul>
                        
                    </div><!--/.nav-collapse -->
                </div>
            </div>
            
            <!--Phần menu chính-->
            
            <!--Phần tìm kiếm -->
            
            <div class="navbar-brand pull-right search_area">
                <form class="form" action="searchServlet" method="post" >
                    <div class="input-group">
                        <input type="text" name="search"class="input_search">
                        <span class="span" >
                            <button type="submit" class="bt_submit" value="" style="background:black;">
                                <i class="fa fa-search"><img class="img_search" src="images/search.png"/></i>
                            </button>
                        </span>
                    </div>
                </form>
            </div>
            
            <!--Phần tìm kiếm -->
            
        </div>
    </section>
    
    <!--Phần menu chính và tìm kiếm -->
    
</header>

