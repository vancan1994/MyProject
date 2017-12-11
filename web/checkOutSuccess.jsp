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
                height: 90%;
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
                clear:both;
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
        </style>
    </head>
    <body>
        <c:import url="/includes/headerUser.jsp"/>
        <div id="mainBody">
            <div class="container">
                <div class="row"><br>
                    <div class="span9">
                        <h3 style="margin-top: 50px;">  GIỎ HÀNG</h3>
                        <h2 style="text-align: center; color:green">Chúc mừng, bạn đã đặt hàng thành công</h2>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
