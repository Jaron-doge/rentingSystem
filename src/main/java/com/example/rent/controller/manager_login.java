package com.example.rent.controller;

import com.example.rent.entity.Manager;
import com.example.rent.entity.User;
import com.example.rent.service.ManagerService;
import com.example.rent.service.UserService;
import com.example.rent.service.impl.ManagerServiceImpl;
import com.example.rent.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/manager_login")
public class manager_login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置接收的编码为UTF-8
        request.setCharacterEncoding("utf-8");
        Manager manager = new Manager();
        ManagerService service = new ManagerServiceImpl();

        Integer managerId = Integer.valueOf(request.getParameter("managerId"));
        String password = request.getParameter("Pwd");

        manager.setManagerId(managerId);
        manager.setPwd(password);

        // 获取用户登录信息
        Manager us = service.login(manager);

        System.out.println("----us的信息----");
        System.out.println(us);
        //设置一个session
        HttpSession session = request.getSession();
        session.setAttribute("manager", us);



        if (us != null ) {
            response.sendRedirect("index.jsp");
        } else  {
            response.sendRedirect("login_register.jsp");
        }
    }
}

