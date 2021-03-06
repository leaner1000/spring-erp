<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
    <meta http-equiv="content-type" content="text/html"/>
    <meta charset="utf-8" />
    <link href="css/login.css" rel="stylesheet"  type="text/css"/>
    <link href="js/jquery.min.js"/>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <style>
  * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { 
					height: 100%; 
					background: #fff url(../img/backgroud.png) 50% 50% no-repeat;
					background-size: cover;
					}
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(../img/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 12px auto; padding: 0px;}
        .form-item input { margin: 0 auto; padding: 0px;width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item button { margin: 0 auto; padding: 0px;width: 288px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        #account { background: url(../img/emil.png) 20px 14px no-repeat; }
        #password { background: url(../img/password.png) 23px 11px no-repeat; }
        #code{ background: url(../img/validate4.png) 24px 14px no-repeat;}
        .tip { display: none; position: absolute; left: 20px; top: 52px; font-size: 14px; color: #f50; }
        .reg-bar { width: 360px; margin: 20px auto 0; font-size: 14px; overflow: hidden;}
        .reg-bar a { color: #fff; text-decoration: none; }
        .reg-bar a:hover { text-decoration: underline; }
        .reg-bar .reg { float: left; }
        .reg-bar .forget { float: right; }
        .dowebok ::-webkit-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok ::-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-ms-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
		#button{ width:288px; height:48px; background-color: #f20d0d;border-radius: 20px;text-align: center;margin: 0 auto; padding: 0px; color:white;}
		#button:hover{ width:288px; height:48px; background-color: #c20a0a;border-radius: 20px;text-align: center;margin: 0 auto; padding: 0px;color:white}
        @media screen and (max-width: 500px) {
            * { box-sizing: border-box; }
            .dowebok { position: static; width: auto; height: auto; margin: 0 30px; border: 0; border-radius: 0; }
            .logo { margin: 50px auto; }
            .form-item { width: auto; }
            .form-item input, .form-item button, .reg-bar { width: 100%; }
        }
    
	</style>
</head>
<body>
<script type="text/javascript">
    function refresh() {
        loginForm.ImgValidate.src = "validate?id="+Math.random();
    }
</script>
<div class="dowebok">
    <div class="logo"></div>
    <form id="loginForm" name="loginForm" action="/login" method="post">
        <div class="form-item">
            <input id="account" type="text" name="username"  autocomplete="off"  placeholder="账号" style="width: 367px; "/><BR>
        </div>
        <div class="form-item">
            <input id="password" type="password" name="password"  autocomplete="off" placeholder="登录密码" style="width: 366px; "/><BR>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      验证码：<img name="ImgValidate" src="validate" onclick="refresh()"><BR>
        <div class="form-item">
            <input id="code" name="validate_code" type="text"  autocomplete="off" placeholder="验证码" style="width: 366px; ">
            <!-- 验证-->
        </div>
        <div class="form-item">
            <div href="#" id="button" onclick="login()">登录</div>
        </div>
    </form>
</div>

</body>
<script>
    function login() {
        $.post("login",$("#loginForm").serialize(),function(status){
            if(status.status!=200){
               alert(status.msg);
            }else{
                location.href = "${baseurl}home";
            }
        })
    }
</script>
</html>
