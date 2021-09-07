package com.example.rent.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.example.rent.entity.User;
import com.example.rent.dao.UserDao;
import com.example.rent.service.UserService;
import java.util.List;
import com.example.rent.dao.impl.UserDaoImpl;
import com.example.rent.service.impl.UserServiceImpl;
@WebServlet("/user_login")
public class user_login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ���ý��յı���ΪUTF-8
        request.setCharacterEncoding("utf-8");
        User user = new User();
        UserService service =new UserServiceImpl();

        String userid = request.getParameter("userid");
        String password = request.getParameter("userpassword");

        user.setUserId(Integer.valueOf(userid));
        user.setUserPwd(password);

        // ��ȡ�û���¼��Ϣ
        User us = service.login(user);

        System.out.println("----us����Ϣ----");
        System.out.println(us);

         //����һ��session
        HttpSession session = request.getSession();
        session.setAttribute("user", us);

        if (us != null ) {
            response.sendRedirect("index.jsp");
        } else  {
            response.sendRedirect("login_register.jsp");
        }
    }
}
