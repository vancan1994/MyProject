<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: auto;">
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
                height: auto;
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
                height:100%;
                background: white;
                float:left;
            }
            h1{
                margin-bottom: 40px;
               
                padding-left: 250px;
                
            }
            
            #singlebutton{
                margin-left: 400px; float: left;
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
            }
        </style>
    </head>
    <body>
        <c:import url="/includes/headerUser.jsp"/>
        <div class="container" style="height:  100%">
            <div class="add-product">
                <h1 style=" color:red;">THÔNG TIN NGƯỜI DÙNG</h1>  
                <form class="form-horizontal" action="ProFileServlet" method="post">
                    <!-- Text input-->
                    <input type="hidden" name="action" value="update">
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Họ</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" value="${account.firstName}" name="firstname" placeholder="Họ" class="form-control input-md"  type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Tên</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" value="${account.lastName}" name="lastname" placeholder="Tên" class="form-control input-md"  type="text">
                        </div>
                   </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label danhmuc">Email</label>  
                        <div class="col-md-4 height" >
                            <input id="product_name" value="${account.email}" name="email" class="form-control input-md"  type="text" readonly="">
                        </div>
                   </div>
                    <!-- Text input-->
                   <div class="form-group">
                     <label class="col-md-4 control-label" >Ngày sinh</label>  
                     <div class="col-md-4 height" >
                         <input id="product_name" name="birthday" value="${account.birthday}" placeholder="Ngày sinh" class="form-control input-md" type="text" pattern="\d{4}-\d{1,2}-\d{1,2}" title="yyyy-MM-dd">
                     </div>
                   </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Địa chỉ</label>  
                        <div class="col-md-4 height">
                        <input id="product_name" value="${account.address}" name="address" placeholder="Địa chỉ" class="form-control input-md"  type="text">
                        </div>
                    </div> 
                    <div class="form-group">
                      <label class="col-md-4 control-label" >Số điện thoại</label>  
                      <div class="col-md-4 height">
                      <input id="product_name" value="${account.phone}" name="phone" placeholder="Số điện thoại" class="form-control input-md"  type="text">
                      </div>
                    </div>  
                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" >Giới tính</label>  
                      <div class="col-md-4 height">
                        <c:if test = "${account.sex==1}">   
                          <input id="product_name" value="Nam" name="sex" placeholder="Giới tính" class="form-control input-md"  type="text">
                        </c:if>
                        <c:if test = "${account.sex==0}">   
                          <input id="product_name" value="Nữ" name="sex" placeholder="Giới tính" class="form-control input-md"  type="text">
                        </c:if>
                      </div>
                    </div>
                     
                    <!-- File Button --> 
                    <div class="col-md-12 submit">
                       <button id="singlebutton" name="singlebutton" class="btn btn-primary">Cập Nhập</button>
                       <button name="singlebutton" style="margin-left: 10px;"class="btn btn-primary"><a href="ProFileServlet?action=changePassword&amp;email=${account.email}"  style="color:white;text-decoration: none ;">Đổi mật khẩu</a></button>
                    </div>
                </form>    
            </div>
        </div>            
    </body>
</html>
