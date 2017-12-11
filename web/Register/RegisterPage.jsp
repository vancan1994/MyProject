<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PetsDaNang</title>
        <script>
            function addOption(selectbox, text, value) {
                var optn = document.createElement("option");
                optn.text = text;
                optn.value = value;
                selectbox.options.add(optn);
            }
            
            function addOption_list() {

                for(var i=02; i <= 31;++i){
                    addOption(document.form.day,i,i);
                }
                    for (var i=02; i <= 12;++i) {
                    addOption(document.form.month,i,i);
                }
                    for (var i=2016; i >1900;i--) {
                    addOption(document.form.year,i,i);
                }
            }
        </script>
        <link href="/PetsDaNang/css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="addOption_list()">
        <main>  
            <div id ="register">
                <h3>TẠO TÀI KHOẢN MỚI</h3>
                <form  name="form" action="/PetsDaNang/RegisterServlet" id="date_form" >
                    <!--lay action-->
                    
                    <input type="hidden" name="action" value="dangky">
                    
                    <!--lay action-->
                    
                    <!--input Họ-->
                    
                    <input type="text" placeholder="  Họ" name="ho" required>
                    
                    <!--input Họ-->
                    
                    <!--input Tên-->
                    
                    <input type="text" name="ten" class="ten" placeholder="  Tên"required><br>
                    
                    <!--input Tên-->
                    
                    <!--input emial-->
                    
                    <input type="email" name="email" class="email" placeholder="  Email"required><br>
                    
                    <!--input Tên-->
                    
                    <!--input mật khẩu-->
                    
                    <input type="password" name="matkhau" class="passwork" placeholder="  Mật khẩu"required><br>
                    
                    <!--input mật khâu-->
                     
                    <!--Select ngày sinh-->
                    <label>Ngày sinh</label><br>
                    
                    <table>                 
                        <tr>
                            <td><select name="day"><option value="">1</option></select></td>
                            <td><select name="month"><option value="">1</option></select></td>
                            <td><select name="year"><option value="">2017</option></select></td>
                        </tr>
                    </table>
                    
                    <!--Select ngày sinh-->
                    
                    <!--radio button giới tính--> 
                     
                    <input name="gioitinh" type="radio" class="radio" value="Nam" checked="checked"><a>Nam</a>

                    <input name="gioitinh" type="radio" value="Nữ" class="radio1" /><a>Nữ</a><br>
                   
                    <!--radio button giới tính--> 
                    
                    <!--botton submit--> 
                    
                    <input style="background: white;cursor: pointer;font-weight: bold;color:black"class="button" type="submit" value="Tạo tài khoản mới">
                    <p style="color:white;font-size:18px;margin-left: 150px;">${message}</p>
                    
                    <!--botton submit--> 
           
                </form>  
            </div>
        </main>
    </body>
</html>
