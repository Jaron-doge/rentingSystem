package com.example.rent.dao;

import java.util.List;
import com.example.rent.entity.Rent;
public interface RentDao {
    /**
     * 按照用户名或者经理名或者交易id检索rent
     */
    public List<Rent> selectRent(Integer id);


    /**
     * 加入新交易
     */
    public boolean addRent(Rent newrent);


    /**
     * 取消交易
     */
    public boolean removeRent(Integer userid,Integer rentid);
}
