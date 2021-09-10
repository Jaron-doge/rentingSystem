package com.example.rent.entity;

public class House {
    private Integer houseId;
    private Integer userId;
    private String  city;
    private String  district;
    private String address;
    private Integer  price;
    private String area;
    private String description;
    private Integer managerId;
    private String  village;
    private Integer floor;
    private Integer floor_sum;
    private Integer floor_lift;
    private Integer type_bedroom;
    private Integer type_livingroom;
    private Integer type_bathroom;
    private String houseToward;
    private String facilities;
    private String requirement;
    private Integer personnum;
    private String houseImg;
    private String payMethod;


    public String getHouseImg() {
        return houseImg;
    }

    public void setHouseImg(String houseImg) {
        this.houseImg = houseImg;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

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


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVillage() {
        return village;
    }
吗
    public void setVillage(String village) {
        this.village = village;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloor_sum() {
        return floor_sum;
    }

    public void setFloor_sum(Integer floor_sum) {
        this.floor_sum = floor_sum;
    }

    public Integer getFloor_lift() {
        return floor_lift;
    }

    public void setFloor_lift(Integer floor_lift) {
        this.floor_lift = floor_lift;
    }

    public Integer getType_bedroom() {
        return type_bedroom;
    }

    public void setType_bedroom(Integer type_bedroom) {
        this.type_bedroom = type_bedroom;
    }

    public Integer getType_livingroom() {
        return type_livingroom;
    }

    public void setType_livingroom(Integer type_livingroom) {
        this.type_livingroom = type_livingroom;
    }

    public Integer getType_bathroom() {
        return type_bathroom;
    }

    public void setType_bathroom(Integer type_bathroom) {
        this.type_bathroom = type_bathroom;
    }

    public String getHouseToward() {
        return houseToward;
    }

    public void setHouseToward(String houseToward) {
        this.houseToward = houseToward;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" +houseId +'\''  +
                ", userId=" + userId +'\''  +
                ", managerId=" + managerId+ '\''  +
                ", city='" + city  +'\''  +
                ", district=" +district +'\''  +
                ", village=" +village +'\''  +
                ", address=" +address +'\''  +
                ", floor=" +floor +'\''  +
                ", floor_sum=" +floor_sum +'\''  +
                ", floor_lift=" +floor_lift +'\''  +
                ", price=" +price+ '\'' +'\''  +
                ", type_bedroom=" +type_bedroom +'\'' +
                ", type_livingroom=" +type_livingroom +'\'' +
                ", type_bathroom=" +type_bathroom +'\'' +
                ", area='" + area +'\''  +
                ", description=" +description+ '\'' +
                ", houseToward=" +houseToward+ '\'' +
                ", facilities=" +facilities+ '\'' +
                ", requirement=" +requirement+ '\'' +
                ", personnum=" +personnum+ '\'' +
                ", hosueImg=" +houseImg+ '\'' +
                ", payMethod=" +payMethod+ '\'' +
                '}';
    }

}
