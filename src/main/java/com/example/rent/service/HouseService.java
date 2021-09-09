package com.example.rent.service;

import com.example.rent.entity.House;

import java.util.List;

public interface HouseService {
    /**
     * 查询房屋信息
     * @return
     */
    public List<House> select();

    /**
     * 根据房屋地址进行查询
     * @param houseId
     * @return
     */
    public House getHouse(Integer houseId);


    /**
     * 根据用户id进行查询
     * @return
     */
    public List<House> getHouseByUserId(Integer userId);

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
