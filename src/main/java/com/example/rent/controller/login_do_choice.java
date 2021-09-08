package com.example.rent.controller;

import com.example.rent.entity.Manager;
import com.example.rent.service.ManagerService;
import com.example.rent.service.impl.ManagerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login_do")
public class login_do_choice extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer admin = Integer.valueOf(request.getParameter("radio"));
        Integer userid = Integer.valueOf(request.getParameter("userid"));
        String userpassword = request.getParameter("userpassword");
        if(admin==1){
            request.setAttribute("managerid",userid);
            request.setAttribute("managerpassword",userpassword);
           request.getRequestDispatcher("/manager_login").forward(request,response);

        }else{
            request.setAttribute("userid",userid);
            request.setAttribute("userpassword",userpassword);
            request.getRequestDispatcher("/user_login").forward(request,response);

        }
    }
}
