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
 
</style>
    

    <body>
        <c:import url="/includes/header.jsp"/>
        <div class="main" >
              
                    <div class="add-product">
                        
                            <form class="form-horizontal" action="ProductsManagerServlet" method="post" style="padding-left: 10%">
                               
                                <p style="margin-left: -130px;font-size: 25px">Địa chỉ giao hàng của quý khách</p>
                                <hr>
                                </table>
                                     <h1 style="text-align: center;">THANH TOÁN ĐƠN HÀNG</h1><br>
                                    <input type="hidden" name="action" value="update">
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label danhmuc">Email</label>  
                                    <div class="col-md-4 height" >
                                        <input id="product_name" value="${product.categoryID}" placeholder="Email" name="email" class="form-control input-md"  type="email" required>
                                    </div>
                               </div>
                                 <!-- Text input-->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" >Tên</label>  
                                  <div class="col-md-4 height" >
                                  <input id="product_name" name="productID" value="${product.productID}" placeholder="Họ và tên" class="form-control input-md" type="text" required>
                                  </div>
                                </div>

                                <!-- Text input-->
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="product_name_fr">Địa chỉ</label>
                                    <div class="col-md-4 height">                     
                                        <textarea class="form-control" id="product_name_fr" placeholder="Số nhà, phường, quận, thành phố" name="description">${product.description}</textarea>
                                    </div>
                                </div>
                                <!-- Text input-->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="product_name_fr">Số điện thoại</label>  
                                  <div class="col-md-4 height">
                                  <input id="product_name_fr" name="quantity" value="${product.quantity}" placeholder="Số điện thoại" class="form-control input-md" required>

                                  </div>
                                </div>
                                
                                <div class="col-md-12 submit"><br><br>
                                    <button id="singlebutton"  style="margin-left: 500px" name="singlebutton" class="btn btn-primary">Đặt hàng</button>
                                </div>
                           </form>
    
                    </div>
                </div>
    </body>
</html>
