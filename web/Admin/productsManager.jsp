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
            }
            .list_Product{
                width:600px;
                height:530px;
                background: white;
                box-shadow: 2px 2px 2px 2px grey;
                float:left;
                margin-right:  10px;
                overflow: scroll;
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
                margin-left: 145px;
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
             margin-top: 2px;   
            }
            h2{
                font-size: 35px;
            }
            thead{
                position: fixed;
                width:600px;
                background: #00ffff;
            }
            tbody{
                margin-top: 20px;
            }
            .tensp{
                width: 240px;
            }
            .edit{
                width: 100px;
            }
            .dongia{
                width: 120px;
            }
        </style>
    </head>
    <body>
            <!-- import slide bar -->
            
                <c:import url="../includes/sliderBar.jsp"/>
                
            <!-- import slide bar -->
            
            <!-- main content -->
            
                <div class="main">
                    <h1>DANH SÁCH SẢN PHẨM</h1>
                    <h1 class="h1_them">THÊM MỚI SẢN PHẨM</h1>
                    
                    <!--Phần div lấy danh sách sản phẩm-->
                    
                    <div  class="list_Product">
                        
                        <!-- Danh sách tấc cả sản phẩm -->
                        
                        <table class="table table-hover">
                            
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <thead>
                                <tr>
                                    <th style="width: 60px">Mã</th>
                                    <th class="tensp">Tên sản phẩm</th>
                                    <th class="dongia">Đơn giá</th>
                                    <th class="edit">Chỉnh sửa</th>
                                    <th>Xoá</th>
                                </tr>
                                
                            </thead>
                                
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <!--Phần nội dung của danh sách sản phẩm lấy từ database PetsDaNang--->
                            <tbody> 
                                <tr>
                                    <th>Mã</th>
                                    <th class="tensp">Tên sản phẩm</th>
                                    <th>Đơn giá</th>
                                    <th class="edit">Chỉnh sửa</th>
                                    <th>Xoá</th>
                                </tr>
                                <!--Dùng vòng lọc foreach để lấy danh sách products từ database trong servelet-->
                                <c:forEach var="p" items="${products}">
                                    <tr>
                                        <td>${p.productID}</td>
                                        <td class="name_product">${p.productName}</td>
                                        <td>${p.price}</td>
                                        <td><a href="ProductsManagerServlet?action=edit&amp;productID=${p.productID}">Chỉnh sửa</a></td>
                                        <td><a href="ProductsManagerServlet?action=delete&amp;productID=${p.productID}">Xoá</a></td>    
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
                    
                    <!--Phần div thêm mới sản phẩm-->
                    <div class="add-product">
                        
                        <!--Form thêm mới sản phẩm-->
                        
                        <form class="form-horizontal" action="ProductsManagerServlet" method="post">
                                <fieldset>
                                    
                                    <!--Lấy action khi submit-->
                                    
                                    <input type="hidden" name="action" value="add">
                                    
                                    <!--Lấy action khi submit-->
                                    
                                    <!-- select Danh mục-->
                                        
                                    <div class="form-group">
                                        <label class="col-md-4 control-label danhmuc">Danh mục</label>  
                                        <div class="col-md-4">
                                           <Select name="categoryID">  
                                                <option value="0001" seleted>Chó</option>
                                                <option value="0002">Mèo</option>
                                                <option value="0003">Hamster</option>
                                                <option value="0004">Khác</option>
                                            </Select>
                                        </div>
                                    </div>
                                    
                                    <!-- select Danh mục-->
                                        


                                    <!-- Text input Tên sản phẩm-->
                                    
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="product_name">Tên sản phẩm</label>  
                                        <div class="col-md-4 height">
                                        <input id="product_name" name="productName" placeholder="Tên sản phẩm" class="form-control input-md"  type="text"required>

                                        </div>
                                    </div>
                                    
                                    <!-- Text input Tên sản phẩm-->

                                     <!-- Text input Đơn giá-->
                                     
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="product_categorie">Đơn giá</label>
                                        <div class="col-md-4 height">
                                          <input id="product_name_fr" name="price" placeholder="Đơn giá" class="form-control input-md" type="text"required pattern="[0-9]{1,10}"title="Đơn giá phải là số">
                                        </div>
                                    </div>
                                     
                                    <!-- Text input Đơn giá-->

                                    <!-- Text input Mô tả--> 
                                    
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="product_name_fr">Mô tả</label>
                                        <div class="col-md-4 height">                     
                                          <textarea class="form-control" id="product_name_fr" name="description"></textarea>
                                        </div>
                                    </div>
                                    
                                    <!-- Text input Mô tả-->
                                     
                                    <!-- file input Ảnh chính-->
                                    
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="filebutton">Ảnh chính</label>
                                        <div class="col-md-4">
                                          <input id="filebutton" name="image" class="input-file" type="file">
                                        </div>
                                    </div>
                                    
                                    <!-- file input Ảnh chính-->
                                    
                                <!-- file input Ảnh 1-->
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Ảnh1</label>
                                    <div class="col-md-4">
                                      <input id="filebutton" name="image1" class="input-file" type="file">
                                    </div>
                                </div>
                                
                                <!-- file input Ảnh 1-->

                                <!-- file input Ảnh 2--> 
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Ảnh2</label>
                                    <div class="col-md-4">
                                      <input id="filebutton" name="image2" class="input-file" type="file">
                                    </div>
                                </div>
                                
                                <!-- file input Ảnh 2-->

                                <!-- file input Ảnh 3-->
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Ảnh3</label>
                                    <div class="col-md-4">
                                      <input id="filebutton" name="image3" class="input-file" type="file">
                                    </div>
                                </div>
                                
                                <!-- file input Ảnh 3-->

                                <!-- file input Ảnh 4-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Ảnh4</label>
                                    <div class="col-md-4">
                                      <input id="filebutton" name="image4" class="input-file" type="file">
                                    </div>
                                </div>
                                
                                <!-- file input Ảnh 1-->
                                
                                <!-- button submit-->
                                
                                <div class="col-md-12 submit">
                                   <button id="singlebutton" name="singlebutton" class="btn btn-primary">Thêm mới</button>
                                </div>
                                
                                <!-- button submit-->
                            </form>
                           <br><br><p style="color:green;clear: both;text-align: center" >${message}</p>
                         <!--Form thêm mới sản phẩm-->
    
                    </div>
                     
                </div>
                    
            <!-- main content -->       
    </body>
</html>
