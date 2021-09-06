package com.example.rent.dao.impl;

import com.example.rent.dao.ManagerDao;
import com.example.rent.entity.Manager;

import com.example.rent.entity.User;
import com.example.rent.util.BaseDao;
import javafx.scene.input.Mnemonic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {

    /**
     * 用户登录
     * @param manager
     * @return
     */
    @Override
    public Manager login(Manager manager) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            con = BaseDao.getConnection();
            // 2.写sql
            String sql = "select * from Manager where managername = ? and managerPwd = ?";
            // 3.预编译
            ps = con.prepareStatement(sql);
            // 4.设置值
            ps.setObject(1,manager.getName());
            ps.setObject(2,manager.getPwd());
            rs = ps.executeQuery();
           Manager managers = null;
            if(rs.next()){
                managers = new Manager();
                // 从数据库中获取值到实体类的setter方法中
                managers.setManagerId(rs.getInt("managerId"));
                managers.setName(rs.getString("managername"));
                managers.setPwd(rs.getString("managerPwd"));
                managers.setManagerIcon("managerIcon");
                managers.setSum(rs.getInt("houseSum"));


                // 返回的是你查询出来的完整的对象
                return managers;

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
     * 用户注册
     * @param manager
     * @return
     */
    @Override
    public boolean register(Manager manager) {

        String sql = "insert into Manager values (?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(manager.getManagerId());
        list.add(manager.getName());
        list.add(manager.getPwd());
        list.add(manager.getManagerIcon());

        list.add(manager.getSum());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 寻找经理数据
     * @param sql
     * @param arr
     * @return
     */
    @Override
    public List<Manager> selectUser(String sql, Object[] arr) {
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
                    ps.setObject(i+1,arr[i]);
                }
            }
            // 3.执行sql
            rs = ps.executeQuery();
            // 4.保存查询出来的数据到list
            List<Manager> list = new ArrayList<Manager>();
            while(rs.next()){
              Manager manager = new Manager();
                // 从数据库中获取值到实体类的setter方法中
                manager.setManagerId(rs.getInt("managerid"));
                manager.setName(rs.getString("managername"));
                manager.setPwd(rs.getString("mangerPwd"));
                manager.setManagerIcon(rs.getString("managerIcon"));

                manager.setSum(rs.getInt("houseSum"));


                // 测试数据
                System.out.println("Dao层测试日志，显示用户信息：");
                System.out.println(manager);
                // 将对象保存到list中
                list.add(manager);
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

    /**
     * 得到manager信息
     * @param managerid
     * @return
     */
    @Override
    public Manager getUser(Integer managerid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            String sql = "select * from Manager where userid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,managerid);
            // 3.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                Manager manager = new Manager();
                manager.setManagerId(rs.getInt("managerId"));
                manager.setName(rs.getString("managerName"));
               manager.setPwd(rs.getString("managerPwd"));
                manager.setManagerIcon(rs.getString("managerIcon"));
                manager.setSum(rs.getInt("hosueSum"));
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

    /**
     * 添加新的manager
     * @param manager
     * @return
     */
    @Override
    public boolean addUManager(Manager manager) {
        String sql = "insert into Manager values (?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(manager.getManagerId());
        list.add(manager.getName());
        list.add(manager.getPwd());
        list.add(manager.getManagerIcon());
        list.add(manager.getSum());



        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 更新manager数据
     * @param manager
     * @return
     */
    @Override
    public boolean updateManager(Manager manager) {
        String sql = "update Manager set managerPwd=?,managerName=?,managerIcon=?,where managerId=?";
        List<Object> list = new ArrayList<Object>();
        list.add(manager.getPwd());
        list.add(manager.getName());
        list.add(manager.getManagerIcon());


        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删去manager
     * @param managerid
     * @return
     */
    @Override
    public boolean deleteManager(Integer managerid) {
        String sql = "delete from Manager where managerId=?";
        List<Object> list = new ArrayList<Object>();
        list.add(managerid);

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
    }

