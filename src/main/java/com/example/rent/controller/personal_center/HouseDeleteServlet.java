package com.example.rent.controller.personal_center;

import com.example.rent.entity.House;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "houseDeleteServlet", value = "/houseDeleteServlet")
public class HouseDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        //获取admin.jsp页面的houseid
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));

        System.out.println(houseId);
        //引入数据交互层
        HouseService houseService = new HouseServiceImpl();
        boolean flag = houseService.deleteHouse(houseId);

        if (flag) {
            response.sendRedirect("/rentingSystem/uPersonal_center.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
