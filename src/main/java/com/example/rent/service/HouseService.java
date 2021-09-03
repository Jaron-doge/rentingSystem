package com.example.rent.service;

import com.example.rent.entity.House;

import java.util.List;

public interface HouseService {
    /**
     * 查询房屋信息
     * @param houseid
     * @return
     */
    public List<House> select(Integer houseid);

    /**
     * 根据房屋地址进行查询
     * @param area
     * @return
     */
    public House getHouse(String area);


    /**
     * 房屋新增
     * @param house
     * @return
     */
    public boolean addHouse(House house);

    /**
     * 房屋信息修改
     * @param book
     * @return
     */
    public boolean updateHouse(House book);

    /**
     * 删除房屋
     * @param houseid
     * @return
     */
    public boolean deleteHouse(Integer houseid);
}
