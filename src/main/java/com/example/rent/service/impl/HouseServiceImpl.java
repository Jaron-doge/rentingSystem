package com.example.rent.service.impl;

import com.example.rent.dao.HouseDao;
import com.example.rent.dao.impl.HouseDaoImpl;
import com.example.rent.entity.House;
import com.example.rent.service.HouseService;
import com.example.rent.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = new HouseDaoImpl();
        @Override
        public List<House> select() {
            StringBuffer sql = new StringBuffer("select * from House where 1 = 1 ");
            List<Object> list = new ArrayList<Object>();

            return houseDao.select(sql.toString(),list.toArray());
        }



    @Override
    public House getHouse(Integer houseId) {
        return houseDao.getHouse(houseId);
    }

    @Override
    public boolean addHouse(House house) {
        return houseDao.addHouse(house);
    }

    @Override
    public boolean updateHouse(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public boolean deleteHouse(Integer houseid) {
        return houseDao.deleteHouse(houseid);
    }

    @Override
    public List<House> getHouseByUserId(Integer userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<House> houses = new ArrayList<House>();
        try {
            String sql = new String("select * from House where userId = ?");
            // 第一步：连接数据库
            con = BaseDao.getConnection();
            // 第二步：预编译
            ps = con.prepareStatement(sql);
            // 第三步：设置值
            ps.setObject(1,userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                House house = new House();
                house .setHouseId(rs.getInt("houseId"));
                house .setUserId(rs.getInt("userId"));
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
                house .setDescription(rs.getString("Description"));
                house .setHouseToward(rs.getString("HouseToward"));
                house .setFacilities(rs.getString("Facilities"));
                house.setRequirement(rs.getString("requirement"));
                house.setPersonnum(rs.getInt("personnum"));
                house.setHouseImg(rs.getString("houseImg"));
                house.setPayMethod(rs.getString("payMethod"));



                houses.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(con,ps,rs);
        }
        return houses;
    }
}
