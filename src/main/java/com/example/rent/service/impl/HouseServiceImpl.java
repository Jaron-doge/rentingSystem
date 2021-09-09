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
        public List<House> select() {
            StringBuffer sql = new StringBuffer("select * from House where 1 = 1 ");
            List<Object> list = new ArrayList<Object>();

            return houseDao.select(sql.toString(),list.toArray());
        }



    @Override
    public House getHouse(Integer houseId) {
        return houseDao.getHouse(houseId);
    }

    @Override
    public boolean addHouse(House house) {
        return houseDao.addHouse(house);
    }

    @Override
    public boolean updateHouse(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public boolean deleteHouse(Integer houseid) {
        return houseDao.deleteHouse(houseid);
    }
}
