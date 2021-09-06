package com.example.rent.dao.impl;

import com.example.rent.dao.HouseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.rent.entity.House;
import  com.example.rent.util.BaseDao;

public class HouseDaoImpl implements HouseDao {
    @Override
    public List<House> select(String sql, Object[] arr) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            ps = con.prepareStatement(sql);
            if(arr != null){
                for (int i = 0; i < arr.length; i++) {
                    // 传入sql的参数
                    ps.setObject(i+1,arr[i]);
                }
            }
            // 3.执行sql
            rs = ps.executeQuery();
            // 4.保存查询出来的数据到list
            List<House> list = new ArrayList<House>();
            while (rs.next()){
                House house = new House();
                house .setHouseId(rs.getInt("hosueId"));
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
                house .setType_bedroom(rs.getInt("Type_bedroom"));
                house .setType_livingroom(rs.getInt("Type_livingroom"));
                house .setType_bathroom(rs.getInt("Type_bathroom"));
                house .setArea(rs.getString("area"));
                house .setDescription(rs.getString("Description"));
                house .setHouseToward(rs.getString("HouseToward"));
                house .setFacilities(rs.getString("Facilities"));
                house.setRequirement(rs.getString("requirement"));
                house.setPersonnum(rs.getInt("personnum"));
                house.setHouseImg(rs.getString("houseImag"));
                house.setPayMethod(rs.getString("PayMethod"));



                list.add(house );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            BaseDao.close(con,ps,rs);
        }
        return null;
    }

    @Override
    public House getHouse(Integer houseid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            String sql = "select * from House where houseId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,houseid);
            // 3.执行sql
            rs = ps.executeQuery();
            while (rs.next()){


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
                    house .setType_bedroom(rs.getInt("Type_bedroom"));
                    house .setType_livingroom(rs.getInt("Type_livingroom"));
                    house .setType_bathroom(rs.getInt("Type_bathroom"));
                    house .setArea(rs.getString("area"));
                    house .setDescription(rs.getString("Description"));
                    house .setHouseToward(rs.getString("HouseToward"));
                    house .setFacilities(rs.getString("Facilities"));
                    house.setRequirement(rs.getString("requirement"));
                    house.setPersonnum(rs.getInt("personnum"));
                    house.setHouseImg(rs.getString("houseImag"));
                    house.setPayMethod(rs.getString("PayMethod"));

                return house;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            BaseDao.close(con,ps,rs);
        }
        return null;
    }

    /**
     * 新增房屋

     */
    @Override
    public boolean addHouse(House house) {
        String sql = "insert into House values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(house.getHouseId());
        list.add(house.getUserId());
        list.add(house.getManagerId());
        list.add(house.getCity());
        list.add(house.getDistrict());
        list.add(house.getVillage());
        list.add(house.getAddress());
        list.add(house.getFloor());
        list.add(house.getFloor_sum());
        list.add(house.getFloor_lift());
        list.add(house.getPrice());
        list.add(house.getType_bedroom());
        list.add(house.getType_livingroom());
        list.add(house.getType_bathroom());
        list.add(house.getArea());
        list.add(house.getDescription());
        list.add(house.getHouseToward());
        list.add(house.getFacilities());
        list.add(house.getRequirement());
        list.add(house.getPersonnum());
        list.add(house.getHouseImg());
        list.add(house.getPayMethod());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新房屋
     */
    @Override
    public boolean updateHouse(House house) {
        String sql = "update house set userId=?,managerid=?,city=?,district=?,village=?,address=?,floor=?,floor_sum=?,floor_lift=?,price=?,type_bedroom=?,type_livingroom=?," +
                "type_bathroom=?,area=?,description=?,houseToward=?,facilities=?,requirement=?,personnum=?,houseImg=?,payMethod=?where houseid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(house.getHouseId());
        list.add(house.getUserId());
        list.add(house.getManagerId());
        list.add(house.getCity());
        list.add(house.getDistrict());
        list.add(house.getVillage());
        list.add(house.getAddress());
        list.add(house.getFloor());
        list.add(house.getFloor_sum());
        list.add(house.getFloor_lift());
        list.add(house.getPrice());
        list.add(house.getType_bedroom());
        list.add(house.getType_livingroom());
        list.add(house.getType_bathroom());
        list.add(house.getArea());
        list.add(house.getDescription());
        list.add(house.getHouseToward());
        list.add(house.getFacilities());
        list.add(house.getRequirement());
        list.add(house.getPersonnum());
        list.add(house.getHouseImg());
        list.add(house.getPayMethod());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除房屋
     */
    @Override
    public boolean deleteHouse(Integer houseid) {
        String sql = "delete from House where houseId=?";
        List<Object> list = new ArrayList<Object>();
        list.add(houseid);

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
