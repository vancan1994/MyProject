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
            .table{
                width: 600px;
                margin-left: 80PX;
            }
            .content{
                float:left;
                margin-left: 300px;
                padding-top: 50px;
            }
            h5{
                color: green;
                margin-left: 80px;
                font-weight: bold;
            }
            a{
                text-decoration: none;
                color: black;
            }
            .a1{
                margin-left: 50px;
                 text-decoration: none;
            }
            .a2{
                margin-left: 68px;
            }
            .a3{
                margin-left: 30px;
            }
            .a4{
                margin-left: 80px;
            }
            #sliderBar{
                position: fixed;
            }
        </style>
    </head>
    <body>
    <!-- import slide bar -->
        <c:import url="../includes/sliderBar.jsp"/>
        <div class="content">
            <h3 style="margin-left: 200px;color: red">CHI TIẾT ĐƠN HÀNG</h3>
            <h5>Họ và tên:<a class="a1">${order.account.firstName}&nbsp;${order.account.lastName}</a></h5><br>
            <h5>Địa chỉ:<a class="a2">${order.account.address}</a></h5><br>
            <h5>Số điện thoại:<a class="a3">${order.account.phone}</a></h5><br>
            <h5>Email:<a class="a4">${order.account.email}</a></h5><br><br>
            <b style="margin-left: 80px;">Danh sách đơn hàng</b><br><br>
             <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${order.cart.items}">
                        <tr>
                            <td> 
                                <img width="60" src="images/${item.product.image}" alt="xxx"/>
                            </td>
                            <td>
                                <br><span>${item.product.productName}</span>
                            </td>
                            <td>
                                <input type="hidden" name="productID" value="${item.product.productID}">
                                <input type="hidden" name="action" value="update">
                                <br><span>${item.quantity}</span>
                            </td> 
                            <td>
                                <br><span>${item.product.price} VND</span>
                            </td>
                            <td>
                                <br><span>${item.totalFormatted} VND</span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h4 style="float: right">Tổng tiền: ${order.invoiceTotal} VNĐ</h2>
        </div>
        
                        
    </body>
</html>
