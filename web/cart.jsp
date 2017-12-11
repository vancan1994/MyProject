<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .btnLogin {
                background-color: #DDDDDD;
                border-radius: 6%;
            }
            html{
                margin: 0;
                padding: 0;
                height: 100%;
                width:100%;
                font-family: Times New Roman;
                zoom:100%;
            }
            body{

            }
            #mainBody{
               
                
            }
            main{
                text-align: center;

            }
            .list_Product{
                width:100%;
                height:300px;
                background: white;
                box-shadow: 2px 2px 2px 2px grey;
                float:left;
                margin-right: 10px;
            }
            h1{
                margin-left: 100px;
                float:left;
            }
            
            #singlebutton{
                margin-left: -160px;
            }
            .h1_them{
                margin-left:140px;
            }
            .height{
                width:250px;
            }
            .danhmuc{
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
            th{
                text-align: center;
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
        
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="HomeServlet">Trang chủ</a> <span class="divider"></span></li>
                            <li class="active">giỏ hàng</li>
                        </ul>
                        <h3 style="color:green">  GIỎ HÀNG</h3>	
                        <c:choose>
                            <c:when test="${cart.count==0}">
                                <p style="color:red;font-size: 20px;    margin-left: 400px">Không có sản phẩm trong giỏ hàng</p>
                            </c:when>
                            <c:when test="${cart.count>0}">    
                            <hr class="soft"/> 
                            <span style="color: red;text-transform: uppercase;"></span>
                                <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Giá</th>
                                        <th>Thành tiền</th>
                                        <th>Cập nhật</th>
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${cart.items}">
                                        <tr>
                                            <td> 
                                                <img  style="margin-left: 30px;" width="100px" height="80px"  src="images/${item.product.image}" alt="xxx"/>
                                            </td>
                                            <td>
                                                <span>${item.product.productName}</span>
                                            </td>
                                            <td>
                                                <input type="hidden" name="productID" value="${item.product.productID}">
                                                <input type="hidden" name="action" value="update">
                                                <input style="width: 60px;text-align: center;"id="quantity${item.product.productID}" type="text" name="quantity" value="${item.quantity}">
                                            </td> 
                                            <td>
                                                <span>${item.price}</span>
                                            </td>
                                            <td>
                                                <span>${item.totalFormatted}</span>
                                            </td>
                                            <td>
                                                <a id="update${item.product.productID}" class="btn btn-info">Update</a>
                                                <script>
                                                    $(document).ready(function() {
                                                        $("#update${item.product.productID}").click(function(){
                                                            var quantity${item.product.productID} = $("#quantity${item.product.productID}").val();
                                                            var href = '/PetsDaNang/cartServlet?action=update&quantity='+quantity${item.product.productID}+'&productID=${item.product.productID}';
                                                            window.location.href = href;
                                                        });
                                                    });
                                                </script>
                                            </td>
                                            <td>
                                                <form>
                                                    <input type="hidden" name="productID" value="${item.product.productID}">
                                                    <input type="hidden" name="quantity" value="0">
                                                    <input class="btn btn-danger" type="submit" value="Xóa">
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            
                    </div>
                </div>
            </div>
        </div>
        <form action="" method="post">
            <input type="hidden" name="action" value="checkout">
            <button id="singlebutton" style="margin-left: 500px"  class="btn btn-primary"><a href="HomeServlet" style="text-decoration: none;color: white;">Mua tiếp</a></button>
            <c:choose>
                <c:when test="${checkLogin=='0'}">
                    <button id="singlebutton" style="margin-left:10px" name="singlebutton" class="btn btn-primary"><a href="cartServlet?action=checkNoacc" style="text-decoration: none;color: white;">Đặt hàng</a></button>
                </c:when>
                <c:when test="${checkLogin=='1'}">
                    <button id="singlebutton" style="margin-left:10px" name="singlebutton" class="btn btn-primary"><a href="cartServlet?action=check" style="text-decoration: none;color: white;">Đặt hàng</a></button>
                </c:when>
            </c:choose>
            
            <br><br><p style="text-align: center;color:green;margin-right: 200px;" >${message}</p>
        </form>
            </c:when>
        </c:choose>
    </body>
</html>
