<%--
  Created by IntelliJ IDEA.
  User: LY
  Date: 2021/9/7
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
    Object user= session.getAttribute("user");
    Object manager = session.getAttribute("manager");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <base href="http://localhost:8080/rentingSystem/">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>租房系统头部</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/rotation.css">
    <link rel="stylesheet" href="css/common.css">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <style>
        .personal_center:hover {
            cursor: pointer;
        }

        .exit:hover {
            cursor: pointer;
        }
    </style>
</head>

<body>
<header class="nav w">
    <div class="fl">
        <ul>
            <li class="logo"><a href="index.jsp"><img src="images/图片1.png" width="171" height="50"></a></li>
            <div class="search">
                <form  name="searchInfo" method="get">
                    <input type="search"  id="" placeholder="请输入搜索内容" name="searchContent">
                    <img src="images/搜索 (1).png" onclick="formsubmit()"></img>
                </form>
            </div>
        </ul>
    </div>
    <div class="fr">
        <ul>

            <%
                System.out.println(user);
                System.out.println(manager);
                if(user == null && manager == null) {
            %>
            <li class="login"><a href="login_register.jsp"><img src="images/登陆.png">登录</a></li>
            <li class="register"><a href="login_register.jsp"><img src="images/注册%20(选中).png">注册</a></li>
            <%
                }
            %>
            <c:if test="${not empty user}">
                <li class="release"><a href="house_releasing.jsp">发布租房</a></li>
                <li class="personal_center login"  onclick='openPersonal_center()'><a><img src="images/登陆.png">个人中心</a></li>
                <li class="exit register" onclick="userExit()"><img src="images/退出.png">退出</li>
            </c:if>
            <c:if test="${not empty manager}">
                <li class="personal_center login" onclick='openPersonal_center()'><a><img src="images/登陆.png" href="personal_center.jsp">个人中心</a></li>
                <li class="exit register" onclick="managerExit()"><img src="images/退出.png">退出</li>
            </c:if>
        </ul>
    </div>
</header>
<!-- 导航栏模块结束 -->

<script>
    function formsubmit() {
        document.searchInfo.action="search_list.jsp";
        document.searchInfo.submit();

    }

    function openPersonal_center() {
        window.location.href = 'personal_center.jsp';
    }
    function userExit(){
        console.log(1);
        $.get('/rentingSystem/userExitServlet');
        window.location.href = 'index.jsp';
    }

    function managerExit(){
        console.log(1);
        $.get('/rentingSystem/managerExitServlet');
        window.location.href = 'index.jsp';
    }


</script>

</body>
</html>
