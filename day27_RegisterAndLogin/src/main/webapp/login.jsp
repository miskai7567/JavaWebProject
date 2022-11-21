<%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/10
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <h1>用户登录</h1>
    <form action="ServletLogin" method="post">
        姓名：<input type="text" name="username" value="${cookie.username.value}"/><br/>
        密码：<input type="password" name="password"/><br/>
        验证码：<input type="text" name="checkcode"/><br/>
        <img id="imgId" src="ServletCheckCode"><a onclick="changeCheckCode()">换一换</a><br/>
        <input type="checkbox" name="remember" value="true"> 记住用户名<br/>
        <input type="submit" value="登录"/>
    </form>
</center>
<script>
    function changeCheckCode() {
        // 修改img标签src属性的值
        document.getElementById("imgId").src = "ServletCheckCode?time="+new Date().getMilliseconds();
    }
</script>
</body>
</html>
