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
               padding: 50px;
               padding-top: 0px;
            }
            .add-product{
                width:800px;
                height:672px;
                background: white;
                box-shadow: 2px 2px 2px 2px grey;
                float:left;
                padding-top:10px;
                margin-left: 170px;
            }
            h1{
                margin-left: 200px;
                margin-bottom: 20px;
                color:green;
            }
            
            #singlebutton{
                margin-left: 300px;
            }
            .h1_them{
                margin-left:140px;
            }
            .height{
                width:300px;
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
            }
            .form-horizontal{
                margin-left: 50px;
            }
            label{
                color: green;
            }
  
  
        </style>
    </head>
    <body>
            <c:import url="../includes/sliderBar.jsp"/>
                <div class="main">
                    <div class="add-product">
                        <h1>CẬP NHẬP SẢN PHẨM</h1>    
                        <form class="form-horizontal" action="ProductsManagerServlet" method="post">
                                <fieldset>
                                    <input type="hidden" name="action" value="update">
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label danhmuc">Danh mục</label>  
                                    <div class="col-md-4 height" >
                                        <input id="product_name" value="${product.categoryID}" name="categoryID" class="form-control input-md"  type="text" readonly>
                                    </div>
                               </div>

                                 <!-- Text input-->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" >Mã sản phẩm</label>  
                                  <div class="col-md-4 height" >
                                  <input id="product_name" name="productID" value="${product.productID}" placeholder="Mã sản phẩm" class="form-control input-md" type="text" readonly>
                                  </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" >Tên sản phẩm</label>  
                                  <div class="col-md-4 height">
                                  <input id="product_name" value="${product.productName}" name="productName" placeholder="Tên sản phẩm" class="form-control input-md"  type="text"required>

                                  </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="product_categorie">Đơn giá</label>
                                  <div class="col-md-4 height">
                                    <input id="product_name_fr" name="price" value="${product.price}" placeholder="Đơn giá" class=" danhmuc form-control input-md" type="text"required pattern="[0-9]{1,10}"title="Đơn giá phải là số">
                                  </div>
                                </div>

                                <!-- Textarea -->
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="product_name_fr">Mô tả</label>
                                  <div class="col-md-4 height mota">                     
                                    <textarea class="form-control" id="product_name_fr" name="description">${product.description}</textarea>
                                  </div>
                                </div>
                                  <!-- File Button --> 
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="filebutton">Ảnh chính</label>
                                  <div class="col-md-4">
                                    <input id="filebutton" name="image" class="input-file" type="file">
                                  </div>
                                </div>
                                <!-- File Button --> 
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="filebutton">Ảnh1</label>
                                  <div class="col-md-4">
                                    <input id="filebutton" name="image1" class="input-file" type="file">
                                  </div>
                                </div>

                                 <!-- File Button --> 
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="filebutton">Ảnh2</label>
                                  <div class="col-md-4">
                                    <input id="filebutton" name="image2" class="input-file" type="file">
                                  </div>
                                </div>

                                  <!-- File Button --> 
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="filebutton">Ảnh3</label>
                                  <div class="col-md-4">
                                    <input id="filebutton" name="image3" class="input-file" type="file">
                                  </div>
                                </div>

                                   <!-- File Button --> 
                                <div class="form-group">
                                  <label class="col-md-4 control-label" for="filebutton">Ảnh4</label>
                                  <div class="col-md-4">
                                    <input id="filebutton" name="image4" class="input-file" type="file">
                                  </div>
                                </div>
                                <div class="col-md-12 submit">
                                   <button id="singlebutton" name="singlebutton" class="btn btn-primary">Cập Nhập</button>
                                </div>
                           </form>
    
                    </div>
                </div>
            </div>
            
    </body>
</html>
