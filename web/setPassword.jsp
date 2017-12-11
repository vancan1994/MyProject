
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>PetsDaNang</title>
  <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <script src="styles/bootstrap.min.js" type="text/javascript"></script>
  <script src="styles/jquery.min.js" type="text/javascript"></script>
  <link href="css/forget.css" rel="stylesheet" type="text/css"/>
  <script src="js/login/action_login.js" type="text/javascript"></script>
  <script src="js/login/login.js" type="text/javascript"></script>
  <style>
      .vetrangchu{
          color: white;
          text-decoration: none;
      }
      .vetrangchu:hover{
          color: #FF4081;
          text-decoration: none;
      }
  </style>
</head>
    <body>
        <button type="button"  style=" color:white;margin-top: 20px;margin-left: -1150px;width: 100px; background: white; border: 1px solid #FF4081;height:35px; border-radius: 5px"class="btn btn-success"><a class="vetrangchu" style="" href="HomeServlet">Trang chủ</a></button>
        <form action="ForgetServlet" method="post" >
            <input type="hidden" name="action" value="set">
            <input type="hidden" name="email" value="${email}">
            <input name="password" style="width: 280px; margin-left:550px; margin-top: 180px" type="password" class="form-control" placeholder="Nhập vào passowrd" required autofocus>
            <input name="password1" style="width: 280px; margin-left:550px; margin-top: 10px" type="password" class="form-control" placeholder="Nhập lại passowrd" required autofocus>
            <button class="btn">Lấy lại mật khẩu</button><br><br><br>
            <p style="color:green">${message}</p>
        </form>
    </body>
</html>