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
                House hosue = new House();
                hosue .setHouseId(rs.getInt("hosueid"));
                hosue .setAddress(rs.getString("address"));
                hosue .setPrice(rs.getInt("price"));
                hosue .setArea(rs.getString("area"));
                hosue .setCity(rs.getString("city"));
                hosue .setDetail(rs.getString("detail"));
                hosue .setDistrict(rs.getString("district"));
                hosue .setManagerId(rs.getInt("managerid"));
                hosue .setType(rs.getString("type"));
                hosue .setUserId(rs.getInt("userid"));


                list.add(hosue );
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            BaseDao.close(con,ps,rs);
        }
        return null;
    }

    @Override
    public House getHouse(Integer bookid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            String sql = "select * from book where bookid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,bookid);
            // 3.执行sql
            rs = ps.executeQuery();
            while (rs.next()){

                House hosue = new House();
                hosue .setHouseId(rs.getInt("hosueid"));
                hosue .setAddress(rs.getString("address"));
                hosue .setPrice(rs.getInt("price"));
                hosue .setArea(rs.getString("area"));
                hosue .setCity(rs.getString("city"));
                hosue .setDetail(rs.getString("detail"));
                hosue .setDistrict(rs.getString("district"));
                hosue .setManagerId(rs.getInt("managerid"));
                hosue .setType(rs.getString("type"));
                hosue .setUserId(rs.getInt("userid"));

                return hosue;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        String sql = "insert into manager values (?,?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(house.getHouseId());
        list.add(house.getPrice());
        list.add(house.getManagerId());
        list.add(house.getType());
        list.add(house.getCity());
        list.add(house.getArea());
        list.add(house.getAddress());
        list.add(house.getDetail());
        list.add(house.getDistrict());
        list.add(house.getUserId());

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
        String sql = "update house set housename=?,price=?,managerid=?,type=?,userid=?,area=?,district=?,city=?,address=? where houseid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(house.getHouseId());
        list.add(house.getPrice());
        list.add(house.getManagerId());
        list.add(house.getType());
        list.add(house.getCity());
        list.add(house.getArea());
        list.add(house.getAddress());
        list.add(house.getDetail());
        list.add(house.getDistrict());
        list.add(house.getUserId());

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
    public boolean deleteHouse(Integer bookid) {
        String sql = "delete from house where houseid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(bookid);

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
