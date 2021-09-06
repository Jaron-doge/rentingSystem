package com.example.rent.service.impl;



import com.example.rent.dao.UserDao;
import com.example.rent.dao.impl.UserDaoImpl;
import com.example.rent.entity.User;
import com.example.rent.service.UserService;
import com.example.rent.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
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
            String sql = "select * from User where userid = ? and userPwd = ?";
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
                user.setIcon(rs.getInt("userIcon"));

                // 返回的是你查询出来的完整的对象
                return users;

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
     */
    @Override
    public boolean register(User user) {
        String sql = "insert into User values (?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUserId());
        list.add(user.getUserPwd());
        list.add(user.getUserName());
        list.add(user.getIcon());

        boolean flag = BaseDao.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
    // 定义dao对象
    private UserDao userDao = new UserDaoImpl();

    /**
     * 查询用户信息
     */
    @Override
    public List<User> selectUser(String username) {

        StringBuffer sql = new StringBuffer("select * from User where 1 = 1 ");
        List<Object> list = new ArrayList<Object>();
        if(username != null){

            sql.append(" and userid = ?");
            list.add(username);
        }
        // 交给dao层处理逻辑
        return userDao.selectUser(sql.toString(),list.toArray());
    }

    @Override
    public User getUser(Integer userid) {
        return userDao.getUser(userid);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer userid) {
        return userDao.deleteUser(userid);
    }
}

