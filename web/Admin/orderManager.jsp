<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PetsDaNang</title>
        <link href="/PetsDaNang/styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="/PetsDaNang/styles/bootstrap.min.js" type="text/javascript"></script>
        <script src="/PetsDaNang/styles/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/PetsDaNang/css/slideBar.css"/>
        <style>
            html{
                margin: 0;
                padding: 0;
                height: 100%;
                width:100%;
                font-family: Times New Roman;
                zoom:100%;
            }
            body{
                background: url("/PetsDaNang/images/giaodien-admin.jpg");
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

            .main{
               padding-top: 10px;
               padding-left: 250px;
               padding-right:50px;
            }
            .add-product{
                width:450px;
                height:530px;
                background: white;
                box-shadow: 2px 2px 2px 2px grey;
                float:left;
                padding-top:10px; 
            }
            h1{
                margin-left: 100px;
                float:left;
            }
            
            #singlebutton{
                margin-left: 160px;
            }
            .h1_them{
                margin-left:140px;
            }
            .height{
                width:250px;
            }
            select{
               height: 34px; 
            }
            .name_product{
                font-weight: bold;
            }
            .message{
                float:left;
                color:blue;
                padding-top: 11px;
            }
            .submit{
             margin-top: 10px;   
            }
            h2{
                font-size: 35px;
            }
            th,td{
                text-align: center;
            }
            .xem{
                color:blue;
                cursor: pointer;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
            <!-- import slide bar -->
            
                <c:import url="../includes/sliderBar.jsp"/>
                
            <!-- import slide bar -->
            
            <!-- main content -->
            
                <div class="main">
                    <h1>DANH SÁCH ĐƠN HÀNG</h1>
                    
                    <!--Phần div lấy danh sách sản phẩm-->
                    
                    <div  class="list_Product">
                        
                        <!-- Danh sách tấc cả sản phẩm -->
                        
                        <table class="table table-hover">
                            
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Tên khách hàng</th>
                                    <th>Địa chỉ</th>
                                    <th>Ngày đặt</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th>Duyệt<th>
                                </tr>
                            </thead>
                            
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <!--Phần nội dung của danh sách sản phẩm lấy từ database PetsDaNang--->
                            <tbody> 
                                <!--Dùng vòng lọc foreach để lấy danh sách products từ database trong servelet--> 
                                <c:forEach var="order" items="${orders}">
                                    
                                    <tr>
                                        <td style="color:green">${order.orderID}</td>
                                        <td>${order.account.firstName}&nbsp;${order.account.lastName}</td>
                                        <td>${order.account.address}</td>
                                        <td>${order.dateOrder}</td>
                                        <td>${order.invoiceTotalFormat} VND</td>
                                        <c:if test = "${order.status==0}">
                                          <td style="color:red">Chưa đuyệt</td>
                                          <td><a  href="OrderManagerServlet?action=duyet&amp;orderID=${order.orderID}">Duyệt</a></td>   
                                        </c:if>
                                          <c:if test = "${order.status==1}">
                                          <td style="color:green">Đã duyệt</td>
                                          <td><a  href="OrderManagerServlet?action=huy&amp;orderID=${order.orderID}">Huỷ</a></td>   
                                        </c:if>
                                          <td><a href="OrderManagerServlet?action=xem&amp;orderID=${order.orderID}"class="xem">Xem chi tiết</a></td>
                                       
                                    </tr>
                                </c:forEach>
                                    
                                <!--Dùng vòng lọc foreach để lấy danh sách products từ database trong servelet-->
                                
                            </tbody>
                            
                            <!--Phần nội dung của danh sách sản phẩm lấy từ database PetsDaNang--->
                            
                        </table>
                        
                        <!---Danh sách tấc cả sản phẩm--->
                        
                        <!--Tìm sản phẩm-->
                        
                        <div class="search-products">
                            
                        </div>
                        
                        <!--Tìm sản phẩm-->
                    
                    </div>
                    
                    <!--Phần div lấy danh sách sản phẩm-->
                    
                  
                </div>
            
            <!-- main content -->       
    </body>
</html>
