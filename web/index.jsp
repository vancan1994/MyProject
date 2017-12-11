<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>PetsDaNang</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="styles/bootstrap.min.js" type="text/javascript"></script>
        <script src="styles/jquery.min.js" type="text/javascript"></script>
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
        
    </head>
    <body>
        <!--Phần header của trang chủ -->
        <c:choose>
            <c:when test="${checkLogin=='0'}">
                <c:import url="/includes/header.jsp"/>
            </c:when>
            <c:when test="${checkLogin=='1'}">
                <c:import url="/includes/headerUser.jsp"/>
            </c:when>
        </c:choose>
        
        <!--Phần header của trang chủ -->
        
        <!--Phần slider -->
        
        <div class="hom-slider">        
            
        </div>
        
        <!--Phần slider -->
        
        <div class="clearfix"></div>
        
        <!--Phần Show sản phẩm -->
        
        <div class="container">
            
            <!--Phần Show sản phẩm bán chạy -->
            
            <div class="hot-products">
                <h3 class="title">Sản phẩm <strong>Chó</strong></h3>
                
                <!--button di chuyển slide sản phẩm -->
                
                <div class="control">
                    <a id="prev_hot" class="prev" href="#" style="display: block;">&lt;</a>
                    <a id="next_hot" class="next" href="#" style="display: block;">&gt;</a>
                </div>
                
                <!--button di chuyển slide sản phẩm -->
                
                <!--List sản phẩm bán chạy từ databse -->
                
                <div class="caroufredsel_wrapper" style="display: block; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 1140px; height: 450px; margin: 0px;overflow: hidden;">
                    <ul id="hot" class="no-border" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 5700px; height: 425px; z-index: auto;">
                        <%
                            int i=1;
                        %>
                        <c:forEach var="product" items="${products}">                                         
                            <li class="li_product"style="width: 265px;">
                                <div class="products">
                                    <div class="thumbnail" style="border: none">
                                        <a>
                                            <img style="width:220px; height: 220px"src="images/${product.image}" alt="xin chao"/>
                                        </a>
                                        <a href="HomeServlet?action=detail&amp;productName=${product.productName}"  class="quick-view">Xem Chi tiết</a>
                                    </div>
                                    <div class="productname" name="productName">${product.productName}</div>
                                    <h4 class="price" name="price">${product.price}</h4>
                                    <div class="button_group">
                                        <button class="button add-cart" onclick="location.href='cartServlet?productID=${product.productID}';" type="button" >
                                            Thêm vào giỏ hàng
                                        </button>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                
                <!--List sản phẩm bán chạy từ databse -->
                
            </div>
            
            <!--Phần Show sản phẩm bán chạy -->
            
            <div class="clearfix"></div>
            
            <!--Phần Show sản phẩm mới -->
            <%
               i=1;
            %>
            
            <div class="featured-products">
                <h3 class="title">Sản Phẩm <strong>Mèo</strong></h3>
                
                <!--button di chuyển slide sản phẩm -->
                
                <div class="control">
                    <a id="prev_hot" class="prev" href="#" style="display: block;">&lt;</a>
                    <a id="next_hot" class="next" href="#" style="display: block;">&gt;</a>
                </div>
                
                <!--button di chuyển slide sản phẩm -->
                
                <!--List sản phẩm bán chạy từ databse -->
                
                <div class="caroufredsel_wrapper" style="display: block; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 1140px; height: 450px; margin: 0px;overflow: hidden;">
                    <ul id="hot" class="no-border" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 5700px; height: 425px; z-index: auto;">
                        
                        <c:forEach var="product" items="${products1}">                                         
                            <li class="li_product"style="width: 265px;">
                                <div class="products">
                                    <div class="thumbnail" style="border: none">
                                        <a>
                                            <img style="width:220px; height: 220px"src="images/${product.image}" alt="xin chao"/>
                                        </a>
                                        <a href="HomeServlet?action=detail&amp;productName=${product.productName}"  class="quick-view">Xem Chi tiết</a>
                                    </div>
                                    <div class="productname" name="productName">${product.productName}</div>
                                    <h4 class="price" name="price">${product.price}</h4>
                                    <div class="button_group">
                                        <button class="button add-cart" onclick="location.href='cartServlet?productID=${product.productID}';" type="button" >
                                           Thêm vào giỏ hàng
                                        </button>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>         
                    </ul>
                </div>
            </div>
            
            <!--Phần Show sản phẩm Phổ biến -->
            
            <div class="clearfix"></div>
            
            <!--Phần Show sản phổ biến -->
            
            <div class="featured-products">
                <h3 class="title">Sản Phẩm <strong>Phổ biến</strong></h3>
                
                <!--button di chuyển slide sản phẩm -->
                
                <div class="control">
                    <a id="prev_hot" class="prev" href="#" style="display: block;">&lt;</a>
                    <a id="next_hot" class="next" href="#" style="display: block;">&gt;</a>
                </div>
                
                <!--button di chuyển slide sản phẩm -->
                
                <!--List sản phẩm bán chạy từ databse -->
                
                <div class="caroufredsel_wrapper" style="display: block; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 1140px; height: 450px; margin: 0px;overflow: hidden;">
                    <ul id="hot" class="no-border" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 5700px; height: 425px; z-index: auto;">
                        
                        <c:forEach var="product" items="${products}">                                         
                            <li class="li_product"style="width: 265px;">
                                <div class="products">
                                    <div class="thumbnail" style="border: none">
                                        <a>
                                            <img style="width:220px; height: 220px"src="images/${product.image}" alt="xin chao"/>
                                        </a>
                                        <a href="HomeServlet?action=detail&amp;productName=${product.productName}"  class="quick-view">Xem Chi tiết</a>
                                    </div>
                                    <div class="productname" name="productName">${product.productName}</div>
                                    <h4 class="price" name="price">${product.price}</h4>
                                    <div class="button_group">
                                        <button class="button add-cart" onclick="location.href='cartServlet?productID=${product.productID}';" type="button" >
                                            Thêm vào giỏ hàng
                                        </button>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>        
                    </ul>
                </div>
            </div>
            
            <!--Phần Show sản phẩm Phổ biến -->
            
            <div class="clearfix"></div>
            
            
        </div>
        
        <!--Phần Show sản phẩm -->
        
        <div class="clearfix"></div>
        
        <!--Phần footer -->
        
        <div class="footer">
            <div class="footer-info" style="background:#333333">
                <div class="container">
                    
                    <!--Logo website -->
                    
                    <div class="col-md-3">
                        <div class="footer-logo">
                            <a href="#"><img src="images/logo.png" alt=""></a>
                        </div>
                    </div>
                    
                    <!--Logo website -->
                    
                    <!--Thông tin liên lạc -->
                    
                    <div class="col-md-3 col-sm-6 thongtin">
                        <h4 class="title1"> <strong>Thông tin</strong> liên lạc</h4>
                        <p>Điạ chỉ: 254, Nguyễn Văn Linh, Đà Nẵng</p>
                        <p>Điện thoại : 01228 577 599</p>
                        <p>Email   :  petdanang@gmail.com</p>
                    </div>
                    
                    <!--Thông tin liên lạc -->
                    
                    <!--Hổ trợ khác hàng-->
                    
                    <div class="col-md-3 col-sm-6 thongtin">
                        <h4 class="title1"><strong>Hỗ trợ </strong>khách hàng</h4>
                        <ul class="support">
                            <li><a class="a_1" href="#">Giải đáp</a></li>
                            <li><a class="a_1" href="#">Lựa chọn thanh toán</a></li>
                            <li><a class="a_1" href="#">Nhiều thú cưng đẹp</a></li>
                            <li><a class="a_1" href="#">Nguồn gốc rõ ràng</a></li>
                        </ul>
                    </div>
                    
                    <!--Hổ trợ khác hàng-->
                </div>
            </div>
            
            <!--Phần coppyright-->    
        </div>
        <div class="copyright-info">
            <div class="container">
                <div class="col-md-6">
                    <p>Copyright © 2017. Covered by <strong>HTTC Team</strong> of <strong>Michael Lee</strong></p>
                </div>
            </div>
        </div>
    </div>
    
    <!--Phần coppyright-->  
    
    <!--Phần footer -->
</body>
</html>
