<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PetsDaNang</title>
        <style>
            html{
                width: auto;
                height: 2000px;
                
            }
            body{
                width: 100%;
              
            }
            .xemtin{
                /*background: #F7544A;*/
            }
            .header_area{
                position: fixed;
                top: 0; 
            }
            .dangtin{
                background: #F7544A;
                border: none;
                color: white;
                height: 30px;
                border-radius: 2px;
                float: right;
                margin-right: 56px;
                margin-top:85px;
            }
            .li_menu_trangchu{
                background: #2c2c2c;
            }
            main{
                /*top:130px;*/
                padding-left:5%;
                padding-right:5%;
                /*height: 700px;*/
                width: auto;
                position: relative;
                padding-top: 1%;
                background-image: url("images/background.jpeg");
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .side-left{
                width:20%;
                border-radius: 1%; 
                height: 100%;
                float: left;
                margin-right: 2%;
                height: 100%;
                position: fixed;
                margin-top: 16px;   
            }
            .posting{
                width: 52%;
                float: left;
                height: 100%;
                margin-left:24%;
            }
            .tieude_baidang{
                text-transform: uppercase;
            }
            
            .noidung{
                width: 90%;
                height: 100%;
                margin-bottom: 20px;
            }
            .anh{
                margin-top:2%;
                margin-left:8%;
                
            }
            
            #singlebutton{
                color: white;
                border: none;
                height: 30px;
                border-radius: 5px;
                margin-left: 110px;
            }
            .chonAnh{
                float: left;
                cursor: pointer;
            }
            .dangTin:focus,textArea:focus{
                outline: none;
            }
            .xembaiviet{
                margin-top: 2%;
            }
            .baidang{
                height:auto;
                background: white;
                border: 1px solid graytext;
                border-radius: 5px;
                box-shadow: 2px 2px 2px 2px gray;
                padding-left: 50px;
                padding-right: 50px;
                padding-top: 15px;
                padding-bottom: 40px;
                margin-bottom: 15px;
            }
            
            
            .image-raotin{
                height:150px;
                width: 30%;
                float: left;
                margin-right: 20px;
            }
            .image1{
                border: 1px solid black;
                height:100%;
                width: 100%;
            }
            .product1{
                width:20%;
                z-index: 2;
                height: 480px;
                float: right;
                overflow: hidden;
                border: none;
                margin-left: 69%;
                margin-top: 25px;
            }
            .product{
                width:90%;
                height:80px;
                border: 1px solid grey;
                margin-left: 15px;
                background: white;
                margin-bottom: 10px;
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
                margin-top: 20px;
            }
            .name-product{
                text-decoration: none;
                cursor: pointer;
                color:#F7544A;
                font-size: 15px;
            }
            .name-product:hover{
                text-decoration: none;
                cursor: pointer;
                color:#F7544A;
                font-size: 15px;
            }
            .price-product{
                color: black; 
                text-decoration: none;
                font-size: 15px;
            }
            .price-product:hover{
                text-decoration: none;
                color: black; 
                text-decoration: none;
            }
            .upload{
                margin-right: 300px;
                margin-top: 5px;
            }
            .info_view{
                color:blue;
                font-size: 18px;
            }
            .acc_infor{
                color:#2c2c2c;
                font-size: 15px;
            }
            .div_search{
                margin-left: 20px;
                padding-top:20px;
                padding-right: 45px;
            }
            .search-query{
                border: 1px solid #F7544A;
                width: 240px;
                height: 30px;            }
            .search-query:focus,.select_loaitin:focus{
                border: 1px solid #F7544A;
                outline: none;
            }
            .form-control{
                width: auto;
            }
            option{
                text-align: center;
            }
            .select_loaitin{
                height: 30px;
                width: 240px;
                border: 1px solid #F7544A;
                
            }
            .lb_type{
            }
            .btn-default:focus{
                
                border: 1px solid #F7544A;
                outline: none;
            }
        </style>
    </head>  
    <body>
        
        <c:choose>
            <c:when test="${checkLogin=='0'}">
                <c:import url="/includes/header.jsp"/>
            </c:when>
            <c:when test="${checkLogin=='1'}">
                <c:import url="/includes/headerUser.jsp"/>
            </c:when>
        </c:choose>
        <script>
            var file = document.forms['form2']['file'].files[0];
        </script>
        <div class="clearfix"></div>
        <main>
            <div class="container-fluid">
            <div class="side-left">
                <form action="PostingServlet?action=timkiem" method="Post">
                    <div class="input-append span12 div_search">
                        <b style="text-align: center;color: #F7544A;margin-left: 80px; font-size: 16px;">TÌM KIẾM TIN</b><br>
                        <label class="lb_type">Tiêu đề</label>
                        <input type="text" class="search-query" placeholder="Tìm kiếm" name="title"><br><br>
                        <label class="lb_type">Loại tin</label><br>
                        <select class="select_loaitin" id="sel1" name="typePosting">
                            <option selected>Loại tin</option>
                            <option>Mua</option>
                            <option>Bán</option>
                            <option>Tìm kiếm</option>
                        </select><br><br>
                        <label class="lb_type">Danh mục</label><br>
                        <select class="select_loaitin" id="sel1" name="category">
                            <option selected>Danh mục</option>
                            <option>Chó</option>
                            <option>Mèo</option>
                            <option>Hamster</option>
                        </select><br><br>
                        <label class="lb_type">Quận</label><br>
                        <select class="select_loaitin" id="sel1" name="address">
                            <option selected>Quận</option>
                            <option>Hải Châu</option>
                            <option>Thanh Khê</option>
                            <option>Sơn Trà</option>
                            <option>Ngũ Hành Sơn</option>
                            <option>Liên Chiểu</option>
                            <option>Cẩm Lệ</option>
                        </select><br><br>
                        <button sclass="btn btn-default" style=" height: 30px;color:#F7544A;border: 1px solid #F7544A;margin-left: 70px;background: white">Tìm kiếm</button>   
                    </div>
                </form>
            </div>
                
            <div class="posting">
                <b style="text-align: center;margin-left: 200px;">${message}</b>
                <div class="xembaiviet">
                    <c:forEach var="posting" items="${postings}">  
                        <div class="baidang">
                            <div class="image-raotin">
                                <img class="image1" src="images/Pomeranian/${posting.image}.png" alt=""/>
                            </div>
                            <div class="header_baidang">
                                <b class="tieude_baidang">${posting.postingTitle}</b><br>
                                <p class="phone info_view">Số điện thoại: ${posting.phone}</p>
                                <p class="Address info_view">Địa chỉ: ${posting.address}</p>
                                <p class="Type info_view">Loại Tin: ${posting.typePosting}</p>
                                <div>
                                    <p class="date acc_infor" style="float:left">Thời gian: ${posting.localDate}</p>
                                    <p class="name acc_infor"style="float:right;color:#F7544A;"><b>${posting.account.firstName}&nbsp${posting.account.lastName}</b></p>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>    
                    </c:forEach>      
                </div>   
            </div>
            <div class="product1" style="position: fixed">
                <p style="color:black;font-size: 20px; text-align: center">Sản phẩm<Strong style="color: #F7544A"> HOT</Strong></p>
                <c:forEach var="product" items="${products}">  
                    <div class="product">
                        <div class="image-hot-product">
                            <img class="img-product" src="images/${product.image}" alt=""/>
                        </div> 
                        <div class="thongtin-product">
                            <a  href="HomeServlet?action=detail&amp;productName=${product.productName}" class="name-product" name="" >${product.productName}</a><br><br>
                            <a class="price-product">Giá: ${product.price}</a>
                        </div>   
                    </div>
                </c:forEach> 
            </div> 
            </div>
        </main>
    </body>
</html>