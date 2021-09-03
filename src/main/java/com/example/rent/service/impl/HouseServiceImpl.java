package com.example.rent.service.impl;

import com.example.rent.dao.HouseDao;
import com.example.rent.dao.impl.HouseDaoImpl;
import com.example.rent.entity.House;
import com.example.rent.service.HouseService;

import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = new HouseDaoImpl();
        @Override
        public List<House> select(Integer houseid) {
            StringBuffer sql = new StringBuffer("select * from book where 1 = 1 ");
            List<Object> list = new ArrayList<Object>();
            if(houseid != null){
                sql.append(" and houseid = ?");
                list.add(houseid);

            }
            return houseDao.select(sql.toString(),list.toArray());
        }



    @Override
    public House getHouse(String area) {
        return null;
    }

    @Override
    public boolean addHouse(House house) {
        return false;
    }

    @Override
    public boolean updateHouse(House book) {
        return false;
    }

    @Override
    public boolean deleteHouse(Integer houseid) {
        return false;
    }
}
