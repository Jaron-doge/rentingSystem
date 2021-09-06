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
import java.io.IOException;

@WebServlet("/manager_register")
public class manager_register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        Manager manager=new Manager();
        //获取register.jsp页面提交的账号和密码

        Integer id =Integer.parseInt(request.getParameter("id").trim());
        String password=request.getParameter("password");
        String name = "manager";
        Integer houseSum =1;

        //获取register.jsp页面提交的账号和密码设置到实体类User中

        manager.setManagerId(id);
        manager.setPwd(password);
        manager.setName(name);
        manager.setSum(houseSum);


        //引入数据交互层
        ManagerService service = new ManagerServiceImpl();
        boolean flag=service.register(manager);

        if(flag){
            response.sendRedirect("login_register.jsp");
        }else{
            response.sendRedirect("login_register.jsp");
        }
    }
}
