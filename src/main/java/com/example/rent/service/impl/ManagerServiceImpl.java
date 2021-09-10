package com.example.rent.service.impl;

import com.example.rent.dao.HouseDao;
import com.example.rent.dao.ManagerDao;
import com.example.rent.dao.UserDao;
import com.example.rent.dao.impl.HouseDaoImpl;
import com.example.rent.dao.impl.ManagerDaoImpl;
import com.example.rent.dao.impl.UserDaoImpl;
import com.example.rent.entity.House;
import com.example.rent.entity.Manager;
import com.example.rent.entity.ManagerBean;
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
    private HouseDao houseDao = new HouseDaoImpl();
    @Override
    public boolean register(Manager manager) {
        String sql = "insert into Manager values (?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(manager.getManagerId());
        list.add(manager.getPwd());
        list.add(manager.getName());
        list.add(manager.getSum());
        list.add(manager.getTelephone());

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
            String sql = "select * from Manager where managerId = ? and managerPwd = ?";
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
                manager.setPwd(rs.getString("managerPwd"));
                manager.setName(rs.getString("managerName"));
                manager.setSum(rs.getInt("houseSum"));
                manager.setTelephone(rs.getString("telNo"));

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
    public Manager getManager(Integer userid) {
        return null;
    }

    @Override
    public boolean addManager(User user) {
        return false;
    }

    private ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public boolean updateManager(Manager manager) {

        return managerDao.updateManager(manager);
    }

    @Override
    public boolean deleteManager(Integer userid) {
        return false;
    }

    @Override
    public ManagerBean<House> managerQuery(int managerid, int currentPage, int pageSize) {
        //封装ManagerBean
        ManagerBean<House> mb = new ManagerBean<House>();
        //设置当前页码
        mb.setCurrentPage(currentPage);
        //设置每页显示条数
        mb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = houseDao.findTotalCountByManager(managerid);
        mb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<House> list = houseDao.findByPageByManager(managerid,start,pageSize);
        mb.setList(list);
        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        mb.setTotalPage(totalPage);
        return mb;
    }
}
