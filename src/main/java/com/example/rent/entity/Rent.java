package com.example.rent.entity;

import java.util.Date;

public class Rent {
    private Integer rentId;
    private Integer houseId;
    private Integer userrentId;
    private Integer managerId;
    private Integer tenancy;
    private Date startDate;

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserrentId() {
        return userrentId;
    }

    public void setUserrentId(Integer userrentId) {
        this.userrentId = userrentId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getTenancy() {
        return tenancy;
    }

    public void setTenancy(Integer tenancy) {
        this.tenancy = tenancy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", userrentId=" + userrentId +
                ", managerId=" + managerId +
                ", houseId='" + houseId + '\'' +
                ", tenancy='" + tenancy + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
