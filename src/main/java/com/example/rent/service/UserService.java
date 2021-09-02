package com.example.rent.service;



import com.example.rent.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询用户信息
     */
    public List<User> selectUser(String username);



    /**
     * 根据用户编号进行查询
     */
    public User getUser(Integer userid);


    /**
     * 图书新增
     */
    public boolean addUser(User user);

    /**
     * 图书修改
     */
    public boolean updateUser(User user);

    /**
     * 删除用户
     */
    public boolean deleteUser(Integer userid);
}
