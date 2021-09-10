package com.example.rent.service;

import com.example.rent.entity.House;
import com.example.rent.entity.Manager;
import com.example.rent.entity.ManagerBean;
import com.example.rent.entity.User;

import java.util.List;

public interface ManagerService {
    /**
     * manager登陆
     */

    public Manager login(Manager manager);
    /**
     * 用户注册
     */
    public boolean register(Manager manager);
    /**
     * 查询用户信息
     */
    public List<Manager> selectManager(Integer managerId);



    /**
     * 根据用户编号进行查询
     */
    public Manager getManager(Integer userid);


    /**
     * 用户新增
     */
    public boolean addManager(User user);

    /**
     * 用户修改
     */
    public boolean updateManager(Manager manager);

    /**
     * 删除用户
     */
    public boolean deleteManager(Integer userid);
    public ManagerBean<House> managerQuery(int managerid, int currentPage, int pageSize);
}
