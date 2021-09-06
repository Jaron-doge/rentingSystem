<%--
  Created by IntelliJ IDEA.
  User: YYH
  Date: 2021/9/2
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.rent.dao.UserDao" %>
<%@ page import="com.example.rent.dao.impl.UserDaoImpl" %>
<%@ page import="com.example.rent.entity.User" %>
<%@ page import="com.example.rent.service.UserService" %>
<%@ page import="com.example.rent.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath %>"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jc</title>
    <link rel="stylesheet" href="./font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./login-register.css">
</head>

<body>
<!-- svg图案 -->
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#b83f0f" fill-opacity="1" d="M0,192L48,197.3C96,203,192,213,288,229.3C384,245,480,267,576,250.7C672,235,768,181,864,181.3C960,181,1056,235,1152,234.7C1248,235,1344,181,1392,154.7L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path></svg>

<div class="head"><br><br>安居租房管理系统</div>

<div class="container">

    <!-- 登录框 -->
    <div class="box login">
        <div class="form-content">

            <!-- 头像 -->
            <div class="avtar">
                <div class="pic"><img src="./img/1.jpg" alt=""></div>
            </div>

            <h1>欢迎登录</h1>

            <!-- <form> 标签用于为用户输入创建 HTML 表单 -->
            <form action="/rentingSystem/user_login" method="post" class="form">
                <div>
                    <input type="text" name="userid" id="userid" placeholder="请输入手机号">
                </div>
                <div>
                    <input type="password" name="userpassword" id="userpassword"placeholder="请输入密码">
                </div>
                <div class="btn">
                    <button type="submit">登录</button>
                </div>
            </form>

            <p class="btn-something">
                Don't have an account ? <span class="signupbtn">signup</span>
            </p>
        </div>

    </div>

    <!-- 注册框 -->
    <div class="box signup">
        <div class="form-content">

            <div class="avtar">
                <div class="pic"><img src="./img/2.jpg" alt=""></div>
            </div>

            <h1>开始安居</h1>
            <!-- <form> 标签用于为用户输入创建 HTML 表单 -->
            <form action="/rentingSystem/user_register" class="Form" method="post" name="registerForm">

                <div><input type="text" name="id" id="id" placeholder="请输入您的手机号"></div>
                <div>
                    <i class="fa fa-key"></i>
                    <input type="password" name="password" id="password" placeholder="请设置您的密码">
                </div>
                <div class="btn">
                    <button type="submit" onclick="return checkForm()">注册</button>
                </div>
            </form>
            <p class="btn-something">
                Already have an account ? <span class="loginbtn">login</span>
            </p>
        </div>
    </div>
</div>


<script type="text/javascript"src="js/jquery-3.4.1.js"></script>
<script>
    let login = document.querySelector(".login");
    let signup = document.querySelector(".signup");

    let loginbtn = document.querySelector(".loginbtn");
    let siginupbtn = document.querySelector(".signupbtn");

    let user = document.querySelector(".head");

    siginupbtn.addEventListener("click", () => {
        login.style.transform = "rotateY(180deg)"
        signup.style.transform = "rotateY(0deg)";
    })

    loginbtn.addEventListener("click", () => {
        login.style.transform = "rotateY(0deg)"
        signup.style.transform = "rotateY(-180deg)";
    })
    function checkForm() {
        var name = registerForm.id.value;
        var pwd = registerForm.password.value;
        if (id == "" || name == null) {
            alert("请输入用户名");
            registerForm.id.focus();
            return false;
        } else if (pwd == "" || pwd == null) {
            alert("请输入密码");
            registerForm.password.focus();
            return false;
        }
        alert('注册成功！');
        return true;
    }
</script>
</body>
</html>