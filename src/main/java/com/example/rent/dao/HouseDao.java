package com.example.rent.dao;

import java.util.List;
import com.example.rent.entity.House;
public interface HouseDao {



        /**
         * 查询房屋信息
         */
        public List<House> select(String sql, Object[] arr);

        /**
         * 根据房屋编号进行查询
         */
        public House getHouse(Integer houseid);


        /**
         * 房屋新增
         */
        public boolean addHouse(House house);

        /**
         * 房屋修改
         */
        public boolean updateHouse(House house);

        /**
         * 房屋图书
         */
        public boolean deleteHouse(Integer hosueid);
}
