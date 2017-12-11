
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
   <title>PetsDaNang</title>
  <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <script src="styles/bootstrap.min.js" type="text/javascript"></script>
  <script src="styles/jquery.min.js" type="text/javascript"></script>
  <link href="css/login.css" rel="stylesheet" type="text/css"/>
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
    <div class="panda">
        <div class="ear"></div>
        <div class="face">
            <div class="eye-shade"></div>
            <div class="eye-white">
                <div class="eye-ball"></div>
            </div>
            <div class="eye-shade rgt"></div>
            <div class="eye-white rgt">
                <div class="eye-ball"></div>
            </div>
            <div class="nose"></div>
            <div class="mouth"></div>
        </div>
        <div class="body"> </div>
        <div class="foot">
            <div class="finger"></div>
        </div>
        <div class="foot rgt">
            <div class="finger"></div>
        </div>
    </div>
    <form action="loginServlet" method="post">
            <div class="hand"></div>
            <div class="hand rgt"></div>
            <h1>ĐĂNG NHẬP</h1>
            <input name="txtUsername" style="width: 280px; margin-left: 20px; margin-bottom: 20px" type="text" class="form-control" placeholder="Email" required autofocus>
             <input name="txtPassword"style="width: 280px; margin-left: 20px;" type="password" class="form-control" placeholder="Mật khẩu" required>
                
        <div class="form-group">
            <p class="alert">Sai tài khoản hoặc mật khẩu..!!</p>
            <button class="btn">Đăng nhập </button><br><br>
            <a href="/PetsDaNang/forgetPassword.jsp" style="cursor: pointer">Quên mật khẩu?</a>
        </div>
             <br><br><br><br>
             <p style="color: white">${message}</p>
    </form>
  
</body>
</html>