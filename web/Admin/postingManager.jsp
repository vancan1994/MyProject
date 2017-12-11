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
            td,th{
                text-align: center;
            }
            
        </style>
    </head>
    <body>
            <!-- import slide bar -->
            
                <c:import url="../includes/sliderBar.jsp"/>
                
            <!-- import slide bar -->
            
            <!-- main content -->
            
                <div class="main">
                    <h1 style="margin-left: 350px;">DANH SÁCH TIN ĐĂNG</h1>
                    
                    <!--Phần div lấy danh sách sản phẩm-->
                    
                    <div  class="list_Product">
                        
                        <!-- Danh sách tấc cả sản phẩm -->
                        
                        <table class="table table-hover">
                            
                            <!--Phần tiêu đề của danh sách sản phẩm--->
                            
                            <thead>
                                <tr>
                                    <th>Người đăng</th>
                                    <th>Loại Tin</th>
                                    <th>Danh mục</th>
                                    <th>Số điện thoại</th>
                                    <th>Địa chỉ</th>
                                    <th>Ngày đăng</th>
                                    <th>Trạng thái</th>
                                    <th>Duyệt</th>
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
                                        <td><b>${posting.account.firstName}&nbsp${posting.account.lastName}<b></td>
                                        <td>${posting.typePosting}</td>
                                        <td>${posting.category}</td>
                                        <td>${posting.phone}</td>
                                        <td>${posting.address}</td>
                                        <td>${posting.localDate}</td>
                                        <c:if test = "${posting.status==0}">
                                          <td style="color:red">Chưa duyệt</td>
                                          <td><a  href="PostingManagerServlet?action=duyet&amp;id=${posting.postingID}">Phê duyệt</a></td>   
                                        </c:if>
                                        <c:if test = "${posting.status==1}">
                                          <td style="color:Green">Đã duyệt</td>
                                          <td><a  href="PostingManagerServlet?action=huy&amp;id=${posting.postingID}"">Huỷ duyệt</a></td>   
                                        </c:if>             
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
