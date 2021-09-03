package com.example.rent.entity;

public class House {
    private Integer houseId;
    private Integer userId;
    private String  city;
    private String  district;
    private String address;
    private Integer  price;
    private String  type;
    private String area;
    private String detail;
    private Integer managerId;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @Override
    public String toString() {
        return "House{" +
                "houseId=" +houseId +
                ", userId=" + userId +
                ", managerId=" + managerId+ '\''  +
                ", area='" + area +
                ", city='" + city  +
                ", district=" +district +
                ", address=" +address +
                ", price=" +price+ '\'' +
                ", type=" +type +'\'' +
                ", detail=" +detail+ '\'' +
                '}';
    }

}
