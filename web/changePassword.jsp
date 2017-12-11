<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PetsDaNang</title>
        <link href="/PetsDaNang/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="/PetsDaNang/styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="/PetsDaNang/styles/bootstrap.min.js" type="text/javascript"></script>
        <script src="/PetsDaNang/styles/jquery.min.js" type="text/javascript"></script>
        <link href="/PetsDaNang/css/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="/PetsDaNang/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="/PetsDaNang/js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="j/PetsDaNang/js/bootstrap.min.js"></script>
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
                height: 100%;
                width:100%;

            }
            .add-product{
                width: 1130px;
                height:532px;
                background: white;
                float:left;
                padding-top: 100px;
            }
            h1{
                margin-bottom: 20px;
                color:red;
                padding-left: 320px;
            }
            
            #singlebutton{
                margin-left: 240px; float: left;
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
                margin-top: 20px;
            }
            .form-horizontal{
                padding: 20px 200px;
            }
        </style>
    </head>
    <body>
        <c:import url="/includes/headerUser.jsp"/>
        <div class="container">
            <div class="add-product">
                <h2 style="margin-left: 450px;">Đổi mật khẩu</h2>  
                <form class="form-horizontal" action="ProFileServlet" method="post">
                    <input type="hidden" name="action" value="doChange">
                    <input type="hidden" name="email" value="${account.email}">
                    
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Mật khẩu cũ</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" name="oldPassword" placeholder="Mật khẩu cũ" class="form-control input-md"  type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Mật khẩu mới</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" name="newPassword" placeholder="Mật khẩu mới" class="form-control input-md"  type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Nhập lại mật khẩu mới</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" name="newPassword2" placeholder="Nhập lại mật khẩu mới" class="form-control input-md"  type="password">
                        </div>
                    </div>
                    <!-- File Button --> 
                    <div class="col-md-12 submit">
                        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Thay đổi</button><br><br><br>
                        <p style="color: red;margin-left: 240px">${message}</p>
                        <p style="color: green;margin-left: 240px">${message1}</p>
                </form>    
            </div>
        </div>            
    </body>
</html>
