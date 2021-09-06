<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        h4 {
            text-align: center;
            color: red;
        }


    </style>
</head>
<body>

<hr>
<%
    // 设置接收的编码为UTF-8
    request.setCharacterEncoding("utf-8");
    User user = new User();
    UserDao dao = new UserDaoImpl();

    String username = request.getParameter("username");
    String password = request.getParameter("userpassword");

    user.setUserName(username);
    user.setUserPwd(password);

    // 获取用户登录信息
    User us = dao.login(user);

    // 把数据库里面的User获取出来
    UserService service = new UserServiceImpl();
    List<User> list = service.selectUser(username);
    for (int i = 0; i < list.size(); i++) {
        user = list.get(i);
    }

    System.out.println("----us的信息----");
    System.out.println(us);

    // 设置会话
    session.setAttribute("user", user);

    if (us != null ) {
        response.sendRedirect("index.jsp");
    } else  {
        response.sendRedirect("login_register.jsp");
    }
%>
</body>
</html>
