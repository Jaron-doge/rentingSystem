package com.example.rent.controller;

import com.example.rent.dao.HouseDao;
import com.example.rent.dao.impl.HouseDaoImpl;
import com.example.rent.entity.House;
import com.example.rent.entity.User;
import com.example.rent.service.HouseService;
import com.example.rent.service.UserService;
import com.example.rent.service.impl.HouseServiceImpl;
import com.example.rent.service.impl.UserServiceImpl;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;

@WebServlet("/house_add")
public class house_add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置获取注册时的编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        House house = new House();
        HouseService service =new HouseServiceImpl();
        HttpSession session = request.getSession();
        //获取页面提交的数据
        Integer houseId =(service.select().size()+1);
        User user1  = (User) session.getAttribute("user");
        Integer userId = user1.getUserId();
        Integer Personnum =0;
        Integer house_lift = 1;
        String village = request.getParameter("village");
        Integer floor = Integer.valueOf(request.getParameter("floor"));
        Integer floor_sum = Integer.valueOf(request.getParameter("floor_sum"));
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        Integer type_bedroom = Integer.valueOf(request.getParameter("type_bedroom"));
        Integer type_livingroom = Integer.valueOf(request.getParameter("type_livingroom"));
        Integer type_bathroom = Integer.valueOf(request.getParameter("type_bathroom"));
        String area = request.getParameter("area");
        String address = request.getParameter("address");
        String houseToward = request.getParameter("houseToward");
        Integer price = Integer.valueOf(request.getParameter("price"));
        String payMethod = request.getParameter("payMethod");
        String description = request.getParameter("description");
        String[] facilities = request.getParameterValues("facilities");
        String[] requirement = request.getParameterValues("requirement");
        String[]  houseimg = request.getParameterValues("houseImg");
        Integer managerId = Integer.valueOf(request.getParameter("managerId"));
        String facilitie="";
        String requirements="";
        String houseimage="";
        for(int i =0;i<facilities.length;i++){
             facilitie = facilitie+";" + facilities[i];
        }
        for(int i =0;i<requirement.length;i++){
            requirements = requirements+";" + requirement[i];
        }
        for(int i =0;i<houseimg.length;i++){
            houseimage =  houseimage+";" +  houseimg[i];
        }
        //获取页面提交的数据设置到实体类house中
        house .setHouseId(houseId);
        house .setUserId(userId);
        house.setManagerId(managerId);
        house .setCity(city);
        house .setDistrict(district);
        house .setVillage(village);
        house .setAddress(address);
        house .setFloor(floor);
        house .setFloor_sum(floor_sum);
        house .setPrice(price);
        house .setType_bedroom(type_bedroom);
        house .setType_livingroom(type_livingroom);
        house .setType_bathroom(type_bathroom);
        house .setArea(area);
        house .setDescription(description);
        house .setHouseToward(houseToward);
        house .setFacilities(facilitie);
        house.setRequirement(requirements);
        house.setPersonnum(Personnum);
        house.setPayMethod(payMethod);
        house.setHouseImg(houseimage);
        house.setFloor_lift(house_lift);

        //引入数据交互层
        HouseService service1 = new HouseServiceImpl();
        Boolean flag = service1.addHouse(house);

        if (flag) {
            response.sendRedirect("manager.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
