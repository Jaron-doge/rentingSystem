package com.example.rent.service;

import java.util.List;
import com.example.rent.entity.Rent;
public interface RentService {
    /**
     * 按照用户id检索交易
     * @param rentid
     * @return
     */
    public List<Rent> selectRent(Integer rentid);

    /**
     * 加入交易
     * @param rent
     * @return
     */
    public boolean addRent(Rent rent);


    /**
     * 移出交易
     * @param userid
     * @param rentid
     * @return
     */
    public boolean removeRent(Integer userid,Integer rentid);
}
