package com.example.rent.dao;



import com.example.rent.entity.User;

import java.util.List;


public interface UserDao {

    /**
     * 用户登录
     */
    public User login(User user);

    /**
     * 用户注册
     */
    public boolean register(User user);

    /**
     * 查询用户信息
     */
    public List<User> selectUser(String sql, Object arr[]);

    /**
     * 根据用户编号进行查询
     */
    public User getUser(Integer userid);


    /**
     * 新增用户
     */
    public boolean addUser(User user);

    /**
     * 修改用户
     */
    public boolean updateUser(User user);

    /**
     * 删除用户
     */
    public boolean deleteUser(Integer userid);
}

