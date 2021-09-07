package com.example.rent.service.impl;

import com.example.rent.entity.Manager;
import com.example.rent.entity.User;
import com.example.rent.service.ManagerService;
import com.example.rent.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public boolean register(Manager manager) {
        String sql = "insert into Manager values (?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(manager.getManagerId());
        list.add(manager.getPwd());
        list.add(manager.getName());
        list.add(manager.getSum());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Manager login(Manager manager) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            con = BaseDao.getConnection();
            // 2.写sql
            String sql = "select * from Manager where managerId = ? and Pwd = ?";
            // 3.预编译
            ps = con.prepareStatement(sql);
            // 4.设置值
            ps.setObject(1,manager.getManagerId());
            ps.setObject(2,manager.getPwd());
            rs = ps.executeQuery();
            User users = null;
            if(rs.next()){
                Manager manager1= new Manager();
                // 从数据库中获取值到实体类的setter方法中
                manager.setManagerId(rs.getInt("managerId"));
                manager.setPwd(rs.getString("Pwd"));
                manager.setName(rs.getString("managerName"));
                manager.setSum(rs.getInt("houseSum"));

                // 返回的是你查询出来的完整的对象
                return manager;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            BaseDao.close(con,ps,rs);
        }
        return null;
    }
    @Override
    public List<Manager> selectManager(Integer managerId) {
        return null;
    }

    @Override
    public User getManager(Integer userid) {
        return null;
    }

    @Override
    public boolean addManager(User user) {
        return false;
    }

    @Override
    public boolean updateManager(User user) {
        return false;
    }

    @Override
    public boolean deleteManager(Integer userid) {
        return false;
    }
}
