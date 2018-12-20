<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
    <meta http-equiv="content-type" content="text/html"/>
    <meta charset="utf-8" />
    <link href="css/login.css" rel="stylesheet"  type="text/css"/>
    <link href="js/jquery.min.js"/>
</head>
<body>
<script type="text/javascript">
    function refresh() {
        loginForm.ImgValidate.src = "validate?id="+Math.random();
    }
</script>
<div class="dowebok">
    <div class="logo"></div>
    <form name="loginForm" action="/login" method="post">
        <div class="form-item">
            <input id="account" type="text" name="username"  autocomplete="off"  placeholder="账号"/><BR>
        </div>
        <div class="form-item">
            <input id="password" type="password" name="password"  autocomplete="off" placeholder="登录密码"/><BR>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码：<img name="ImgValidate" src="validate" onclick="refresh()"><BR>
        <div class="form-item">
            <input id="code" name="validate_code" type="text"  autocomplete="off" placeholder="验证码">
            <!-- 验证-->
        </div>
        <div class="form-item">
            <a href="#" onclick="login()">登录</a>
        </div>
    </form>
</div>

</body>
<script>
    function login() {
        $post()
    }
</script>
</html>
