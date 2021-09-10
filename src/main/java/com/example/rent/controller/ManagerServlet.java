package com.example.rent.controller;

import com.example.rent.dao.ManagerDao;
import com.example.rent.dao.impl.ManagerDaoImpl;
import com.example.rent.entity.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("manager");
        int managerId=Integer.parseInt(req.getParameter("managerId"));

        ManagerDao managerdao=new ManagerDaoImpl();
        Manager manager=managerdao.getManager(managerId);

        //4. 将pageBean对象序列化为json，返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(manager);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(json);
    }
}
