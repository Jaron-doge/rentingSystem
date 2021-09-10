package com.example.rent.controller;

import com.example.rent.entity.House;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;
import com.example.rent.util.BaseDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rentRight")
public class HouseRightServlet {
    public class HouseServlet extends HttpServlet {
        private HouseService houseService = new HouseServiceImpl();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("right");
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<House> list = new ArrayList<>();
            try {
                // 1.连接数据库
                con = BaseDao.getConnection();
                // 2.预编译
                String sql = "Select * from House limit 0,5";
                ps = con.prepareStatement(sql);
                // 3.执行sql
                rs = ps.executeQuery();

                if (rs.next()){
                    House house = new House();
                    house.setHouseId(rs.getInt("houseId"));
                    house.setUserId(rs.getInt("userId"));
                    house.setManagerId(rs.getInt("managerId"));
                    house .setCity(rs.getString("city"));
                    house .setDistrict(rs.getString("district"));
                    house .setVillage(rs.getString("village"));
                    house .setAddress(rs.getString("address"));
                    house .setFloor(rs.getInt("floor"));
                    house .setFloor_sum(rs.getInt("floor_sum"));
                    house .setFloor_lift(rs.getInt("floor_lift"));
                    house .setPrice(rs.getInt("price"));
                    house .setType_bedroom(rs.getInt("type_bedroom"));
                    house .setType_livingroom(rs.getInt("type_livingroom"));
                    house .setType_bathroom(rs.getInt("type_bathroom"));
                    house .setArea(rs.getString("area"));
                    house .setDescription(rs.getString("description"));
                    house .setHouseToward(rs.getString("houseToward"));
                    house .setFacilities(rs.getString("facilities"));
                    house.setRequirement(rs.getString("requirement"));
                    house.setPersonnum(rs.getInt("personnum"));
                    house.setHouseImg(rs.getString("houseImg"));
                    house.setPayMethod(rs.getString("payMethod"));
                    list.add(house);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                // 关闭资源，避免出现异常
                BaseDao.close(con,ps,rs);
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(json);

        }
        }

    }
