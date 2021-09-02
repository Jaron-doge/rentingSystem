package com.example.rent.dao.impl;



import com.example.rent.dao.UserDao;
import com.example.rent.entity.User;
import com.example.rent.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    /**
     * 用户登录
     */
    @Override
    public User login(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            con = BaseDao.getConnection();
            // 2.写sql
            String sql = "select * from user where username = ? and userPwd = ?";
            // 3.预编译
            ps = con.prepareStatement(sql);
            // 4.设置值
            ps.setObject(1,user.getUserName());
            ps.setObject(2,user.getUserPwd());
            rs = ps.executeQuery();
            User users = null;
            if(rs.next()){
                users = new User();
                // 从数据库中获取值到实体类的setter方法中
                users.setUserId(rs.getInt("userid"));
                users.setUserName(rs.getString("username"));
                users.setUserPwd(rs.getString("userPwd"));
                user.setIcon(rs.getInt("icon"));

                // 返回的是你查询出来的完整的对象
                return users;

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
     * 用户注册
     */
    @Override
    public boolean register(User user) {
        String sql = "insert into user values (?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUserId());
        list.add(user.getUserName());
        list.add(user.getUserPwd());

        list.add(user.getIcon());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询用户信息
     */
    @Override
    public List<User> selectUser(String sql, Object[] arr) {
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
            List<User> list = new ArrayList<User>();
            while(rs.next()){
                User user = new User();
                // 从数据库中获取值到实体类的setter方法中
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPwd(rs.getString("userPwd"));

                user.setIcon(rs.getInt("icon"));


                // 测试数据
                System.out.println("Dao层测试日志，显示用户信息：");
                System.out.println(user);
                // 将对象保存到list中
                list.add(user);
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

    /**
     * 根据用户编号进行查询
     */
    @Override
    public User getUser(Integer userid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = BaseDao.getConnection();
            // 2.预编译
            String sql = "select * from user where userid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,userid);
            // 3.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setIcon(rs.getInt("icon"));

                return user;
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
     * 新增用户
     */
    @Override
    public boolean addUser(User user) {
        String sql = "insert into user values (?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUserId());
        list.add(user.getUserName());
        list.add(user.getUserPwd());
        list.add(user.getIcon());



        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改用户
     */
    @Override
    public boolean updateUser(User user) {
        String sql = "update user set userPwd=?,userName=?where userid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUserPwd());
        list.add(user.getUserName());


        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除用户
     */
    @Override
    public boolean deleteUser(Integer userid) {
        String sql = "delete from user where userid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(userid);

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
