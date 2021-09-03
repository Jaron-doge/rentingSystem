package com.example.rent.dao.impl;

import com.example.rent.util.BaseDao;
import com.example.rent.dao.RentDao;
import com.example.rent.entity.Rent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDaoImpl implements RentDao {
    @Override
    public List<Rent> selectRent(Integer userid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            String sql = "select * from rent where userid=?";
            ps = con.prepareStatement(sql);
            if(userid != null){
                // 传入sql的参数
                ps.setObject(1,userid);

            }
            // 3.执行sql
            rs = ps.executeQuery();
            // 4.保存查询出来的数据到list
            List<Rent> list = new ArrayList<>();
            while (rs.next()){
                Rent rent= new Rent();
                rent.setRentId(rs.getInt("id"));
                rent.setUserrentId(rs.getInt("userid"));
                rent.setManagerId(rs.getInt("managerid"));
                rent.setHouseId(rs.getInt("houseid"));
                rent.setTenancy(rs.getInt("tenancy"));
                rent.setStartDate(rs.getDate("date"));

                list.add(rent);
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
    public boolean addRent(Rent bookShelf) {
        String sql = "insert into rent values (?,?,?,?,?,now())";
        Rent rent =new Rent();
        List<Object> list = new ArrayList<Object>();
        list.add(rent.getRentId());
        list.add(rent.getHouseId());
        list.add(rent.getUserrentId());
        list.add(rent.getManagerId());
        list.add(rent.getTenancy());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean removeRent(Integer userid, Integer rentid) {
        String sql = "delete from rent where userId=? and rentId=?";
        List<Object> list = new ArrayList<Object>();
        list.add(userid);
        list.add(rentid);

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}

