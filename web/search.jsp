<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>PetsDaNang</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="styles/bootstrap.min.js" type="text/javascript"></script>
        <script src="styles/jquery.min.js" type="text/javascript"></script>
        <style>
        </style>
        
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
        
        <div class="clearfix"></div>
        
        <!--Phần Show sản phẩm -->
        
        <div class="container" style="min-height: 100%;">
            
            <!--Phần Show sản phẩm bán chạy -->
            <!--            <div class="hot-products">
                            <span>${search}</span>
                        </div>-->
            
            <div class="hot-products">
                <p style="color:black;text-align: center; font-size: 20px">${message}</p>
                <h3 class="title">Danh Sách: <strong style="text-transform: uppercase;">${search}</strong></h3>
                
                <!--button di chuyển slide sản phẩm -->
                
                <div class="control">
                    <a id="prev_hot" class="prev" href="#" style="display: block;">&lt;</a>
                    <a id="next_hot" class="next" href="#" style="display: block;">&gt;</a>
                </div>
                
                <!--button di chuyển slide sản phẩm -->
                
                <!--List sản phẩm bán chạy từ databse -->
                
                <div class="caroufredsel_wrapper" style="display: block; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 100%;">
                    <div class="col-sm-12">
                        <c:choose>
                            <c:when test="${not empty products}">
                                <div style="float:left;">
                                    <span class="btn btn-link" style="text-decoration: none; color: black;">Sort By: </span>
                                </div>
                                <div style="float:left;">
                                    
                                    <form action="searchServlet" method="post">
                                        <button name="action" class="btn btn-link" value="priceSort">Giá</button>
                                        <button name="action" class="btn btn-link" value="nameSort">Tên</button>
                                        <input type="hidden" name="search" value="${search}">
                                    </form>
                                    
                                    
                                </div>
                            </c:when>
                            <c:when test="${empty products}">
                                <span style="color: red;text-transform: uppercase;">Không có sản phẩm nào được tìm thấy!</span>
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="col-sm-12">
                        <ul id="hot" class="no-border" style="text-align: left; ">
                            <c:forEach var="product" items="${products}">                                           
                                <li class="li_product"style="width: 250px;">
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
                
                <!--List sản phẩm bán chạy từ databse -->
                
            </div>
            
            <!--Phần Show sản phẩm bán chạy -->
            
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
        
        <!--Phần coppyright-->  
        
        <!--Phần footer -->
    </body>
</html>
