<%-- 
    Document   : details
    Created on : Nov 4, 2017, 11:19:30 AM
    Author     : PhiLong
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="styles/bootstrap.min.js" type="text/javascript"></script>
        <script src="styles/jquery.min.js" type="text/javascript"></script>
        <link href="css/w3.css" rel="stylesheet" type="text/css"/>
         <title>PetsDaNang</title>
    </head>
    <style>
        html{
            height: auto;
            width: auto;
        }
        .main{
            padding: 0 100px;
            
            padding-top:40px;
            clear: both;
        }
        .image{
            height: 400px;
            width:30%;
            border: 1px solid graytext;
            padding:40px;
            float:left;
        }
        .main-image{
            width: 260px;
            height: 240px;
            margin-bottom: 10px;
        }
        .image-small{
            width: 60px;
            height: 60px;
            margin-right: 2px;
            cursor: pointer;
        }
        .detail{
            height: 400px;
            width: 60%;
            border: 1px solid graytext;
            margin-left:32%;
            margin-right: 10px;
            padding: 20px;
        }
        .hot-product{
            height: 400px;
            width: 300px;
            border: 1px solid graytext;
            float: right;
            padding: 10px;
        }
        .detail-product{
            float:left;
            width: 1150px;
            
        }
        .price1{
            padding-top:10px;
            border-bottom: 1px solid graytext;
            height: 80px;
        }
        .mySlides{
            height: 250px;
            width: 200px;
        }
        i-product{
            float: left;
        }
        .h-product{
            float: left;
        }
        .add-cart:hover{
            border-color: #f7544a;
            color: #fff;
            background-color: #f7544a;
        }
         .add-cart{
            text-decoration: none;
            color:#434343;
        }
        .add-cart:hover{
            color: white;
            text-decoration: none;
        }
.image-hot-product{
            float: left;
            width: 40%;

        }
        .img-product{
            width:96px;
            height: 78px;
        }
        .thongtin-product{
            margin-top: 10px;
        }
        .name-product{
            text-decoration: none;
            cursor: pointer;
            color:#F7544A;
        }
        .name-product:hover{
            text-decoration: none;
            cursor: pointer;
            color:#F7544A;
        }
        .price-product{
         color: black; 
         text-decoration: none;
        }
        .price-product:hover{
            text-decoration: none;
            color: black; 
            text-decoration: none;
        }
        .products{
            height: 400px;
            width: 300px;
            border: 1px solid graytext;
            float: right;
            padding: 10px;
            overflow: hidden;
        }
    </style>
    

    <body>
        <c:import url="/includes/header.jsp"/>
        
        <div class="main">
            <h2>CHI TIẾT <strong>SẢN PHẨM</strong></h2>
            <!-- anh cua trang chi tiêt -->
            <div class="detail-product">
                <div class="image">
                    <div>
                        <img class="main-image" src="images/${product.image1}" alt=""/>
                        <img class="main-image" src="images/${product.image2}" alt=""/>
                        <img class="main-image" src="images/${product.image3}" alt=""/>
                        <img class="main-image" src="images/${product.image4}" alt=""/>
                    </div>
                    <div >
                        <img class="image-small" src="images/${product.image1}" onclick="currentDiv(1)"alt=""/>
                        <img class="image-small" src="images/${product.image2}" onclick="currentDiv(2)" alt=""/>
                        <img class="image-small" src="images/${product.image3}" onclick="currentDiv(3)" alt=""/>
                        <img class="image-small" src="images/${product.image4}" onclick="currentDiv(4)" alt=""/>
                    </div>
                </div>
                <script>
                        var slideIndex = 1;
                        showDivs(slideIndex);

                        function plusDivs(n) {
                          showDivs(slideIndex += n);
                        }

                        function currentDiv(n) {
                          showDivs(slideIndex = n);
                        }

                        function showDivs(n) {
                          var i;
                          var x = document.getElementsByClassName("main-image");
                          var dots = document.getElementsByClassName("image-small");
                          if (n > x.length) {slideIndex = 1;}
                          if (n < 1) {slideIndex = x.length;}
                          for (i = 0; i < x.length; i++) {
                             x[i].style.display = "none";
                          }
                          for (i = 0; i < dots.length; i++) {
                             dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
                          }
                          x[slideIndex-1].style.display = "block";
                          dots[slideIndex-1].className += " w3-opacity-off";
                        }
                    </script>
                <!-- anh cua trang chi tiêt -->
                <div class="detail">
                    <h4 class="productName" name="productName"><b>${product.productName}</b></h4>
                    <div style="height: 150px; margin-bottom:5px;border-top: 1px solid graytext;border-bottom: 1px solid graytext; ">
                        <p class="description" style="color:black;padding-top:22px;"name="description">${product.description}</p>
                    </div>
                    <div style="">  
                        <h3 class="price1">Giá:<strong style="margin-left: 200px; font-size:30px;">${product.price}</strong></h3>
                    </div>
                    <div class="button_group" style="padding-top:10px;">
                        <button class="button add-cart" type="button"><a href="cartServlet?productID=${product.productID}" class="add-cart">Thêm vào giỏ hàng</a></button>
                    </div>
                </div>
            <!-- san pham dang hot -->
            </div>
        </div>
    </body>
</html>
