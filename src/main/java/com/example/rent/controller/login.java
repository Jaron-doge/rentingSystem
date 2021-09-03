package com.example.rent.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.rent.entity.User;
import com.example.rent.dao.UserDao;
import com.example.rent.service.UserService;
import java.util.List;
import com.example.rent.dao.impl.UserDaoImpl;
import com.example.rent.service.impl.UserServiceImpl;
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置接收的编码为UTF-8
        request.setCharacterEncoding("utf-8");
        User user = new User();
        UserDao dao = new UserDaoImpl();

        String username = request.getParameter("userid");
        String password = request.getParameter("userpassword");

        user.setUserName(username);
        user.setUserPwd(password);

        // 获取用户登录信息
        User us = dao.login(user);

        System.out.println("----us的信息----");
        System.out.println(us);


        if (us != null ) {
            response.sendRedirect("index.jsp");
        } else  {
            response.sendRedirect("login_register.jsp");
        }
    }
}
