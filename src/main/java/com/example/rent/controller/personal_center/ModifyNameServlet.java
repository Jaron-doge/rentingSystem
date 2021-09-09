package com.example.rent.controller.personal_center;

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
import java.io.IOException;

@WebServlet(name = "modifyNameServlet", value = "/modifyNameServlet")
public class ModifyNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 修改用户昵称
        request.setCharacterEncoding("UTF-8");
        User user =(User) request.getSession().getAttribute("user");
        Manager manager =(Manager) request.getSession().getAttribute("manager");
        // 如果是管理员
        String name = request.getParameter("name");
        if(manager != null) {
            manager.setName(name);
            ManagerService managerService = new ManagerServiceImpl();
            boolean flag =  managerService.updateManager(manager);
            if(flag) {
                response.sendRedirect("personal_center.jsp");
            }
            else {
                response.sendRedirect("error.jsp");
            }
        } // 如果是用户
        else {
            user.setUserName(name);
            UserService userService = new UserServiceImpl();
            boolean flag =  userService.updateUser(user);
            if(flag) {
                response.sendRedirect("personal_center.jsp");
            }
            else {
                response.sendRedirect("error.jsp");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
