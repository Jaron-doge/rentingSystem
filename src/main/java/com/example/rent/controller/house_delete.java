package com.example.rent.controller;

import com.example.rent.entity.House;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_house")
public class house_delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");

        //获取admin.jsp页面的houseid
        Integer houseId = Integer.parseInt(request.getParameter("houseId"));


        //引入数据交互层
        HouseService houseService = new HouseServiceImpl();
        House house= new House();
        house = houseService.getHouse(houseId);
        System.out.println("删除的房屋信息：");
        System.out.println(house);
        boolean flag = houseService.deleteHouse(houseId);

        if (flag) {
            response.sendRedirect("manager.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
