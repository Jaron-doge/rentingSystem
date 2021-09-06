package com.example.rent.controller;

import com.example.rent.dao.UserDao;
import com.example.rent.dao.impl.UserDaoImpl;
import com.example.rent.entity.User;
import com.example.rent.service.UserService;
import com.example.rent.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class user_register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        User user=new User();
        //获取register.jsp页面提交的账号和密码

        Integer id =Integer.parseInt(request.getParameter("id").trim());
        String password=request.getParameter("password");
        String name = "user";
        Integer icon =1;

        //获取register.jsp页面提交的账号和密码设置到实体类User中

        user.setUserId(id);
        user.setUserPwd(password);
        user.setIcon(icon);
        user.setUserName(name);


        //引入数据交互层
        UserService service=new UserServiceImpl();
        boolean flag=service.register(user);

        if(flag){
            response.sendRedirect("login_register.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
