package com.example.rent.service.impl;

import com.example.rent.dao.impl.RentDaoImpl;
import com.example.rent.entity.Rent;
import com.example.rent.service.RentService;
import com.example.rent.dao.RentDao;
import java.util.List;

public class RentServiceImpl implements RentService {

    private RentDao rentDao = new RentDaoImpl();
    /**
     * 根据租借记录序号查询该租借记录
     * @param rentid
     * @return
     */
    @Override
    public List<Rent> selectRent(Integer rentid) {
        return rentDao.selectRent(rentid);

    }

    /**
     * 添加租借记录
     * @param rent
     * @return
     */
    @Override
    public boolean addRent(Rent rent) {
        return rentDao.addRent(rent);

    }

    /**
     * 移出租借记录
     * @param userid
     * @param rentid
     * @return
     */
    @Override
    public boolean removeRent(Integer userid, Integer rentid) {
        return rentDao.removeRent(userid,rentid);
    }
}
