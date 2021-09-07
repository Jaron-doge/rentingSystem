package com.example.rent.dao;

import com.example.rent.entity.Manager;
import com.example.rent.entity.User;

import java.util.List;

public interface ManagerDao  {
    /**
     * 用户登录
     */
    public Manager login(Manager manager);

    /**
     * 用户注册
     */
    public boolean register(Manager manager);

    /**
     * 查询用户信息
     */
    public List<Manager> selectManager(String sql, Object arr[]);

    /**
     * 根据用户编号进行查询
     */
    public Manager getManager(Integer managerid);


    /**
     * 新增用户
     */
    public boolean addUManager(Manager manager);

    /**
     * 修改用户
     */
    public boolean updateManager(Manager manager);

    /**
     * 删除用户
     */
    public boolean deleteManager(Integer managerid);
}
