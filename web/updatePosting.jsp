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
        width: auto;
        height: auto;
        background-image: url("images/background.jpeg");
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        margin: 0px;
        padding: 0px;
    }
    body{
        
        width: 100%;
        z-index: 1;
    }
    .header_area{
        position: fixed;
        top: 0; 
    }
    .li_menu_trangchu{
        background: #2c2c2c;
    }
    main{
        width: auto;
        position: relative;   
    }
    .taobaiviet{
        padding-top: 4%;
        height:100%;
        z-index: 1;
        width: 100%;
        float:left;
    }
    .listPosting{
        padding-top: 4%;
        float:left;
    }
    .div_taobaiviet{
        height:10%;
        margin-bottom: 2%;
    }
    .a-taobaiviet{
        text-decoration: none;
        color:black;
        font-weight: bold;
        cursor: pointer;
        position: absolute;
        margin-left: 10px;
    }
    .a-taobaiviet:hover{
        text-decoration: none;  
        color:#F7544A;
        font-weight: bold;
        cursor: pointer;
    }
    .txtarea_post{
        margin-top: 3%;
        padding-left:8%;
        width: 100%;
        height: 50%;
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
        border-radius: 2px;
        margin-left: 500px;
    }
    .chonAnh{
        float: left;
        cursor: pointer;
    }
    .dangTin:focus,textArea:focus{
        outline: none;
    }
    .upload{
        margin-right: 300px;
        margin-top: 5px;
    }
    .form-horizontal{
        margin: 0;
        padding: 0;
    }
    th{
        text-align: center;
    }
    td{
        text-align: center;
    }
    label{
        color: black;
    }
</style>
    
<script>
    var file = document.forms['form2']['file'].files[0];
</script>   
<body>
    <c:import url="/includes/headerUser.jsp"/>
    <div class="clearfix"></div>

    <main>
        <div class="col-md-12 taobaiviet"> 
            <div class=" col-md-12 add-product">
                   
                <form class=" col-md-12 form-horizontal" action="PostingServlet?action=capnhap&amp;postingID=${posting.postingID}" method="post">
                    <h1 col-md-12 style="margin-left: 480px;color: red;font-size: 30px;">CẬP NHẬP TIN</h1> 
                        <input type="hidden" name="email" value="${account.email}">
                        <!-- select input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Loại tin</label>  
                            <div class="col-md-4 height" >
                                <select class="form-control" id="sel1" name="type" value="${posting.typePosting}">
                                    <option selected>Mua</option>
                                    <option>Bán</option>
                                    <option>Tìm kiếm</option>
                                    <option>Khác</option>
                                </select>
                            </div>
                       </div>
                        
                        <!-- select input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Danh mục</label>  
                            <div class="col-md-4 height" >
                                <select class="form-control" id="sel1" name="categories" value="${posting.category}">
                                    <option selected>Chó</option>
                                    <option>Mèo</option>
                                    <option>Hamster</option>
                                    <option>Khác</option>
                                </select>
                            </div>
                       </div>

                         <!-- Text input-->
                        <div class=" form-group">
                          <label class="col-md-4 control-label" >Tiêu đề tin</label>  
                          <div class="col-md-4 height" >
                          <input id="product_name" name="title" value="${posting.postingTitle}" placeholder="Tiêu đề" class="form-control input-md" type="text">
                          </div>
                        </div>
                        
                         <!-- Textarea -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="product_name_fr">Mô tả</label>
                          <div class="col-md-4 height">                     
                                <textarea class="form-control" id="product_name_fr" name="description">${posting.description}</textarea>
                          </div>
                        </div>
                          
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" >Số điện thoại</label>  
                          <div class="col-md-4 height">
                          <input id="product_name" value="${posting.account.phone}" name="phone" placeholder="Số điện thoại" class="form-control input-md"  type="text"required>

                          </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Địa chỉ</label>  
                            <div class="col-md-4 height" >
                                <select class="form-control" id="sel1" name="address" value="${posting.account.address}">
                                    <option>Hải Châu</option>
                                    <option>Thanh Khê</option>
                                    <option>Sơn Trà</option>
                                    <option>Ngũ Hành Sơn</option>
                                    <option>Liên Chiểu</option>
                                    <option>Cẩm Lệ</option>
                                </select>
                            </div>
                       </div>

                        
                          <!-- File Button --> 
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="filebutton">Ảnh</label>
                          <div class="col-md-4">
                              <input style="height:50px;" id="filebutton" name="image" class="input-file" type="file">
                          </div>
                        </div>
                        <div class="col-md-12 submit">
                           <button id="singlebutton" name="singlebutton" class="btn btn-primary">Cập nhập</button>
                        </div>
                   </form><br>
                   <p style="color: red;text-align: center; margin-right:100px;margin-top: 10px">${message}</p>

            </div>
        </div>
    </main>
</body>
</html>