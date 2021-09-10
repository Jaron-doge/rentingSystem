package com.example.rent.controller;

import com.example.rent.entity.HouseBean;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rentDetail")
public class HouseDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int houseId=Integer.parseInt(req.getParameter("houseId"));

        HouseService houseService=new HouseServiceImpl();
        //
        HouseBean housedetail=houseService.houseDetailQuery(houseId);
        //4. 将pageBean对象序列化为json，返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(housedetail);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(json);

    }
}
