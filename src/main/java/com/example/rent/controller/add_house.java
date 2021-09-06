package com.example.rent.controller;

import com.example.rent.entity.House;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;

@WebServlet("/add_house")
public class add_house extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        House house = new House();

        //获取页面提交的数据
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));
        Integer userId  = Integer.valueOf(request.getParameter("userId"));
        Integer managerId = Integer.valueOf(request.getParameter("managerId"));
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String village = request.getParameter("vilage");
        String address = request.getParameter("address");
        Integer floor = Integer.valueOf(request.getParameter("floor"));
        Integer floor_sum = Integer.valueOf(request.getParameter("floor_sum"));
        Integer floor_lift = Integer.valueOf(request.getParameter("floor_lift"));
        Integer price = Integer.valueOf(request.getParameter("price"));
        Integer type_bedroom = Integer.valueOf(request.getParameter("type_room"));
        Integer type_livingroom = Integer.valueOf(request.getParameter("type_livingroom"));
        Integer type_bathroom = Integer.valueOf(request.getParameter("type_bathroom"));
        String area = request.getParameter("area");
        String description = request.getParameter("description");
        String houseToward = request.getParameter("houseToward");
        String facilities = request.getParameter("facilities");
        String requirement = request.getParameter("requirement");
        Integer personnum = Integer.valueOf(request.getParameter("personnum"));
        String houseImg = request.getParameter("houseImg");
        String payMethod = request.getParameter("payMethod");


        //获取页面提交的账号和密码设置到实体类house中
        house .setHouseId(houseId);
        house .setUserId(userId);
        house.setManagerId(managerId);
        house .setCity(city);
        house .setDistrict(district);
        house .setVillage(village);
        house .setAddress(address);
        house .setFloor(floor);
        house .setFloor_sum(floor_sum);
        house .setFloor_lift(floor_lift);
        house .setPrice(price);
        house .setType_bedroom(type_bedroom);
        house .setType_livingroom(type_livingroom);
        house .setType_bathroom(type_bathroom);
        house .setArea(area);
        house .setDescription(description);
        house .setHouseToward(houseToward);
        house .setFacilities(facilities);
        house.setRequirement(requirement);
        house.setPersonnum(personnum);
        house.setHouseImg(houseImg);
        house.setPayMethod(payMethod);


        //引入数据交互层
        HouseService houseservice = new HouseServiceImpl();
        boolean flag = houseservice.addHouse(house);


        if (flag) {
            response.sendRedirect("manager.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
