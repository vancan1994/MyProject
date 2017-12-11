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
        background-image: url("images/background1.jpg");
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
    body{
        background: #E9EBEE;
        width: 100%;
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
        width: 100%;
        float:left;
    }
    .listPosting{
        margin-top:4%;
        float:left;
    }
    .listPosting1{
        height: 300px;
        overflow-x: no-content;
        overflow-y: scroll;
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
        margin-left: 200px;
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

    tbody{
        height: 150px;
        overflow: hidden;
    }
</style>
    
<script>
    var file = document.forms['form2']['file'].files[0];
</script>   
<body>
    <c:import url="/includes/headerUser.jsp"/>
    <div class="clearfix"></div>

    <main>
        <div class="col-md-6 taobaiviet"> 
            <div class=" col-md-12 add-product">
                   
                <form class=" col-md-12 form-horizontal" action="PostingServlet?action=dangtin" method="post">
                    <h1 col-md-12 style="margin-left: 280px;color: red;font-size: 30px;">TẠO MỚI TIN</h1> 
                        <input type="hidden" name="email" value="${account.email}">
                        <!-- select input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Loại tin</label>  
                            <div class="col-md-8 height" >
                                <select class="form-control" id="sel1" name="type">
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
                            <div class="col-md-8 height" >
                                <select class="form-control" id="sel1" name="categories">
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
                          <div class="col-md-8 height" >
                          <input id="product_name" name="title" value="" placeholder="Tiêu đề" class="form-control input-md" type="text">
                          </div>
                        </div>
                        
                         <!-- Textarea -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="product_name_fr">Mô tả</label>
                          <div class="col-md-8 height">                     
                                <textarea class="form-control" id="product_name_fr" name="description"></textarea>
                          </div>
                        </div>
                          
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" >Số điện thoại</label>  
                          <div class="col-md-8 height">
                          <input id="product_name" value="" name="phone" placeholder="Số điện thoại" class="form-control input-md"  type="text"required>

                          </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Địa chỉ</label>  
                            <div class="col-md-8 height" >
                                <select class="form-control" id="sel1" name="address">
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
                          <div class="col-md-8">
                              <input style="height:50px;" id="filebutton" name="image" class="input-file" type="file">
                          </div>
                        </div>
                        <div class="col-md-12 submit">
                           <button id="singlebutton" name="singlebutton" class="btn btn-primary">Tạo tin</button>
                        </div>
                   </form><br>
                   <p style="color: green;text-align: center; margin-right:100px;margin-top: 10px">${message}</p>

            </div>
        </div>
        <div class="col-md-4 listPosting">
               <h1 col-md-12 style="margin-left: 80px;color: red;font-size: 30px;">Lịch sử đăng</h1>
               <div class="col-md-12 listPosting1">
               
                   <table class="col-md-12 table table-hover tb_ls">
                            
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <thead>
                                <tr>
                                    <th>Ngày đăng</th>
                                    <th>Ảnh</th>
                                    <th>Tiêu đề</th>
                                    <th>Cập nhập</th>
                                    
                                </tr>
                            </thead>
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            <!--Phần nội dung của danh sách sản phẩm lấy từ database PetsDaNang--->
                                <tbody> 
                                <!--Dùng vòng lọc foreach để lấy danh sách products từ database trong servelet--> 
                                <%
                                    String gioitinh="Chưa duyệt";
                                %>
                                <c:forEach var="posting" items="${postings}">
                                    <tr>
                                        <td>${posting.localDate}</td>
                                        <td>${posting.image}</td>
                                        <td>${posting.postingTitle}</td>
                                        <td><a href="PostingServlet?action=update&amp;postingID=${posting.postingID}">Cập nhập</a></td>
                                                  
                                    </tr>
                                </c:forEach>           
                                <!--Dùng vòng lọc foreach để lấy danh sách products từ database trong servelet-->                                
                            </tbody>
  
                            <!--Phần nội dung của danh sách sản phẩm lấy từ database PetsDaNang--->
                            
                        </table>
                   </div>
        </div>
    </main>
</body>
</html>