package com.example.rent.dao;

import java.util.List;
import com.example.rent.entity.House;
public interface HouseDao {



        /**
         * 查询图书信息
         */
        public List<House> select(String sql, Object[] arr);

        /**
         * 根据图书编号进行查询
         */
        public House getHouse(Integer houseid);


        /**
         * 图书新增
         */
        public boolean addHouse(House house);

        /**
         * 图书修改
         */
        public boolean updateHouse(House house);

        /**
         * 删除图书
         */
        public boolean deleteHouse(Integer hosueid);
}
