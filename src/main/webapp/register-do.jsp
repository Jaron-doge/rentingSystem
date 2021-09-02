<%--
  Created by IntelliJ IDEA.
  User: YYH
  Date: 2021/9/2
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@page import="com.example.rent.dao.impl.UserDaoImpl"%>
<%@page import="com.example.rent.dao.UserDao"%>
<%@page import="com.example.rent.entity.User"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>处理注册</title>
</head>
<body>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");
    User user=new User();
    //获取register.jsp页面提交的账号和密码

    String name=request.getParameter("name");
    String password=request.getParameter("password");
    Integer icon =1;

    //获取register.jsp页面提交的账号和密码设置到实体类User中

    user.setUserName(name);
    user.setUserPwd(password);
    user.setIcon(icon);


    //引入数据交互层
    UserDao dao=new UserDaoImpl();
    boolean flag=dao.register(user);

    if(flag){
        response.sendRedirect("login_register.jsp");
    }else{
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>

